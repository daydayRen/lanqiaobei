package it.base;

import java.util.Scanner;

public class DuShu {
	private static void change(int n) {
		int i, j;
		String[] c = { "ling ", "yi ", "er ", "san ", "si ", "wu ", "liu ", "qi ", "ba ", "jiu " };
		String[] d = { "", "shi ", "bai ", "qian ", "wan ", "shi ", "bai ", "qian ", "yi ", "shi ", "bai " };
		String ss = n + "";
		String buffer = new String();
		boolean b = true;
		
		// ��һ�γ�����
		for (i = 0; i <ss.length(); i++) {
			//System.out.println(i);
			for (j = 0; j <= 9; j++)
				if (ss.charAt(i) == j + '0'){
					//System.out.println(j);
					break;
				}
			if(ss.length()==1 && ss.charAt(i)==0+'0'){
				buffer += c[j] + d[ss.length() - i - 1];
			}else if ((ss.length() + 2) % 4 == 0 && i == 0 && j == 1) {//ʮλ���ж��Ƿ�Ϊ1
				buffer += d[ss.length() - i - 1];
			}else if (i != ss.length() - 1 && j == 0) {//�ж��Ƿ�Ϊ0  ���
				if (b) {
					buffer += c[j];
					b = false;
				}
			} else if (i == ss.length() - 1 && j == 0) {
				if (!b)
					buffer = buffer.substring(0, buffer.length() - 5);// ������һ��ҲΪ0����ȥ��֮ǰ��ӵ�
																		// ling
			} else {
				buffer += c[j] + d[ss.length() - i - 1];//���λ��
				//System.out.println(i+":"+buffer);
				b = true;
			}
		}
		System.out.println(buffer);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		change(n);
	}
}