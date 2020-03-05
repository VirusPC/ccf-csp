package d2015_9.q1;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	new Main().run();
    }
    
    public void run() {
    	Scanner input = new Scanner(System.in);
    	int total = input.nextInt();

    	int segmentsNum = 1;
    	int numNow = input.nextInt();
    	
    	for(int i=1; i<total; i++) {
    		int num = input.nextInt();
    		if(num!=numNow) {
    			numNow = num;
    			segmentsNum++;
    		}
    	}
    	System.out.print(segmentsNum);
    }
}
