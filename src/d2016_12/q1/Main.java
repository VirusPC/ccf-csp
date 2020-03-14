package d2016_12.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 方法一：先排序，再从中间找中间数
 * 方法二：直方图(评测用例有范围，可用数组直方图)，不用区分奇偶，较简单
 * @author PengCheng
 *
 */

public class Main {
	public static void main(String[] args) {
		new Main().run2();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n<=0) {
			System.out.print(-1);
			return;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(input.nextInt());
		}
		input.close();
		Collections.sort(list);
		
		int midNum = 0;
		if(list.size()%2==0) {
			int midPos = list.size()/2;
			midNum = list.get(midPos);
			if(midNum != list.get(midPos-1)) {
				midNum = -1;
			}
			int count = 0;
			for(int i=midPos+1; i<list.size(); i++) {
				if(list.get(i)!=midNum) {
					break;
				}
				count++;
			}
			for(int i=midPos-2; i>=0; i--) {
				if(list.get(i)!=midNum) {
					break;
				}
				count--;
			}
			if(count!=0) {
				midNum = -1;
			}
		} else {
			int midPos = list.size()/2;
			midNum = list.get(midPos);
			int count = 0;
			for(int i=midPos+1; i<list.size(); i++) {
				if(list.get(i)!=midNum) {
					break;
				}
				count++;
			}
			for(int i=midPos-1; i>=0; i--) {
				if(list.get(i)!=midNum) {
					break;
				}
				count--;
			}
			if(count!=0) {
				midNum = -1;
			}
		}
		
		System.out.print(midNum);
	}
	
	int maxNum = 1000;
	public void run2() {
		int[] histogram = new int[maxNum+1];
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=0; i<n; i++) {
			int num = input.nextInt();
			histogram[num]++;
		}
		input.close();
		
		int halfN = n/2;
		int count = 0;
		for(int i=1; i<maxNum+1; i++) {
			// 大于不能大于等于
			if(count+histogram[i]>halfN) {
				// 少于i的数字的数量 等于 多于i的数字的数量，不必区分奇偶
				if(count == n-count-histogram[i]) {
					System.out.print(i);
				} else {
					System.out.print(-1);
				}
				break;
			}
			count += histogram[i];
		}
	}
	
}
