#include<iostream>
using namespace std;
int main()
{
	const double *pc = 0 ;
	const double davl = 3.14;
	pc = &davl ;
	cout << *pc << endl;
	return 0; 
} 
