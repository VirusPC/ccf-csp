package d2015_3.q3;

import java.util.Scanner;

/**
 * 一三五七八十腊,三十一天永不差,四六九冬三十天,平年二月二十八
 * 闰年2月有29天，平年2月有28天
 * 
 * printf("%03d",x); 03 表示输出3位 不足补0.
 * 
 * 注意3个式子：1.判断是否为闰年 2.week=(week-1)%7+1 3.由当前月初星期，快速计算指定日
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
		
		// 1850年1月1日星期二为起始
		int weekBegin = 2;
		
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		int yearBegin = input.nextInt();
		int yearEnd = input.nextInt();
		

		// 快速跳到指定范围的前一年的一月一日的星期
		for(int i=1850; i<yearBegin; i++) {
			if(isRun(i)) {
				weekBegin += runYearDays;
			} else {
			    weekBegin += pingYearDays;
			}
		}
		weekBegin = (weekBegin-1)%7+1;
		
		
		// 在指定年份范围内查找日期
		for(int year = yearBegin; year<=yearEnd; year++) {
			
			// 是否为闰年
			boolean run = isRun(year);
			
			/*
			 * 仅在当年年份使用的星期指针。每次都初始化为当年的一月一日的星期。
			 * 不直接用weekBegin是为了方便计算下一年1月1日的星期
			 */
			int weekPoint = weekBegin;
			
			// weekBegin指向下一年一月一日
			if(run) {
				weekBegin += runYearDays;
			} else {
				weekBegin += pingYearDays;
			}
			
			// weekPoint定位到指定月月初
			for(int i=1; i<a; i++) {
				weekPoint += daysInMonth[i];
			}
			
			//若为闰年且大于二月份，还需要加一天
			if(run && a>2) {
				weekPoint++;
			}
			
			weekPoint = (weekPoint-1)%7+1;
			
			// 日从1开始
			int day = 1;
			
			/*
			 * **********************************************
			 * 重点
			 * 快速计算指定日
			 ************************************************/
			if(weekPoint<=c) {
				day +=  7*(b-1) + (c-weekPoint);
			} else {
			    day += 7*b - (weekPoint-c);
			}
			
			// 判断日是否超出范围
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
	 * 是否为闰年
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
