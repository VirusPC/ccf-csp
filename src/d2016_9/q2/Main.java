package d2016_9.q2;

import java.util.Scanner;

/**
 * 1-20排，每排5个座位，1-100编号
 * 一个人买1-5张票 0张？
 * 同一个人买的票，
 * 		1.优先安排在 a.同一排 b.编号相邻 的座位
 * 		2.否则安排在编号最小的空座位（不考虑是否相邻）
 * 初始时，车票全部未购买
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
		
		// 先寻找是否有同一排的连续n个座位
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
		
		// 没有连续的时，选取最小号
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
