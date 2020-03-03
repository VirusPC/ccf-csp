package d2015_3.q1;

import java.util.Scanner;

/**
 * 图像不动，换坐标系。即换输出的方向
 * 把头向右转90度思考打印的方向。
 * 
 * 数组声明在方法内部80分，声明在类中90分。都存在内存溢出问题。
 * 
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
	int[][] img ;
	
    public void run() {
       	Scanner input = new Scanner(System.in);
    	int lines = input.nextInt();
    	int columns = input.nextInt();
    	
    	img = new int[lines][columns];
    	
    	for(int i=0; i<lines; i++) {
    		for(int j=0; j<columns; j++) {
    			img[i][j] = input.nextInt();
    		}
    	}
    	
    	input.close();
    	
    	for(int i=columns-1; i>=0; i--) {
    		for(int j=0; j<lines; j++) {
    			System.out.print(img[j][i]+" ");
    		}
    		System.out.println();
    	}
    	
    }
}
