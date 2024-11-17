bool locknode(LokingTree* country, int user) {
    if (!country) return false;
    
    // Exclusive lock on the current node (write lock)
    country->m.lock();  

    if (country->islockedthenode || !country->descendentnode.empty()) {
        country->m.unlock();
        return false;
    }

    // Traverse up the tree to check if any ancestor is locked
    LokingTree* p = country->parentnode;
    while (p) {
        // Use shared lock on ancestor nodes for reading
        p->m.lock_shared();  // Read lock for ancestor node

        if (p->islockedthenode) {
            p->m.unlock_shared();  // Release shared lock on failure
            country->m.unlock();   // Release exclusive lock on current node
            return false;
        }

        // Release the shared lock on the ancestor
        p->m.unlock_shared();
        p = p->parentnode;
    }

    // Lock the current node exclusively (write lock)
    country->islockedthenode = true;
    country->islockby = user;
    updateparentnode(country->parentnode, country);

    // Unlock the current node after updating
    country->m.unlock();  

    return true;
}

