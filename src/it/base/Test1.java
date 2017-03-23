package it.base;

import java.util.Scanner;

public class Test1 {  
	  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        String s1 = sc.next();  
        String s2 = sc.next();  
  
        int[] a = new int[100];  
        int[] b = new int[100];  
        int[] c = new int[100];  
  
        copy(a, s1);  
        copy(b, s2);  
  
        int jw = 0;  
        for (int i = 0; i < s1.length() + 5; i++) {  
            int temp = a[i] + b[i] + jw;  
            c[i] = temp % 10;  
            jw = temp / 10;  
        }  
  
        boolean begin = false;  
  
        for (int i = c.length - 1; i >= 0; i--) {  
            if (begin) {  
                System.out.print(c[i]);  
                continue;  
            }  
  
            if (c[i - 1] != 0) {  
                begin = true;  
            }  
        }  
    }  
  
    private static void copy(int[] x, String s) {  
        int len = s.length();  
        for (int i = 0; i < len; i++) {  
            x[i] = s.charAt(len - 1 - i) - '0';  
        }  
    }  
  
}