package d2015_3.q1;

import java.util.Scanner;

/**
 * ͼ�񲻶���������ϵ����������ķ���
 * ��ͷ����ת90��˼����ӡ�ķ���
 * 
 * ���������ڷ����ڲ�80�֣�����������90�֡��������ڴ�������⡣
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
