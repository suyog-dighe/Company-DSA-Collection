#include<iostream>
#include<thread>
#include<mutex>
#include<chrono>
using namespace std;

std::mutex m1;
int buffer=0;

//lock_guard
void task(const char* num,int loopfor){

	std::lock_guard<mutex> lock(m1);
	for(int i=0;i<loopfor;i++){
		std::this_thread::sleep_for(chrono::seconds(1));
		buffer++;
		cout<<num<<" "<<buffer<<endl;
	}
}

// unique_lock
//		- defer_lock
//		- try_to_lock
//		- adopt_lock

void task1(const char* num, int loopfor){
	std::unique_lock<mutex> lock(m1);
	for(int i=0;i<loopfor;i++){
		buffer++;
		cout<<num<<" "<<buffer<<endl;
	}
}

// defer_lock :- do not aquire ownership of the mutex
void task2(const char* num, int loopfor){
	std::unique_lock<mutex> lock(m1,defer_lock);
	lock.lock();
	for(int i=0;i<loopfor;i++){
		buffer++;
		cout<<num<<" "<<buffer<<endl;
	}
}

// try_to_lock :- try to aquire ownership of the mutex without blocking
void task3(const char* num, int loopfor){
	std::unique_lock<mutex> lock(m1,try_to_lock);
	lock.lock();
	for(int i=0;i<loopfor;i++){
		buffer++;
		cout<<num<<" "<<buffer<<endl;
	}
}

// adopt_lock :- assume the calling thread already has ownership of the mutex
void task4(const char* num, int loopfor){
	std::unique_lock<mutex> lock(m1,adopt_lock);
	lock.lock();
	for(int i=0;i<loopfor;i++){
		buffer++;
		cout<<num<<" "<<buffer<<endl;
	}
}


int main(){
	thread t1(task4,"t1",10);
	thread t2(task4,"t2",10);
	t1.join();
	t2.join();
	
	return 0;
	
}
