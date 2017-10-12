// problem F
#include<stdio.h>
#include<stdlib.h>
#define ll long long int
bool cp(ll q1,ll p1,ll q2,ll p2)
{
	if( q1*p2 > q2*p1 ) return true;
	else return false;
}

ll gcd(ll q,ll p) // 6 / 50
{
	while(q!=0)
	{
		ll tmp = p%q; // tmp=2 // 0
		p = q;         // p = 6 // 2 
		q = tmp;       // q = 2 // 0
	}
	//f[s][t].q = f[s][t].q / p;
	//f[s][t].q = f[s][t].q / p;
	return p;	
}

struct fract {
	ll p; // ¤À¥À 
	ll q; // ¤À¤l 
	//double ans ;
};

int s,t;
fract f[1000][1000];
int used[1000];
//fract len[n];
void dijkstra(int n)
{
	fract len[n];
	//while(1)
	//{
		//printf("begin\n");
		//system("pause");
		for(int i=s;i<=t;i++) // start point to i point
		{
			used[i]=0;
			len[i].p = f[s][i].p;
			//printf("%d\n",len[i].p);
			len[i].q = f[s][i].q;
			//printf("%d\n",len[i].q);
			//printf("%d/%d\n",len[i].q,len[i].p);
			//system("pause");
		} 
	while(1)
	{	
		fract min;
		min.p = 1;
		min.q = 0;
		int newn = -1;
		for(int j=s;j<=t;j++)
		{
			if(cp(len[j].q,len[j].p,min.q,min.p)&&used[j]==0)
			{
				min.p = len[j].p;
				min.q = len[j].q;
				newn = j; 
			}
		}
		
		//printf("newn:%d\n",newn);
		
		if(newn==-1) 
		{
			break;
		}
			
		used[newn] = 1;
	
		for(int k=s;k<=t;k++)
		{
			fract tmp;
			tmp.p = len[newn].p*f[newn][k].p;
			//printf("len[%d].p:%d f[%d][%d].p :%d\n",newn,len[newn].p,newn,k,f[newn][k].p);
			tmp.q = len[newn].q*f[newn][k].q;
			//printf("len[%d].q:%d f[%d][%d].q :%d\n",newn,len[newn].q,newn,k,f[newn][k].q);
			//if(cp(tmp.q,tmp.p,f[s][k].q,f[s][k].p))
			ll dd = gcd(tmp.q,tmp.p);
			tmp.q = tmp.q / dd;
			tmp.p = tmp.p / dd;
			
			if(cp(tmp.q,tmp.p,len[k].q,len[k].p))
			{
				//f[s][k].p = tmp.p;
				//f[s][k].q = tmp.q;
				len[k].p = tmp.p;
				//printf("len[%d].p:%d ",k,len[k].p);
				len[k].q = tmp.q;
				//printf("len[%d].q:%d\n",k,len[k].q);
			} 
		}
		
		
		
	}
	//printf("ans:%d/%d\n",len[6].q,len[6].p);
	ll d = gcd(len[t].q,len[t].p);
	len[t].q = len[t].q / d;
	len[t].p = len[t].p / d;
	if(len[t].q==0)
	printf("-1\n");
	else 
	printf("%lld %lld\n",len[t].q,len[t].p);
}

//int s,t;

int main()
{
	freopen("PF.in","r",stdin);
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		
		int sp; // sum point
		scanf("%d",&sp);
		//int s,t;
		scanf("%d%d",&s,&t);
		for(int i=s;i<=t;i++)
		{
			for(int j=s;j<=t;j++)
			{
				if(i==j)
				{
					f[i][j].p = 1;
					f[i][j].q = 0;
				}
				else 
				{
					f[i][j].p = 1;
					f[i][j].q = 0;
				}
			}	
		}	
		int e;
		scanf("%d",&e);
		// input 
		for(int i=0;i<e;i++)
		{
			int p1,p2;
			ll pp,qq;
			scanf("%d%d%lld%lld",&p1,&p2,&qq,&pp);
			f[p1][p2].q=qq;
			f[p1][p2].p=pp;
			//f[p1][p2].ans = qq/pp;
			//printf("%lf\n",qq/pp);
			//printf("%d %d %d %d %lf\n",p1,p2,f[p1][p2].q,f[p1][p2].p,f[p1][p2].ans);
		}
		//printf("hi\n");
		//system("pause");
		dijkstra(sp);
		//printf("%d %d\n",len[s][t].q,len[s][t].p);	
	}
	return 0;
}
