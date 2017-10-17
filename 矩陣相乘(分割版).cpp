#include<stdio.h>
#include<time.h>    // clock() 
#include<algorithm> // min()
using namespace std; // min()
int A[3000][3000],B[3000][3000],C[3000][3000];
int main()
{
	
	freopen("1000.out","wt",stdout); // ��bmm1.out��.txt�� �g�J �Htext�Ҧ� 
	int n,p; // n:n*n matrix p:block matrix size
	scanf("%d%d",&n,&p);
	
	// ��� 
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			A[i][j]=1;
		}
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			B[i][j]=1;
		}
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			C[i][j] = 0;
		}
	}
	// end ���
	 
	double start = clock(); // �}�l�p��
	
	int k,j,i,jj,kk; 
	
	for(k=0;k<n;k+=p)
	{
		for(j=0;j<n;j+=p)
		{
			for(i=0;i<n;i++)
			{
				for(jj=j;jj<min(j+p,n);jj++)
				{
					for(kk=k;kk<min(k+p,n);kk++)
						C[i][jj]+=A[i][kk]*B[kk][jj];		
				}
			}	
		}	
	} 
	
	double end = clock();
	/*
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			printf("%d ",C[i][j]);
		}
		printf("\n");
	}
	*/
	printf("�`�@��:%lf ms\n",end-start);
	printf("�`���:%lf  s\n",(end-start)/CLOCKS_PER_SEC);
	return 0;	 
} 
