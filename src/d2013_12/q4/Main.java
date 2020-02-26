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
		 *  ��̬�滮
		 * 
		 *  �Ժ����������Ŀ�������Ѿ�������Ŀ������״̬
		 *  ��֪��λ��Ϊ2����1����0��
		 *  ״̬���£�
		 *  0. �� 2
		 *  1. �� 2��0               ��һ��0״̬��ĩβ��1 || ��һ��1״̬��ĩβ��2��0
		 *  2. �� 2��0��1         ��һ��1״̬��ĩβ��1 || ��һ��2״̬��ĩβ��1��2
		 *  3. �� 2��3               ��һ��0״̬��ĩβ��1 || ��һ��3״̬��ĩβ��3
		 *  4. �� 2��3��0         ��һ��1״̬��ĩβ��3 || ��һ��3״̬��ĩβ��0 || ��һ��4״̬��ĩβ��0��3
		 *  5. �� 2��3��0��1   ��һ��2״̬��ĩβ��3 || ��һ��4״̬��ĩβ��1 || ��һ��5״̬��ĩβ��1��3
		 *  
		 *  ע��������⣬ȡ����˳�ͬһ���ȼ�
		 */
		long[] states  = new long[6];
		long[] statesOld = new long[6];
		
		// ȫΪ2�Ŀ�����ֻ��һ��
		states[0] = 1;
		
		for(int i=2; i<=digits; i++) {
			
			for(int j=1; j<6; j++) {
				statesOld[j] = states[j];
			}
			
			// ȡ����������Ƴ˳��ŵ������ڣ�����Ҫ���������ȡ��һ��
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
