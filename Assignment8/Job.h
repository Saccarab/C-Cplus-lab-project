#ifndef JOB
#define JOB

#include<iostream>

using namespace std;

class Job {


	public:
		Job();
			
		Job(int nTime,int nPrio, int idNumber,int nProcessTime);
		
		bool operator>(const Job &Job1);
		
		bool operator<(const Job &Job1);
		
		bool operator>=(const Job &Job1);
		
		//Job& operator=(const Job &Job1);
	
		void swap(Job &Job1,Job &Job2);	
		
		friend ostream& operator<<(ostream & out, const Job & b);	
		
		void setId(int num);
		
		void setTime(int num);
		
		void setProcessTime(int num);
		
		void setPrio(int num);
		
		int getId();
		
		int getTime();
		
		int getProcessTime();
		
		int getPrio();
		
	private:
		
		int id;
		int time;
		int prio;
		int processTime;
};
		
#endif
