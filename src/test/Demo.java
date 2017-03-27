package test;

public class Demo {
	static int flag[]=new int[10];
	static void slove(int i,int j){
		int temp=i*j;
		System.out.println(temp);
		if(i>=100&&i<1000){
			while(temp>0){
				flag[temp%10]++;
				temp/=10;
			}
		}
	}
	public static void main(String[] args) {
		slove(225,113%10);
		System.out.println(113%10);
		System.out.println(123%100);
		System.out.println(123%100/10);

	}

}
