package d2017_3.q2;

import java.util.Scanner;

/**
 * ��˳���Ŷ�
 * 
 * 1. ����ѧ����ѧ�Ŵ�С��������
 * 2. ������
 *    2.1. ���� 
 *    2.2. ��ǰ/����ƶ�
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
		
		// ������ʼ����
		int[] stu = new int[n];
		for(int i=0; i<n; i++) {
			stu[i] = i+1;
		}
		
		// ��ȡm������
		int m = input.nextInt();
		while(--m>=0) {
//			for(int sid: stu) {
//				System.out.print(sid+" ");
//			}
//			System.out.println();
			int p = input.nextInt();
			int q = input.nextInt();
			
			// Ѱ��ѧ��Ϊp��ͬѧ��λ��
			for(int i=0; i<n; i++) {
				int sid = stu[i];
				// �ҵ�������ƶ�����
				if(sid==p) {
					if(q>0) {  // ����ƶ�
						if(q>n-i-1) {
							q=n-i-1;
						}
						int target = i+q; //  ���n-1
						for(int j=i; j<target; j++) {
							stu[j] = stu[j+1];
						}
						stu[target] = sid;
					} else if(q<0) {  // ��ǰ�ƶ�
						q = -q;
						if(q>i) {  
							q=i;
						}
						int target = i-q;
						for(int j=i; j>target; j--) {
							stu[j] = stu[j-1];
						}
						stu[target] = sid;
					} else {
						System.out.println("not defined");
					}
					break;
				}			
			}
			

		}
		
		for(int sid: stu) {
			System.out.print(sid+" ");
		}
	}

}
