package d2014_9.q2;

import java.util.Scanner;

/**
 * ����һ��156ms
 * �ȼ�¼�����о��ε����꣬�Լ�����ȫ����ռƽ��Ļ������η�Χ
 * Ȼ��Ի������η�Χ��ÿ��С�����ж��Ƿ���ĳ�����ε��ڲ���
 *     **������ϵ��һ������������ϲ�һ������**
 *     ������Χ�ڳ����ұߺ����±ߵ�ÿ������㣬
 *     �жϸõ��Ƿ���ĳһ�����ڷ��ұ߽���ϱ߽��ϵĵ㣬
 *     �������+1
 * ʱ�临�Ӷ�o(n^3)
 * 
 * ��������140ms
 * ����һ��boolean���飬��ÿ��Ԫ�ر�־���������Ͻǵĸ����Ƿ�Ϳ����ɫ
 * ����ÿ�����εķ�Χ����boolean�������Ϳɫ
 * 
 * 16:30-17:10
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run2();
		
	}
	
	/**
	 * ����������ÿ�������ж��Ƿ���ĳ��������
	 */
	public void run() {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] rectangle = new int[num][4];
		
		// �����ܹ��������о��εĻ�����Χ�����ض�ÿ�����ӱ�����
		int xMin = 0;
		int xMax = 0;
		int yMin = 0;
		int yMax = 0;
		int area = 0;
		
		for(int i=0; i<num; i++) {
	        int xLeft = input.nextInt();
	        int yBottom = input.nextInt();
	        int xRight = input.nextInt();
	        int yTop = input.nextInt();
	        
	        rectangle[i][0] = xLeft;
	        rectangle[i][1] = xRight;
	        rectangle[i][2] = yBottom;
	        rectangle[i][3] = yTop;
	        
	        xMin = xMin<xLeft?xMin:xLeft;
	        xMax = xMax>xRight?xMax:xRight;
	        yMin = yMin<yBottom?yMin:yBottom;
	        yMax = yMax>yTop?yMax:yTop;
	        
		}
		
		// �����ұ߽���±߽��������η�Χ��ÿ�������
		for(int x = xMin; x<xMax; x++) {
			for(int y = yMin; y<yMax; y++) {
				
				// �ж�������Ƿ���ĳ��С���ε��ڲ����±߽����߽���
				for(int i=0; i<num; i++) {
					if(x>=rectangle[i][0] && x<rectangle[i][1]
							&&y>=rectangle[i][2] && y<rectangle[i][3]) {
						area++;
						break;
					}
				}
				
			}
		}
		
		System.out.print(area);
		
	}
	
	
	
	
	int maxSize = 100;
	
	/**
	 * ����һ��������ÿһ������ĵ�boolean���飬��������õ��Ƿ�Ϳ����ɫ
	 * �˷����ȱ���ÿ�������ٰѾ��η�Χ�����ڱ�Ϊtrue
	 */
	public void run2() {
		Scanner scanner = new Scanner(System.in);
		// ÿһ��Ԫ�ش������ϸõ����Ͻǵ�һ������, ���ݷ�Χ0-99
		boolean[][] colored = new boolean[maxSize][maxSize];
		int area = 0;
		
		int n = scanner.nextInt();
		for(int i=0; i<n; i++) {
			int left = scanner.nextInt();
			int bottom = scanner.nextInt();
			int right = scanner.nextInt();
			int top = scanner.nextInt();
			
			for(int j=left; j<right; j++) {
				for(int k=bottom; k<top; k++) {
					if(!colored[j][k]) {
						colored[j][k] = true;
						area++;
					}
				}
			}
		}
		
		System.out.print(area);
		
	}

}
