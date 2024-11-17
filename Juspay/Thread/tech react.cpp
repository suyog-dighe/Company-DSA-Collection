#include<bits/stdc++.h>
using namespace std;
void dfs(int node, unordered_map<int, vector<int>>& g, unordered_set<int>& vis){
    vis.insert(node);
    for(int n : g[node]){
        if(vis.find(n) == vis.end()){
            dfs(n, g, vis);
        }
    }
}

int solve(int n, vector<int>& memberid, int m, vector<vector<int>>& fr) {
    // Write your code here
    unordered_map<int, vector<int>> g;
    for(auto &it:fr){
        g[it[0]].push_back(it[1]);
        g[it[1]].push_back(it[0]);
    }
    unordered_set<int> vis;
    int cnt = 0;
    for(int id : memberid){
        if(vis.find(id) == vis.end()){
            dfs(id, g, vis);
            cnt++;
        }
    }
    return cnt;
}
