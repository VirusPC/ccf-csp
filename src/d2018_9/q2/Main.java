package d2018_9.q2;

import java.util.Scanner;

/**
 * 分解成时间段两个两个的比较，
 * 根据两个时间段的起始时间和结束时间列出所有可能的情况
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
		int n = input.nextInt();
		int[][] x = new int[n][2];
		int[][] y = new int[n][2];
		int px = 0;
		int py = 0;
		int totalTime = 0;
		
		for(int i=0; i<n ; i++) {
			x[i][0] = input.nextInt();
			x[i][1] = input.nextInt();
		}
		for(int i=0; i<n ; i++) {
			y[i][0] = input.nextInt();
			y[i][1] = input.nextInt();
		}
		
		/*
		 *  取两个人的时间段各一个，x的时间段为[a, b]，y的时间段为[c, d]
		 *  已知a>b, c>d
		 *  则abcd大小顺序有六种：
		 *  	1. b<=c 无相交时间段
		 *  	2. a>=d 无相交时间段
		 *  	3. c<=a=<=b<=d
		 *  	4. a<=c<=b<=d
		 *  	5. c<=a<=d<=b
		 *  	6. a<=c<=d<=b
		 */
		
		while(px<n && py<n) {
			int a = x[px][0];
			int b = x[px][1];
			int c = y[py][0];
			int d = y[py][1];
			
			if(a>=d) {  // 无交叉，且y的时间段在前
				py++;
			} else if(b<=c) { // 无交叉，且x的时间段在前
				px++;
			} else if(b<=d) { //有交叉，x先结束
				if(a<=c) {  // x先开始
					totalTime += b-c;
				} else {  // y先开始
					totalTime += b-a;
				}
				px++;
			} else {  // 有交叉，y先结束
				if(a<=c) {  // x先开始
					totalTime += d-c;
				} else {  // y先开始
					totalTime += d-a;
				}
				py++;
			}
		}
		System.out.print(totalTime);
	}

}
