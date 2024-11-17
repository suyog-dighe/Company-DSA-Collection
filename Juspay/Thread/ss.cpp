#include <iostream>
#include <vector>
#include <deque>
#include <map>
#include <algorithm>

using namespace std;

int main() {
    int n, bFactor, ops;
    cin >> n >> bFactor >> ops;

    vector<string> nodes(n);
    for (int i = 0; i < n; ++i) {
        cin >> nodes[i];
    }

    class TreeNode {
    public:
        string name;
        int lockedBy;
        bool isLocked;
        vector<TreeNode*> children;
        TreeNode* parent;
        vector<TreeNode*> lockedChildren;  // Change to vector

        // Constructor
        TreeNode(string nm, TreeNode* par) : name(nm), lockedBy(-1), parent(par), isLocked(false) {}

        // Add child nodes
        void addKids(const vector<string>& childNames) {
            for (const auto& ch : childNames) {
                children.push_back(new TreeNode(ch, this));
            }
        }

        // Destructor
        ~TreeNode() {
            for (auto* child : children) {
                delete child;
            }
        }
    };

    class MTree {
    private:
        TreeNode* root;
        map<string, TreeNode*> nodeMap;

    public:
        MTree(string rootName) {
            root = new TreeNode(rootName, nullptr);
        }

        // Build the tree
        void build(const vector<string>& names, int bFactor) {
            deque<TreeNode*> queue;
            int idx = 1, total = names.size();
            queue.push_back(root);

            while (!queue.empty()) {
                TreeNode* curr = queue.front();
                queue.pop_front();
                nodeMap[curr->name] = curr;

                vector<string> childNames;
                for (int i = idx; i < min(total, idx + bFactor); ++i) {
                    childNames.push_back(names[i]);
                }

                curr->addKids(childNames);

                for (auto* child : curr->children) {
                    queue.push_back(child);
                }
                idx += bFactor;
            }
        }

        // Lock node
        bool lock(const string& name, int userId) {
            TreeNode* node = nodeMap[name];
            if (node->isLocked || !node->lockedChildren.empty()) return false;

            for (TreeNode* par = node->parent; par; par = par->parent) {
                if (par->isLocked) return false;
            }

            // Update parent nodes
            for (TreeNode* par = node->parent; par; par = par->parent) {
                par->lockedChildren.push_back(node);
            }

            node->isLocked = true;
            node->lockedBy = userId;
            return true;
        }

        // Unlock node
        bool unlock(const string& name, int userId) {
            TreeNode* node = nodeMap[name];
            if (!node->isLocked || node->lockedBy != userId) return false;

            // Remove from parent lockedChildren
            for (TreeNode* par = node->parent; par; par = par->parent) {
                auto it = find(par->lockedChildren.begin(), par->lockedChildren.end(), node);
                if (it != par->lockedChildren.end()) {
                    par->lockedChildren.erase(it);
                }
            }

            node->isLocked = false;
            node->lockedBy = -1;
            return true;
        }

        // Upgrade lock
        bool upgrade(const string& name, int userId) {
            TreeNode* node = nodeMap[name];
            if (node->isLocked || node->lockedChildren.empty()) return false;

            // Check if all locked by the same user
            for (auto* child : node->lockedChildren) {
                if (child->lockedBy != userId) return false;
            }

            for (TreeNode* par = node->parent; par; par = par->parent) {
                if (par->isLocked) return false;
            }

            // Unlock children
            for (auto* child : node->lockedChildren) {
                unlock(child->name, userId);
            }

            lock(name, userId);
            return true;
        }

    public:
        ~MTree() {
            delete root;
        }
    };

    MTree* tree = new MTree(nodes[0]);
    tree->build(nodes, bFactor);

    while (ops--) {
        int type, userId;
        string nodeName;
        cin >> type >> nodeName >> userId;

        if (type == 1) {
            cout << (tree->lock(nodeName, userId) ? "true" : "false") << endl;
        } else if (type == 2) {
            cout << (tree->unlock(nodeName, userId) ? "true" : "false") << endl;
        } else if (type == 3) {
            cout << (tree->upgrade(nodeName, userId) ? "true" : "false") << endl;
        }
    }

    delete tree;
    return 0;
}

