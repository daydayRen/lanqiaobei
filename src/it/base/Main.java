package it.base;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int n,i,j;
        n=sc.nextInt();
        int a[][]=new int[n][n];
        int count[]=new int[n];
        for(i=0;i<n;i++){
            
            count[i]=1;
            for( j=0;j<n;j++)
                a[i][j]=sc.nextInt();
        }
        for(j=0;j<n;j++)
        {
            for(i=0;i<n;i++){
                if(i!=j && (a[i][j]==1))
                    count[j]++;
            }
            if((count[j]>(n/2)) &&(j!=(n-1)))
                System.out.print(j+1+" ");
            else if((count[j]>(n/2))&& (j==(n-1)))
            System.out.println(n);
        }

    }

}