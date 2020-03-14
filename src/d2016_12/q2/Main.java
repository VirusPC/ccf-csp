package d2016_12.q2;

import java.util.Scanner;

/*
 * 由结果推答案
 * 
 * 
 * 0-1500 -0.03-> 0-1455
 * 1500-4500 -0.1-> 0-2700
 * 4500-9000 -0.2-> 0-3600
 * 9000-35000 -0.25-> 0-19500
 * 35000-55000 -0.3-> 0-14000
 * 55000-80000 -0.35-> 0-16250
 * >80000   -0.45-> 0-
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	
	public void run() {
		Scanner input = new Scanner(System.in);
		double money = input.nextInt();
		
		if(money<3500) {
			
		} else if(3500<money && money<=4955) {
			money = 3500 + (money-3500)/0.97;
		} else if(money<=7655) {
			money = 5000 + (money-4955)/0.9;
		} else if(money<=11255) {
			money = 8000 + (money-7655)/0.8;
		} else if(money<=30755) {
			money = 12500 + (money-11255)/0.75;
		} else if(money<=44755) {
			money = 38500 + (money-30755)/0.7;
		} else if(money<=61005){
			money = 58500+(money-44755)/0.65;
		} else {
			money = 83500+(money-61005)/0.55;
		}
		
		System.out.print((int)money);
	}

}
