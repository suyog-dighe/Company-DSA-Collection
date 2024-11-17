#include <iostream>
#include <vector>
#include <deque>
#include <unordered_map>
#include <algorithm>

using namespace std;

void readInput(int &nodeCount, int &branchFactor, int &operations, vector<string> &nodeNames) {
    cin >> nodeCount >> branchFactor >> operations;
    nodeNames.resize(nodeCount);
    for (int j = 0; j < nodeCount; ++j) {
        cin >> nodeNames[j];
    }
}

class TreeNode {
public:
    string name;
    int ownerId;
    bool locked;
    vector<TreeNode*> children;
    TreeNode* parent;
    vector<TreeNode*> lockedChildren;

    TreeNode(const string& name, TreeNode* parentNode) : name(name), ownerId(-1), parent(parentNode), locked(false) {}

    void addChildren(const vector<string>& childNames) {
        for (const auto& childName : childNames) {
            children.push_back(new TreeNode(childName, this));
        }
    }

    ~TreeNode() {
        for (auto* child : children) {
            delete child;
        }
    }
};

class MTree {
private:
    TreeNode* root;
    unordered_map<string, TreeNode*> nodeLookup;

public:
    MTree(const string& rootName) {
        root = new TreeNode(rootName, nullptr);
    }

    void build(const vector<string>& names, int limit) {
        deque<TreeNode*> queue;
        queue.push_back(root);
        int index = 1;

        while (!queue.empty()) {
            TreeNode* currentNode = queue.front();
            queue.pop_front();
            nodeLookup[currentNode->name] = currentNode;

            vector<string> childNames;
            for (int i = index; i < min(static_cast<int>(names.size()), index + limit); ++i) {
                childNames.push_back(names[i]);
            }

            currentNode->addChildren(childNames);
            for (auto* child : currentNode->children) {
                queue.push_back(child);
            }
            index += limit;
        }
    }

    bool lock(const string& nodeName, int userId) {
        TreeNode* target = nodeLookup[nodeName];
        if (target->locked || !target->lockedChildren.empty()) return false;

        for (TreeNode* ancestor = target->parent; ancestor; ancestor = ancestor->parent) {
            if (ancestor->locked) return false;
        }

        for (TreeNode* ancestor = target->parent; ancestor; ancestor = ancestor->parent) {
            ancestor->lockedChildren.push_back(target);
        }

        target->locked = true;
        target->ownerId = userId;
        return true;
    }

    bool unlock(const string& nodeName, int userId) {
        TreeNode* target = nodeLookup[nodeName];
        if (!target->locked || target->ownerId != userId) return false;

        for (TreeNode* ancestor = target->parent; ancestor; ancestor = ancestor->parent) {
            auto it = find(ancestor->lockedChildren.begin(), ancestor->lockedChildren.end(), target);
            if (it != ancestor->lockedChildren.end()) {
                ancestor->lockedChildren.erase(it);
            }
        }

        target->locked = false;
        target->ownerId = -1;
        return true;
    }

    bool upgrade(const string& nodeName, int userId) {
        TreeNode* target = nodeLookup[nodeName];
        if (target->locked || target->lockedChildren.empty()) return false;

        for (auto* child : target->lockedChildren) {
            if (child->ownerId != userId) return false;
        }

        for (TreeNode* ancestor = target->parent; ancestor; ancestor = ancestor->parent) {
            if (ancestor->locked) return false;
        }

        for (auto* child : target->lockedChildren) {
            unlock(child->name, userId);
        }

        lock(nodeName, userId);
        return true;
    }

public:
    ~MTree() {
        delete root;
    }
};

int main() {
    int nodeCount, branchFactor, operations;
    vector<string> nodeNames;

    // Call the input function to read the data
    readInput(nodeCount, branchFactor, operations, nodeNames);

    MTree* myTree = new MTree(nodeNames[0]);
    myTree->build(nodeNames, branchFactor);

    while (operations--) {
        int opType, userId;
        string nodeName;
        cin >> opType >> nodeName >> userId;

        if (opType == 1) {
            cout << (myTree->lock(nodeName, userId) ? "true" : "false") << endl;
        } else if (opType == 2) {
            cout << (myTree->unlock(nodeName, userId) ? "true" : "false") << endl;
        } else if (opType == 3) {
            cout << (myTree->upgrade(nodeName, userId) ? "true" : "false") << endl;
        }
    }

    delete myTree;
    return 0;
}

