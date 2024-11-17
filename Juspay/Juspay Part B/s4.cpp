// Lock for current node exclusively (write lock)
std::unique_lock<std::shared_mutex> lock(country->m);

// Check if the current node is already locked or has locked descendants
if(country->islockedthenode || !country->descendentnode.empty()){
    return false;  // Return false if the node is locked or has locked descendants
}

// Traverse up the tree to check if any ancestor is locked
LokingTree* p = country->parentnode;
while(p) {
    // Acquire shared lock on the ancestor for read-only access
    std::shared_lock<std::shared_mutex> ancestorLock(p->m);

    // If the ancestor is locked, we cannot proceed
    if(p->islockedthenode) {
        return false;
    }

    p = p->parentnode;
}
std::unique_lock<std::shared_mutex> lock(country->m);
// Proceed with locking the current node (write lock)
country->islockedthenode = true;
country->islockby = user;
updateparentnode(country->parentnode, country);

// Unlock the current node (release write lock)
lock.unlock();  // Unlocking the current node explicitly after the operation

