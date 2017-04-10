package com.moni2017;
/**
 * 7.X星系的的防卫体系包含 n 个空间站。这 n 个空间站间有 m 条通信链路，构成通信网。
两个空间站间可能直接通信，也可能通过其它空间站中转。
对于两个站点x和y (x != y), 如果能找到一个站点z，使得：
当z被破坏后，x和y无法通信，则称z为关于x,y的关键站点。
显然，对于给定的两个站点，关于它们的关键点的个数越多，通信风险越大。
你的任务是：已知网络结构，求两站点之间的通信风险度，即：它们之间的关键点的个数。
输入数据第一行包含2个整数n(2 <= n <= 1000), m(0 <= m <= 2000),分别代表站点数，链路数。
空间站的编号从1到n。通信链路用其两端的站点编号表示。
接下来m行，每行两个整数 u,v (1 <= u, v <= n; u != v)代表一条链路。
最后1行，两个数u,v，代表被询问通信风险度的两个站点。
输出：一个整数，如果询问的两点不连通则输出-1.
例如：
用户输入：
7 6
1 3 2 3
3 4 3 5
4 5 5 6
1 6
则程序应该输出：
2
 */
import java.util.Scanner;

public class 星球度量风险 {
	private static int[] father = new int[1001];
	private static int n, m;
	private static int[][] ar;
	private static int t1, t2;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		ar=new int[1001][2];
		for(int i=0;i<m;i++){
			ar[i][0]=sc.nextInt();
			ar[i][1] = sc.nextInt();
		}
		t1=sc.nextInt();
		t2=sc.nextInt();
		int count=0;
		if(!isOk()){
			System.out.println(-1);
			return;
		}
		for(int j=1;j<=n;j++){
			//去除需要检查的两个点
			if(j==t1||j==t2)
				continue;
			for(int i=1;i<=n;i++)
				father[i]=i;
			for(int i=0;i<m;i++){
				if(ar[i][0]==j||ar[i][1]==j)
					continue;//去除的两点不存在
				int a=findF(ar[i][0]);
				int b=findF(ar[i][1]);
				if(a>b){
					a^=b;
					b^=a;
					a^=b;
				}
				if(a!=b)
					father[b]=a;
				
			}
			int a=findF(t1);
			int b=findF(t2);
			if(a!=b)
				count++;
			}
		System.out.println(count);
		sc.close();
		}

	
	private static boolean isOk() {
		for(int i=1;i<=n;i++){
			father[i]=i;
		}
			for(int j=0;j<m;j++){
				int a=findF(ar[j][0]);
				int b=findF(ar[j][1]);
				if(a>b){
					a^=b;
					b^=a;
					a^=b;
				}
				if(a!=b)
					father[b]=a;
			}
			int a=findF(t1);
			int b=findF(t2);
			if(a==b)
				return true;
			return false;
	
	}
	private static int findF(int i) {
		if(father[i]==i)
			return i;
		return father[i]=findF(father[i]);
	}

}
