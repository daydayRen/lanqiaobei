package it.base;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	//huffuman��
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n=s.nextInt();
		int result=0;
		if(n<0&&n>100){
			return;
		}
		int [] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		
		int i=0;
		while(i+1<a.length){
			int temp=0;
			Arrays.sort(a);//��������  ����
			temp=a[i]+a[i+1];//����С��������
			a[i+1]=temp;
			result+=temp;
			a=Arrays.copyOfRange(a, i+1, a.length);//�ı�����Ϊ�����飬ȥ����С��������
		}
		System.out.println(result);
	}
}
