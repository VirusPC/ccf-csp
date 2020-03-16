package d2017_3.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

	void run(){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] cakes = new int[n];
		
		for(int i=0; i<n; i++) {
			cakes[i] = input.nextInt();
		}
		
		int get = 0;
		
		int i=0;
		while(i<n) {
			int total = 0;		
			while(total<k&&i<n) {
				total += cakes[i];
				i++;
			}		
			get++;
		}
		
		System.out.print(get);
	}
}
