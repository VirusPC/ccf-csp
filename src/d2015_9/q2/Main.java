package d2015_9.q2;

import java.util.Scanner;

/**
 * 2015��3�µ�����ļ򻯰�
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	int[] daysInMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		int day = input.nextInt();
		input.close();
		
		// ����ʱ���·ݶ�һ��
		if((year%400==0)
				||(year%4==0 && year%100!=0)) {
			daysInMonth[2]++;
		}
	
		
		
		int month=1;
		
		// ���������
		for(month=1; day>daysInMonth[month]; month++) {
			day -= daysInMonth[month];
		}
		
		System.out.println(month);
		System.out.print(day);
		
	}
	

}
