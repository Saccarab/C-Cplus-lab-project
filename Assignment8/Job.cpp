#include "Job.h"

Job::Job(){
	id=0;
	time=0;
	prio=0;
	processTime=0;	
}


Job::Job(int nTime,int nPrio, int idNumber,int nProcessTime){
	id=idNumber;
	time=nTime;
	prio=nPrio;
	processTime=nProcessTime;
}

bool Job::operator>(const Job &Job1){
	
    return this->prio<Job1.prio;
    
}
bool Job::operator>=(const Job &Job1){
	
    return this->prio<=Job1.prio;
    
}

bool Job::operator<(const Job &Job1){

    return this->prio>Job1.prio;
    
}

/*Job& Job::operator=(const Job &Job1){
	this->id=Job1.id;
	this->time=Job1.time;
	this->prio=Job1.prio;
	this->processTime=Job1.processTime;
	
	return *this;
}*/

void Job::swap(Job &Job1,Job &Job2){
	
	int hold[4];
	hold[0]=Job2.getId();
	hold[1]=Job2.getTime();
	hold[2]=Job2.getPrio();
	hold[3]=Job2.getProcessTime();
	
	Job2.setId(Job1.getId());
	Job2.setTime(Job1.getTime());
	Job2.setPrio(Job1.getPrio());
	Job2.setProcessTime(Job1.getProcessTime());
		
	Job1.setId(hold[0]);
	Job1.setTime(hold[1]);
	Job1.setPrio(hold[2]);
	Job1.setProcessTime(hold[3]);	
	
}
void Job::setId(int num){
	
	id=num;
	
}

void Job::setTime(int num){
	
	time=num;
	
}

void Job::setProcessTime(int num){
	
	processTime=num;
	
}

void Job::setPrio(int num){
	
	prio=num;
	
}

int Job::getId(){
	
	return id;
	
}

int Job::getTime(){
	
	return time;
	
}

int Job::getProcessTime(){
	
	return processTime;
	
}

int Job::getPrio(){
	
	return prio;
	
}

ostream& operator<<(ostream & out, const Job & a) {
	out << a.id << " " << a.time <<" "<< a.prio << " " << a.processTime;
	return out;
}


	
/*bool Job::findMaxPrio(const Job &Job1, const Job &Job2){
	
	if(Job1.prio<Job2.prio)
	
		return true;
	
	else
		
		return false;
}*/
