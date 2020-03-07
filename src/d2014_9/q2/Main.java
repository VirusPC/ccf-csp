package d2014_9.q2;

import java.util.Scanner;

/**
 * 方法一：156ms
 * 先记录下所有矩形的坐标，以及他们全部所占平面的画布矩形范围
 * 然后对画布矩形范围内每个小方块判断是否在某个矩形的内部：
 *     **令坐标系中一个点代表其右上侧一个方格**
 *     遍历范围内除最右边和最下边的每个坐标点，
 *     判断该点是否在某一矩形内非右边界和上边界上的点，
 *     是则面积+1
 * 时间复杂度o(n^3)
 * 
 * 方法二：140ms
 * 设置一个boolean数组，其每个元素标志该坐标右上角的格子是否被涂上颜色
 * 遍历每个矩形的范围，对boolean数组进行涂色
 * 
 * 16:30-17:10
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run2();
		
	}
	
	/**
	 * 遍历画布上每个方格判断是否在某个矩形内
	 */
	public void run() {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] rectangle = new int[num][4];
		
		// 保存能够包含所有矩形的画布范围（不必对每个格子遍历）
		int xMin = 0;
		int xMax = 0;
		int yMin = 0;
		int yMax = 0;
		int area = 0;
		
		for(int i=0; i<num; i++) {
	        int xLeft = input.nextInt();
	        int yBottom = input.nextInt();
	        int xRight = input.nextInt();
	        int yTop = input.nextInt();
	        
	        rectangle[i][0] = xLeft;
	        rectangle[i][1] = xRight;
	        rectangle[i][2] = yBottom;
	        rectangle[i][3] = yTop;
	        
	        xMin = xMin<xLeft?xMin:xLeft;
	        xMax = xMax>xRight?xMax:xRight;
	        yMin = yMin<yBottom?yMin:yBottom;
	        yMax = yMax>yTop?yMax:yTop;
	        
		}
		
		// 忽略右边界和下边界对整体矩形范围内每个点遍历
		for(int x = xMin; x<xMax; x++) {
			for(int y = yMin; y<yMax; y++) {
				
				// 判断坐标点是否在某个小矩形的内部或下边界或左边界上
				for(int i=0; i<num; i++) {
					if(x>=rectangle[i][0] && x<rectangle[i][1]
							&&y>=rectangle[i][2] && y<rectangle[i][3]) {
						area++;
						break;
					}
				}
				
			}
		}
		
		System.out.print(area);
		
	}
	
	
	
	
	int maxSize = 100;
	
	/**
	 * 设置一个代表画布每一个方格的的boolean数组，用来保存该点是否被涂上颜色
	 * 此方法先遍历每个矩形再把矩形范围方格内标为true
	 */
	public void run2() {
		Scanner scanner = new Scanner(System.in);
		// 每一个元素代表画布上该点右上角的一个方格, 横纵范围0-99
		boolean[][] colored = new boolean[maxSize][maxSize];
		int area = 0;
		
		int n = scanner.nextInt();
		for(int i=0; i<n; i++) {
			int left = scanner.nextInt();
			int bottom = scanner.nextInt();
			int right = scanner.nextInt();
			int top = scanner.nextInt();
			
			for(int j=left; j<right; j++) {
				for(int k=bottom; k<top; k++) {
					if(!colored[j][k]) {
						colored[j][k] = true;
						area++;
					}
				}
			}
		}
		
		System.out.print(area);
		
	}

}
