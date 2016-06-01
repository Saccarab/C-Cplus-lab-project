#ifndef PQUEUE
#define PQUEUE

#include "Job.h"

#include<iostream>

typedef Job ItemType;
using namespace std;

class pQueue{
	
	public:
		pQueue();
		
		int getQueueSize();
		//returns Queue Size
		bool empty();
		//returns true if queue is empty
		void enqueue(ItemType item);
		//queues item
		void dequeue();
		//dequeue
		
		
		//void helper(int iParent);
		
		ItemType front();
		//returns first priority item
		void displayQueue();
		
	private:
		
		int size;
		ItemType queue[20];
};

#endif
