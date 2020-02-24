package q201312_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int totalNum = input.nextInt();
        int[] items = new int[totalNum];
        
        Map<Integer, Integer> entrys = new HashMap();
        for(int i=0; i<totalNum; i++) {
        	Integer num = input.nextInt();
        	if(entrys.containsKey(num)) {
        		Integer old = entrys.get(num);
        		entrys.put(num, old+1);
        	} else {
        		entrys.put(num, 1);
        	}
        }
        
        int maxNum=0;
        int maxTimes = 0;
        
        for(Integer key: entrys.keySet()) {
        	int times = entrys.get(key);
        	if(times>maxTimes) {
        		maxNum = key;
        		maxTimes = times;
        	} else if(times==maxTimes && key<maxNum) {
        		maxNum = key;
        	}
        }
        
        System.out.print(maxNum);
    }
}
