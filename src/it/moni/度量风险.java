package it.moni;

import java.util.Scanner;

public class 度量风险 {
	private static int[] father = new int[1001];
	private static int n, m;
	private static int[][] ar;
	private static int t1, t2;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		n = sn.nextInt();
		m = sn.nextInt();
		ar = new int[1001][2];
		for (int i = 0; i < m; i++) {// 表示第i个存储的两站连接点
			ar[i][0] = sn.nextInt();
			ar[i][1] = sn.nextInt();
		}
		t1 = sn.nextInt();
		t2 = sn.nextInt();
		int count = 0;
		if (!isLinked()) {
			System.out.println(-1);
			return;
		} // 判断初试两点是否联通，不能联通直接结束程序
		for (int i = 1; i <= n; i++) {
			if (i == t1 || i == t2)
				continue;// 去除需要检查联通的两点，这两点不需要遍历
			for (int j = 1; j <= n; j++)
				father[j] = j;// 初始化
			for (int j = 0; j < m; j++) {
				if (ar[j][0] == i || ar[j][1] == i)
					continue;// 去除的这个点所在的线段就不存在了
				int a = findF(ar[j][0]);
				int b = findF(ar[j][1]);
				if (a > b) {
					a ^= b;
					b ^= a;
					a ^= b;
				}
				if (a != b)
					father[b] = a; // 以小的为父节点
			}
			int a = findF(t1);
			int b = findF(t2);
			if (a != b)
				count++;// 如果共同父亲不同，那么肯定不连通，即那条被剪去的线路是核心线路，在这线路上有一头是核心站

		}
		System.out.println(count);
		sn.close();
	}

	public static boolean isLinked() {
		for (int j = 1; j <= n; j++)
			father[j] = j;
		for(int i=0;i<m;i++){
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