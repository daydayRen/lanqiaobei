package it.base;

import java.util.Scanner;

public class JuXingMianJi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a[]=new int[4];
		int b[]=new int[4];
		int i;
		for(i=0;i<4;i++)
			a[i]=sc.nextInt();
		for(i=0;i<4;i++)
			b[i]=sc.nextInt();
		float result=Math.abs((a[2]-b[2])*(a[3]-b[3]));
		
		System.out.println(result);
	}

}
