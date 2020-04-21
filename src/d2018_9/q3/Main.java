package d2018_9.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 70��
 * 
 * �������õ�˳��ṹ�����õ����νṹ��
 * ʹ�ø��Ӷ�����Ϣ�ľ�̬�����ʾ����
 * 
 * ����ƥ��
 * 
 * ע���ǩ�����ִ�Сд��id����
 * 
 * ��ǩѡ������idѡ���������ѡ����ȫ����Ϊ���ѡ����
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
		int rank;  // �ڼ���
		String label;  // ��ǩ
		String id;  // id����
		List<Integer> children; // �ӽڵ�
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

		// ���ĵ���ÿһ����Ϊһ����㣬���������ĵ�
		Node[] text = new Node[n];
		
		// �õ�һ�д������ڵ�
		Node root = createNode( input.nextLine());
		text[0] = root;
		
		// �����ı�ʣ�ಿ�֣��洢�ĵ���㲢������
		for(int i=1; i<n; i++) {
			// ��ÿһ�н�����һ�����
			Node node = createNode(input.nextLine());
			
			// Ѱ�Ҹ��ڵ㣬���������ڸ��ڵ���
			int parentLineNum = i-1;
			while(parentLineNum>0 && text[parentLineNum].rank>=node.rank){
				parentLineNum--;
			}
			text[parentLineNum].children.add(i);

			// ����������
			text[i] = node;
		}
		
		
		// ѡ��������
		for(int i=0; i<m; i++) {
			search(text, input.nextLine());
		}
		

	}
	
	// ����һ�У�����һ�����
	public Node createNode(String line) {
		line = line.trim();
		int length = line.length();
		int rank = 0;
		StringBuilder label = new StringBuilder();
		StringBuilder id = new StringBuilder();
		int pos=0;
		
		// ������λ�ڵڼ���
		while(line.charAt(pos)=='.') {
			pos+=2;
		}
		rank = pos/2;
		
		//�����ո�
		while(line.charAt(pos)==' ') {
			pos++;
		}
		
		// ��������ǩ
		while(pos<length && line.charAt(pos)!=' ') {
			label.append(line.charAt(pos));
			pos++;
		}
		
		//�����ո�
		while(pos<length && line.charAt(pos)==' ') {
			pos++;
		}
		
		//��������
		pos++;
		
		// ������id
		while(pos<length && line.charAt(pos)!=' ') {
			id.append(line.charAt(pos));
			pos++;
		}
		
		// ��ǩ�����ִ�Сд��תСд
		return new Node(rank, label.toString().toLowerCase(), id.toString());
	}

	public void search(Node[] text, String command) {
		String[] selector = command.split(" ");
		List<Integer> lineNums = new ArrayList<Integer>();

		// �ж���ƥ���ǩ����id����ȡ����ǩ����id������ǩ��תСд
		String first = selector[0];		
		boolean isLabel = true;
		if('#'==first.charAt(0)) {
			isLabel = false;
			first = first.substring(1);
		} else {
			first = first.toLowerCase();
		}
		
		// �����ı���ѡ���һ��ƥ��Ľ��
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
	 * �Ӹ�����㴦��ʼƥ��
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
