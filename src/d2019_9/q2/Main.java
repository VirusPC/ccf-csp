package d2019_9.q2;

import java.util.Scanner;

/**
 * ����ͳ�Ʋ�һ����ζ����ƻ������
 *  4��������2�飬5��������3�顣����
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
		int n = Integer.parseInt(input.next());
		
		int t = 0;  // ƻ������
		int d = 0;  // ��������Ŀ���
		int e = 0;  // �����������������������
		boolean[] isDrop = new boolean[n];  // ��¼ÿ�����Ƿ�������
		
		// ͳ������ƻ������˳���¼��Щ����������
		for(int i=0; i<n; i++) {
			int m = input.nextInt();
			int apples = input.nextInt(); //������ʼƻ������
			for(int j=1; j<m; j++) {
				int op = input.nextInt();
				if(op>0) { // ����ͳ��
					if(op!=apples) {
						isDrop[i] = true;
						apples = op;
					}
				} else {  // ���
					apples += op;
				}
			}
			t += apples;
		}
		

		for(int i=0; i<n; i++) {
			if(isDrop[i]) {
				d++;
				if(isDrop[(i+1)%n] && isDrop[(i+2)%n]) {
					e++;
				}
			}
		}
		
		System.out.println(t+" "+d+" "+e);
	}

}
