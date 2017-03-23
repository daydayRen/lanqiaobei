package it.base;

import java.util.Scanner;

public class BaoShiZhuShou {
	static String eng[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty"};
	static int m;
	static int h;
	static String r="o'clock";
	
	static String getH(int num){
		StringBuffer sb=new StringBuffer();
		int a=num/10;
		int b=num%10;
		if(num<=20){
			sb.append(eng[num]+" "+r);
		}else{
			sb.append(eng[a+18]+" "+eng[b]+" "+r);
		}
		return sb.toString();
	}
	static String getHM(int num){
		StringBuffer sb=new StringBuffer();
		int a=num/10;
		int b=num%10;
		if(num<=20){
			sb.append(eng[num]+" ");
		}else{
			sb.append(eng[a+18]+" ");
			if(b!=0){
				sb.append(eng[b]+" ");
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		h=sc.nextInt();
		m=sc.nextInt();
		if(m==0){
			System.out.println(getH(h));
		}else{
			System.out.println(getHM(h)+getHM(m));
		}
		
	}
}
