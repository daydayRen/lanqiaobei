package it.moni;

import java.util.Scanner;

public class HuanKuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble()/100/12;
        int month = sc.nextInt();
        int money = 10000*100;//�÷�����ʾ
        int min = money/month;
        int ans = 0x7fffffff,last = 0x7fffffff;//�ֱ��ʾ����;���ֵ��С���Ǹ�ֵ
        for(int i=min;;i++){
        	int moneys=money;
        	for(int j=1;j<=month;j++){
        		moneys=get(moneys*(1+m)-i);
        	}
        	if(Math.abs(last)>Math.abs(moneys)){
        		last=moneys;
        		ans=i;
        	}else
        		break;
        	
        }
        System.out.println(ans);
        sc.close();
    }

    private static int get(double money) {
    	return (int)(money+0.5);
    }
}