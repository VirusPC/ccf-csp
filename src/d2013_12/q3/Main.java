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
		
		//读取数据
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int[] heights = new int[total];
		for(int i=0; i<total; i++) {
			heights[i] = input.nextInt();
		}
		
		// 保存当前最大面积
		int maxArea = heights[0];
		
		/*
		 *  从左到右依次以每个柱体作为矩形最左侧的柱体
		 *      确定好矩形的最左侧左侧柱体后，不断增加宽度，
		 *      并以当前最低的柱体的高作为矩形的高，
		 *      求出当前面积与最大面积相比较，取最大值
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
