package d2015_9.q3;

import java.util.Scanner;

/**
 * 80分，正则表达式有问题
 * 
 * 记得读取后先trim()
 * replaceAll可以使用正则表达式：s = s.replaceAll(regex, oldStr);
 * 
 * 小括号、中括号、大括号需要转义,如空格"{"应写为"\\{"，因为单纯的括号在正则表达式中有特殊作用
 * 不要留空格，空格用\s表示（"\\s"）
 * 
 * 
 * 用双斜杠
 * [abc] a, b, or c (simple class) 
 * [^abc] Any character except a, b, or c (negation) 
 * [a-zA-Z] a through zor A through Z, inclusive (range) 
 * [a-d[m-p]] a through d,or m through p: [a-dm-p] (union) 
 * [a-z&&[def]] d, e, or f (intersection) 
 * [a-z&&[^bc]] a through z,except for b and c: [ad-z] (subtraction) 
 * [a-z&&[^m-p]] a through z,and not m through p: [a-lq-z](subtraction) 
 * 
 * . Any character (may or may not match line terminators) 
 * \d A digit: [0-9] 
 * \D A non-digit: [^0-9] 
 * \s A whitespace character: [ \t\n\x0B\f\r] 
 * \S A non-whitespace character: [^\s] 
 * \w A word character: [a-zA-Z_0-9] 
 * \W A non-word character: [^\w] 
 * 
 * ^ The beginning of a line 
 * $ The end of a line 

 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "{{ _123456789012345 }}";
//		s = s.replaceAll("\\{\\{\\s*([a-zA-Z|_][a-zA-Z|0-9|_]{0,15})\\s*\\}\\}"," replacement ");
//		System.out.println(s);
//		System.out.print("|");
		new Main().run();
	}
	
	String[] doc;
	String[] var;
	String[] data;
	String begin = "\\{\\{ ";
	String end = " \\}\\}";
	String nameRegex = "([a-zA-Z|_][a-zA-Z|0-9|_]{0,15})";
	
	public void run() {
		read();
		
		String regex = begin + nameRegex;
		for(int i=0; i<var.length; i++) {
			regex += "^(";
			regex += var[i];
			regex += ")";
		}
		regex += end;
		
		for(int i=0; i<doc.length; i++) {
		    doc[i] = doc[i].replaceAll(regex, "");
			for(int j=0; j<var.length; j++) {
				doc[i] = doc[i].replaceAll(begin+var[j]+end, data[j]);
			}
		}
		
		print();
	}
	
	
	public void read() {
		Scanner input = new Scanner(System.in);
		int linesNum = input.nextInt();
		int varsNum = input.nextInt();
		
		doc = new String[linesNum];
		var = new String[varsNum];
		data = new String[varsNum];
		
		input.nextLine();
		
		for(int i=0; i<linesNum; i++) {
			doc[i] = input.nextLine();
		}
		
		for(int i=0; i<varsNum; i++) {
			var[i] = input.next().trim();	
			data[i] = input.nextLine().trim();
			data[i] = data[i].substring(1, data[i].length()-1);
		}
		input.close();

	}
	
	public void print() {
		for(int i=0; i<doc.length; i++) {
			System.out.println(doc[i]);
		}
	}

	
}
