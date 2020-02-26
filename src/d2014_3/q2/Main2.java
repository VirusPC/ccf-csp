package d2014_3.q2;

import java.util.Scanner;
//import java.util.Stack;

/**
 * ջ ��Ҫ����ջ�ͽ�ĳλ��Ԫ���ᵽջ��������������
 * ע�⻻��
 * ������������������
 * @author PengCheng
 *
 */
public class Main2 {
	
	class Stack {
		
		int[] elements;
		int top;
		
		Stack(int n){
			this.elements = new int[n];
			top =0;
		}
	
		
		public void push(int num) {
			elements[top] = num;
			top++;
		}
		
		public void selectNumToTop(int order) {
			int temp = elements[order];
			for(int i=order; i<top-1; i++) {
				elements[i] = elements[i+1];
			}
			elements[top-1] = temp;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main2().run();
	}
	

    
	public void run() {
		Scanner input = new Scanner(System.in);
		int windowsNum = input.nextInt();
		int clicksNum = input.nextInt();
		int[][] windows = new int[windowsNum][4];
		
		// ���ģ��������浱ǰ���ڵ�˳��Ҳ����ֱ�ӽ��Ѵ��ڱ�����Ϊջ��Ԫ�أ���ÿ�����ڶ������һλ��������š�
		Stack stack = new Stack(windowsNum);
		
		// ��ȡ������Ϣ
		for(int i=0; i<windowsNum; i++) {
			stack.push(i);
			int[] window = new int[4];
			window[0] = input.nextInt();
			window[1] = input.nextInt();
			window[2] = input.nextInt();
			window[3] = input.nextInt();
			windows[i] = window;
		}
		

		for(int i=0; i<clicksNum; i++) {
			int x= input.nextInt();
			int y = input.nextInt();

			boolean clicked = false;
			
			// �Զ����±���
			for(int j=stack.top-1; j>=0; j--) {
				int num = stack.elements[j];
				if(windows[num][0]<=x && windows[num][2]>=x
						&& windows[num][1]<=y && windows[num][3]>=y) {
					clicked =true;
					System.out.println(num+1);
					stack.selectNumToTop(j); // �������ƶ������ϲ�
					break;
				}
			}
			
			if(!clicked) {
				System.out.println("IGNORED");
			}
		
		}
		
	}
	

}
