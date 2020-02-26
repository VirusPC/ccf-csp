package d2014_3.q2;

import java.util.Scanner;
//import java.util.Stack;

/**
 * 代码看起来更简单，但更费时。
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
		int windowsNum = input.nextInt();
		int clicksNum = input.nextInt();
		
		/*
		 *  windows[i][0] 表示当前从上往下第i+1个窗口的序号
		 *  windows[i][1] ~ windows[i][4] 存放窗口信息
		 *  i为0时为最底层，i为windowsNum-1时为最顶层
		 */
		int[][] windows = new int[windowsNum][5];
		
		// 读取窗口信息
		for(int i=0; i<windowsNum; i++) {
			int[] window = new int[5];
			window[0] = i+1;
			window[1] = input.nextInt();
			window[2] = input.nextInt();
			window[3] = input.nextInt();
			window[4] = input.nextInt();
			
			windows[i] = window;
		}
		

		for(int i=0; i<clicksNum; i++) {
			int x= input.nextInt();
			int y = input.nextInt();

			boolean clicked = false;
			
			// 自顶向下判断是否点在窗口内
			for(int j=windowsNum-1; j>=0; j--) {
				int[] window = windows[j];
				if(window[1]<=x && window[3]>=x
						&& window[2]<=y && window[4]>=y) {
					clicked =true;
					System.out.println(window[0]);
					
					
					// 将当前窗口移动到最顶层
					for(int k=j; k<windowsNum-1; k++) {
						windows[k] = windows[k+1];
					}
					windows[windowsNum-1] = window;
					
					break;
				}
			}
			
			if(!clicked) {
				System.out.println("IGNORED");
			}
		
		}
		
	}
	

}
