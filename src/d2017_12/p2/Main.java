package d2017_12.p2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run2();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		input.close();
		int[] children = new int[n];
		for(int i=0; i<children.length; i++) {
			children[i] = i+1;
		}
		int pos = 0;
		int num = 0;
		int length = n;
		while(length>1) {
			num++;
			if(pos>=length) {
				pos=0;
			}
			if(num%k==0 || num%10==k) {
				for(int i=pos; i<length-1; i++) {
					children[i]=children[i+1];
				}
				length--;
			} else {
				pos++;
			}
		}
		System.out.print(children[0]);
	}

	class Queue {
		int[] array;
		int length;
		int pos;
		Queue(int n){
			array = new int[n];
			length = n;
			pos = 0;
			number();
		}
		public void number() {
			for(int i=0; i<array.length; i++) {
				array[i] = i+1;
			}
		}
		public int getNext() {
			pos = (pos+1)%length;
			return array[pos];
		}
		
		public void deleteNow() {
			for(int i=pos; i<length-1; i++) {
				array[i] = array[i+1];
			}
			length--;
//			pos = pos-1;
//			if(pos<0) {
//				pos = length-1;
//			}
		}
	}
	
	public void run2() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int num = 0;
		Queue q = new Queue(n);
		while(q.length>1) {
			num++;
			if(num%k==0 || num%10==k) {
				q.deleteNow();
			} else {
				q.getNext();		
			}
		}
		System.out.print(q.getNext());
	}
}
