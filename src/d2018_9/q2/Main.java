package d2018_9.q2;

import java.util.Scanner;

/**
 * �ֽ��ʱ������������ıȽϣ�
 * ��������ʱ��ε���ʼʱ��ͽ���ʱ���г����п��ܵ����
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] x = new int[n][2];
		int[][] y = new int[n][2];
		int px = 0;
		int py = 0;
		int totalTime = 0;
		
		for(int i=0; i<n ; i++) {
			x[i][0] = input.nextInt();
			x[i][1] = input.nextInt();
		}
		for(int i=0; i<n ; i++) {
			y[i][0] = input.nextInt();
			y[i][1] = input.nextInt();
		}
		
		/*
		 *  ȡ�����˵�ʱ��θ�һ����x��ʱ���Ϊ[a, b]��y��ʱ���Ϊ[c, d]
		 *  ��֪a>b, c>d
		 *  ��abcd��С˳�������֣�
		 *  	1. b<=c ���ཻʱ���
		 *  	2. a>=d ���ཻʱ���
		 *  	3. c<=a=<=b<=d
		 *  	4. a<=c<=b<=d
		 *  	5. c<=a<=d<=b
		 *  	6. a<=c<=d<=b
		 */
		
		while(px<n && py<n) {
			int a = x[px][0];
			int b = x[px][1];
			int c = y[py][0];
			int d = y[py][1];
			
			if(a>=d) {  // �޽��棬��y��ʱ�����ǰ
				py++;
			} else if(b<=c) { // �޽��棬��x��ʱ�����ǰ
				px++;
			} else if(b<=d) { //�н��棬x�Ƚ���
				if(a<=c) {  // x�ȿ�ʼ
					totalTime += b-c;
				} else {  // y�ȿ�ʼ
					totalTime += b-a;
				}
				px++;
			} else {  // �н��棬y�Ƚ���
				if(a<=c) {  // x�ȿ�ʼ
					totalTime += d-c;
				} else {  // y�ȿ�ʼ
					totalTime += d-a;
				}
				py++;
			}
		}
		System.out.print(totalTime);
	}

}
