package it.base;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {

	public static void main(String[] args) throws Exception {
		Calculator calc = new Calculator();
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(calc.GetResult(s));
	}
	
	//��ȡ���
	public Integer GetResult(String infix) throws Exception {	
		StringBuffer suffix = new StringBuffer();
		InfixToSuffix(infix, suffix);
		return CalcSuffix(suffix.toString());
	}
	
	
	//��׺ת��׺����ʽ
	private void InfixToSuffix(String infix, StringBuffer suffix) throws Exception {
		Stack<Character> s = new Stack<>();	//����һ��ջ
		int iLen = infix.length();            //���㳤����������ѭ��
		for (int i = 0;i < iLen;i++) {
			//1.�Թ��ո�
			if (infix.charAt(i) == ' ')
				continue;
			//2.���������(����С��)ֱ�����
			else if (IsDigit(infix.charAt(i)))
				suffix.append(infix.charAt(i));
			//3.����������ţ���ֱ����ջ
			else if (infix.charAt(i) == '(')
				s.push(infix.charAt(i));
			//4.����������ţ����ջ��ֱ������������Ϊֹ�����ѡ�������ջ
			else if (infix.charAt(i) == ')') {
				while (s.peek() != '(') {
					suffix.append(s.peek());
					s.pop();
				}		
				s.pop();
			}
			//5.�����+-,��ջ����Ԫ�ػ���ջ���С���������ֱ����ջ������ȫ����ջ(����'('Ҳֹͣ)������ջ����Ϊ+-��������ȼ���ͣ�
			else if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
				//��һ���ָ���������2λ���ϵ�����
				suffix.append(' ');
				if (s.empty() || s.peek() == '(')
					s.push(infix.charAt(i));
				else {
					do {
						suffix.append(s.peek());
						s.pop();
					} while (!s.empty() && s.peek() != '(');
					s.push(infix.charAt(i));
				}
			}
			//6.�����*/,��ջ�����ȼ����ڵ�ǰ���������ֱ����ջ�������ȳ�ջ����ջ
			else if (infix.charAt(i) == '*' || infix.charAt(i) == '/'){
				//��һ���ָ���������2λ���ϵ�����
				suffix.append(' ');
				//��ǰ����������ȼ�����ջ�������ȼ���ʱ��ֱ����ջ
				if (GetPriority(s.peek(), infix.charAt(i)) == 1)
					s.push(infix.charAt(i));
				else {   //��ջ��Ϊ�գ��ҵ�ǰ����������ȼ�С�ڵ���ջ�������ȼ���ջ�����ǡ����������ܳ�ջ
					while (!s.empty() && (GetPriority(s.peek(), infix.charAt(i)) < 1) && s.peek() != '(') {
						suffix.append(s.peek());
						s.pop();
					}
					s.push(infix.charAt(i));
			}
		}
	}
		//7.����ջ�е����������ջ
		while (!s.empty()) {
			suffix.append(s.peek());
			s.pop();
		}
	}
	
	//��׺����ʽ����
	private Integer CalcSuffix(String suffix) {				
		Stack<Integer> s = new Stack<>();   	//����һ��ջ
		int iLen = suffix.length();			 //���㳤����������ѭ��
		int result = 0;                   //����ʽ���ս��
		StringBuffer temp = new StringBuffer();						 //��ʱ�������
		for (int i = 0;i < iLen;i++) {
			//1.ɨ�赽��������ջ
			if (IsDigit(suffix.charAt(i)))
				temp.append(suffix.charAt(i));
			else if (suffix.charAt(i) == ' ') { //��������ָ��������tempת��Ϊ���֣�ѹ��ջ
				if (temp.length() > 0) {//��ֹ�����������ָ����������ж�һ��temp�����Ƿ�������
					s.push(Integer.valueOf(temp.toString()));
					temp.setLength(0);
				}
			}
			//2.ɨ�赽�������ջ��������Ԫ�����γ�ջ����Ӧ������,�ѽ������ջ
			else if (IsOperator(suffix.charAt(i))) {
				//��ֹ���ֺ���ֱ�Ӹ����������������ҲҪ�ж�һ��temp�Ƿ�������û����ȡ����
				if (temp.length() > 0){
					s.push(Integer.valueOf(temp.toString()));
					temp.setLength(0);
				}
				int op1 = s.peek();
				s.pop();
				int op2 = s.peek();
				s.pop();
				result = Calc(op1, op2, suffix.charAt(i));
				s.push( result);
			}
		}
		return s.peek();
	}
	
	//�ж��Ƿ�������
	private boolean IsDigit(char ch) {									  
		return (ch >= '0' && ch <= '9') || ch == '.' ? true : false;
	}
	
	//�ж��Ƿ��ǲ�����	
	private boolean IsOperator(char ch) {									
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' ? true : false;
	}
	
	//�ж�����������ȼ���-1��ʾС�ڣ�0��ʾ���ڣ�1��ʾ����								
	private int GetPriority(char op1, char op2) throws Exception {
		if ((op1 == '+' || op1 == '-') && (op2 == '-' || op2 == '+'))
			return 0;
		else if (op1 == op2)
			return 0;
		else if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/'))
			return 1;
		else if ((op1 == '*' || op1 == '/') && (op2 == '-' || op2 == '+'))
			return -1;
		else if ((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/') && op1 != op2)
			return 0;
		else 
			throw new Exception("������������ȼ�δ����.");
	}
	
	//�����������������
	private int Calc(int op1, int op2, char op) {			
		switch (op) {
		case '+': return op2 + op1;
		case '-': return op2 - op1;
		case '*': return op2 * op1;
		case '/': if (op1 != 0) return op2 / op1;
				  else return 0;
		default:  return 0;
		}
	}

}