package d2017_9.q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int money = input.nextInt();
		int num = 0;
		
		num += (money/50)*7;
		money = money%50;
		num += (money/30)*4;
		money = money%30;
		num += money/10;
		
		System.out.println(num);
	}

}
