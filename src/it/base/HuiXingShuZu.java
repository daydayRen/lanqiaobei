package it.base;

import java.util.Scanner;

public class HuiXingShuZu {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] a=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++){
				a[i][j]=sc.nextInt();
			}
		int i=0;
		int j=0;
		for(;i<(n+1)/2 && i<(m+1)/2;i++){
			for(j=i;j<m-i;j++)
				System.out.print(a[j][i]+" ");
			for(j=i+1;j<n-i;j++)
				System.out.print(a[m-i-1][j]+" ");
			if(n-i-1>i)
				for(j=m-2-i;j>=i;j--)
					System.out.print(a[j][n-i-1]+" ");
			if(m-i-1>i)
				for(j=n-2-i;j>i;j--)
					System.out.print(a[i][j]+" ");
		}
	}

}
