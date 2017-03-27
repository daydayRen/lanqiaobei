package it.base;

import java.util.Scanner;

public class FJSine {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(Sn(n,1));
	}
	public static String An(int n,int i){		
		if(n==i){
			return "sin("+i+")";
		}else{
			if(i%2==0)
				return "sin("+i+"+"+An(n,i+1)+")";
			else
				return "sin("+i+"-"+An(n,i+1)+")";
		}
	}
	
	public static String Sn(int n,int i){
		if(n==i)
			return An(n,1)+"+"+(n-i+1);
		else
			return "("+An(i,1)+"+"+(n-i+1)+")"+Sn(n,i+1)+"";
	}
}
