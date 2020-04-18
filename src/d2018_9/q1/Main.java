package d2018_9.q1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] prices = new int[n];
		
		for(int i=0; i<n; i++) {
			prices[i] = input.nextInt();
		}
		
		int[] prices2 = new int[n];
		for(int i=0; i<n; i++) {
			int count = 1;
			prices2[i] = prices[i];
			if(i-1>=0) {
				prices2[i] += prices[i-1];
				count++;
			}
			if(i+1<n) {
				prices2[i] += prices[i+1];
				count++;
			}
			prices2[i] /= count;
		}
		
		for(int i: prices2) {
			System.out.print(i+" ");
		}
	}
}
