#include <iostream>
#include "Job.h"
#include "pQueue.h"
#include "JobScheduler.h"
#include <fstream>


using namespace std;


void openFile(ifstream &FILE); // opens file

int main(){
	
	ifstream iFILE;
	cout<<"Type textname to read"<<endl;
	
	openFile(iFILE);
	
	JobScheduler trial(2);
	
	
	trial.process(iFILE);
	
	iFILE.close();
	
}

void openFile(ifstream &FILE){
	
	string filename;

	cout << "Please enter a file name to read: " << endl;
	getline( cin, filename );
	
	FILE.open(filename.c_str());
	while(!FILE.is_open()){
		cout<<"File failed to open."<<endl;	
		openFile(FILE);
	}
	
}
