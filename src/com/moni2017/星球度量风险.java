package com.moni2017;
/**
 * 7.X��ϵ�ĵķ�����ϵ���� n ���ռ�վ���� n ���ռ�վ���� m ��ͨ����·������ͨ������
�����ռ�վ�����ֱ��ͨ�ţ�Ҳ����ͨ�������ռ�վ��ת��
��������վ��x��y (x != y), ������ҵ�һ��վ��z��ʹ�ã�
��z���ƻ���x��y�޷�ͨ�ţ����zΪ����x,y�Ĺؼ�վ�㡣
��Ȼ�����ڸ���������վ�㣬�������ǵĹؼ���ĸ���Խ�࣬ͨ�ŷ���Խ��
��������ǣ���֪����ṹ������վ��֮���ͨ�ŷ��նȣ���������֮��Ĺؼ���ĸ�����
�������ݵ�һ�а���2������n(2 <= n <= 1000), m(0 <= m <= 2000),�ֱ����վ��������·����
�ռ�վ�ı�Ŵ�1��n��ͨ����·�������˵�վ���ű�ʾ��
������m�У�ÿ���������� u,v (1 <= u, v <= n; u != v)����һ����·��
���1�У�������u,v������ѯ��ͨ�ŷ��նȵ�����վ�㡣
�����һ�����������ѯ�ʵ����㲻��ͨ�����-1.
���磺
�û����룺
7 6
1 3 2 3
3 4 3 5
4 5 5 6
1 6
�����Ӧ�������
2
 */
import java.util.Scanner;

public class ����������� {
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
			//ȥ����Ҫ����������
			if(j==t1||j==t2)
				continue;
			for(int i=1;i<=n;i++)
				father[i]=i;
			for(int i=0;i<m;i++){
				if(ar[i][0]==j||ar[i][1]==j)
					continue;//ȥ�������㲻����
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
