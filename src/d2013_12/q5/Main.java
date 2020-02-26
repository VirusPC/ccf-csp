package d2013_12.q5;

import java.util.Scanner;


public class Main {
	
	class Node {
		int number;
		Node next;
		
		public Node(int number) {
			this.number = number;
		}
		
		public void addNext(Node node) {
			node.next = this.next.next;
			this.next = node;
		}
	}

	public final static char STOP = '#';
	public final static char WASD = '+';
	public final static char AD = '-';
	public final static char WS = '|';
	public final static char S = '.';
	public final static char BEGIN = 'S';	
	
	// 停止或上下左右非#
	public final static char END = 'T';
	
	char[] symbols;
	Node[] table;
	int row;
	int column;
	int beginRow;
	int beginColumn;
	int endRow;
	int endColumn;

	int count;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	public void run() {
		createMap();
	}
	
	public char[][] getMapMatrix() {
		return null;
	}
	
	public void createMap() {
		Scanner input = new Scanner(System.in);
		row = input.nextInt();
		column = input.nextInt();
		int totalNum = row*column;
		symbols = new char[totalNum];
		table = new Node[totalNum];
		
		// 此处有问题，需先存在二维数组内再转邻接表，否则加边时不知道它下面和左边的符号
		// 创建初始邻接表，将邻接表中每个点的符号记录在symbols中，并记录下开始位置
		for(int i=0; i<row; i++) {
			String line = input.next();
			for(int j=0; j<column; j++) {
				char symbol = line.charAt(j);
				int now = i*row+j;
				symbols[now] = symbol;
				Node startNode = new Node(now);
				addEdge(startNode, symbol, i, j);
				if(BEGIN == symbol) {
				    beginRow = i;
				    beginColumn = j;
				}
				
			}
		}
		
		
	}
	
	public void addEdge(Node startNode, char symbol, int i, int j) {
		int top = (i-1)*row +j;
		int bottom = (i+1)*row+j;
		int left = i*row+j-1;
		int right = i*row+j+1;
		
		switch(symbol) {
		case WASD:
		case BEGIN:
		case END:
			if(i>0 && symbols[top]!=STOP) {
				startNode.addNext(new Node(top));
			}
		case AD:
			if(j>0 && symbols[left]!=STOP) {
				startNode.addNext(new Node(left));
			}
			if(j<column-1 && symbols[right]!=STOP) {
				startNode.addNext(new Node(right));
			}
		case S:
			if(j<row-1 && symbols[bottom]!=STOP) {
				startNode.addNext(new Node(bottom));
			}
		}
	}
	
	//public int getTopPostion() {}
	
	public void toEnd(int row, int column) {
		
	}

}
