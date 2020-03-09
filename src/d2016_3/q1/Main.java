package d2016_3.q1;

import java.util.Scanner;

/**
 * 注意n<3的情况
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run2();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n<3) {
			System.out.print(0);
			return;
		}

		int turnNum = 0;
		int trendBefore = scanner.nextInt();
		int before = scanner.nextInt();
		trendBefore = before-trendBefore;
		
		for(int i=2; i<n; i++) {
			int now = scanner.nextInt();
			int trendNow = now-before;
			// 零点定理
			if(trendNow*trendBefore<0) {
				turnNum++;
			}

			trendBefore = trendNow;
			before = now;
		}
		scanner.close();
		System.out.print(turnNum);
	}
	
	
	
	public void run2() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n<3) {
			System.out.print(0);
			return;
		}
		
		int turnNum = 0;
		int left = input.nextInt();
		int mid = input.nextInt();	
		for(int i=2; i<n; i++) {
			int right = input.nextInt();
			// 正数乘负数得负数
			if((right-mid)*(mid-left)<0) {
				turnNum++;
			}
			left = mid;
			mid = right;
		}
		
		System.out.print(turnNum);
	}


}
