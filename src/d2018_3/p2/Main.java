package d2018_3.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int L = input.nextInt();
		int t = input.nextInt();
		int start = 0;
		int end = L;
		int[] direction = new int[n];
		int[] position = new int[n];
		for(int i=0; i<n; i++) {
			position[i] = input.nextInt();
			direction[i] = 1;
		}
		// ��ײ�㲻�ᷢ���ڶ˵�
		for(int i=1; i<=t; i++) {
			// �˶�������˵�ʱ��������
			for(int j=0; j<n; j++) {
				if(position[j]<=start) {
					direction[j] = 1;
				} else if(position[j]>=end) {
					direction[j] = -1;
				}
				position[j]+=direction[j];
			}
			/* 
			 * �ж�С���Ƿ���ײ����1
			 * ���������ᣬ����ÿ�����ϵ�С������
			 * ���������ᣬ�ж��Ƿ���һ�������ϴ�������С�򣬵������ǵķ���
			 */
//			List<Integer>[] coordinates = new ArrayList[L+1];
//			for(int j=0; j<coordinates.length; j++) {
//				coordinates[j] = new ArrayList<Integer>();
//			}
//			for(int j=0; j<n; j++) {
//				coordinates[position[j]].add(j);
//			}
//			for(List<Integer> point: coordinates) {
//				if(point.size()<2) {
//					continue;
//				}
//				for(int k:point) {
//					direction[k] =  - direction[k];
//				}
//			}
			
			/*
			 *  �ж�С���Ƿ���ײ����2
			 *  ��һ������������Ƿ�������С��λ���ص�����
			 *  	���У�����Ϊtrue�������ٱ�������ʱ�ͻ�����������˵�����������ײ��
			 *  ��ÿһ��û�з�����ײ��С�����Ѱ����û��С�����䷢����ײ��������ͬ��
			 *  	��������ײ����������
			 */
			boolean[] collided = new boolean[n];
			for(int j=0; j<n; j++) {
				if(collided[j]) {
					continue;
				}
				for(int k=j+1; k<n; k++) {
					if(collided[k]) {
						continue;
					}
					if(position[j] == position[k]) {
						direction[j] = -direction[j];
						direction[k] = -direction[k];
						collided[k] = true;
					}
				}
			}
		}
		
		for(int i: position) {
			System.out.print(i + " ");
		}
	}

}
