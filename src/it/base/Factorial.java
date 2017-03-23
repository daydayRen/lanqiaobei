package it.base;

import java.util.Scanner;

public class Factorial {  
    
    public static void main(String[] args) {  
        int[] a = new int[900];  
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();  
        sc.close();  
        a[0] = 1;  
          
        for(int i=2; i<=n; i++){  
            int jw = 0;  
            for(int j=0; j<a.length; j++){  
                int temp = a[j]*i + jw;  
                a[j] = temp%10;  
                jw = temp/10;  
            }  
              
        }  
          
        boolean begin = false;  
          
        for(int i=a.length-1; i>=0; i--){  
            if(begin){  
                System.out.print(a[i]);  
                continue;  
            }  
              
            if(a[i-1] != 0){  
                begin = true;  
            }  
        }  
    }  
}