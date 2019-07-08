#include<stdio.h>
void f(int *p,int a[])
{
	p = a;
}
int main()
{
	int a[] = {1,3,5,7};
	int *p = &a[1];
	f(p,a);
	p++;
	printf("%d",*(p));
	return 0;	
} 
