package d2018_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author PengCheng
 *
 */
public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	
	class Format {
		String name;
		Pattern pattern;
		public Format(String name, Pattern pattern) {
			this.name = name;
			this.pattern = pattern;
		}
	}
	
	String paramInt = "([0-9]+)";
	String paramStr = "([a-zA-Z0-9-_.]+)";
	String paramPath = "([a-zA-Z0-9-_./]+)";
	List<Format> formats;
	
	public void run() {
		formats = new ArrayList<Format>();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		for(int i=0; i<n; i++) {
			String line = input.next();
			String name = input.next();
			String patternString = line.replace("<int>", paramInt)
					.replace("<str>", paramStr)
					.replace("<path>", paramPath);
			Pattern pattern = Pattern.compile(patternString);
			Format format = new Format(name, pattern);
			formats.add(format);
		}
		
		for(int i=0; i<m; i++) {
			String url = input.next();
			boolean found = false;
			for(Format format: formats) {
				Matcher matcher = format.pattern.matcher(url);
				
				if(matcher.matches()) {
					found = true;
					System.out.print(format.name + " ");
					int c = matcher.groupCount();
					// 遍历捕获组
					for(int j=1; j<=c; j++) {
						String param = matcher.group(j);
						// 去除数字串最前面的连续的0
						if(Pattern.compile(paramInt).matcher(param).matches()) {
							int pos = 0;
							while(pos<param.length()-1) {
								if('0'!=param.charAt(pos)) {
									break;
								}
								pos++;
							}
							param = param.substring(pos);
						}
						System.out.print(param+" ");
					}
					break;
				}
			}
			if(!found) {
				System.out.print("404");
			}
			System.out.println();
		}
	}
}
