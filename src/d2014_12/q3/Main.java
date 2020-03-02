package d2014_12.q3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * ͨ���ж������Ƿ�Ϊ�����ж������Ƿ��������hasNextLine��������
 * ���̼۱ض�Ϊ�򷽳����е�һ��������ͼ�>=���̼�>=����߼ۣ�
 * @author PengCheng
 *
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	class Entry {
		boolean buy;
		float price;
		int num;
		
		Entry(boolean buy, float price, int num){
			this.buy = buy;
			this.price = price;
			this.num = num;
		}
	}
	
	class ascendantComparator implements Comparator<Entry>{

		@Override
		public int compare(Entry arg0, Entry arg1) {
			if(arg0==null||arg1==null) {
				System.out.println("error");
				return 0;
			}
			float price1 = arg0.price;
			float price2 = arg1.price;
			if(price1>price2) {
				return 1;
			} else if(price1<price2) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	class descendantComparator implements Comparator<Entry>{

		@Override
		public int compare(Entry arg0, Entry arg1) {
			if(arg0==null||arg1==null) {
				System.out.println("error");
				return 0;
			}
			float price1 = arg0.price;
			float price2 = arg1.price;
			if(price1>price2) {
				return -1;
			} else if(price1<price2) {
				return 1;
			} else {
				return 0;
			}
		}
		
	}

	public void run() {
		Entry[] entrys = readEntrys();
		
		Queue<Entry> buyQueue = new PriorityQueue<Entry>(new descendantComparator());
		Queue<Entry> sellQueue = new PriorityQueue<Entry>(new ascendantComparator());
		
		for(int i=0; i<entrys.length; i++) {
			Entry entry  = entrys[i];
			if(entry == null) {
				continue;
			} else if(entry.buy) {
				buyQueue.add(entry);
			} else {
				sellQueue.add(entry);
			}
		}
		
		int total = buyQueue.size() + sellQueue.size();
		
		
		
		int buyNum=0;
		int sellNum=0;
	    float minBuyPrice = buyQueue.peek().price;
		float maxSellPrice = sellQueue.peek().price;
		
		while(!buyQueue.isEmpty() && !sellQueue.isEmpty()) {
			if(buyNum>sellNum) {
				Entry sellEntry = sellQueue.poll();
				if(sellEntry.price>minBuyPrice) {
					break;
				}
				sellNum+=sellEntry.num;
				maxSellPrice = sellEntry.price;
			} else {
				Entry buyEntry = buyQueue.poll();
				if(buyEntry.price<maxSellPrice) {
					break;
				}
				buyNum += buyEntry.num;
				minBuyPrice = buyEntry.price;
			}
		}
		
		/*
		 *  buyQueueΪ�գ���������.
		 */
		while(buyQueue.isEmpty())
		
		
		/*  
		 *  sellQueueΪ�գ�����Ӧ��. Ϊ����ɽ����������������Ϣ
		 */
		while(sellQueue.isEmpty()) {
			Entry entry = buyQueue.poll();
			buyNum+=entry.num;
			//??????
		}
		
		
		/*
		 *  ���߶���Ϊ�գ�minBuyPrice��maxBuyprice��ͷ����ʱminBuyPrice������߿��̼ۡ�
		 */
		
		float p0 = minBuyPrice;
		
		System.out.printf("%.2f %d", p0, Math.min(buyNum, sellNum));
		

	}
	
	public Entry[] readEntrys() {
		
		Entry[] entrys = new Entry[5000];

		Scanner input = new Scanner(System.in);
		
		
		for(int i=0; i<5000; i++) {
			String line = input.nextLine();
			String[] words = line.split(" ");
			
			if(words.length<2 || words.length>3) {
				break;
			} else if(words.length == 2) { //������¼
				int order = Integer.parseInt(words[1]);
				entrys[order-1] = null;
				continue;
			} else {		
				// ��Ӽ�¼
				boolean buy = "buy".equals(words[0])?true:false;
				float price = Float.parseFloat(words[1]);
				int num = Integer.parseInt(words[2]);
				
				entrys[i] = new Entry(buy, price, num);
			}
		}
		
		input.close();
		
		return entrys;
	}
	
	
	
}
