package com.moni2017;
/**
 * 2.题目：猜算式

你一定还记得小学学习过的乘法计算过程，比如：

   273
x   15
------
  1365
  273
------
  4095
 
请你观察如下的乘法算式

    ***
x   ***
--------
    ***
   ***
  ***
--------
  *****
 
星号代表某位数字，注意这些星号中，
0~9中的每个数字都恰好用了2次。
(如因字体而产生对齐问题，请参看图p1.jpg)

请写出这个式子最终计算的结果，就是那个5位数是多少？

注意：只需要填写一个整数，不要填写任何多余的内容。比如说明文字。

思路：

拆分出来两个数的每一位，设置标记数组每一位大小是2位。测试结束后，查看0~9每一位是不是都是2。符合条件，将结果输出。

结果：40096
 * @author oneday
 *
 */

public class 猜算式 {
    public static void main(String[] args) {
        for(int i = 100;i<=999;i++){
            for(int j = 100;j<=999;j++){
                int[] f = new int[10];
                
                int a = i*(j%10);
                int b = i*(j/10%10);
                int c = i*(j/100);
                if(a>=1000||b>=1000||c>=1000||i*j>=100000||a<100||b<100||c<100)continue;
                //i,j,a,b,c,i*j
                if(check(i,f)&&check(j,f)&&check(a,f)&&check(b,f)&&check(c,f)&&check(i*j,f)){
                    System.out.println(i+" "+j+" "+a+" "+b+" "+c+" "+i*j);
                }
            }
        }
    }
    public static boolean check(int i,int[] f){

        while(i>0){
        	//判断数字出现次数是否多于两次
            if(f[i%10]==2){
           
                return false;
            }
            //数字出现次数
            f[i%10]++;
            i/=10;
        }
        return true;
    }
}