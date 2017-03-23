package it.base;

import java.util.Scanner;

public class HeiBaiHuangHou {
	static int sum=0;
	static int black=2;
	static int white=3;
	public static boolean select(int i,int j,int color,int n,int queen[][]){
		int r,c;
		//上下查找
		for(r=0;r<n;r++)
			if(queen[r][j]==color)
				return false;
		//左右查找
		for(r=0;r<n;r++)
			if(queen[i][r]==color)
				return false;
		//右上角查找
		for(r=i-1,c=j+1;r>=0&&c<n;r--,c++)
			if(queen[r][c]==color)
				return false;
		//左下角查找
		for(r=i+1,c=j-1;r<n&&c>=0;r++,c--)
			if(queen[r][c]==color)
				return false;
		//右下角查找
		for(r=i+1,c=j+1;r<n&&c<n;r++,c++)
			if(queen[r][c]==color)
				return false;
		//左上角查找
		for(r=i-1,c=j-1;r>=0&&c>=0;r--,c--)
			if(queen[r][c]==color)
				return false;
		return true;
	}
	
	public static void find(int i,int j,int n,int queen[][]){
		int t;
		if(i>=n){
			if(j==0){//黑白皇后都找到了
				sum++;
				j=1;
				return;
			}
			//只找到了黑皇后
			j=0;
			i=0;
		}
		//首先查找黑皇后
		if(j!=0){
			for(t=0;t<n;t++){
				if(select(i, t, black, n, queen)&&queen[i][t]==1){
					queen[i][t]=black;
					find(i+1,j,n,queen);
					queen[i][t]=1;
				}
					
			}
		}
		//查找白皇后 
		else{
			for(t=0;t<n;t++){
				if(select(i, t, white, n, queen)&&queen[i][t]==1){
					queen[i][t]=white;
					find(i+1,j,n,queen);
					queen[i][t]=1;
				}
					
			}

		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] a=new int[n][n]; 
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();

		find(0,1,n,a);
		System.out.println(sum);
	}

}
