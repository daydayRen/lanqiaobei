package it.lijieshiti;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class JuZhenYIngBi {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
           Scanner cin = new Scanner(System.in); 
           String s1 = cin.next();
           String s2 = cin.next();
           BigInteger ans1 = BigSqrt(s1);
           BigInteger ans2 = BigSqrt(s2);
           //System.out.println(ans1+" "+ans2);
           BigInteger ans = ans1.multiply(ans2);
           System.out.println(ans);
    }

    private static BigInteger BigSqrt(String s) {        
        int mlen=s.length();
        //获取数据
        BigInteger  original=new BigInteger(s);
        BigInteger before;
        BigInteger last;
        int len;
        len=(mlen%2==1)?(mlen/2+1):(mlen/2);
        char[] sArray=new char[len];
        Arrays.fill(sArray,'0');
        for(int i=0;i<len;i++){
        	for(char num='1';num<='9';num++){
        		sArray[i]=num;
        		before=new BigInteger(String.valueOf(sArray));
        		last=before.multiply(before);
        		if(last.compareTo(original)==1){
        			sArray[i]-=1;
        			break;
        		}
        		}
        }
        return new BigInteger(String.valueOf(sArray));
        		
    }
}