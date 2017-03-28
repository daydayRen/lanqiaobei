package it.base;

import java.util.Scanner;

public class ZiFuChuanBiJiao {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();
		if(b.length()!=a.length())
			System.out.println(1);
		else if(a.equals(b))
			System.out.println(2);
		else if(!a.equals(b) && (a.toUpperCase()).equals((b.toUpperCase())))
			System.out.println(3);
		else if(!a.equals(b) && !(a.toUpperCase()).equals((b.toUpperCase())))
			System.out.println(4);
	}

}
