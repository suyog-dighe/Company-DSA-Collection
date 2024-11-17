#include<iostream>
#include<thread>
#include<chrono>

using namespace std;

void run(int count){

	while(count-->0){
		cout<<" runnnig thread.."<<endl;
	}
//	std::this_thread::sleep_for(chrono::seconds(2));
	 cout<<"exiting thread...."<<endl;
	
}

int main(){
	std::thread t1(run,10);
	t1.join();  // it is waited for thread to completed
	t1.detach();  // it is not waiting to thread to complete its terminated right away
	if(t1.joinable())
		t1.join();
	cout<<"end process"<<endl;
	return 0;
}
