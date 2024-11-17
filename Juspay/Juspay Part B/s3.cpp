bool locknode(LokingTree* country, int user) {
    if (!country) return false;

    // Lock the current node to ensure no one else can modify it
    country->m.lock();

    // Check if the node is locked or has locked descendants
    if (country->islockedthenode || !country->descendentnode.empty()) {
        country->m.unlock();
        return false;
    }


    LokingTree* p = country->parentnode;
    while (p) {
        // Lock each ancestor before checking its state
        p->m.lock();

        // If the ancestor is locked, release the lock and return false
        if (p->islockedthenode) {
            p->m.unlock();  // Release ancestor lock
            country->m.unlock();  // Release current node lock
            return false;
        }

        p->m.unlock();  // Release ancestor lock after check
        p = p->parentnode;
    }

    //Lock the current node exclusively (write lock)
    country->islockedthenode = true;
    country->islockby = user;

    // Update parent nodes with the new locked status
    updateparentnode(country->parentnode, country);

    // Unlock the current node after all operations are complete
    country->m.unlock();

    return true;
}
