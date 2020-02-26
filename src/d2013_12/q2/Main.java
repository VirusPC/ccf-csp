package d2013_12.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 20:30-21：20
 * @author PengCheng
 *
 */
public class Main{
	
    public static void main(String[] args){
    	new Main().run();
    }
    
    /**
     * 字符串处理
     */
    public void run() {
    	Scanner input = new Scanner(System.in);
    	String code = input.next();
    	
    	// 去除“-”
    	String numberString =code.replace("-","");
    	
    	// 利用9位数字计算识别码
    	int sum = 0;
    	for(int i=0; i<numberString.length()-1; i++) {
    		// 0的ascii码是48
    		sum += (numberString.charAt(i)-48)*(i+1);
    	}
    	sum %= 11;
    	char identifier = numberString.charAt(numberString.length()-1);
    	
    	// 验证
    	if((sum == 10 && identifier == 'X')
    		|| sum+48 == identifier) {
    		System.out.print("Right");
    	} else {
    		System.out.print(
    				code.substring(0, code.length()-1)
    				+ (sum==10?"X":String.valueOf(sum))
    				);
    	}
    	
    }
}
