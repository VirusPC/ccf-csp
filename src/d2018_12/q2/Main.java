package d2018_12.q2;

import java.util.Scanner;

/**
 * ��Ҫת�����̵Ƶ�˳��ͱ�ʶ��
 * timer��Ҫ��long����������
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
		int[] yrg = new int[3];
		yrg[1] = input.nextInt();
		yrg[0] = input.nextInt();
		yrg[2] = input.nextInt();
		int n = input.nextInt();
		
		long timer = 0;
		
		for(int i=0; i<n; i++) {
			int sign = input.nextInt();
			sign = normalizeSign(sign);
			int countdown = input.nextInt();
			
			int[] status = statusNow(sign, countdown, timer, yrg);
			
			if(status[0]==4) {  // ����һ��·
				timer += status[1];
			} else if(status[0]==1) {  // ���
				timer += status[1];
			} else if(status[0]==0) {  // �Ƶ�
				timer += (status[1]+yrg[1]);
			}
		}
		
		System.out.println(timer);
		
	}
	
	// ���㵱ǰʱ��
	public int[] statusNow(int sign, int countdown, long timer, int[]yrg) {
		if(sign == 4) {
			return new int[] {sign, countdown};
		}

		timer = timer%(yrg[0]+yrg[1]+yrg[2]);
		while(countdown<=timer) {
			timer-=countdown;
			sign = (sign+1)%3;
			countdown = yrg[sign];
		}
		
		countdown -= timer;

		return new int[] {sign, countdown};
	}
	

	/**
	 * r:1 y:2 g:3 ת  r:1 y:0 g:2
	 * ����һ��·��0ת4
	 * @param sign
	 * @return
	 */
	public int normalizeSign(int sign) {
		if(sign==0) {
			sign=4;
		}else if(sign==2) {
			sign=0;
		} else if(sign==3) {
			sign=2;
		} 
		return sign;
	}

}
