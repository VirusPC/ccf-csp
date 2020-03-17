package d2017_3.q2;

import java.util.Scanner;

/**
 * 按顺序排队
 * 
 * 1. 先让学生按学号从小到大排序
 * 2. 调整：
 *    2.1. 出队 
 *    2.2. 向前/向后移动
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
		int n = input.nextInt();
		
		// 创建初始队列
		int[] stu = new int[n];
		for(int i=0; i<n; i++) {
			stu[i] = i+1;
		}
		
		// 读取m条命令
		int m = input.nextInt();
		while(--m>=0) {
//			for(int sid: stu) {
//				System.out.print(sid+" ");
//			}
//			System.out.println();
			int p = input.nextInt();
			int q = input.nextInt();
			
			// 寻找学号为p的同学的位置
			for(int i=0; i<n; i++) {
				int sid = stu[i];
				// 找到后进行移动操作
				if(sid==p) {
					if(q>0) {  // 向后移动
						if(q>n-i-1) {
							q=n-i-1;
						}
						int target = i+q; //  最大n-1
						for(int j=i; j<target; j++) {
							stu[j] = stu[j+1];
						}
						stu[target] = sid;
					} else if(q<0) {  // 向前移动
						q = -q;
						if(q>i) {  
							q=i;
						}
						int target = i-q;
						for(int j=i; j>target; j--) {
							stu[j] = stu[j-1];
						}
						stu[target] = sid;
					} else {
						System.out.println("not defined");
					}
					break;
				}			
			}
			

		}
		
		for(int sid: stu) {
			System.out.print(sid+" ");
		}
	}

}
