package d2017_9.q3;

import java.util.Scanner;
import java.util.Stack;

/**
 * 90分
 * 
 * split中匹配的是正则表达式，要用"."分割，需写成"\\."
 * 栈，括号匹配思想（键值对，键视为左括号，值视为右括号,右大括号视为逗号）
 * 用二叉树表示森林
 * 
 * 反斜杠后面不能出现 " 和  \
 * 查询结果：1. STRING 名字   2.OBJECT  3.NOTEXIST	
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		new Main().run();
	}
	
	class Node{
		private String name;
		private Node leftNode;
		private Node rightNode;
		Node(String name){
			this.name = name;
		}

		public void addRightNode(Node newNode) {
			Node temp = rightNode;
			rightNode = newNode;
			newNode.rightNode = temp;
		}
		public void addChildNode(Node newNode) {
			if(leftNode==null) {
				leftNode = newNode;
			} else {
				leftNode.addRightNode(newNode);
			}
		}
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();
		StringBuilder jsonBuilder = new StringBuilder();
		for(int i=0; i<n; i++) {
			jsonBuilder.append(input.nextLine().trim());
		}
		String json = jsonBuilder.toString();
		//json.replace(" ", "");
		
		Node root = new Node("root");
		parseObject(root, json);
		
		for(int i=0; i<m; i++) {
			searchValue(input.nextLine(), root);
		}
		
	}
	
	public void parseObject(Node root, String json) {
		StringBuilder wordBuilder = new StringBuilder();
		Stack<Node> keyStack = new Stack<Node>();
		keyStack.push(root);
		int pos = 0;
		
		
		while(pos<json.length()) {
			char now = json.charAt(pos);
			if(':'==now) {
				Node key = new Node(wordBuilder.toString());
				wordBuilder = new StringBuilder();
				keyStack.push(key);
			} else if(','==now || '}'==now) { // 上一个键值对已经分析完
				char before = json.charAt(pos-1);
				for(int i=2; ' '==before; i++) {
					before = json.charAt(pos-i);
				}
				if('"'==before){ //上一个键值对的值是字符串
					Node value = new Node(wordBuilder.toString());
					wordBuilder = new StringBuilder();
					Node key = keyStack.peek();
					key.addChildNode(value);
				}
				Node key = keyStack.pop();
				Node parent = keyStack.peek();
				parent.addChildNode(key);

			} else if ('"'==now){
				
				now = json.charAt(++pos);
				while('"'!=now) {
					if('\\'==now) {
						now = json.charAt(++pos);
					}
					wordBuilder.append(now);
					now = json.charAt(++pos);
				}
			}
			pos++;
		}
		
	}
	

	public void searchValue(String s, Node tree) {
		String[] names = s.split("\\.");
		Node searchNode = tree;
		for(int i=0; i<names.length; i++) {
			searchNode = searchNode.leftNode;
			// 寻找同级内有没有符合条件的名称
			while(searchNode!=null) {
				if(searchNode.name.equals(names[i])) {
					break;
				}
				searchNode = searchNode.rightNode;
			}
			if(searchNode==null) {
				System.out.println("NOTEXIST");
				return;
			} 
		}
		if(searchNode.leftNode==null) {
			System.out.println("NOTEXIST");
		}else if(searchNode.leftNode.leftNode==null) {
			System.out.println("STRING "+searchNode.leftNode.name);
		} else {
			System.out.println("OBJECT");
		}
	}

}
