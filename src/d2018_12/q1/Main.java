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
			if(sign==0) { // 经过一段路
				totalTime += countdown;
			} else if(sign==1) {  // 红灯
				totalTime += countdown;
			} else if(sign==2) { // 黄灯
				totalTime += (r+countdown);
			}
			// 绿灯视为通路
		}
		
		System.out.println(totalTime);
		
	}

}
