#define CAP 20
#include "pQueue.h"


int leftChild(int num); // returns num*2 +1

int parent(int num);  // returns num-1 / 2
		
int rightChild(int num);  // returns num*2 +2

pQueue::pQueue(){
	
	size=-1;
	
	
}

int pQueue::getQueueSize(){
	
	return size+1;
	
}


bool pQueue::empty(){
	
	return size==-1;
	
}


void pQueue::enqueue(ItemType item){

	size++;
	queue[size]=item;
	
	int current=size;
	if (size!=0){
		while (parent(current)>=0){
			
			if (queue[current]>queue[parent(current)]){
				
				swap(queue[current],queue[parent(current)]);
				
				if (current==1)
					current=-10; //leave the loop
				else
					current=parent(current);  
			}
			else 
				current=-3;
		}	
	}
}

void pQueue::dequeue(){
	

	queue[0]=queue[size];
	size--;
	pQueue swapQueue;

	for(int i=0; i<=size; i++)
		swapQueue.enqueue(queue[i]);
	for(int k=0; k<=size; k++)
		queue[k]=swapQueue.queue[k];

}

ItemType pQueue::front(){
	
	return queue[0];	
}

void pQueue::displayQueue(){
	
	int i;
	
	for(i=0;i<=size;i++){
		cout<<queue[i]<<" q["<<i<<"]"<<endl;
	}
}

int leftChild(int num){
	
	return num*2+1;
	
}
int parent(int num){
	
	return (num-1)/2;
	
}
		
int rightChild(int num){
	
	return num*2+2;
	
}

