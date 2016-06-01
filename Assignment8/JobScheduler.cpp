#include <time.h>
#include <stdlib.h>
#include "JobScheduler.h"
#include <fstream>
#include <sstream>
bool isMarked(int cTime,int marks[],int length); //checks if current Time exists in marks array //helps checking if a Job is to be included in this turn.

JobScheduler::JobScheduler(){
	
	slice=1;
	
}

JobScheduler::JobScheduler(int timeSlice){
	
	slice=timeSlice;
	
}

void JobScheduler::process(ifstream &FILE){
	
	
	string line;
	string dump;
	int tempTime;
	int i=0;
	int time=0;
	int hold=0;
	int counter=0;
	int processD,ID,priority,entrance;
	
	while(getline(FILE,line)){
		counter++;
	}
	
	
	Job storage[counter];
	int mark[counter];
	
	FILE.clear();
	FILE.seekg(0, ios::beg);
	
	while(getline(FILE,line)){
	
		istringstream iss(line);
		iss >> entrance >> priority >> ID; 
		
		processD=rand()%5+1;
		storage[i]=Job(entrance,priority,ID,processD);
		mark[i]=entrance;
		i++;
	}
	
	cout<<"Time    will be completed job in x seconds      current job        PQsize"<<endl;
	int cmpTime=0;
	pQueue priorityQueue;
	Job currentJob;
	int curId=0;
	i=0;
	bool isProcess=false;
	int remSlice=0;
	int k;
	time=0;
	bool comp=false;
	int completed;
		
	while (i<counter||!priorityQueue.empty()){

		
		
		if (remSlice==0){
			isProcess=false;
		}
		else 
			isProcess=true;
		
	
		if (isMarked(time,mark,counter)&&isProcess==true){
			priorityQueue.enqueue(storage[i]);
			i++;
		}
		else if (isMarked(time,mark,counter)&&isProcess==false){
				
			if (priorityQueue.empty()||storage[i]>=priorityQueue.front()){
				
				tempTime=storage[i].getProcessTime();
				curId=storage[i].getId();
				if (tempTime>2){
					storage[i].setProcessTime(tempTime-slice);
					priorityQueue.enqueue(storage[i]);
					remSlice=slice;
				}
				else if(tempTime==1){
			
					remSlice=1;
					completed=storage[i].getId();
					cmpTime=1;
					comp=true;
				}
				
				else{
					storage[i].setProcessTime(0);
					completed=storage[i].getId();
					comp=true;
					cmpTime=2;
					remSlice=slice;
				}	
			
			}
			
			else{
				curId=priorityQueue.front().getId();
				tempTime=priorityQueue.front().getProcessTime();
				
				if (tempTime>2){
					priorityQueue.front().setProcessTime(tempTime-slice);
					remSlice=slice;
				}
				else if(tempTime==1){
			
					priorityQueue.dequeue();
					comp=true;
					completed=curId;
					cmpTime=1;
					remSlice=1;
					//completed?
				}
				else {
					completed=curId;
					cmpTime=2;
					remSlice=slice;
					priorityQueue.dequeue();
					comp=true;//in 2
				}
				priorityQueue.enqueue(storage[i]);
			}
			i++;
		}
		else if(!isMarked(time,mark,counter)&&isProcess==true){
			// do nothing
		}
		else if(!isMarked(time,mark,counter)&&isProcess==false&&!priorityQueue.empty()){
			tempTime=priorityQueue.front().getProcessTime();
			curId=priorityQueue.front().getId();
	
			if (tempTime>2){
				priorityQueue.front().setProcessTime(tempTime-slice);
				Job fail(priorityQueue.front().getTime(),priorityQueue.front().getPrio(),priorityQueue.front().getId(),tempTime-slice);
				priorityQueue.dequeue();
				priorityQueue.enqueue(fail);
				remSlice=slice;
				
			}
			else if(tempTime==1){
		
				priorityQueue.dequeue();
				comp=true;
				completed=curId;
				cmpTime=1;
				remSlice=1;
				//completed?
			}
			else{
				completed=curId;
				remSlice=slice;
				cmpTime=slice;
				priorityQueue.dequeue();
				comp=true;//in 2
			}
		}
		
		else{
			//do nothing
		}
	
		if (time>=10){
			
			if (comp==true)
				cout<<time<<"            "<<completed<<" in "<<cmpTime<<"    seconds                   "<<curId<<"               "<<priorityQueue.getQueueSize()<<endl;
			else
				cout<<time<<"            "<<"                                      "<<curId<<"               "<<priorityQueue.getQueueSize()<<endl;	
		
		}
		else{
			
			if (comp==true)
				cout<<time<<"            "<<completed<<" in "<<cmpTime<<"    seconds                    "<<curId<<"               "<<priorityQueue.getQueueSize()<<endl;
			else
				cout<<time<<"            "<<"                                       "<<curId<<"               "<<priorityQueue.getQueueSize()<<endl;
		}
		comp=false;	
			
		time++;
		
		if (remSlice!=0)
			remSlice--;	
	}
	cout << "Number of jobs completed: " <<counter<<endl;
}

bool isMarked(int cTime,int marks[],int length){
	
	
	for(int i=0;i<length;i++){
		if (cTime==marks[i]){
			return true;	
			}
	}	
	return false;

}

