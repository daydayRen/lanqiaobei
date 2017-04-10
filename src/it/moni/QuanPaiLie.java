package it.moni;


/**
 * 判断全排列是第几个数字
 * @author oneday
 *
 */
public class QuanPaiLie {
	//阶乘
	public static long fact(long n){
		long i;
		long s=1;
		for(i=2;i<=n;i++){
			s*=i;
		}
		return s;
	}
	//数组内每个数字后面有多少种排列
	public static int result(int a[],int n){
		int i,j,sum=0,temp;
		for(i=0;i<n;i++){
			temp=0;
			for(j=i+1;j<n;j++)
				if(a[j]<a[i])
					temp++;
			sum+=temp*fact(n-i-1);
			
		}
		return sum;
	}
	public static void main(String[] args) {
		int [] a=new int[]{3, 5, 7, 4, 1, 2, 9, 6, 8};
		System.out.println(1+result(a,a.length));

	}

}
