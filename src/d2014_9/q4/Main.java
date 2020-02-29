package d2014_9.q4;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 
/**
 * ͼ
 * ������һ��ʼ�ͽ�ͼ�������������Ա߱����ߴ������ڵ�Ҫ����������Ϣ��
 * @author PengCheng
 *
 */
public class Main {

	static class Vertex implements Cloneable {
		public int x;
		public int y;
		
		// ��¼�ߵ�����ڵ�Ĳ���
		public int step;
 
		public Vertex(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
 
		public Vertex() {

		}

	}

 

	public static void main(String[] args) {

		long[][] map = new long[1001][1001];
		Queue<Vertex> q = new ArrayDeque<Main.Vertex>() ;//LinkedList<Vertex>();
		boolean[][] vis = new boolean[1001][1001];
		// �ƶ�ʱx��y�������仯��
		int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		Scanner in = new Scanner(System.in);
		long size = in.nextLong();
		long m = in.nextLong();
		long k = in.nextLong();
		long d = in.nextLong();

		// �����Դ��������
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int step = 0;
			q.add(new Vertex(x, y, step));
		}

		for (int i = 0; i < k; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			map[x][y] = z;
		}

		// �������ߵĽڵ���ǰ��ǣ���ȱ���ʱ�Ͳ��ᾭ��������
		for (int i = 0; i < d; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			vis[x][y] = true;
		}

		in.close();
		long cnt = 0;
		long ans = 0;
 

		while (!q.isEmpty()) {
			Vertex u = q.remove();

			for (int i = 0; i < 4; i++) {
				Vertex tem = new Vertex();
				tem.x = u.x;
				tem.y = u.y;
				tem.step = u.step+1;
				tem.x += move[i][0];
				tem.y += move[i][1];
				if (tem.x > 0 && tem.y <= size && tem.y > 0 && tem.x <= size && !vis[tem.x][tem.y]) {
					vis[tem.x][tem.y] = true;
					if (map[tem.x][tem.y] != 0) {
						ans += map[tem.x][tem.y] * tem.step;
						++cnt;
						if (cnt == k)
							break;
					}
					q.add(tem);
				}
			}
		}

		System.out.println(ans);

	}

}
