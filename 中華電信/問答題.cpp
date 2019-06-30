#include<stdio.h>
int main()
{
	int number[20+1];
	int output[20+1];
	int count = 0;
	for(int i=0;i<20;i++)
	{
		scanf("%d",&number[i]);

	    int flag = 1;
	    for(int j=0;j<count;j++)
	    {
	    	if(output[j]== number[i])
	    	{
	    		flag = 0;
			}
		}
		if(flag)
		{
		  output[count++] = number[i];	
		}
		
		if(count==0)
		{
		   output[count++] = number[i];
	    }
	}
	printf("%d",output[0]);
	for(int k=1;k<count;k++)
	{
		printf(" %d",output[k]);
	}
	return 0;	
} 
