package it.base;

import java.util.Scanner;

public class Test111 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int count = 0;

        for (int i = 0; i < arr2.length -1; i++) {
            if (arr1[i] != arr2[i]) {
                arr1[i] = arr2[i];
                if (arr1[i+1] =='*') {
                    arr1[i+1] ='o';
                }else {
                    arr1[i+1] ='*';
                }
                count++;
            }
        }
        System.out.println(count);
    }
}