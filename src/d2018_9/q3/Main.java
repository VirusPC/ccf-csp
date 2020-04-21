package d2018_9.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 70分
 * 
 * 即可以用到顺序结构，又用到树形结构：
 * 使用附加额外信息的静态链表表示的树
 * 
 * 树的匹配
 * 
 * 注意标签不区分大小写，id区分
 * 
 * 标签选择器，id选择器，后代选择器全部视为后代选择器
 * 
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	class Node{
		int rank;  // 第几层
		String label;  // 标签
		String id;  // id属性
		List<Integer> children; // 子节点
		Node(int rank, String lable, String id){
			this.rank = rank;
			this.label = lable;
			this.id = id;
			this.children = new ArrayList<Integer>();
		}
	}
	

	public void run() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();

		// 将文档的每一行作为一个结点，保存整个文档
		Node[] text = new Node[n];
		
		// 用第一行创建根节点
		Node root = createNode( input.nextLine());
		text[0] = root;
		
		// 遍历文本剩余部分，存储文档结点并创建树
		for(int i=1; i<n; i++) {
			// 将每一行解析成一个结点
			Node node = createNode(input.nextLine());
			
			// 寻找父节点，将本结点挂在父节点上
			int parentLineNum = i-1;
			while(parentLineNum>0 && text[parentLineNum].rank>=node.rank){
				parentLineNum--;
			}
			text[parentLineNum].children.add(i);

			// 将本结点放入
			text[i] = node;
		}
		
		
		// 选择器搜索
		for(int i=0; i<m; i++) {
			search(text, input.nextLine());
		}
		

	}
	
	// 给出一行，创建一个结点
	public Node createNode(String line) {
		line = line.trim();
		int length = line.length();
		int rank = 0;
		StringBuilder label = new StringBuilder();
		StringBuilder id = new StringBuilder();
		int pos=0;
		
		// 解析出位于第几层
		while(line.charAt(pos)=='.') {
			pos+=2;
		}
		rank = pos/2;
		
		//跳过空格
		while(line.charAt(pos)==' ') {
			pos++;
		}
		
		// 解析出标签
		while(pos<length && line.charAt(pos)!=' ') {
			label.append(line.charAt(pos));
			pos++;
		}
		
		//跳过空格
		while(pos<length && line.charAt(pos)==' ') {
			pos++;
		}
		
		//跳过井号
		pos++;
		
		// 解析出id
		while(pos<length && line.charAt(pos)!=' ') {
			id.append(line.charAt(pos));
			pos++;
		}
		
		// 标签不区分大小写，转小写
		return new Node(rank, label.toString().toLowerCase(), id.toString());
	}

	public void search(Node[] text, String command) {
		String[] selector = command.split(" ");
		List<Integer> lineNums = new ArrayList<Integer>();

		// 判断是匹配标签还是id，并取出标签名或id名，标签名转小写
		String first = selector[0];		
		boolean isLabel = true;
		if('#'==first.charAt(0)) {
			isLabel = false;
			first = first.substring(1);
		} else {
			first = first.toLowerCase();
		}
		
		// 遍历文本，选择第一个匹配的结点
		for(int i=0; i<text.length; i++) {
			if( (!isLabel&&first.equals(text[i].id))
					|| (isLabel && first.equals(text[i].label))) {
				int result = match(text, i, selector);
				if(result!=-1) {
					lineNums.add(result);
				}
			}
		}
		
		System.out.print(lineNums.size() + " ");
		for(int i: lineNums) {
			System.out.print((i+1) + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * 从给定结点处开始匹配
	 * @param text
	 * @param rootNum
	 * @param selector
	 * @return
	 */
	public int match(Node[] text, int rootNum, String[] selector) {
		if(selector.length<=1) {
			return rootNum;
		}
		int parentNum = rootNum;
		for(int i=1; i<selector.length; i++) {
			boolean isLabel = false;
			String s = selector[i];
			if(s.charAt(0)=='#') {
				s = s.substring(1);
			} else {
				s = s.toLowerCase();
				isLabel = true;
			}
			
			boolean isMatched = false;
			for(int childNum: text[parentNum].children) {
				Node child = text[childNum];
				if((isLabel&&child.label.equals(s))
						||(!isLabel&&child.id.equals(s))) {
					parentNum = childNum;
					isMatched = true;
					break;
				}
			}
			if(!isMatched) {
				return -1;
			}
			
		}
		
		return parentNum;
	}
	
}
