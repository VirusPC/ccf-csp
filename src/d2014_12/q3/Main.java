package d2014_12.q3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 通过判断下行是否为空来判断输入是否结束。用hasNextLine会有问题
 * 开盘价必定为买方出价中的一个（买方最低价>=开盘价>=买房最高价）
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
		 *  buyQueue为空，供过于求.
		 */
		while(buyQueue.isEmpty())
		
		
		/*  
		 *  sellQueue为空，供不应求. 为扩大成交量继续填入买家信息
		 */
		while(sellQueue.isEmpty()) {
			Entry entry = buyQueue.poll();
			buyNum+=entry.num;
			//??????
		}
		
		
		/*
		 *  二者都不为空，minBuyPrice与maxBuyprice碰头，此时minBuyPrice还是最高开盘价。
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
			} else if(words.length == 2) { //撤销记录
				int order = Integer.parseInt(words[1]);
				entrys[order-1] = null;
				continue;
			} else {		
				// 添加记录
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
