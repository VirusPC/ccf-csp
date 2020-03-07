package d2015_12.q3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * ���ʱ������ȣ����д��󣬹�����ջ�����������ȣ����г�ʱ����ֻ��90�֡�
 * 
 * charĬ��ֵΪ0x00
 * 
 * �������߼��ṹ������ṹ�ֿ���.
 * 
 * ��֮ǰ�Ļ�ͼ���ⲻͬ������һ������㼴Ϊһ���ַ���֮ǰ��һ�������������Ͻ�һ������
 * 
 * ע���ӡ�����˳��
 * 
 * �����������Ҫ����֪����λ�����ڵ����Ϣ�����Դ����߱�Ҳ���Ը����߼�
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
		
		// ������ʼ����
		canvas = new char[m][n];
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				canvas[i][j] = '.';
//			}
//		}
		
		// ��ͼ
		for(int i=0; i<q; i++) {
			int mode = input.nextInt();
			
			if(mode == 0) {  // ����
				int x1 = input.nextInt();
				int y1 = input.nextInt();
				int x2 = input.nextInt();
				int y2 = input.nextInt();
				drawLine(x1, y1, x2, y2);
			} else { // ����������
				int x = input.nextInt();
				int y = input.nextInt();
				char fill = input.next().charAt(0);
				fillCanvasBFS(x, y, fill);		
			}			
		}
		
		
		// ��ӡ���
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
		
		// Ҫ���ݵ�ǰλ�ú�����λ�õķ������жϱ�λ���Ƿ���'+'
		if(x1==x2) {  // ����
			for(int j=y1; j<=y2; j++) {
				if(canvas[x1][j] == heng
						||(x1<m-1&&canvas[x1+1][j] == heng)
						||(x1>0&&canvas[x1-1][j] == heng)) { 
					canvas[x1][j] = cross;
				}else {
					canvas[x1][j] = shu;
				}
			}
		} else {  // ����

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
	
	// ������ȣ���ͬ��passedֱ��ͨ���жϷ������ж��Ƿ��߹�
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
			
			// ���ν���������û�߹��һ������Ҳ�Ϊ�߽�����	
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

    // �������
	public void fillCanvasDFS(int x, int y, char fill) {
		canvas[x][y] = fill;
		// ���ν���������û�߹��һ������Ҳ�Ϊ�߽�����			
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
	 * ��ӡ����
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
