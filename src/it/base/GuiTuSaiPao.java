package it.base;

import java.util.Scanner;

public class GuiTuSaiPao {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v1=sc.nextInt();//�����ٶ�
		int v2=sc.nextInt();//�ڹ��ٶ�
		int t=sc.nextInt();//��Խ����
		int s=sc.nextInt();//��Ϣʱ��
		int l=sc.nextInt();//�ܳ���
		int l1=0,l2=0,xt=0,tt=0;
		while(l1<l&&l2<l){
			if(l1-l2>=t){
				tt+=s;
				l1=v1*xt;
				l2=v2*tt;
			}else{
				tt++;
				xt++;
				l1=v1*xt;
				l2=v2*tt;
			}
		}
		if(l1>l2){
			System.out.println("R");
			System.out.println(tt);
		}else if(l1==l2){
			System.out.println("D");
			System.out.println(tt);
		}else if(l1<l2){
			System.out.println("T");
			System.out.println(l/v2);
		}
			
		}
		
}
