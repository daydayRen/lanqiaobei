package com.moni2017;
/**
 * ������Ҫһ���µ��ַ����ȽϺ���compare(s1, s2).
���������Ҫ���ǣ�
1. ������һ����������ʾ�ȽϵĽ����
2. ���Ϊ��ֵ����ǰһ������Ϊ��ֵ����һ�����󣬷�����ͬ��
3. ����ľ���ֵ��ʾ���ڵڼ�����ĸ�����������������ȡ�

�����Ǵ���ʵ�֡�����������ݣ����Ϊ��
-3
2
5

˼·��

��һ�����������ǵ�ǰ��С�ں��߻᷵��-1������Ϊ�ݹ������㣬����Ϊ-2����-3���-1��

�ڶ���������ǰ�ߴ��ں��ߣ�ֻ��Ҫ��鵽�ڶ����ַ��Ϳ��Է��أ�����ֵΪ1����2���1��
 * @author oneday
 *
 */
public class ��ĸ���Ƚ� {

	static int compare(String s1, String s2)
	{
	    if(s1==null && s2==null) return 0;
	    if(s1==null) return -1;
	    if(s2==null) return 1;
	    
	    if(s1.isEmpty() && s2.isEmpty()) return 0;
	    if(s1.isEmpty()) return -1;
	    if(s2.isEmpty()) return 1;
	    
	    char x = s1.charAt(0);
	    char y = s2.charAt(0);
	    
	    if(x<y) return -1;
	    if(x>y) return 1;
	    
	    int t = compare(s1.substring(1),s2.substring(1));
	    if(t==0) return 0;
	    
	    return t>0?t+1:t-1; //���λ��
	}

	public static void main(String[] args)
	{
	    System.out.println(compare("abc", "abk"));
	    System.out.println(compare("abc", "a"));
	    System.out.println(compare("abcde", "abcda"));            
	}
}
