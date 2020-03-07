package d2015_12.q3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 填充时深度优先，运行错误，估计是栈溢出；广度优先，运行超时。都只有90分。
 * 
 * char默认值为0x00
 * 
 * 将数组逻辑结构与物理结构分开想.
 * 
 * 与之前的画图问题不同，此题一个坐标点即为一个字符。之前是一个坐标点代表右上角一个方格
 * 
 * 注意打印输出的顺序
 * 
 * 广度优先最重要的是知道如何获得相邻点的信息，可以创建边表，也可以根据逻辑
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	char shu = '|';
	char heng = '-';
	char cross = '+';
	int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	char[][] canvas;
	int m;
	int n;
	
	public void run() {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		int q = input.nextInt();
		
		// 创建初始画布
		canvas = new char[m][n];
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				canvas[i][j] = '.';
//			}
//		}
		
		// 画图
		for(int i=0; i<q; i++) {
			int mode = input.nextInt();
			
			if(mode == 0) {  // 画线
				int x1 = input.nextInt();
				int y1 = input.nextInt();
				int x2 = input.nextInt();
				int y2 = input.nextInt();
				drawLine(x1, y1, x2, y2);
			} else { // 广度优先填充
				int x = input.nextInt();
				int y = input.nextInt();
				char fill = input.next().charAt(0);
				fillCanvasBFS(x, y, fill);		
			}			
		}
		
		
		// 打印输出
		printCanvas();
		
	}
	
	public void drawLine(int x1, int y1, int x2, int y2) {
		if(x1>x2) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if(y1>y2) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		
		// 要根据当前位置和两侧位置的符号来判断本位置是否填'+'
		if(x1==x2) {  // 竖线
			for(int j=y1; j<=y2; j++) {
				if(canvas[x1][j] == heng
						||(x1<m-1&&canvas[x1+1][j] == heng)
						||(x1>0&&canvas[x1-1][j] == heng)) { 
					canvas[x1][j] = cross;
				}else {
					canvas[x1][j] = shu;
				}
			}
		} else {  // 横线

			for(int j=x1; j<=x2; j++) {
				if(canvas[j][y1] == shu
						||(y1<n-1 && canvas[j][y1+1] == shu)
						||(y1>0 && canvas[j][y1-1] == shu)) {
					canvas[j][y1] = cross;
				}else {
					canvas[j][y1] = heng;
				}
			}
		}
	}
	
	// 广度优先，不同过passed直接通过判断符号来判断是否走过
	public void fillCanvasBFS(int x, int y, char fill) {
		//boolean[][] passed = new boolean[m][n];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {x, y});			
		while(!queue.isEmpty()) {
			int[] position = queue.poll();
			int xFill = position[0];
			int yFill = position[1];
			canvas[xFill][yFill] = fill;
			//passed[xFill][yFill] = true;
			
			// 依次将上下左右没走过且画布内且不为边界点加入	
			for(int ii=0; ii<direction.length; ii++) {
				int xx = xFill+direction[ii][0];
				int yy = yFill+direction[ii][1];
				if( 0<=xx && xx<m && 0<=yy && yy<n
						//&& !passed[xx][yy]
						&& canvas[xx][yy]!=fill
						&& canvas[xx][yy]!=shu
						&& canvas[xx][yy]!=heng
						&& canvas[xx][yy]!=cross) {
					queue.add(new int[] {xx, yy});
				}
			}
			
		}
	}

    // 深度优先
	public void fillCanvasDFS(int x, int y, char fill) {
		canvas[x][y] = fill;
		// 依次将上下左右没走过且画布内且不为边界点加入			
		for(int ii=0; ii<direction.length; ii++) {
			int xx = x+direction[ii][0];
			int yy = y+direction[ii][1];
			if( 0<=xx && xx<m && 0<=yy && yy<n
					&& canvas[xx][yy]!=fill
					&& canvas[xx][yy]!=shu
					&& canvas[xx][yy]!=heng
					&& canvas[xx][yy]!=cross) {
				fillCanvasDFS(xx, yy, fill);
			}
		}

	}
	
	/**
	 * 打印画布
	 */
	public void printCanvas() {
		for(int j=n-1; j>=0; j--) {
			for(int i=0; i<m; i++) {
				if(canvas[i][j]==0) {
					System.out.print('.');
				} else {
					System.out.print(canvas[i][j]);
				}
			}
			System.out.println();
		}
	}

}
