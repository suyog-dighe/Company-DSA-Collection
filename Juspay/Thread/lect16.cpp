#include<iostream>
#include<thread>
#include<mutex>
#include<chrono>
#include<algorithm>
#include<future>

using namespace std;
using namespace std::chrono;

typedef long int ull;

ull findodd(ull start,ull end){
	ull oddsum=0;
	for(ull i=start;i<=end;i++){
		if(i & 1){
			oddsum +=i;
		}
	}
	return oddsum;
}
int main(){
	
	ull start=0,end=190000000;
	cout<<"thread created policy is std:: launch :: async!!"<<endl;
	
	std::future<ull> oddsum=std::async(std::launch::deferred,findodd,start,end);
	
	cout<<"Wating for result !! "<<endl;
	cout<<"oddsum :"<<oddsum.get()<<endl;
	
	cout<<"completed !"<<endl;
	return 0;	
}
