package it.base;

import java.util.Scanner;

public class GetNum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[][] c=new int[a][b];
		int[] d=new int[a*b];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				c[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<(a*b);i++){
			for(int j=0;j<b;j++){
				for(int k=0;k<a;k++){
					d[i]=c[k][j];
				}
			}
		}
		

	}

}
