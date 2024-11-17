#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <algorithm>

using namespace std;

class N {
public:
    string nm;                // Node name
    int lBy;                  // Locked by user ID (-1 if not locked)
    bool l;                   // Locked status
    vector<N*> ch;           // Children nodes
    N* par;                   // Parent node
    vector<N*> lDesc;        // Locked descendants

    N(string n, N* p) : nm(n), par(p), lBy(-1), l(false) {}

    void addCh(const vector<string>& nms) {
        for (const string& n : nms) {
            ch.push_back(new N(n, this));
        }
    }
};

class LM {
private:
    unordered_map<string, N*> nodes;  // Mapping of node names to nodes

public:
    N* getNode(const string& nm) {
        auto it = nodes.find(nm);
        return (it != nodes.end()) 

    void addNode(const string& nm, N* n) {
        nodes[nm] = n;
    }

    bool lock(N* n, int uId) {
        if (!n || n->l || !n->lDesc.empty()) return false;  // Ensure node exists and is not locked or has locked descendants

        N* p = n->par;
        while (p) {
            if (p->l) return false;  // Cannot lock if any ancestor is locked
            p = p->par;
        }

        n->l = true;
        n->lBy = uId;
        updateParent(n->par, n, true);  // Update locked descendants in ancestors
        return true;
    }

    bool unlock(N* n, int uId) {
        if (!n || !n->l || n->lBy != uId) return false;  // Ensure node exists, is locked, and is locked by the same user

        n->l = false;
        n->lBy = -1;
        updateParent(n->par, n, false);  // Update unlocked descendants in ancestors
        return true;
    }

    bool upgrade(N* n, int uId) {
        if (!n || n->l || n->lDesc.empty()) return false;  // Ensure node exists, is not locked, and has locked descendants

        for (N* desc : n->lDesc) {
            if (desc->lBy != uId) return false;  // Ensure all locked descendants are by the same user
        }

        // Unlock all locked descendants
        for (N* desc : n->lDesc) {
            unlock(desc, uId);
        }

        return lock(n, uId);  // Lock the current node
    }

private:
    void updateParent(N* p, N* n, bool isLock) {
        while (p) {
            if (isLock) {
                // Lock operation: add the node to locked descendants
                p->lDesc.push_back(n);  // Add the locked node
            } else {
                // Unlock operation: remove the node from locked descendants
                auto it = remove(p->lDesc.begin(), p->lDesc.end(), n);
                p->lDesc.erase(it, p->lDesc.end()); // Remove the node from the vector
            }
            p = p->par; // Move to the parent node
        }
    }
};

class TB {
public:
    static N* buildTree(const vector<string>& nms, int chPerN, LM& mgr) {
        if (nms.empty()) return nullptr;

        N* root = new N(nms[0], nullptr);
        mgr.addNode(nms[0], root);

        queue<N*> q;
        q.push(root);
        size_t idx = 1;
        while (!q.empty() && idx < nms.size()) {
            N* cur = q.front();
            q.pop();

            vector<string> chNms;
            for (int i = 0; i < chPerN && idx < nms.size(); ++i) {
                chNms.push_back(nms[idx++]);
            }
            cur->addCh(chNms);

            for (N* c : cur->ch) {
                q.push(c);
                mgr.addNode(c->nm, c);
            }
        }

        return root;
    }
};

int main() {
    int n, m, t;
    cin >> n >> m >> t;

    vector<string> nms(n);
    for (int i = 0; i < n; i++) {
        cin >> nms[i];
    }

    LM mgr;
    N* root = TB::buildTree(nms, m, mgr);

    while (t--) {
        int op, uId;
        string nm;
        cin >> op >> nm >> uId;

        N* n = mgr.getNode(nm);

        if (!n) {
            cout << "false" << endl;  // Ensure the node exists
            continue;  // Skip this iteration if node doesn't exist
        }

        switch (op) {
            case 1:
                cout << (mgr.lock(n, uId) ? "true" : "false") << endl;
                break;
            case 2:
                cout << (mgr.unlock(n, uId) ? "true" : "false") << endl;
                break;
            case 3:
                cout << (mgr.upgrade(n, uId) ? "true" : "false") << endl;
                break;
        }
    }

    return 0;
}

