package it.base;

import java.util.Scanner;

public class GuiTuSaiPao {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v1=sc.nextInt();//兔子速度
		int v2=sc.nextInt();//乌龟速度
		int t=sc.nextInt();//超越米数
		int s=sc.nextInt();//休息时间
		int l=sc.nextInt();//总长度
		int l1=0,l2=0,xt=0,tt=0;
		while(l1<l&&l2<l){
			if(l1-l2>=t){
				tt+=s;
				l1=v1*xt;
				l2=v2*tt;
			}else{
				tt++;
				xt++;
				l1=v1*xt;
				l2=v2*tt;
			}
		}
		if(l1>l2){
			System.out.println("R");
			System.out.println(tt);
		}else if(l1==l2){
			System.out.println("D");
			System.out.println(tt);
		}else if(l1<l2){
			System.out.println("T");
			System.out.println(l/v2);
		}
			
		}
		
}
