package d2014_9.q3;

import java.util.Scanner;

/**
 * ����ģʽƥ���㷨. ��ƥ��. KMP���鷳�ҶԴ������������Ǻܴ��û��
 * ע�⣺��������m���ִ���n�����ֻ��Ҫ�Ƚ�m-n+1��
 * 20:20-20:40
 * @author PengCheng
 *
 */
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	// 0Ϊ��Сд�����У� 1Ϊ����
	int mode;
	//String[] sentences;
	public void run() {
		Scanner input = new Scanner(System.in);
		String word = input.next();
		
		mode = input.nextInt();
		if(mode==0) {
			word = word.toLowerCase();
		}
		
		int num = input.nextInt();
		//String[] sentences = new String[num];
		
		for(int i=0; i<num; i++) {
			String sentence = input.next();
			if(mode==0) {
				if(contain(sentence.toLowerCase(), word)) {
					System.out.println(sentence);
				}
			} else {
				if(contain(sentence, word)) {
					System.out.println(sentence);
				}
			}
		}
		
	}
	
	/**
	 * �ַ���ƥ��
	 * @param sentence ����
	 * @param word ����
	 * @return
	 */
	public boolean contain(String sentence, String word) {
		//boolean result = false;
		
		// ע��˴�ӦΪС�ڵ��ڶ�����С��
		for(int i=0; i<=sentence.length()-word.length(); i++) {
			int pos = 0;
			while(pos<word.length()) {
				if(sentence.charAt(i+pos) == word.charAt(pos)) {
					pos++;
				} else {
					break;
				}
			}
			if(pos==word.length()) {
				return true;
			}
		}
		
		
		return false;
	}

}
