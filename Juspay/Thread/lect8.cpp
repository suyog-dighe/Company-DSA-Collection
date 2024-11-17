#include<iostream>
#include<thread>
#include<mutex>
#include<chrono>

using namespace std;

//1 Recursive Mutex example

std::recursive_mutex m1;
int buffer=0;

void recursion(char ch, int loopfor){
	if(loopfor<0){
		return;
	}
	m1.lock();
	
//	std::this_thread::sleep_for(chrono::seconds(1));
	cout<<ch<<" "<<buffer++<<endl;
	recursion(ch,--loopfor);
	m1.unlock();
	cout<<"thread unlocked by :"<<ch<<endl;
}
int main(){
	thread t1(recursion,'1',10);
	thread t2(recursion,'2',10);
	
	t1.join();
	t2.join();
	
	//loop example
	for(int i=0;i<5;i++){
		m1.lock();
		cout<<"locked "<<i<<endl;
	}
	for(int i=0;i<5;i++){
		m1.unlock();
		cout<<"unlocked "<<i<<endl;
	}
	
	return 0;
	
}
