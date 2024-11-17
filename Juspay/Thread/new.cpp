#include <bits/stdc++.h>
using namespace std;

class LockingTree {
    struct Node {
        int id, owner = -1;
        bitset<10000> descendants, ancestors;
        bool is_locked = false;
    };
    
    vector<Node> nodes;
    vector<int> parent;
    unordered_map<string, int> name_to_id;
    vector<string> id_to_name;
    int locked_count = 0;
    
    void dfs(int v, int p = -1) {
        if (p != -1) {
            nodes[v].ancestors = nodes[p].ancestors;
            nodes[v].ancestors.set(p);
        }
        for (int i = 0; i < id_to_name.size(); i++) {
            if (parent[i] == v) {
                nodes[v].descendants.set(i);
                dfs(i, v);
                nodes[v].descendants |= nodes[i].descendants;
            }
        }
    }
    
public:
    LockingTree(const vector<string>& names, int b) {
        int n = names.size();
        nodes.resize(n);
        parent.resize(n);
        id_to_name = names;
        
        for (int i = 0; i < n; i++) {
            nodes[i].id = i;
            name_to_id[names[i]] = i;
            parent[i] = (i == 0) ? -1 : (i - 1) / b;
        }
        
        dfs(0);
    }
    
    bool lock(const string& name, int user) {
        int node_id = name_to_id[name];
        auto& node = nodes[node_id];
        
        if (node.is_locked) return false;
        
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes[i].is_locked && (node.ancestors[i] || node.descendants[i])) {
                return false;
            }
        }
            
        node.is_locked = true;
        node.owner = user;
        locked_count++;
        return true;
    }
    
    bool unlock(const string& name, int user) {
        int node_id = name_to_id[name];
        auto& node = nodes[node_id];
        
        if (!node.is_locked || node.owner != user)
            return false;
            
        node.is_locked = false;
        node.owner = -1;
        locked_count--;
        return true;
    }
    
    bool upgrade(const string& name, int user) {
        int node_id = name_to_id[name];
        auto& node = nodes[node_id];
        
        if (node.is_locked) return false;
        
        bool has_locked_descendant = false;
        vector<int> to_unlock;
        
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes[i].is_locked) {
                if (node.ancestors[i]) return false;
                if (node.descendants[i]) {
                    has_locked_descendant = true;
                    if (nodes[i].owner != user) return false;
                    to_unlock.push_back(i);
                }
            }
        }
        
        if (!has_locked_descendant) return false;
        
        for (int i : to_unlock) {
            nodes[i].is_locked = false;
            nodes[i].owner = -1;
            locked_count--;
        }
        
        node.is_locked = true;
        node.owner = user;
        locked_count++;
        return true;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, b, q;
    cin >> n >> b >> q;
    
    vector<string> names(n);
    for (auto& name : names) {
        cin >> name;
    }
    
    LockingTree tree(names, b);
    
    for (int i = 0; i < q; i++) {
        int op, user;
        string name;
        cin >> op >> name >> user;
        
        bool result;
        switch (op) {
            case 1:
                result = tree.lock(name, user);
                break;
            case 2:
                result = tree.unlock(name, user);
                break;
            case 3:
                result = tree.upgrade(name, user);
                break;
            default:
                result = false;
        }
        cout << (result ? "true" : "false") << endl;
    }
    
    return 0;
}
