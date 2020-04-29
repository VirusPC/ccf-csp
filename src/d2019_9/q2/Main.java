package d2019_9.q2;

import java.util.Scanner;

/**
 * 重新统计不一定意味着有苹果掉落
 *  4个相连算2组，5个相连算3组。。。
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
		int n = Integer.parseInt(input.next());
		
		int t = 0;  // 苹果总数
		int d = 0;  // 发生掉落的棵树
		int e = 0;  // 连续三棵树发生掉落的组数
		boolean[] isDrop = new boolean[n];  // 记录每棵树是否发生掉落
		
		// 统计最终苹果数，顺便记录哪些树发生掉落
		for(int i=0; i<n; i++) {
			int m = input.nextInt();
			int apples = input.nextInt(); //该树初始苹果数量
			for(int j=1; j<m; j++) {
				int op = input.nextInt();
				if(op>0) { // 重新统计
					if(op!=apples) {
						isDrop[i] = true;
						apples = op;
					}
				} else {  // 梳果
					apples += op;
				}
			}
			t += apples;
		}
		

		for(int i=0; i<n; i++) {
			if(isDrop[i]) {
				d++;
				if(isDrop[(i+1)%n] && isDrop[(i+2)%n]) {
					e++;
				}
			}
		}
		
		System.out.println(t+" "+d+" "+e);
	}

}
