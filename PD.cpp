#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#define maxs 100000
#define maxd 1000 
using namespace std;
int main() {
    freopen("PD.in","r",stdin);
    int s,d;
    int tc;
    scanf("%d",&tc);
    while(tc--)
    {
        scanf("%d %d",&s,&d);
        //int A[s+5][d+5]={0};
        int (*A)[maxd+1] = new int[maxs][maxd+1];
        for(int i=0;i<s;i++)
        {
            int j = 0;
            while(1)
            {
                int in;
                scanf("%d",&in);
                if(in==0) break;
                A[i][j]=in;
                //printf("%d ",A[i][j]);
                j++;
            }
        	//printf("\n");
        }
        
        //int B[100][100]={0}; // imp.
        int (*B)[maxs+2] = new int[maxd][maxs+2]; 
        for(int m=0;m<d;m++)    
        {
            int n = 0;
            while(1)
            {
                int inn;
                scanf("%d",&inn);
                if(inn==0) break;
                B[m][n]=inn;
                //printf("%d ",B[m][n]);
                n++;
            }
            //printf("\n");
        }
        //delete A;
        //delete B;
        //system("pause");
        
        //int is[s+3]={0};
        int* is = new int[maxs+1];
        
        for(int i=0;i<maxs+1;i++)
        	is[i] = 0;
				
        //int BB[d+5][s+5]={0};
		int (*BB)[maxs+2] = new int[maxd+1][maxs+2];
		for(int i=0;i<maxd+1;i++)
		{
			for(int j=0;j<maxs+2;j++)
			{
				BB[i][j] = 0;
			}
		}
		 
        int v=0; // vacant
        for(int j=0;j<d;j++) 
        {
        	int count=0;
            for(int i=1;i<=s;i++) 
            {
                if(B[j][i]!=0) 
                {
                	for(int k=0;k<d;k++) 
                	{	
                    	if(A[B[j][i]-1][k]==0) break;
                    	if(A[B[j][i]-1][k]==j+1) 
                    	{
                        	BB[j][count] = k+1;
                        	count++;
                        	break;
                    	}   
                	}
				}
            }
        }   
		 
        for(int i=1;i<=d;i++) // 第一,二,三...志願 
        {
        	for(int j=0;j<d;j++) // 第幾間學校 
        	{		
        			for(int k=0;BB[j][k]!=0;k++) // 錄取順序 
        			{
        			
        				if(BB[j][k]==i&&is[B[j][k+1]-1]==0&&B[j][0]!=0)
        				{
        					is[B[j][k+1]-1]=1;
        					//printf("%d\n",B[j][k+1]-1);--test
        					B[j][0]--;
        					
						}
					}
					//printf("B[%d][0]:%d\n",j,B[j][0]);--test
			}
		} 
		
		
		
		
		for(int i=0;i<d;i++)
		{
			//printf("debug:%d\n",B[i][0]);
			v+=B[i][0];
		}
		int ss = 0;
		for(int j=0;j<s;j++)
		{
			//printf("is:%d\n",is[j]);
			ss+=is[j];	
		}
		 
        printf("%d %d\n",ss,v);
        delete A;
        delete B;
        delete is;
        delete BB;
    }    
    
    return 0;
}
