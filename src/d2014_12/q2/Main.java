package d2014_12.q2;

import java.util.Scanner;

/**
 * ��ɨ����̲��ɿ�ѭ����С���̡�������Ϊ�������̣�1.�����½������Ͻ�ɨ�� 2.�����Ͻ������½�ɨ��
 * ͨ�����ñ���direction������ɨ�跽��ÿ��ɨ����������һ�в���������
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
    	// trueΪ�����Ϸ���falseΪ�����·�
    	boolean direction = true;
    	
    	while(i!=n-1 || j!=n-1) {
    	
    		//�ӱ߽������Ϸ��ƶ�
    		if(direction == true) {
    			
    			// �����ϱ߽�Ҳ�����ұ߽�ʱ
    			while(i!=0 && j!=n-1){
    				System.out.print(matrix[i][j]+" ");
    				i--;
    				j++;

    			}
    			// ����߽��ϵĵ�
    			System.out.print(matrix[i][j] + " ");
    			
    			/*
    			 *  ת��
    			 *  �����Խ���˳�����ڣ�0, n-1����Ĵ���
    			 */
    			if(j==n-1) {
    				i++;
    			} else {
    				j++;
    			}
    			
    		} else {  // �ӱ߽������·��ƶ�
    			
    			// �����±߽�Ҳ������߽�ʱ
    			while(i!=n-1 && j!=0) {
    				System.out.print(matrix[i][j] + " ");
    				i++;
    				j--;

    			}
    			// ����߽��ϵĵ�
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
