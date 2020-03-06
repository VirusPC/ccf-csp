package d2015_12.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
    void run() {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int sum = 0;
    	while(n!=0) {
    		sum += n%10;
    		n /= 10;
    	}
    	System.out.print(sum);
    }
}
