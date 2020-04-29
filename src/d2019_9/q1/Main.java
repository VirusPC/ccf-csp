package d2019_9.q1;

import java.util.Scanner;

/**
 * 边输入，边一次求出结果
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
		int n = input.nextInt();
		int m = input.nextInt();

		int totalApples = 0;
		int k = 0;
		int p = 0;
		for(int i=0; i<n; i++) {
			totalApples += input.nextInt();
			int accP = 0;
			for(int j=1; j<=m; j++) {
				accP += input.nextInt();
			}
			if(accP<p) {
				k = i;
				p = accP;
			}
			totalApples += accP;
		}
		System.out.println(totalApples+" "+(k+1)+" "+(-p));
	}

}
