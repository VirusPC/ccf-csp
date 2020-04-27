package d2019_3.q2;

import java.util.Scanner;
import java.util.Stack;


/**
 * 
 * 注意输出的是No而不是NO
 * 
 * 用一个栈来保存数字。
 * 在正序遍历字符串过程中：
 * 		数字直接入栈
 * 		遇到乘号，取栈顶数字，乘以下一个数字后入栈
 * 		遇到除号，取栈顶数字，除以下一个数字后入栈、
 * 		遇到减号，将下一个数字的相反数入栈
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		
		boolean[] success = new boolean[n];
		for(int i=0; i<n ;i++) {
			success[i] = isSuccess(input.nextLine());
		}
		
		for(boolean result: success) {
			if(result) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
	static final char PLUS = '+';
	static final char MINUS ='-';
	static final char TIMES = 'x';
	static final char DIV ='/';
	
	public boolean isSuccess(String line) {
		//存放操作数
		Stack<Integer> numStack = new Stack();
		
		/*
		 *  分析字符串，对于乘除的子运算式直接计算，减法取下一个数字相反数入栈
		 *  本题特性：一个运算符后的一个字符，必定为数字，且再后一位要么不存在要么为运算符
		 */
		char[] cs = line.toCharArray();
		int pos = 0;
		while(pos<cs.length) {
			char c = cs[pos];
			if('0'<=c && c<='9') {
				numStack.push(c-'0');
			} else {
				if(c==TIMES||c==DIV) {
					pos++;
					int num1 = numStack.pop();
					int num2 = cs[pos]-'0';
					if(c==TIMES) {
						numStack.push(num1*num2);
					} else {
						numStack.push(num1/num2);
					}
					
				} else if(c==MINUS) {
					pos++;
					int num = 0-(cs[pos]-'0');
					numStack.push(num);
				}
			}
			pos++;
		}
		
		// 计算和
		int sum = 0;
		while(numStack.size()>0) {
			sum += numStack.pop();
		}
		
		if(sum==24) {
			return true;
		}
		return false;
	}

}
