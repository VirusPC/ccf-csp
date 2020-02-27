package d2014_3.q3;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 16:40
 * 类似编译原理词法分析
 * nextLine读取下一行，空格也可以输入。但需要在之前加一个nextLine来读取上一次nextInt未读取的换行
 * List可以直接使用Collections.Sort()来排序
 * 用Set保存符号还要重写比较方法太麻烦，不如直接用TreeMap（键可正常比较，且有序）或Map，其中键为符号，值为符号类型
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	public void run() {
		readOptionsString();
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		// !!!!!!!需要读取一个回车
		input.nextLine();
		for(int i=0; i<num; i++) {
			String command = input.nextLine();
			process(command, i);
		}
	}
	
	public final static int NO_PARAM = 0;
	public final static int PARAM = 1;
	/*
	 *  key是符号
	 *  value为0表示无参，为1表示含参
	 */
	Map<Character, Integer> options;
	
	/**
	 *  读取格式字符串
	 *  方法一：使用split(":")来拆分字符串，对每个子字符串将其最后一位放入含参选项列表，其他的放入无参选项列表
	 *         这样会将字符串最后一位选项永远视为带冒号的选项，故最后还需对最后一个字符再判断一次。
	 *  方法二：也可以用类似字符串匹配的方法：设置一个指针来遍历字符串，对每一个字符有三种情况：
	 *          1。为“：”  2。为字母且下一个字母不为“：” 3。为字母且下一个字母为“：”
	 */
	public void readOptionsString() {
		options = new HashMap<Character, Integer>();
		Scanner input = new Scanner(System.in);
		String optionsString = input.next();
		
		for(int pos=0; pos<optionsString.length(); pos++) {
			char c = optionsString.charAt(pos);
			
			// next可能获取不到
			char next = 'a';
			if(pos<optionsString.length()-1) {
			    next = optionsString.charAt(pos+1);
			}
			if(':'== next) {
				options.put(c, PARAM);
				pos++;
			} else {
				options.put(c, NO_PARAM);
			}
		}
		
	}
	
	/**
	 *  对命令进行处理
	 *  注意参数为小写字母、数字和减号组成的非空字符串
	 * @param s  要处理的命令
	 */
	public void process(String s, int order) {
		System.out.print("Case " + order + ": ");
		
		// words[0] 为命令名，不必处理
		String[] words = s.split(" ", 2);
		if(words.length<2) return;
		s = words[1];

		List<String> optionsList = new ArrayList<String>();
//		Map<String, Integer> times = new HashMap();
//		for(Character key: options.keySet()) {
//			times.put(key, 0);
//		}
		
		
		int pos = 0;
	    while(pos<s.length()) {
	    	char now = s.charAt(pos);
	    	StringBuilder option = new StringBuilder();
	    	if(now==' ') {
	    		pos++;
	    		continue;
	    	} else if('-' == now) {
	    		option.append("-");
	    		pos++;
	    		now = s.charAt(pos);
	    		if(options.containsKey(now)) {
	    			// 无参选项
	    			if(options.get(now) == NO_PARAM) {
	    				option.append(now);
	    				pos++;
	    			} else { // 含参选项
	    				option.append(now+" ");
	    				pos++;
	    				now = s.charAt(pos);
	    				// 跳过选项和参数之间的空格
	    				while(now==' ') {
	    					pos++;
	    					now = s.charAt(pos);
	    				}
	    				
	    				// 题目中还说有“-”？？？
	    				int l = s.length();
	    				while((now>='a' && now<='z')
	    						||(now>='0' && now<='9')
	    						||now=='-') {
	    					option.append(now);
	    					pos++;
	    					if(pos>=l) {
	    						break;
	    					}
	    					now = s.charAt(pos);
	    				}
	    				
	    			}
	    			//option.append(" ");
	    			optionsList.add(option.toString());
	    		} else {
	    			break;
	    		}
	    	} else {
	    		break;
	    	}
	    }

    	Collections.sort(optionsList);
    	for(int i=0; i<optionsList.size()-1; i++) {
    		String ooo = optionsList.get(i);
    		String ooo2 = optionsList.get(i+1);
    		ooo = ooo.substring(0, 2);
    		ooo2 = ooo2.substring(0, 2);
    		if(ooo.equals(ooo2)) {
    			optionsList.remove(i);
    		}   		
    	}
    	
    	for(String sss: optionsList) {
    		System.out.print(sss+" ");
    	}
    	System.out.println();
		
		
	}

}
