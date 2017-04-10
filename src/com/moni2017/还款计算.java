package com.moni2017;
/**
 * 5.标题： 还款计算

银行贷款的等额本息还款方法是：
每月还固定的金额，在约定的期数内正好还完（最后一个月可能会有微小的零头出入）。

比如说小明在银行贷款1万元。贷款年化利率为5%，贷款期限为24个月。
则银行会在每个月进行结算：
结算方法是：计算本金在本月产生的利息： 本金 x (年利率/12)
则本月本金结余为：本金 + 利息 - 每月固定还款额
计算结果会四舍五入到“分”。

经计算，此种情况下，固定还款额应为：438.71

这样，第一月结算时的本金余额是：
9602.96
第二个月结算：
9204.26
第三个月结算：
8803.9
....
最后一个月如果仍按固定额还款，则最后仍有0.11元的本金余额，
但如果调整固定还款额为438.72, 则最后一个月会多还了银行0.14元。
银行会选择最后本金结算绝对值最小的情况来设定 每月的固定还款额度。
如果有两种情况最后本金绝对值相同，则选择还款较少的那个方案。

本题的任务是已知年化利率，还款期数，求每月的固定还款额度。

假设小明贷款为1万元，即：初始本金=1万元。
年化利率的单位是百分之多少。
期数的单位为多少个月。

输入为2行，
第一行为一个小数r，表示年率是百分之几。(0<r<30)
第二行为一个整数n，表示还款期限。 (6<=n<=120)

要求输出为一个整数，表示每月还款额（单位是：分）
 */
import java.util.Scanner;

public class 还款计算 {

	public static void main(String[] args) {
		//暴力解决，从最小开始
		Scanner sc=new Scanner(System.in);
		double m=sc.nextDouble()/100/12;//计算利息用
		int month=sc.nextInt();//还款多少月
		int money=10000*100;//用分计算
		int min=money/month;//每月最少还款
		int ans=0x7fffffff,last = 0x7fffffff;//分别表示结果和绝对值最小的那个值
		for(int i=min;;i++){
			int moneys=money;
			//限定时间内还款  还剩多少
			for(int j=1;j<=month;j++){
				moneys=get(moneys*(1+m)-i);
			}
			if(Math.abs(last)>Math.abs(moneys)){
				last=moneys;
				ans=i;
			}else{
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}

	private static int get(double d) {
		return (int)(d+0.5);//四舍五入
	}

}
