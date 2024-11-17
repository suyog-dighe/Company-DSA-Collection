#include<iostream>
#include<thread>
#include<mutex>
#include<condition_variable>
#include<chrono>

using namespace std;

//condition variable is for to notify all other thread those are in waiting 
// suppose t1 enters and starting its execuation then t2 waits outside  
//when t1 is completed at that time condition variable notify to t2 to enter it and take cpu 

std::condition_variable cv;
std::mutex m;
long balance=0;

void addmoney(int money){
	std::lock_guard<mutex> lg(m);
	balance+=money;
	cout<<"amount added successfully :"<<balance<<endl;
		std::this_thread::sleep_for(chrono::seconds(1));
	cv.notify_one();
}

void withdrwal(int money){
	std::unique_lock<mutex> ul(m);
	cv.wait(ul,[]{return (balance !=0)? true :false;});
	if(balance>=money){
		balance -=money;
		cout<<"Amount Withdrwal successfully : "<<money<<endl;
	}
	else{
		cout<<"can't withdrwal the money balance is less than "<<money<<endl;
	}
	cout<<"current balanced :"<<balance<<endl;
}
int main(){

	std::thread t1(withdrwal,5498);
	std::thread t2(addmoney,9236);
	t1.join();
	t2.join();
	
	return 0;
	
	
}
