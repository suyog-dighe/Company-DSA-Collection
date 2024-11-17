#include<iostream>
#include<thread>
#include<mutex>

using namespace std;

// mutex or mutual exclusive with try_lock it is a non blocking lock

std::mutex mtx;
int count=0;

void counter(){
	for(int i=0;i<100000;i++){
		if(mtx.try_lock()){
			++count;
			mtx.unlock();
		}
//		mtx.lock();
//		count++;
//		mtx.unlock();
		
	}
}

int main(){
	std:: thread t1(counter);
	std:: thread t2(counter);
	
	t1.join();
	t2.join();
	
	cout<<"counter increases upto :"<<count<<endl;
	
}
