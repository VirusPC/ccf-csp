package d2014_9.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �����㹹������ѣ�Ȼ����������
 * ʱ�临�Ӷȼ��ٵ�nlog_2(n)
 * Ҳ��������ѭ������ƥ�䣬ʱ�临�Ӷ�n^2
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
    public void run() {
    	Scanner input = new Scanner(System.in);
    	int num = input.nextInt();
    	int[] heap = new int[num+1];
    	for(int i=1; i<=num; i++) {
    		heap[i] = input.nextInt();
    		ajustUp(heap, i);
    	}
    	//printHeap(heap);
    	heapSort(heap);
    	//System.out.println(Arrays.toString(heap));
    	find(heap);     
    }
    
    public void find(int[] heap) {
    	int count = 0;
    	for(int i=1; i<heap.length-1; i++) {
    		if(heap[i]-heap[i+1] == -1) {
    			count++;
    		}
    	}
    	System.out.print(count);
    }
    
    
    // С���ϸ�
    public void ajustUp(int[] array, int pos) {
    	if(pos==1) {
    		return;
    	}
    	int parentPos = pos/2;
    	if(array[parentPos]<array[pos]) {
    		int temp = array[parentPos];
    		array[parentPos] = array[pos];
    		array[pos] = temp;
    		ajustUp(array, parentPos);
    	} else {
    		return;
    	}
    }
    
    public void ajustDown(int[] heap, int pos, int len) {
    	if(pos == len) {
    		return;
    	}
    	int leftPos = pos*2;
    	int rightPos = leftPos+1;
    	int maxPos = pos;
    	if(rightPos<=len) {
    		maxPos = heap[leftPos]>heap[rightPos]?leftPos:rightPos;
    	} else if(leftPos<=len) {
    		maxPos = leftPos;
    	}
    	if(heap[maxPos]>heap[pos]) {
    		heap[0] = heap[maxPos];
    		heap[maxPos] = heap[pos];
    		heap[pos] = heap[0];
    		ajustDown(heap, maxPos, len);
    	}
    }
    
    
    public void heapSort(int[] heap) {
    	int len = heap.length-1;
    	
    	while(len>1) {
    		ajustDown(heap, 1, len);
        	heap[0] = heap[1];
        	heap[1] = heap[len];
        	heap[len] = heap[0];
    		len--;
    		//printHeap(heap);
    	}
    }
    

    
    public void printHeap(int[] heap) {
    	int firstInNextLine = 1;
    	for(int i=1; i<heap.length; i++) {
    		if(firstInNextLine == i) {
    			System.out.println();
    			firstInNextLine *= 2;
    		}
    		System.out.print(heap[i]+" ");
    	}
    }
}
