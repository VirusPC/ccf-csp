package d2019_3.q1;

import java.util.Scanner;

/**
 * 
 * ��Ŀ�Ѿ����������ֵ���������ֱ�Ӷ�λ��min��max��mid
 * 
 * �����������뱣��һλС�������Ի��ԣ���ʵ�ϲ����������룬
 * ��Ϊ��������2������ض�Ϊ������*.5
 * 
 * �ѵ㣺midΪfloat�ͣ������ʱ���ٻᱣ��һλС��
 * 		����ĿҪ��mid���Ϊ����ʱ�����������ΪС��ʱ��С�����
 * 		��ͨ��(int)mid==mid?���ж��Ƿ�ΪС��
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String ns = input.nextLine(); 
		String[] nss = ns.split(" ");
		
		int[] midPos;
		if(n%2==0) {
			midPos = new int[]{n/2-1,n/2};
		} else {
			midPos = new int[] {n/2};
		}
		
		float mid = 0;
		for(int i=0; i<midPos.length; i++) {
			mid += Float.parseFloat(nss[midPos[i]]);
		}
		mid = mid/midPos.length;
		
		int max = Integer.parseInt(nss[0]);
		int min = Integer.parseInt(nss[nss.length-1]);
		if(max<min) {
			int temp = max;
			max = min;
			min = temp;
		}
		
		if((int)mid == mid) {
			System.out.print(max+" "+(int)mid+" "+min);
		} else {
			System.out.print(max+" "+mid+" "+min);
		}
		
	}

}
