package d2013_12.q3;

import java.util.Scanner;

public class Main {

	/**
	 * 21:30-21:40
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		
		//��ȡ����
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int[] heights = new int[total];
		for(int i=0; i<total; i++) {
			heights[i] = input.nextInt();
		}
		
		// ���浱ǰ������
		int maxArea = heights[0];
		
		/*
		 *  ������������ÿ��������Ϊ��������������
		 *      ȷ���þ��ε�������������󣬲������ӿ�ȣ�
		 *      ���Ե�ǰ��͵�����ĸ���Ϊ���εĸߣ�
		 *      �����ǰ�������������Ƚϣ�ȡ���ֵ
		 */
		for(int i=0; i<total; i++) {
			int minHeight = heights[i];
			for(int j=i; j<total; j++) {
				minHeight = minHeight<heights[j]?minHeight:heights[j];
				int area = (j-i+1)*minHeight;
				maxArea = maxArea>area?maxArea:area;
			}
		}
		
		System.out.print(maxArea);
	}

}
