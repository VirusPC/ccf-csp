package d2014_12.q1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * MAP的简单应用
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int num = input.nextInt();
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0; i<num; i++) {
    		int code = input.nextInt();
    		if(map.get(code) == null) {
    			map.put(code, 1);
    			System.out.print(1 + " ");
    		} else {
    	        int times = map.get(code)+1;
    			map.put(code, times);
    			System.out.print(times + " ");
    		}
    	}
    	
    }
}
