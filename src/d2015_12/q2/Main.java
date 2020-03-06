package d2015_12.q2;

import java.util.Scanner;

/**
 * 简单
 * 
 * 两次扫描：横向扫描和纵向扫描
 * 每次扫描判断是否有大于等于三个连续的棋子
 * 
 * 考虑到有可能有五个棋子组成的L形可消除的情况，
 * 故不能立刻消除，而是记录下消除的棋子的位置，最后统一消除
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
    
	void run() {
		Scanner input = new Scanner(System.in);
		int lines = input.nextInt();
		int columns = input.nextInt();
		boolean[][] delete = new boolean[lines][columns];
		int[][] chessboard = new int[lines][columns];
		
		int chessColor = 0;
		int accNum = 1; //从1开始
		
		// 边读取，边进行横向扫描
		for(int i=0; i<lines; i++) {
			for(int j=0; j<columns; j++) {
				chessboard[i][j] = input.nextInt();
			    
				// 颜色与上一个相同时，计数器+1
				if(chessColor == chessboard[i][j]) {
					accNum++;
				} else {// 颜色不同时，判断是否需要消除前accNum个棋子，并重置棋子和计数器
					if(accNum>=3) {
						for(int k=1; k<=accNum; k++) {
							delete[i][j-k] = true;
						}
					}
					chessColor = chessboard[i][j];
					accNum=1;
				}
			}
			
			// 行遍历结束需额外判断一次是否需要消除
			if(accNum>=3) {
				for(int k=1; k<=accNum; k++) {
					delete[i][columns-k] = true;
				}
			}
			
			// 每扫描完一次，重置一次
			chessColor = 0;
			accNum = 1;
		}
		
		// 纵向扫描
		for(int j=0; j<columns; j++) {
			for(int i=0; i<lines; i++) {
				if(chessboard[i][j] == chessColor) {
					accNum++;
				} else {
					if(accNum>=3) {
						for(int k=1; k<=accNum; k++) {
							delete[i-k][j] = true;
						}
					}
					chessColor = chessboard[i][j];
					accNum = 1;
				}
			}
			if(accNum>=3) {
				for(int k=1; k<=accNum; k++) {
					delete[lines-k][j] = true;
				}
			}
			chessColor = 0;
			accNum = 1;
		}
		
		
		// 边删除边打印输出
		for(int i=0; i<lines; i++) {
			for(int j=0; j<columns; j++) {
				if(delete[i][j]) {
					System.out.print(0);
				} else {
					System.out.print(chessboard[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
	}
}
