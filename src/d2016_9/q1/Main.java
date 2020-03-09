package d2016_9.q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int maxWave = 0;
		int past = input.nextInt();
		for(int i=1; i<n; i++) {
			int now = input.nextInt();
			int wave = Math.abs(now-past);
			maxWave = Math.max(maxWave, wave);
			past = now;
		}
		System.out.print(maxWave);
	}
}
