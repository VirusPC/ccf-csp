package d2017_3.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 注意<p></p>不用另起一行，<ul></ul>需要另起一行
 * @author PengCheng
 *
 */
public class Main {
	
	List<List<String>> text;
	List<String> html;
	int maxHeadingRank = 6;
	
	public void run() {
		read();
		parse();
		printHTML();
	}
	
	public void parse() {

		html = new ArrayList<String>();
		for(List<String> segment: text) {
			char firstChar = segment.get(0).charAt(0);
			if('#'==firstChar) {  // 标题
				String heading = segment.get(0);
				int headingRank = 0;
				while('#' == heading.charAt(headingRank)) {
					headingRank++;
				}			
				heading = heading.substring(headingRank).trim();

				headingRank = headingRank<maxHeadingRank?headingRank:maxHeadingRank;
				
				heading = parseInLine(heading);
				heading = "<h" + headingRank + ">" + heading + "</h" + headingRank + ">";
				html.add(heading);
			} else if('*' == firstChar) {  // 列表
				html.add("<ul>");
				for(int i=0; i<segment.size(); i++) {
					String line = segment.get(i);
					line = line.substring(1);
					line = line.trim();
					line = parseInLine(line);
					line = "<li>"+line+"</li>";
					// 两个if不能合到一起来写，有可能出现只有一行列表的情况
//					if(i==0) {
//						line = "<ul>"+line;
//					}
//					if(i==segment.size()-1) {
//						line = line + "</ul>";
//					}
					html.add(line);
				}
				html.add("</ul>");
			} else {  // 文本段
				for(int i=0; i<segment.size(); i++) {
					String line = segment.get(i);
					line = parseInLine(line);
					if(i==0) {
						line = "<p>" + line;
					}
					if(i==segment.size()-1) {
						line = line + "</p>";
					}
					html.add(line);
				}
			}
		}
		
	}
	
	public String parseInLine(String line) {
		String htmlLine = "";
		
		
	    int pos=0;
	    
	    while(pos<line.length()) {
	    	if('_' == line.charAt(pos)) {
	    		String[] clips = line.split("_", 3);
	    		if(clips.length<3) {
	    			continue;
	    		}
	    		htmlLine = clips[0] + "<em>" + parseInLine(clips[1]) + "</em>" + parseInLine(clips[2]);
	    		return htmlLine;
	    	} else if('['==line.charAt(pos)) {
	    		htmlLine = line.substring(0, pos);
	    		line = line.substring(pos+1);
	    		pos = 0;
	    		while(']'!=line.charAt(pos)) {
	    			pos++;
	    		}
	    		String text = line.substring(0, pos);
	    		line = line.substring(pos+1).trim();
	    		line = line.substring(1).trim();
	    		pos = 0;
	    		while(pos<line.length()-1 && ')'!=line.charAt(pos)) {
	    			pos++;
	    		}
	    		String link = line.substring(0, pos).trim();
	    		String remains = line.substring(pos+1);
	    		htmlLine += "<a href=\""+parseInLine(link)+"\">"+parseInLine(text)+"</a>"+parseInLine(remains);
	    		return htmlLine;
	    	}
	    	pos++;
	    }
		
		return line;
	}
	
	
	public void read() {
		text = new ArrayList<List<String>>();
		
		Scanner input = new Scanner(System.in);
		List<String> segment = new ArrayList<String>();
		while(input.hasNextLine()) {
			String line = input.nextLine().trim();
			/*******************************/
//			if("end".equals(line)) {
//				break;
//			}
			/*********************************/
			if("".equals(line)) {
				if(segment.size()==0) {
					continue;
				}
				text.add(segment);
				segment = new ArrayList<String>();
			} else {
				segment.add(line);
			}
		}
		if(segment.size()!=0) {
			text.add(segment);
		}
	}
	
	public void printHTML() {
		for(String line: html) {
			System.out.println(line);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
//		String s = "_bbbbbbbbbbbb_";
//		String[] ss = s.split("_", 3);
//		System.out.println(ss.length);
//		for(String a : ss) {
//			System.out.println(a);
//		}
	}

}
