#include<stdio.h>
int main()
{
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		int x1,y1,x2,y2,x3,y3;
		scanf("%d%d%d%d%d%d",&x1,&y1,&x2,&y2,&x3,&y3);
		//printf("%d%d%d%d%d%d\n",x1,y1,x2,y2,x3,y3);
		int flag = 0;
		for(int i=(-64);i<=64&&flag==0;i++)
		{
			//printf("i:%d\n",i);	
			for(int j=(-64);j<=64&&flag==0;j++)
			{
				for(int k=(-64);k<=64;k++)
				{			
					if((i*x1*x1+j*x1+k)==y1&&(i*x2*x2+j*x2+k)==y2&&(i*x3*x3+j*x3+k)==y3)
					{
						printf("%d %d %d\n",i,j,k);
						flag = 1;
						break;
					}
				}
			}
		}	
	}
	return 0;	
} 
