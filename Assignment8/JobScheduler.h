#ifndef JOBSCHEDULER
#define JOBSCHEDULER


#include "pQueue.h"
#include "Job.h"
#include <iostream>
#include <fstream>

using namespace std;

class JobScheduler{
	
	public:
		
		JobScheduler();
		
		JobScheduler(int timeSlice);
		
		void process(ifstream &FILE);
		
	private:
	
		int slice;
};




#endif
