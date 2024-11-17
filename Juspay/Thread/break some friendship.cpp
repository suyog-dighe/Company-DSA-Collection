#include<bits/stdc++.h>
using namespace std;

class DSU{
    public:
    vector<int> p,r;
    DSU(int n){
        p.resize(n+1);
        r.resize(n+1 , 1);
        for(int i =1; i <= n; i++){
            p[i] = i;
        }
    }
    int find(int x){
        if(x!=p[x])
            p[x] = find(p[x]);
        
        return p[x];
    }
    bool unionSet(int x , int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            if(r[px] > r[py]){
                p[py] = px;
            }
            else if(r[px] < r[py]){
                p[px] = py;
            }
            else{
                p[py] = px;
                r[px]++;
            }
            return true;
        }
        return false;
    }
};

// The solve function should be implemented here
int solve(int n, int k,int m, vector<int>& d, vector<vector<int>>& f) {
   DSU dsu(n);
   unordered_set<int> def(d.begin(),d.end());
   int b=0;
   for(int i=0;i<m;i++){
   	int x=f[i][0];
   	int y= f[i][1];
   	bool dx=def.count(x);
   	bool dy =def.count(y);
   	
   	if((dx && dy) || (!dx && !dy)){
   		dsu.unionSet(x,y);
	   }
	   else{
	   	b++;
	   }
   }
    return b;
}
