#include<iostream>
#include<thread>
#include<mutex>
using namespace std;
//mutex lock it is a blocking lock means it onces a t1 thread enter into the critical section 
//it was block other until  t1 is complete its task and t1 unlock it when it was unlock the other thread enter into the C.S.
int account=0;
std::mutex m;
void add(){
	m.lock();
	++account;
	m.unlock();
}
int main(){
	std:: thread t1(add);
	std::thread t2(add);
	
	t1.join();
	t2.join();
	
	cout<<account<<endl;
	
	return 0;
	
	
}



