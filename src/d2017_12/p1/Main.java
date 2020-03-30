package d2017_12.p1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = input.nextInt();
		}
		
		Arrays.sort(nums);
		int min = nums[1]-nums[0];
		for(int i=2; i<n; i++) {
			int diff = nums[i] - nums[i-1];
			if(diff<min) {
				min = diff;
			}
		}
		
		System.out.println(min);
	}

}
