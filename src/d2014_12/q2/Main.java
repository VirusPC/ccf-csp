package d2014_12.q2;

import java.util.Scanner;

/**
 * 将扫描过程拆解成可循环的小过程。此题拆解为两个过程：1.从左下角向右上角扫描 2.从右上角向左下角扫描
 * 通过设置变量direction来控制扫描方向。每次扫描完跳到下一行并调整方向。
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();

    }
    
    
    
    public void run() {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int[][] matrix = new int[n][n];
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			matrix[i][j] = input.nextInt();
    		}
    	}
    	
    	
    	int i=0;
    	int j=0;
    	// true为向右上方，false为向左下方
    	boolean direction = true;
    	
    	while(i!=n-1 || j!=n-1) {
    	
    		//从边界向右上方移动
    		if(direction == true) {
    			
    			// 不在上边界也不在右边界时
    			while(i!=0 && j!=n-1){
    				System.out.print(matrix[i][j]+" ");
    				i--;
    				j++;

    			}
    			// 输出边界上的点
    			System.out.print(matrix[i][j] + " ");
    			
    			/*
    			 *  转向
    			 *  不可以交换顺序。由于（0, n-1）点的存在
    			 */
    			if(j==n-1) {
    				i++;
    			} else {
    				j++;
    			}
    			
    		} else {  // 从边界向左下方移动
    			
    			// 不在下边界也不在左边界时
    			while(i!=n-1 && j!=0) {
    				System.out.print(matrix[i][j] + " ");
    				i++;
    				j--;

    			}
    			// 输出边界上的点
    			System.out.print(matrix[i][j] + " ");
    			
    			if(i==n-1) {
    				j++;
    			} else {
    				i++;
    			}
    		}
    		
    		direction = !direction;
    		
    	}
    	
    	System.out.print(matrix[n-1][n-1] + " ");
    	
    }
}
