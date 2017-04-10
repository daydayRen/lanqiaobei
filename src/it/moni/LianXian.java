package it.moni;

import java.util.Scanner;

public class LianXian {
	private static int N; // 表示看到的边数
	private static int[][] path; // 连接的点数
	private static boolean[] keep = new boolean[10];
	private static int count; // 表示能有多少个可能的结果

	private static boolean isBool(int a, int b) {
		// 8种情况
		int dig[][] = new int[][] { { 1, 3, 2 }, { 4, 6, 5 }, { 7, 9, 8 }, { 1, 7, 4 }, { 2, 8, 5 }, { 3, 9, 6 },
				{ 1, 9, 5 }, { 3, 7, 5 } };
		for (int i = 0; i < 8; i++) {
			if(a==dig[i][0]&&b==dig[i][1]||b==dig[i][0]&&a==dig[i][1])
				if(!keep[dig[i][2]])
					return false;
		}
		return true;
	}

	/*
	 * @N 必须连接的个数
	 * 
	 * @step 当前连接的点数
	 * 
	 * @a 记录连接的序号
	 */
	private static void dfs(int number, int step, int[] process) {
		if (step >= 2) {
			int a=process[step-2];
			int b=process[step-1];
			// 如果为false的话， 那么直接就跳出这次遍历情况
			if (!isBool(a, b))
				return;
		}
		if (step == number) {
			for (int i = 0; i < N; i++) {
				//判断连线成功？
				int a = path[i][0];
				int b = path[i][1];
				for (int j = 0; j < step - 1; j++) {
					if (a == process[j] && b == process[j + 1] || a == process[j + 1] && b == process[j])
						break;
					if (j == step - 2)
						return;
				}
			}
			count++;
			return;
		} else if (step > number)
			return;

		for (int i = 1; i <= 9; i++) {
			if (!keep[i]) {
				keep[i] = true;
				process[step] = i; // 当前位置的值
				dfs(number, step + 1, process);
				keep[i] = false; // 回溯
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		path = new int[N + 1][2];
		int[] process = new int[10];

		for (int i = 0; i < N; i++) {
			path[i][0] = sc.nextInt();
			path[i][1] = sc.nextInt();
		}
		// 如果N的数字大于4，那么就是必须连接到N个数， 否则按连接到4为基准
		for (int i = N > 4 ? N : 4; i <= 9; i++)
			dfs(i, 0, process);

		System.out.println(count);
		sc.close();
	}
}