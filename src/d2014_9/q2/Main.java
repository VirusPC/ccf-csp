package d2014_9.q2;

import java.util.Scanner;

/**
 * �ȼ�¼�����о��ε����꣬�Լ�����ȫ����ռƽ��ľ��η�Χ
 * Ȼ��Ծ��η�Χ��ÿ��С�����ж��Ƿ���ĳ�����ε��ڲ���
 *     **������ϵ��һ������������ϲ�һ������**
 *     ������Χ�ڳ����ұߺ����±ߵ�ÿ������㣬
 *     �жϸõ��Ƿ���ĳһ�����ڷ��ұ߽���ϱ߽��ϵĵ㣬
 *     �������+1
 * ʱ�临�Ӷ�o(n^3)
 * 16:30-17:10
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
		int num = input.nextInt();
		int[][] rectangle = new int[num][4];
		
		// �������о��εķ�Χ
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
	
	

}
