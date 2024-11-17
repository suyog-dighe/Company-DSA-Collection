#include<bits/stdc++.h>
using namespace std;

int solve(int n, vector<int>& id, int m, vector<vector<int>>& fr, int k) {
    // Write your code here
    unordered_map<int, int> mp;
    for(int i = 0 ;i < n ; i++){
        mp[id[i]] = i;
    }
    vector<vector<int>> g(n);
    for(const auto& p : fr)
    {
        int x = mp[p[0]];
        int y = mp[p[1]];
        g[x].push_back(y);
        g[y].push_back(x);
    }
    int s = mp[k];
    vector<int> v(n , -1);
    queue<int> q;
    q.push(s);
    v[s] = 0;
    while(!q.empty()){
        int c = q.front();
        q.pop();
        for(int nbr : g[c]){
            if(v[nbr] == -1){
                v[nbr] = v[c]+1;
                q.push(nbr);
            }
        }
    }
    int res = 0;
    for(int i: v){
        if(i==-1)
            return -1;
        res = max(res , i);
    }
    return res;
}
