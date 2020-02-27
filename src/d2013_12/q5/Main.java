package d2013_12.q5;

import java.util.Scanner;
import java.util.Stack;


/**
 * 0. 本题只拿了20分，显示运行时错误。大概是时间复杂度太高导致超时了?
 * 1. 建立邻接表保存图，边的建立与点的位置有关。一二维坐标可互转，故无需另外保存位置坐标。
 * 2. 以S为起点，对图进行遍历，并且对每个可以到达的点再次进行遍历。若最终可以到达重点，则count++。
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
		
		// 头插法
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
		
		// 深度优先 遍历
		Stack<Integer> stack1 = new Stack();
		boolean[] passed1 = new boolean[table.length];  // 用来标志走过的节点
		boolean arrived1 = false;
		stack1.push(beginPos);
		while(!stack1.empty()) {
			//取栈顶节点访问
			int num1 = stack1.pop();
			passed1[num1] = true;
			Node n1 = table[num1];
			
			// 对能到达的节点遍历
			Stack<Integer> stack2 = new Stack();
			boolean[] passed2 = new boolean[table.length];
			boolean arrived2 = false;
			stack2.push(num1);
			while(!stack2.empty()) {
				int num2 = stack2.pop();
				
				// 可以到达终点，
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
			
			// 将所连接的,未遍历过的节点加入
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

		// 创建初始邻接表，将邻接表中每个点的符号记录在symbols中，并记录下开始位置
		for(int i=0; i<row; i++) {
			String line = input.next();
			for(int j=0; j<column; j++) {
				char symbol = line.charAt(j);
				int now = i*row+j;
				symbols[now] = symbol;
				Node startNode = new Node(now);
				table[now] = startNode;
				
				//保存起点和终点的顶点编号
				if(BEGIN == symbol) {
					beginPos = i*row + j;
				} else if(END == symbol) {
					endPos = i*row+j;
				}
				
			}
		}
		
		// 添边
		for(int i=0; i<table.length; i++) {
			addEdge(table[i], symbols[i], i);
		}
		
		//printTable();
		
	}
	
	public void addEdge(Node startNode, char symbol, int order) {
		
		//二维一维坐标转换
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
