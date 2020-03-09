package d2016_3.q3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 90分
 * 
 * 双端队列，出队列顺序很迷，和方法描述不一致：pop=push,pollLast=pollFirst是什么鬼
 * 
 * 
 * 根目录：/
 * . 本目录， ..上一级目录（根目录上一级是它本身）
 * 连续多个/等于一个/
 * 正规化路径：
 * 0. 绝对路径------------------------
 * 1. 不含.和.. 
 * 2. 连续多个/变一个
 * 3. 路径以/结尾，一定代表目录，要去掉/（根目录不去）
 * 4. 路径为空字符串，返回当前目录 -----------------
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
	   // 5.空字符串，返回当前目录
	   if(s.length()==0) {
		   return workingDir;
	   }
	   
	   Deque<String> deque = new ArrayDeque<String>();

	   // 0.若是相对路径则先将当前目录各级入栈
	   if(!seperator.equals(s.substring(0, 1))) {
		   String[] wdirs = workingDir.split(seperator);
		   for(int i=0; i<wdirs.length; i++) {
			   if(!"".equals(wdirs[i].trim())) {
				   deque.push(wdirs[i]);
			   }
		   }
	   }
	   
	   
	   /* 1. 不含.和.. 
	    * 2. 连续多个/变一个
	    * 3. 路径以/结尾，一定代表目录，要去掉/（根目录不去）
	    * 
	    */
	   s += seperator;
	   StringBuilder word = new StringBuilder();
	   for(int i=0; i<s.length(); i++) {	   
		   String processing = s.substring(i, i+1);
		   
		   // 若为分隔符，则将当前文件名或目录名入栈，间接满足条件2
		   if(processing.equals(seperator)) {
			   String w = word.toString().trim();
			   if(!"".equals(w)) {
				   deque.push(word.toString());  
				   word = new StringBuilder();
			   }
		   } else if(point.equals(processing)&&word.length()==0) { // 有可能出现点开头的文件或目录,比如"..."
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
