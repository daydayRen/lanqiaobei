package it.base;

import java.util.Scanner;

public class FJ {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(cal(sc.nextInt()));

	}
	static String cal(int n){
		if(n==1){
			return "A";
		}else{
			return cal(n-1)+(char)('A'+n-1)+cal(n-1);
		}
	}
}
