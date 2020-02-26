package d2014_3.q1;

import java.util.Scanner;

/**
 * 
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = input.nextInt();
		}
		
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(nums[i] + nums[j] == 0) {
					count++;
					break;
				}
			}
		}
		System.out.print(count);;
	}

}
