package d2014_3.q2;

import java.util.Scanner;
//import java.util.Stack;

/**
 * 栈 需要有入栈和将某位的元素提到栈顶这两个方法。
 * 注意换行
 * 可以输入输出交替进行
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
		
		// 核心，用来保存当前窗口的顺序。也可以直接将把窗口本身作为栈的元素，但每个窗口都需额外一位来保存序号。
		Stack stack = new Stack(windowsNum);
		
		// 读取窗口信息
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
			
			// 自顶向下遍历
			for(int j=stack.top-1; j>=0; j--) {
				int num = stack.elements[j];
				if(windows[num][0]<=x && windows[num][2]>=x
						&& windows[num][1]<=y && windows[num][3]>=y) {
					clicked =true;
					System.out.println(num+1);
					stack.selectNumToTop(j); // 将窗口移动到最上层
					break;
				}
			}
			
			if(!clicked) {
				System.out.println("IGNORED");
			}
		
		}
		
	}
	

}
