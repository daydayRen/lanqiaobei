package it.base;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	//huffuman树
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
			Arrays.sort(a);//数组排序  升序
			temp=a[i]+a[i+1];//求最小的两数和
			a[i+1]=temp;
			result+=temp;
			a=Arrays.copyOfRange(a, i+1, a.length);//改变数组为新数组，去掉最小的两个数
		}
		System.out.println(result);
	}
}
