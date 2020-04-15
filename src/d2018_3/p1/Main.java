package d2018_3.p1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int next = input.nextInt();
		int count = 0;
		int points = 0;
		while(next!=0) {
			if(next==1) {
				count = 0;
				points += 1;
			} else {
				count++;
				points += count*2;
			}
			
			next = input.nextInt();
		}
		System.out.println(points);
	}

}
