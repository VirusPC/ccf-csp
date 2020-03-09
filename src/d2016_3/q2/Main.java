package d2016_3.q2;

import java.util.Scanner;

/**
 * 90分
 * 运行错误
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	int[][] map;
	int[][] block;
	int leftPos;
	
    int mapWidth = 10;
    int mapHeight = 15;
    int blockSize = 4;
    int oneNum = 4;
	
    
	public void run() {
		readInfo();
		
		// 取出板块中的点，虚拟放入到游戏地图的最上面四行（前四行全为0），保存四个点的坐标。
		int[][] node = new int[4][2];
		int n = 0;
		for(int y=0; y<blockSize; y++) {
			for(int x=0; x<blockSize; x++){
				if(block[x][y]==1) {
					node[n][0] = x+leftPos;
					node[n][1] = mapHeight-blockSize+y;
					n++;
				}
			}
		}
		
		/*
		 *  从图的上向下遍历判断是否发生碰撞，一旦板块中有一个点出现碰撞
		 *  就停止
		 */
		int descent=mapHeight;
		boolean collision = false;
		for(int down=1; down<mapHeight; down++) {
			collision = false;
			for(int i=0; i<oneNum; i++) {
				int xB = node[i][0];
				int yB = node[i][1];
				if(yB-down<0||map[xB][yB-down]==1) {
					collision = true;
					break;
				}
			}
			if(collision) {
				descent = down-1;
				break;
			}
		}

		// 将板块正式放入地图中
		for(int i=0; i<oneNum; i++) {
			int xB = node[i][0];
			int yB = node[i][1];
			map[xB][yB-descent] = 1;
		}
		
		printMap();
		
	}

	
	/**
	 * 从控制台读取信息
	 */
	public void readInfo() {
		map = new int[mapWidth][mapHeight+1];
		block = new int[blockSize][blockSize];
		Scanner input = new Scanner(System.in);
		
//		// 在地图最下面加一行全1，简化逻辑
//		for(int x=0; x<mapWidth; x++) {
//			map[x][0] = 1;
//		}
		
		// 读取地图初始状态
		for(int y=mapHeight; y>0; y--) {
			for(int x=0; x<mapWidth; x++) {
				map[x][y] = input.nextInt();
			}
		}
		
		// 读取板块
		for(int y=blockSize-1; y>=0; y--) {
			for(int x=0; x<blockSize; x++) {
				block[x][y] = input.nextInt();
			}
		}
		
		leftPos = input.nextInt()-1;
		
	}
	
	public void printMap() {
		for(int y=mapHeight-1; y>=0; y--) {
			for(int x=0; x<mapWidth; x++) {
				System.out.print(map[x][y]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}

