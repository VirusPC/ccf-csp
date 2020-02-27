package d2013_12.q5;

import java.util.Scanner;
import java.util.Stack;


/**
 * 0. ����ֻ����20�֣���ʾ����ʱ���󡣴����ʱ�临�Ӷ�̫�ߵ��³�ʱ��?
 * 1. �����ڽӱ���ͼ���ߵĽ�������λ���йء�һ��ά����ɻ�ת�����������Ᵽ��λ�����ꡣ
 * 2. ��SΪ��㣬��ͼ���б��������Ҷ�ÿ�����Ե���ĵ��ٴν��б����������տ��Ե����ص㣬��count++��
 * @author PengCheng
 *
 */
public class Main {
	
	class Node {
		int number;
		Node next;
		
		public Node(int number) {
			this.number = number;
		}
		
		// ͷ�巨
		public void addNext(Node node) {
			node.next = this.next;
			this.next = node;
		}
	}

	public final static char STOP = '#';
	public final static char WASD = '+';
	public final static char AD = '-';
	public final static char WS = '|';
	public final static char S = '.';
	public final static char BEGIN = 'S';	
	public final static char END = 'T';
	
	char[] symbols;
	Node[] table;
	int row;
	int column;
	int beginPos = -1;
	int endPos = -1;
	int count = 0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	public void run() {
		createMap();
		
		// ������� ����
		Stack<Integer> stack1 = new Stack();
		boolean[] passed1 = new boolean[table.length];  // ������־�߹��Ľڵ�
		boolean arrived1 = false;
		stack1.push(beginPos);
		while(!stack1.empty()) {
			//ȡջ���ڵ����
			int num1 = stack1.pop();
			passed1[num1] = true;
			Node n1 = table[num1];
			
			// ���ܵ���Ľڵ����
			Stack<Integer> stack2 = new Stack();
			boolean[] passed2 = new boolean[table.length];
			boolean arrived2 = false;
			stack2.push(num1);
			while(!stack2.empty()) {
				int num2 = stack2.pop();
				
				// ���Ե����յ㣬
				if(num2==endPos) {
					arrived1 = true;
					arrived2 = true;
					break;
				}
				
				passed2[num2] = true;
				Node n2 = table[num2];
				while(n2.next!=null) {
					n2 = n2.next;
					if(!passed2[n2.number]) {
						stack2.push(n2.number);
					}
				}
			}
			if(!arrived2) {
				count++;
			}
			
			// �������ӵ�,δ�������Ľڵ����
			while(n1.next!=null) {
				n1 = n1.next;
				if(!passed1[n1.number]) {
				    stack1.push(n1.number);
				}
			}
		}
		
		if(!arrived1) {
			System.out.print("I'm stuck!");
		} else {
			System.out.print(count);
		}
		
	}
	
	
	public void createMap() {
		Scanner input = new Scanner(System.in);
		row = input.nextInt();
		column = input.nextInt();
		int totalNum = row*column;
		symbols = new char[totalNum];
		table = new Node[totalNum];

		// ������ʼ�ڽӱ����ڽӱ���ÿ����ķ��ż�¼��symbols�У�����¼�¿�ʼλ��
		for(int i=0; i<row; i++) {
			String line = input.next();
			for(int j=0; j<column; j++) {
				char symbol = line.charAt(j);
				int now = i*row+j;
				symbols[now] = symbol;
				Node startNode = new Node(now);
				table[now] = startNode;
				
				//���������յ�Ķ�����
				if(BEGIN == symbol) {
					beginPos = i*row + j;
				} else if(END == symbol) {
					endPos = i*row+j;
				}
				
			}
		}
		
		// ���
		for(int i=0; i<table.length; i++) {
			addEdge(table[i], symbols[i], i);
		}
		
		//printTable();
		
	}
	
	public void addEdge(Node startNode, char symbol, int order) {
		
		//��άһά����ת��
		int i = order / column;
		int j = order % column;
		
		int top = order - column;
		int bottom = order + column;
		int left = order-1;
		int right = order+1;
		
		switch(symbol) {
		case S:
			if(i<row-1 && symbols[bottom]!=STOP) {
				startNode.addNext(new Node(bottom));
			}
			break;
		case WS:
			if(i>0 && symbols[top]!=STOP) {
				startNode.addNext(new Node(top));
			}
			if(i<row-1 && symbols[bottom]!=STOP) {
				startNode.addNext(new Node(bottom));
			}
			break;
		case AD:
			if(j>0 && symbols[left]!=STOP) {
				startNode.addNext(new Node(left));
			}
			if(j<column-1 && symbols[right]!=STOP) {
				startNode.addNext(new Node(right));
			}
			break;
		case WASD:
		case BEGIN:
		case END:
			if(i>0 && symbols[top]!=STOP) {
				startNode.addNext(new Node(top));
			}
			if(i<row-1 && symbols[bottom]!=STOP) {
				startNode.addNext(new Node(bottom));
			}
			if(j>0 && symbols[left]!=STOP) {
				startNode.addNext(new Node(left));
			}
			if(j<column-1 && symbols[right]!=STOP) {
				startNode.addNext(new Node(right));
			}
			break;
		}
	}
	
	public void printTable() {
		for(int i=0; i<table.length; i++) {
			Node n =table[i];
			while(n!=null) {
				System.out.print(n.number+" ");
				n = n.next;
			}
			System.out.println();
		}
	}
}
