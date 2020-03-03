package d2015_3.q3;

import java.util.Scanner;

/**
 * һ�����߰�ʮ��,��ʮһ��������,�����Ŷ���ʮ��,ƽ����¶�ʮ��
 * ����2����29�죬ƽ��2����28��
 * 
 * printf("%03d",x); 03 ��ʾ���3λ ���㲹0.
 * 
 * ע��3��ʽ�ӣ�1.�ж��Ƿ�Ϊ���� 2.week=(week-1)%7+1 3.�ɵ�ǰ�³����ڣ����ټ���ָ����
 * 
 * @author PengCheng
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}


	int[] daysInMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	int runYearDays = 366;
	int pingYearDays = 365;
	

	
	public void run() {
		
		// 1850��1��1�����ڶ�Ϊ��ʼ
		int weekBegin = 2;
		
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		int yearBegin = input.nextInt();
		int yearEnd = input.nextInt();
		

		// ��������ָ����Χ��ǰһ���һ��һ�յ�����
		for(int i=1850; i<yearBegin; i++) {
			if(isRun(i)) {
				weekBegin += runYearDays;
			} else {
			    weekBegin += pingYearDays;
			}
		}
		weekBegin = (weekBegin-1)%7+1;
		
		
		// ��ָ����ݷ�Χ�ڲ�������
		for(int year = yearBegin; year<=yearEnd; year++) {
			
			// �Ƿ�Ϊ����
			boolean run = isRun(year);
			
			/*
			 * ���ڵ������ʹ�õ�����ָ�롣ÿ�ζ���ʼ��Ϊ�����һ��һ�յ����ڡ�
			 * ��ֱ����weekBegin��Ϊ�˷��������һ��1��1�յ�����
			 */
			int weekPoint = weekBegin;
			
			// weekBeginָ����һ��һ��һ��
			if(run) {
				weekBegin += runYearDays;
			} else {
				weekBegin += pingYearDays;
			}
			
			// weekPoint��λ��ָ�����³�
			for(int i=1; i<a; i++) {
				weekPoint += daysInMonth[i];
			}
			
			//��Ϊ�����Ҵ��ڶ��·ݣ�����Ҫ��һ��
			if(run && a>2) {
				weekPoint++;
			}
			
			weekPoint = (weekPoint-1)%7+1;
			
			// �մ�1��ʼ
			int day = 1;
			
			/*
			 * **********************************************
			 * �ص�
			 * ���ټ���ָ����
			 ************************************************/
			if(weekPoint<=c) {
				day +=  7*(b-1) + (c-weekPoint);
			} else {
			    day += 7*b - (weekPoint-c);
			}
			
			// �ж����Ƿ񳬳���Χ
			if(run && a==2) {
				if(day>daysInMonth[2]+1) {
					System.out.println("none");
					continue;
				}
			} else {
				if(day>daysInMonth[a]) {
					System.out.println("none");
					continue;
				}
			}
			
			System.out.printf("%4d/%02d/%02d\n",year,a, day);
		    
		}
		
	}
	
	
	/**
	 * �Ƿ�Ϊ����
	 * @param year
	 * @return
	 */
	public boolean isRun(int year) {
		if(year%400==0 
				|| (year%4==0 && year%100!=0)) {
			return true;
		}
		return false;
	}

}
