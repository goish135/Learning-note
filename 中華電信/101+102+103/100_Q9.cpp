#include<stdio.h>
int main()
{
	int a = 5,b=0,c=6;
	a = (a=b) && (c=b);
	printf("a:%d b:%d c:%d\n",a,b,c);
	return 0;	
} 
