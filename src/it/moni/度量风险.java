package it.moni;

import java.util.Scanner;

public class �������� {
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
		for (int i = 0; i < m; i++) {// ��ʾ��i���洢����վ���ӵ�
			ar[i][0] = sn.nextInt();
			ar[i][1] = sn.nextInt();
		}
		t1 = sn.nextInt();
		t2 = sn.nextInt();
		int count = 0;
		if (!isLinked()) {
			System.out.println(-1);
			return;
		} // �жϳ��������Ƿ���ͨ��������ֱͨ�ӽ�������
		for (int i = 1; i <= n; i++) {
			if (i == t1 || i == t2)
				continue;// ȥ����Ҫ�����ͨ�����㣬�����㲻��Ҫ����
			for (int j = 1; j <= n; j++)
				father[j] = j;// ��ʼ��
			for (int j = 0; j < m; j++) {
				if (ar[j][0] == i || ar[j][1] == i)
					continue;// ȥ������������ڵ��߶ξͲ�������
				int a = findF(ar[j][0]);
				int b = findF(ar[j][1]);
				if (a > b) {
					a ^= b;
					b ^= a;
					a ^= b;
				}
				if (a != b)
					father[b] = a; // ��С��Ϊ���ڵ�
			}
			int a = findF(t1);
			int b = findF(t2);
			if (a != b)
				count++;// �����ͬ���ײ�ͬ����ô�϶�����ͨ������������ȥ����·�Ǻ�����·��������·����һͷ�Ǻ���վ

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