package d2014_9.q3;

import java.util.Scanner;

/**
 * 串的模式匹配算法. 简单匹配. KMP较麻烦且对此题提升并不是很大故没用
 * 注意：设主串长m，字串长n，最多只需要比较m-n+1次
 * 20:20-20:40
 * @author PengCheng
 *
 */
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	// 0为大小写不敏感， 1为敏感
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
	 * 字符串匹配
	 * @param sentence 句子
	 * @param word 单词
	 * @return
	 */
	public boolean contain(String sentence, String word) {
		//boolean result = false;
		
		// 注意此处应为小于等于而不是小于
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
