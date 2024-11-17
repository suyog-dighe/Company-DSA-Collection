// Suyog

#include<iostream>
// #include <iostream>
// #include<bits/stdc++.h>
#include<vector>
#include<unordered_map>
#include<queue>
#include<set>
#include<mutex>

using namespace std;

// Tree build Node
class LokingTree{
	public:
	string country;
	int islockby;
	bool islockedthenode;
	vector<LokingTree*> childenodes;
	LokingTree* parentnode;
	set<LokingTree*> descendentnode;
    std::mutex m;


	//constructor
	LokingTree(string node ,LokingTree* parent): country(node),parentnode(parent),islockby(-1),islockedthenode(false){}

	void addchildrentotree(const vector<string>& namenodes){
		for(const string& nt:namenodes){
			childenodes.push_back(new LokingTree(nt,this));
		}
	}
};

// tree lock operation 
//1. Lock
//2. Unlock
//3. Upgrade
class TreeLock{
	private:
	unordered_map<string , LokingTree*> nodes;
	public:
	//get the node from tree
	LokingTree* gettingNode(const string& namenode){
		if(nodes.find(namenode) !=nodes.end()){
			return nodes[namenode];
			
		}
		else{
			return nullptr;
		}
		
	}
	//add the node 
	void addNode(const string& nm,LokingTree* n){
		nodes[nm]=n;
	}
	// operation for the lock
	bool locknode(LokingTree* country, int user){
		
		country-> m.lock();
		
		if(!country || country->islockedthenode || ) return false;

		if(!country->descendentnode.empty())return false;
		LokingTree* p = country->parentnode;
		
		while(p){
//			p->m.lock();
			if(p->islockedthenode){
//			p->m.unlock();
            country->m.unlock();
				return false;
			}
			p=p->parentnode;
		}
		
//		country-> m2.lock();
		
		country->islockedthenode=true;
		country->islockby=user;
		updateparentnode(country->parentnode,country);
		
//		country-> m2.unlock();
		
		country-> m.unlock();
		return true;
	}

	// operation for the unlock
	bool unlocknode(LokingTree* node, int user){
		if(!node || !node->islockedthenode ||  node->islockby !=user) return false;
		node->islockedthenode=false;
		node->islockby=-1;
		updatparentnodelock(node->parentnode,node);
		return true;
	}

	//operation for the upgrade 
	bool upgradenode(LokingTree* country,int user){
		if(!country || country->islockedthenode ) return false;
		if(country->descendentnode.empty()) return false;

		for(LokingTree* desct: country->descendentnode){
			if(!desct || desct->islockby !=user){
				return false;
			}
		}
		vector<LokingTree*> desctounlock(country->descendentnode.begin(),country->descendentnode.end());
		for(LokingTree* desct: desctounlock){
			unlocknode(desct, user);
		}
		return locknode(country,user);
	}

private:
	
	void updateparentnode(LokingTree* p, LokingTree* n){
		while(p){
			p->descendentnode.insert(n);// insert the node
			p=p->parentnode;
		}
	}
	void updatparentnodelock(LokingTree* p, LokingTree* n){
		while(p){
			p->descendentnode.erase(n); // erase or delete the node
			p=p->parentnode;
		}
	}
};

// build a balanced tree 
class Tree{
	public:
	// function for the build operation
	static LokingTree* buildtreefromnodes(const vector<string>& nodemanage,int childeparentnode , TreeLock& nodecheck){
		if(nodemanage.empty()) return nullptr;

		LokingTree* root= new LokingTree(nodemanage[0],nullptr);
		nodecheck.addNode(nodemanage[0], root);

		// queue created
		queue<LokingTree*> q;
		q.push(root);
		size_t index=1;

		while(!q.empty() && index< nodemanage.size()){
			LokingTree* curr=q.front();
			q.pop();

			vector<string> childnodesmanage;

			for(int i=0;i<childeparentnode && index <nodemanage.size();i++){
				childnodesmanage.push_back(nodemanage[index++]);
			}
			curr->addchildrentotree(childnodesmanage);

			for(LokingTree* c: curr->childenodes){
				q.push(c);
				nodecheck.addNode(c->country,c);
			}
		}
		return root;
	}
};

// void inputdata(int& n,int& m, int& t,vector<string>& nms){
	
// }
int main(){
	int n,m,t;
	cin>> n>> m>> t;

	vector<string> tree(n);

	for(int i=0;i<n;i++){
		cin>>tree[i];
	}
	TreeLock balancedtree;
	//tree build
	LokingTree* root=Tree::buildtreefromnodes(tree, m, balancedtree);

	//using while operation to check test cases and all things
	while(t--){
		int operation,user;
		string namenode;
		cin>>operation>>namenode>>user;
		LokingTree* n= balancedtree.gettingNode(namenode);

		if(!n){
			cout<<"false"<<endl;
			continue;
		}
		switch (operation) {
		case 1:
			cout<<(balancedtree.locknode(n,  user) ? "true" :"false")<<endl;
			break;

		case 2:
			cout<<(balancedtree.unlocknode(n, user) ? "true" :"false")<<endl;
			break;
		
		case 3:
			cout<<(balancedtree.upgradenode(n, user) ? "true" :"false")<<endl;
			break;
		}
	}
return 0;
}

