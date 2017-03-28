package it.base;

import java.util.*;
public class FenjieZhiYinShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n2-n1+1];
        if(n1==n2)
            a[0] = n1;
        else
            for(int i=n1,j=0;i<=n2;i++,j++)
                a[j] = i;
        for(int i=0;i<a.length;i++){
           StringBuffer st=new StringBuffer(a[i]+"=");
           int temp=a[i],z=2;
           while(z<=temp){
        	   if(temp%z==0){
        		   if(st.charAt(st.length()-1)!='=')
            		   st.append("*");
        		   st.append(z);
        		   temp/=z;
        		   z=2;
        	   }else
        		   z++;
        	   
           }
           System.out.println(st);
           }
        }
 }