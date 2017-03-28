package it.base;

import java.util.Scanner;

public class ShiJianZhuanHuan {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[3];
		for(int i=0;i<3;i++){
			array[2-i]=n%60;
			n/=60;
		}
		System.out.println(array[0]+":"+array[1]+":"+array[2]);
		
	}

}
