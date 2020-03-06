package d2015_12.q2;

import java.util.Scanner;

/**
 * ��
 * 
 * ����ɨ�裺����ɨ�������ɨ��
 * ÿ��ɨ���ж��Ƿ��д��ڵ�����������������
 * 
 * ���ǵ��п��������������ɵ�L�ο������������
 * �ʲ����������������Ǽ�¼�����������ӵ�λ�ã����ͳһ����
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
		int accNum = 1; //��1��ʼ
		
		// �߶�ȡ���߽��к���ɨ��
		for(int i=0; i<lines; i++) {
			for(int j=0; j<columns; j++) {
				chessboard[i][j] = input.nextInt();
			    
				// ��ɫ����һ����ͬʱ��������+1
				if(chessColor == chessboard[i][j]) {
					accNum++;
				} else {// ��ɫ��ͬʱ���ж��Ƿ���Ҫ����ǰaccNum�����ӣ����������Ӻͼ�����
					if(accNum>=3) {
						for(int k=1; k<=accNum; k++) {
							delete[i][j-k] = true;
						}
					}
					chessColor = chessboard[i][j];
					accNum=1;
				}
			}
			
			// �б�������������ж�һ���Ƿ���Ҫ����
			if(accNum>=3) {
				for(int k=1; k<=accNum; k++) {
					delete[i][columns-k] = true;
				}
			}
			
			// ÿɨ����һ�Σ�����һ��
			chessColor = 0;
			accNum = 1;
		}
		
		// ����ɨ��
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
		
		
		// ��ɾ���ߴ�ӡ���
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
