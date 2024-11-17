#include<iostream>

using namespace std;

class heap{
	public:
	int size;
	int arr [100];
	
	heap(){
		arr[0]=-1;
		size=0;
	}
	//max heap insertion
	void insert(int val){
		size++;
		int index=size;
		arr[index]=val;
		
		while(index>1){
			int parent =index/2;
			if(arr[parent]<arr[index]){
				swap(arr[parent],arr[index]);
				index=parent;
			}else{
				return;
			}
		}	
	}
	//min heap insertion
	void insertmin(int val){
		size++;
		int index=size;
		arr[index]=val;
		
		while(index>1){
			int parent =index/2;
			if(arr[parent]>arr[index]){
				swap(arr[parent],arr[index]);
				index=parent;
			}else{
				return;
			}
		}	
	}
	//delete value from heap for max heap
	void deleteMax(){
		if(size==0){
			cout<<"Nothing to delete";
			return;
		}
		arr[1]=arr[size];
		size--;
		int i=1;
		while(i<size){
			int left=2*i;
			int right=2*i+1;
			if(left < size && arr[i]< arr[left]){
				swap(arr[i],arr[left]);
				i=left;
			}
			else if(right<size && arr[i] < arr[right]){
				swap(arr[i],arr[right]);
				i=right;
			}else{
				return;
			}
		}
	}
	void deleteMin(){
		if(size==0){
			cout<<"Nothing to delete";
			return;
		}
		arr[1]=arr[size];
		size--;
		int i=1;
		while(i<size){
			int left=2*i;
			int right=2*i+1;
			if(left < size && arr[i] > arr[left]){
				swap(arr[i],arr[left]);
				i=left;
			}
			else if(right<size && arr[i] > arr[right]){
				swap(arr[i],arr[right]);
				i=right;
			}else{
				return;
			}
		}
	}
	void print(){
		for(int i=1;i<=size;i++){
			cout<<arr[i]<<" ";
		}cout<<endl;
	}
};

int main(){
	heap h;
	h.insert(20);
	h.insert(45);
	h.insert(67);
	h.insert(9);
	h.insert(50);
	h.insert(26);
	h.print();
	h.deleteMax();
	h.print();
	cout<<endl;
	heap h1;
	h1.insertmin(20);
	h1.insertmin(45);
	h1.insertmin(67);
	h1.insertmin(9);
	h1.insertmin(50);
	h1.insertmin(26);
	h1.print();
	h1.deleteMin();
	h1.print();
	
}
