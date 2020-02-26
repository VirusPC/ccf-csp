package d2014_3.q2;

import java.util.Scanner;
//import java.util.Stack;

/**
 * ���뿴�������򵥣�������ʱ��
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
		 *  windows[i][0] ��ʾ��ǰ�������µ�i+1�����ڵ����
		 *  windows[i][1] ~ windows[i][4] ��Ŵ�����Ϣ
		 *  iΪ0ʱΪ��ײ㣬iΪwindowsNum-1ʱΪ���
		 */
		int[][] windows = new int[windowsNum][5];
		
		// ��ȡ������Ϣ
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
			
			// �Զ������ж��Ƿ���ڴ�����
			for(int j=windowsNum-1; j>=0; j--) {
				int[] window = windows[j];
				if(window[1]<=x && window[3]>=x
						&& window[2]<=y && window[4]>=y) {
					clicked =true;
					System.out.println(window[0]);
					
					
					// ����ǰ�����ƶ������
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
