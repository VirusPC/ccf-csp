package d2015_12.q1;

import java.util.Scanner;
/**
 * 数字和字符串两种处理方法都是140ms
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
    // 数字方法
    void run() {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int sum = 0;
    	while(n!=0) {
    		sum += n%10;
    		n /= 10;
    	}
    	System.out.print(sum);
    }
    
    // 字符串方法
    void run2() {
    	Scanner input = new Scanner(System.in);
    	String s = input.next();
    	int sum = 0;
    	for(int i=0; i<s.length(); i++) {
    		sum += s.charAt(i)-'0';
    	}
    	System.out.print(sum);
    }
}
