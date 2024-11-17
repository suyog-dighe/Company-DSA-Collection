#include<iostream>
#include<thread>
#include<mutex>

using namespace std;
// Process Synchronize	

long balance=0;
std::mutex m;

void addmoney(long money){
	m.lock();
	m.unlock();
	balance +=money;
}

int main(){
	std::thread t1(addmoney,1205);
	std::thread t2(addmoney,2852);
	
	t1.join();
	t2.join();
	
	cout<<"balance :"<<balance<<endl;
	
	return 0;
}
