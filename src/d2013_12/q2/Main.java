package d2013_12.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 20:30-21��20
 * @author PengCheng
 *
 */
public class Main{
	
    public static void main(String[] args){
    	new Main().run();
    }
    
    /**
     * �ַ�������
     */
    public void run() {
    	Scanner input = new Scanner(System.in);
    	String code = input.next();
    	
    	// ȥ����-��
    	String numberString =code.replace("-","");
    	
    	// ����9λ���ּ���ʶ����
    	int sum = 0;
    	for(int i=0; i<numberString.length()-1; i++) {
    		// 0��ascii����48
    		sum += (numberString.charAt(i)-48)*(i+1);
    	}
    	sum %= 11;
    	char identifier = numberString.charAt(numberString.length()-1);
    	
    	// ��֤
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
