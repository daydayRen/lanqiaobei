package com.moni2017;
/**
 * 3.标题： 排列序数

X星系的某次考古活动发现了史前智能痕迹。
这是一些用来计数的符号，经过分析它的计数规律如下：
（为了表示方便，我们把这些奇怪的符号用a~q代替）

abcdefghijklmnopq 表示0
abcdefghijklmnoqp 表示1
abcdefghijklmnpoq 表示2
abcdefghijklmnpqo 表示3
abcdefghijklmnqop 表示4
abcdefghijklmnqpo 表示5
abcdefghijklmonpq 表示6
abcdefghijklmonqp 表示7
.....

在一处石头上刻的符号是：
bckfqlajhemgiodnp

请你计算出它表示的数字是多少？

请提交该整数，不要填写任何多余的内容，比如说明或注释。

思路：

逐为考虑，第一位目标状态是b，那么当为a是，后面字符进行了全排列，即16阶乘。再考虑下一位，依次类推，就能够得到答案。需要注意的是，检查当前位是取值是否包含前面已经取走的，要排除除去。

重新进行补充；

初始状态：abcdefghijklmnopq

最终状态：bckfqlajhemgiodnp
那么，现在从第一位开始考虑，本来是啊，现在要变成b。第一位的取值来说有两种情况，取a的话，情况就是后面所有的字母进行了全排列。16阶乘

如果取b的话，那么显然并不是后面字符的全排列。我们思考，如果可以转化成后面一些字符的全排列还厚累加求和，这样是不是更好计算呢？

再来看第二位，目标状态是c，说明当前位置取a,b是，后面的字符进行了全排列。取c的时候，后面的字符并不是全排列。同时，注意到，因为第一位此时已经不再考虑，说明

它已经转换成了目标状态b，那么就会对第二位的取值造成影响。第二位本来取值a,b，现在只能有一个取值a了，然后是后面的字符全排列，15的阶乘。

再考虑第三位，目标状态是k，那么这一位的取值理论上来说有a,b,c,d,e,f,g,h,i9个取值，但是前两位分别把b,c那走了，剩余的就是a,d,e,f,g,h,i7个取值。照面的字符同样是全排

列，14的阶乘，一共有7个14！。

往下，就以此类推了...

结果：22952601027516
 * @author oneday
 *
 */
public class 序列排序 {

	public static void main(String[] args) {
		String s="bckfqlajhemgiodnp";
		long fs[] = new long[17] ;
		fs[0]=1;
		//数组存储阶乘
		for(int i=1;i<17;i++){
			fs[i]=fs[i-1]*i;
		}
		long sum=0;
		for(int i=0;i<16;i++){
			//获取每一个字母
			char c=s.charAt(i);
			int k=0;
			for(int j=i+1;j<17;j++){
				//判断前面有几个比自身大的字母
				if(c-'a'>s.charAt(j)-'a')
					k++;
			}
			sum+=k*fs[16-i];
		}
		System.out.println(sum);
	}

}
