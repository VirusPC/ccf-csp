package d2019_3.q2;

import java.util.Scanner;
import java.util.Stack;


/**
 * 
 * ע���������No������NO
 * 
 * ��һ��ջ���������֡�
 * ����������ַ��������У�
 * 		����ֱ����ջ
 * 		�����˺ţ�ȡջ�����֣�������һ�����ֺ���ջ
 * 		�������ţ�ȡջ�����֣�������һ�����ֺ���ջ��
 * 		�������ţ�����һ�����ֵ��෴����ջ
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
		//��Ų�����
		Stack<Integer> numStack = new Stack();
		
		/*
		 *  �����ַ��������ڳ˳���������ʽֱ�Ӽ��㣬����ȡ��һ�������෴����ջ
		 *  �������ԣ�һ����������һ���ַ����ض�Ϊ���֣����ٺ�һλҪô������ҪôΪ�����
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
		
		// �����
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
