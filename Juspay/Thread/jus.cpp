#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <string>

// Tree Node class to represent each node in the M-ary tree
class TreeNode {
    friend class MultiTree;

private:
    std::string nodeName;     // Label of the node
    int userLockId;           // ID of the user who locked the node
    bool locked;              // Flag to check if the node is locked
    int descendantLockCount;  // Number of locked descendant nodes
    std::vector<TreeNode*> children;  // Vector of pointers to child nodes
    TreeNode* parentNode;             // Pointer to parent node

public:
    TreeNode(const std::string& name, TreeNode* parent = nullptr) : 
        nodeName(name), userLockId(-1), locked(false), descendantLockCount(0), parentNode(parent) {}

    void addChildren(const std::vector<std::string> &childLabels, std::unordered_map<std::string, TreeNode*> &nodeMap) {
        for (const std::string &child : childLabels) {
            TreeNode* childNode = new TreeNode(child, this);
            children.push_back(childNode);
            nodeMap[child] = childNode;
        }
    }

    ~TreeNode() {
        for (TreeNode* child : children) {
            delete child;
        }
    }
};

// Class to implement the M-ary Tree and its lock management
class MultiTree {
private:
    TreeNode* root;                          // Pointer to the root node
    std::unordered_map<std::string, TreeNode*> nodeMap; // Map from node labels to node pointers

    // Update the count of locked nodes for ancestors
    void updateLockCount(TreeNode* ancestor, int valueChange) {
        while (ancestor) {
            ancestor->descendantLockCount += valueChange;
            ancestor = ancestor->parentNode;
        }
    }

    // Check if any ancestor node is locked
    bool ancestorLocked(TreeNode* currentNode) const {
        TreeNode* checkNode = currentNode->parentNode;
        while (checkNode) {
            if (checkNode->locked) return true;
            checkNode = checkNode->parentNode;
        }
        return false;
    }

public:
    MultiTree(const std::string &rootLabel) {
        root = new TreeNode(rootLabel);
        nodeMap[rootLabel] = root;
    }

    ~MultiTree() {
        delete root;  // Deletes the entire tree recursively
    }

    // Build the M-ary Tree using a list of node labels and branching factor
    void buildTree(const std::vector<std::string> &labels, int branches) {
        std::queue<TreeNode*> nodeQueue;
        nodeQueue.push(root);
        int index = 1;

        while (!nodeQueue.empty() && index < labels.size()) {
            TreeNode* current = nodeQueue.front();
            nodeQueue.pop();

            std::vector<std::string> childNames;
            for (int i = 0; i < branches && index < labels.size(); i++, index++) {
                childNames.push_back(labels[index]);
            }

            current->addChildren(childNames, nodeMap);

            for (TreeNode* child : current->children) {
                nodeQueue.push(child);
            }
        }
    }

    bool lockNode(const std::string &nodeLabel, int userId) {
        TreeNode* lockNode = nodeMap[nodeLabel];

        if (lockNode->locked || lockNode->descendantLockCount > 0 || ancestorLocked(lockNode)) {
            return false;
        }

        lockNode->locked = true;
        lockNode->userLockId = userId;
        updateLockCount(lockNode->parentNode, 1);
        return true;
    }

    bool unlockNode(const std::string &nodeLabel, int userId) {
        TreeNode* unlockNode = nodeMap[nodeLabel];

        if (!unlockNode->locked || unlockNode->userLockId != userId) return false;

        unlockNode->locked = false;
        unlockNode->userLockId = -1;
        updateLockCount(unlockNode->parentNode, -1);
        return true;
    }

    bool upgradeNodeLock(const std::string &nodeLabel, int userId) {
        TreeNode* upgradeNode = nodeMap[nodeLabel];

        if (upgradeNode->locked || upgradeNode->descendantLockCount == 0 || ancestorLocked(upgradeNode)) {
            return false;
        }

        // Ensure all descendants are locked by the same user
        std::queue<TreeNode*> nodesQueue;
        nodesQueue.push(upgradeNode);
        std::vector<TreeNode*> lockedNodes;

        while (!nodesQueue.empty()) {
            TreeNode* currentNode = nodesQueue.front();
            nodesQueue.pop();

            for (TreeNode* child : currentNode->children) {
                if (child->locked) {
                    if (child->userLockId != userId) return false;
                    lockedNodes.push_back(child);
                }
                nodesQueue.push(child);
            }
        }

        for (TreeNode* descNode : lockedNodes) {
            unlockNode(descNode->nodeName, userId);
        }

        return lockNode(nodeLabel, userId);
    }
};

// Function to read inputs and manage operations on the tree
void readInputs(MultiTree &tree) {
    int nodeCount, branchingFactor, queryCount, userId, command;
    std::string nodeLabel;

    // Read the number of nodes and branching factor
    std::cin >> nodeCount >> branchingFactor;

    // Read the number of queries
    std::cin >> queryCount;

    // Read the node labels in one line
    std::vector<std::string> nodeLabels(nodeCount);
    for (int i = 0; i < nodeCount; i++) {
        std::cin >> nodeLabels[i];
    }

    // Build the tree based on the labels and branching factor
    tree.buildTree(nodeLabels, branchingFactor);

    // Process each query
    for (int i = 0; i < queryCount; i++) {
        std::cin >> command >> nodeLabel >> userId;

        if (command == 1) {  // Lock node
            std::cout << (tree.lockNode(nodeLabel, userId) ? "true" : "false") << "\n";
        } else if (command == 2) {  // Unlock node
            std::cout << (tree.unlockNode(nodeLabel, userId) ? "true" : "false") << "\n";
        } else if (command == 3) {  // Upgrade lock
            std::cout << (tree.upgradeNodeLock(nodeLabel, userId) ? "true" : "false") << "\n";
        }
    }
}


int main() {
    std::string rootLabel;
    std::cin >> rootLabel;

    MultiTree lockTree(rootLabel);
    readInputs(lockTree);

    return 0;
}
