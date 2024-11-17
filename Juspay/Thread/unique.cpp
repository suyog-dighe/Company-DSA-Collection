#include <iostream>
#include <vector>
#include <deque>
#include <map>
#include <set>

using namespace std;

int main() {
    int nodeCount, branchFactor, operations;
    cin >> nodeCount >> branchFactor >> operations;

    vector<string> nodeNames(nodeCount);
    int i = 0;
    while (i < nodeCount) {
        cin >> nodeNames[i];
        i++;
    }

    class Node {
    public:
        string nodeName;                // Name of the node
        int lockedByID;                 // ID of the user who locked the node
        bool isLocked;                  // Lock status of the node
        vector<Node*> children;         // Children of the current node
        Node* parent;                   // Parent of the current node
        set<Node*> lockedDescendants;   // Set of locked descendant nodes

        // Constructor to initialize a node with a name and a parent
        Node(string name, Node* parentNode) {
            nodeName = name;
            lockedByID = -1;              // Initially unlocked
            parent = parentNode;
            isLocked = false;             // Node starts unlocked
        }

        // Function to add children to the current node
        void addChildren(vector<string>& childNames) {
            int i = 0;
            while (i < childNames.size()) {
                children.push_back(new Node(childNames[i], this));
                i++;
            }
        }

        // Destructor to clean up dynamically allocated children
        ~Node() {
            int i = 0;
            while (i < children.size()) {
                delete children[i]; // Recursively delete children
                i++;
            }
        }
    };

    class MTree {
    private:
        Node* rootNode;                                     // Root of the tree
        map<string, Node*> nodeMapping;                     // Map for node names to node pointers

    public:
        // Constructor to initialize the M-ary tree with a root node
        MTree(string rootName) {
            rootNode = new Node(rootName, nullptr);
        }

        // Method to build the tree from a list of names
        void buildTree(vector<string>& names, int branchFactor) {
            deque<Node*> nodeDeque;                          // Using deque for level-order traversal
            int index = 1, totalNodes = names.size();
            nodeDeque.push_back(rootNode);                   // Start with the root node

            while (!nodeDeque.empty()) {
                Node* currentNode = nodeDeque.front();
                nodeDeque.pop_front();
                nodeMapping[currentNode->nodeName] = currentNode;

                vector<string> childNames;
                int i = index;
                while (i < min(totalNodes, index + branchFactor)) {
                    childNames.push_back(names[i]);
                    i++;
                }
                currentNode->addChildren(childNames);

                i = 0;
                while (i < currentNode->children.size()) {
                    nodeDeque.push_back(currentNode->children[i]);
                    i++;
                }
                index += branchFactor;
            }
        }

        // Method to lock a node
        bool lockNode(string name, int userID) {
            Node* targetNode = nodeMapping[name];
            if (targetNode->isLocked || !targetNode->lockedDescendants.empty()) return false; // Check locking conditions

            Node* ancestor = targetNode->parent;
            while (ancestor) {
                if (ancestor->isLocked) return false; // Check if any ancestor is locked
                ancestor = ancestor->parent;
            }

            updateAncestors(targetNode->parent, targetNode); // Update locked descendants for ancestors
            targetNode->isLocked = true;                     // Lock the node
            targetNode->lockedByID = userID;
            return true;
        }

        // Method to unlock a node
        bool unlockNode(string name, int userID) {
            Node* targetNode = nodeMapping[name];
            if (!targetNode->isLocked || targetNode->lockedByID != userID) return false; // Check unlocking conditions

            Node* ancestor = targetNode->parent;
            while (ancestor) {
                ancestor->lockedDescendants.erase(targetNode); // Update ancestors about the unlocking
                ancestor = ancestor->parent;
            }

            targetNode->isLocked = false;                    // Unlock the node
            targetNode->lockedByID = -1;
            return true;
        }

        // Method to upgrade the lock of a node
        bool upgradeNodeLock(string name, int userID) {
            Node* targetNode = nodeMapping[name];
            if (targetNode->isLocked || targetNode->lockedDescendants.empty()) return false; // Check upgrade conditions

            auto it = targetNode->lockedDescendants.begin();
            while (it != targetNode->lockedDescendants.end()) {
                if ((*it)->lockedByID != userID) return false; // Check if all descendants are locked by the same ID
                ++it;
            }

            Node* ancestor = targetNode->parent;
            while (ancestor) {
                if (ancestor->isLocked) return false; // Check if any ancestor is locked
                ancestor = ancestor->parent;
            }

            set<Node*> descendantsToUnlock = targetNode->lockedDescendants; // Store locked descendants
            it = descendantsToUnlock.begin();
            while (it != descendantsToUnlock.end()) {
                unlockNode((*it)->nodeName, userID); // Unlock all descendants
                ++it;
            }

            lockNode(name, userID); // Lock the current node
            return true;
        }

    private:
        // Method to update locked descendants for ancestors
        void updateAncestors(Node* ancestor, Node* lockedNode) {
            while (ancestor) {
                ancestor->lockedDescendants.insert(lockedNode);
                ancestor = ancestor->parent;
            }
        }

        // Destructor to clean up dynamically allocated root node
    public:
        ~MTree() {
            delete rootNode; // Delete the root node which will recursively delete all children
        }
    };

    MTree* tree = new MTree(nodeNames[0]);
    tree->buildTree(nodeNames, branchFactor);

    while (operations--) {
        int operationType, userID;
        string nodeName;
        cin >> operationType >> nodeName >> userID;

        if (operationType == 1) {
            cout << (tree->lockNode(nodeName, userID) ? "true" : "false") << endl;
        } else if (operationType == 2) {
            cout << (tree->unlockNode(nodeName, userID) ? "true" : "false") << endl;
        } else if (operationType == 3) {
            cout << (tree->upgradeNodeLock(nodeName, userID) ? "true" : "false") << endl;
        }
    }

    delete tree; // Clean up the MTree object
    return 0;
}

