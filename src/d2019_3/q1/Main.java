package d2019_3.q1;

import java.util.Scanner;

/**
 * 
 * 题目已经给出了数字的数量，可直接定位到min、max和mid
 * 
 * 题述四舍五入保留一位小数具有迷惑性，事实上不必四舍五入，
 * 因为整数除以2，结果必定为整数或*.5
 * 
 * 难点：mid为float型，在输出时至少会保留一位小数
 * 		而题目要求，mid求出为整数时按整形输出，为小数时按小数输出
 * 		需通过(int)mid==mid?来判断是否为小数
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
		int n = Integer.parseInt(input.nextLine());
		String ns = input.nextLine(); 
		String[] nss = ns.split(" ");
		
		int[] midPos;
		if(n%2==0) {
			midPos = new int[]{n/2-1,n/2};
		} else {
			midPos = new int[] {n/2};
		}
		
		float mid = 0;
		for(int i=0; i<midPos.length; i++) {
			mid += Float.parseFloat(nss[midPos[i]]);
		}
		mid = mid/midPos.length;
		
		int max = Integer.parseInt(nss[0]);
		int min = Integer.parseInt(nss[nss.length-1]);
		if(max<min) {
			int temp = max;
			max = min;
			min = temp;
		}
		
		if((int)mid == mid) {
			System.out.print(max+" "+(int)mid+" "+min);
		} else {
			System.out.print(max+" "+mid+" "+min);
		}
		
	}

}
