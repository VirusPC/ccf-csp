package d2018_12.q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		int y = input.nextInt();
		int g = input.nextInt();
		int n = input.nextInt();
		int totalTime = 0;
		
		for(int i=0; i<n; i++) {
			int sign = input.nextInt();
			int countdown = input.nextInt();
			if(sign==0) { // ����һ��·
				totalTime += countdown;
			} else if(sign==1) {  // ���
				totalTime += countdown;
			} else if(sign==2) { // �Ƶ�
				totalTime += (r+countdown);
			}
			// �̵���Ϊͨ·
		}
		
		System.out.println(totalTime);
		
	}

}
