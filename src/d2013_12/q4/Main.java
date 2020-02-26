package d2013_12.q4;

import java.util.Scanner;


/**
 * 22:50-
 * @author PengCheng
 *
 */
public class Main {
	
	public final static long MAX = 1000000007L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int digits = input.nextInt();
	    
		/*
		 *  动态规划
		 * 
		 *  以后可能满足题目条件或已经满足题目条件的状态
		 *  可知首位必为2，有1必有0。
		 *  状态如下：
		 *  0. 有 2
		 *  1. 有 2、0               上一轮0状态的末尾添1 || 上一轮1状态的末尾添2或0
		 *  2. 有 2、0、1         上一轮1状态的末尾添1 || 上一轮2状态的末尾添1或2
		 *  3. 有 2、3               上一轮0状态的末尾添1 || 上一轮3状态的末尾添3
		 *  4. 有 2、3、0         上一轮1状态的末尾添3 || 上一轮3状态的末尾添0 || 上一轮4状态的末尾添0或3
		 *  5. 有 2、3、0、1   上一轮2状态的末尾添3 || 上一轮4状态的末尾添1 || 上一轮5状态的末尾添1或3
		 *  
		 *  注意溢出问题，取余与乘除同一优先级
		 */
		long[] states  = new long[6];
		long[] statesOld = new long[6];
		
		// 全为2的可能性只有一种
		states[0] = 1;
		
		for(int i=2; i<=digits; i++) {
			
			for(int j=1; j<6; j++) {
				statesOld[j] = states[j];
			}
			
			// 取余操作可类似乘除放到括号内，但需要在最外层再取余一次
			states[1] = (1 + statesOld[1]*2) % MAX;
			states[2] = (statesOld[1] + statesOld[2]*2) % MAX;
			states[3] = (1 + statesOld[3]) % MAX;
			states[4] = (statesOld[1] + statesOld[3] +statesOld[4]*2) % MAX;
			states[5] = ( statesOld[2] + statesOld[4] + 2*statesOld[5]) % MAX;
			
		}

		System.out.print(states[5]);
		//System.out.println(Long.MAX_VALUE);
		
	}
	

}
