package q201709_2;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] keyBox = new int[N];
        for(int i =0; i<N; i++) {
        	keyBox[i] = i+1;
        }
        int K = input.nextInt();
        
        
        
        //important
        int[][] teacherItems = new int[K][];
        
        int lastTime = 0;
        
        for(int i=0; i<K; i++) {
        	int[] item = new int[3];
        	item[0] = input.nextInt();
        	item[1] = input.nextInt();
        	item[2] = input.nextInt()+item[1];
        	lastTime = lastTime>item[2]?lastTime:item[2];
        	teacherItems[i] = item;
        }
        
        //int emptyPos = 0;
        
        
        for(int clock=1; clock<=lastTime; clock++) {
        	
        	//»¹Ô¿³×
        	boolean[] returnKey = new boolean[N+1];
        	for(int[] item: teacherItems) {
        		if(item[2] == clock) {
        			returnKey[item[0]] = true;
        		}
        	}
        	for(int keyNum=0; keyNum<returnKey.length; keyNum++) {
        		int pos =0;
        		if(returnKey[keyNum]) {
        			for(; pos<keyBox.length; pos++) {
        				if(keyBox[pos]==0) {
        					keyBox[pos] = keyNum;
        					break;
        				}
        			}
        		}
        	}
        	
        	//È¡Ô¿³×
        	for(int[] item:teacherItems) {
        		if(item[1]==clock) {
        			for(int i=0; i<keyBox.length; i++) {
        				if(keyBox[i] == item[0]) {
        					keyBox[i] = 0;
        					break;
        				}
        			}
        		}
        	}
        }
        
        
        for(int i: keyBox) {
        	System.out.print(i);
        	System.out.print(" ");
        }
        
        
    }
}
