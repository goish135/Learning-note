#include<stdio.h>
int main()
{
	char cha[8+1]="ABCDEFGH";
	for(int i=7;i>=0;i--)
	{
		int flag = 1;
		for(int j=i;j>=0;j--)
		{
			if(flag==1)
			{
				printf("%c",cha[j]);
				flag = 0;
			}
			else
			{
				printf(" %c",cha[j]);
			}
			
		}
		printf("\n");
	}
	return 0;	
} 
