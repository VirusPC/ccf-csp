package d2014_9.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 便插入便构建大根堆，然后升序排序
 * 时间复杂度减少到nlog_2(n)
 * 也可以两层循环暴力匹配，时间复杂度n^2
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
    
    
    // 小的上浮
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
