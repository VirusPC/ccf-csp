package d2016_9.q2;

import java.util.Scanner;

/**
 * 1-20�ţ�ÿ��5����λ��1-100���
 * һ������1-5��Ʊ 0�ţ�
 * ͬһ�������Ʊ��
 * 		1.���Ȱ����� a.ͬһ�� b.������� ����λ
 * 		2.�������ڱ����С�Ŀ���λ���������Ƿ����ڣ�
 * ��ʼʱ����Ʊȫ��δ����
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	boolean[] sold = new boolean[101];
	int rowsNum = 20;
	int columnsNum = 5;
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i=0; i<n; i++) {
			int[] tickets = buy(input.nextInt());
			for(int j=0; j<tickets.length; j++) {
				System.out.print(tickets[j]+" ");
			}
			System.out.println();
		}
	}
	
	public int[] buy(int n) {
		int[] tickets = new int[n];
		
		// ��Ѱ���Ƿ���ͬһ�ŵ�����n����λ
		for(int row=1; row<=20; row++) {
			int start = (row-1)*columnsNum;
			int pos = 0;
			int continues = 0;
			for(int column=1; column<=5; column++) {
				int order = start+column;
				if(!sold[order]) {
					continues++;
				} else {
					pos = column;
					continues = 0;
				}
			}
			if(continues>=n) {
				for(int i=0; i<n; i++) {
					int order = start+pos+1+i;
					sold[order] = true;
					tickets[i] = order;
				}
				return tickets;
			}
		}
		
		// û��������ʱ��ѡȡ��С��
		int acc=0;
		for(int i=1; i<sold.length; i++) {
			if(!sold[i]) {
				tickets[acc] = i;
				acc++;
			}
		}		
		return tickets;
		
	}

}
