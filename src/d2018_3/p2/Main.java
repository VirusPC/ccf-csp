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
		// 碰撞点不会发生在端点
		for(int i=1; i<=t; i++) {
			// 运动，到达端点时调整方向
			for(int j=0; j<n; j++) {
				if(position[j]<=start) {
					direction[j] = 1;
				} else if(position[j]>=end) {
					direction[j] = -1;
				}
				position[j]+=direction[j];
			}
			/* 
			 * 判断小球是否相撞方法1
			 * 建立坐标轴，保存每个点上的小球的序号
			 * 遍历坐标轴，判断是否有一个坐标上存在两个小球，调整它们的方向
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
			 *  判断小球是否相撞方法2
			 *  用一个数组来标记是否存在与该小球位置重叠的球
			 *  	若有，则设为true，这样再遍历到它时就会跳过（题设说最多两个球相撞）
			 *  对每一个没有发生碰撞的小球，向后寻找有没有小球与其发生碰撞（坐标相同）
			 *  	若发生碰撞，调整方向
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
