main.exe: main.o pQueue.o Job.o JobScheduler.o
	g++ main.o pQueue.o Job.o JobScheduler.o -o main.exe
	
main.o: main.cpp
	g++ -c -std=c++11 main.cpp

pQueue.o: pQueue.cpp pQueue.h
	g++ -c -std=c++11 pQueue.cpp
	
Job.o: Job.cpp Job.h
	g++ -c -std=c++11 Job.cpp	

JobScheduler.o: JobScheduler.cpp JobScheduler.h
	g++ -c -std=c++11 JobScheduler.cpp	
		
clean: 
	rm *.o main.exe
