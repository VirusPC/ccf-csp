package d2016_12.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ����һ���������ٴ��м����м���
 * ��������ֱ��ͼ(���������з�Χ����������ֱ��ͼ)������������ż���ϼ�
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
			// ���ڲ��ܴ��ڵ���
			if(count+histogram[i]>halfN) {
				// ����i�����ֵ����� ���� ����i�����ֵ�����������������ż
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
