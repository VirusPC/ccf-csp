package d2014_12.q3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 优先队列，小的在前
 * @author PengCheng
 *
 */
class Entry{
	int order;
	boolean buy;
	boolean valid;
	float price;
	int num;

	public Entry(int order, float price) {
		this.order = order;
		this.price = price;
	}
	
}

public class Main2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main2().run();
	}
	

	public void run() {
		Queue<Entry> q = new PriorityQueue<Entry>(new entryComparator());
		Entry e1 = new Entry(1, 10);
		Entry e2 = new Entry(2, 9);
		Entry e3 = new Entry(3, 4.5f);
		Entry e4 = new Entry(4, 7);
		
		q.add(e1);q.add(e2);q.add(e3);q.add(e4);
		
		while(!q.isEmpty()) {
			Entry e = q.poll();
			System.out.println("order:"+e.order+"    price" + e.price);
		}
	}
	
	public void read() {
		
	}
	
	class entryComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
		    Entry e1 = (Entry)o1;
		    Entry e2 = (Entry)o2;
			return (int)(e1.price-e2.price);
		}
		
	}



}
