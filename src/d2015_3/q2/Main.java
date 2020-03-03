package d2015_3.q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * 使用Collections.Sort排序，List中的元素应实现Comparable接口
 * map按value排序：map->set->list
 * map.entrySet(), 元素类型为Map.Entry<K, V>内部类
 * run()会内存溢出，90分。run2()满分
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run2();
	}
	
	class Node implements Comparable{
		int number;
		int times;
		Node(int number, int times){
			this.number = number;
			this.times = times;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Node n = (Node)o;
			return n.times-this.times;
		}
	}
	
	
	public void run() {
		Scanner input = new Scanner(System.in);	
		int n = input.nextInt();
		Node[] nodes = new Node[1000];
		for(int i=0; i<n; i++) {
			int number = input.nextInt();
			if(nodes[number] == null) {
				nodes[number] = new Node(number, 1);
			} else {
				nodes[number].times++;
			}
		}
		input.close();
		
		List<Node> list = new ArrayList<Node>();
		
		for(int i=0; i<1000; i++) {
			if(nodes[i]!=null) {
				list.add(nodes[i]);
			}
		}
		
		Collections.sort(list);;
		
		for(Node node: list) {
			System.out.println(node.number + " " + node.times);
		}
		
	}
	
	class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			// TODO Auto-generated method stub
			return o2.getValue()-o1.getValue();
		}
		
	}
	
	public void run2() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n; i++) {
			int number = input.nextInt();
			if(map.get(number) == null) {
				map.put(number, 1);
			} else {
				map.put(number, map.get(number)+1);
			}
		}
		input.close();
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
		
		Collections.sort(list, new MyComparator());
		
		for(Map.Entry<Integer, Integer> entry: list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}


	
	

}
