package d2016_3.q3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 90��
 * 
 * ˫�˶��У�������˳����ԣ��ͷ���������һ�£�pop=push,pollLast=pollFirst��ʲô��
 * 
 * 
 * ��Ŀ¼��/
 * . ��Ŀ¼�� ..��һ��Ŀ¼����Ŀ¼��һ����������
 * �������/����һ��/
 * ���滯·����
 * 0. ����·��------------------------
 * 1. ����.��.. 
 * 2. �������/��һ��
 * 3. ·����/��β��һ������Ŀ¼��Ҫȥ��/����Ŀ¼��ȥ��
 * 4. ·��Ϊ���ַ��������ص�ǰĿ¼ -----------------
 * @author PengCheng
 *
 */
public class Main {
   public static void main(String[] args) {
	   new Main().run();
   }
   
   
   String seperator = "/";
   //char root = '/';
   String point = ".";

   String workingDir = "/";
   
   public void run() {
	   Scanner input = new Scanner(System.in);
	   int n = input.nextInt();
	   input.nextLine();
	   workingDir = input.nextLine();
	   
	   for(int i=0; i<n; i++) {
		   String s = input.nextLine();
		   s = process(s);
		   System.out.println(s);
	   }
	   input.close();
   }
   
   public String process(String s) {

	   s =s.trim();
	   // 5.���ַ��������ص�ǰĿ¼
	   if(s.length()==0) {
		   return workingDir;
	   }
	   
	   Deque<String> deque = new ArrayDeque<String>();

	   // 0.�������·�����Ƚ���ǰĿ¼������ջ
	   if(!seperator.equals(s.substring(0, 1))) {
		   String[] wdirs = workingDir.split(seperator);
		   for(int i=0; i<wdirs.length; i++) {
			   if(!"".equals(wdirs[i].trim())) {
				   deque.push(wdirs[i]);
			   }
		   }
	   }
	   
	   
	   /* 1. ����.��.. 
	    * 2. �������/��һ��
	    * 3. ·����/��β��һ������Ŀ¼��Ҫȥ��/����Ŀ¼��ȥ��
	    * 
	    */
	   s += seperator;
	   StringBuilder word = new StringBuilder();
	   for(int i=0; i<s.length(); i++) {	   
		   String processing = s.substring(i, i+1);
		   
		   // ��Ϊ�ָ������򽫵�ǰ�ļ�����Ŀ¼����ջ�������������2
		   if(processing.equals(seperator)) {
			   String w = word.toString().trim();
			   if(!"".equals(w)) {
				   deque.push(word.toString());  
				   word = new StringBuilder();
			   }
		   } else if(point.equals(processing)&&word.length()==0) { // �п��ܳ��ֵ㿪ͷ���ļ���Ŀ¼,����"..."
			   String next = null;
			   String nextt = null;
			   if(i+1<s.length()) {
				   next = s.substring(i+1, i+2);
			   }
			   if(i+2<s.length()) {
				   nextt = s.substring(i+2, i+3);
			   }
			   if(point.equals(next)) {
				   if(!point.equals(nextt)) {
					   i++;
					   if(!deque.isEmpty()) {
						   deque.pop();
					   }
				   } else {
					   word.append(point);
				   }
			   }
		   } else {
			   word.append(processing);
		   }
		   
	   }
	   
	   StringBuilder ss = new StringBuilder();
	  
	   if(deque.isEmpty()) {
		   return seperator;
	   }
	   
	   while(!deque.isEmpty()) {
		   ss.append(seperator);
		   ss.append(deque.pollLast());
	   }
	   
	   return ss.toString();
   }
   
   
}
