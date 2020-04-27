package d2019_3.q3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 70�� ���г�ʱ
 * 
 * �ѵ����ڹ�����block���������ʽ
 * 
 * java����� ��(&)����(~)����(|)�����(^)
 * javaû���޷������Σ�������int����32λ�޷�������Ҫ��long
 * Long.toHexString()��ʡ��ǰ���0
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "FF";
		//System.out.println(Integer.parseInt(s, 16));
		new Main().run();
	}
	
	public class Raid{		
		final static String CAN_NOT_READ = "-";
		final static int BLOCK_SIZE = 4; // ��λ��1B
		final static int BYTESIZE = 8;
		
		//int diskNum;
		int bandNum;  //һ�����̵�������
		int bandSize;  // ������С����λ��1��
		long[][] disks;
		//boolean[] valid; 

		
		Raid(int diskNum, int bandSize){
			//this.diskNum = diskNum;
			this.bandSize = bandSize;
			disks = new long[diskNum][];
			//valid = new boolean[diskNum];
		}
		
		public void addDisk(int diskPos, String content) {
			int blockNum = content.length()/8;
			bandNum = blockNum/bandSize;
			long[] disk = new long[blockNum];
			for(int pos=0; pos<blockNum; pos++) {
				String s = content.substring(pos*8, (pos+1)*8);
				disk[pos] = Long.parseLong(s, 16);
			}
			disks[diskPos] = disk;
			//valid[diskPos] = true;
		}
		
		public void repair() {
			int repairDiskPos = -1;
			for(int i=0; i<disks.length; i++) {
				if(disks[i]==null) {
					// ���ж����Ҫ�޸��Ĵ��̣������޸�
					if(repairDiskPos != -1) {
						return;
					}
					repairDiskPos=i;
				}
			}
			
			// ����Ҫ�޸��Ĵ���
			if(repairDiskPos==-1) {
				return;
			}
			
			/*
			 *  �޸�����
			 *  a^b^c=d <=> a^vb^c^d=0 <=> b^c^d = a
			 *  a^a^a=a
			 */
			int blockNum = bandNum*bandSize;
			disks[repairDiskPos] = new long[blockNum];
			for(int i=0; i<blockNum; i++) {
				long[] blockInOtherDisk = new long[disks.length-1];
				int pos = 0;
				for(int j=0; j<disks.length; j++) {
					if(j==repairDiskPos) {
						continue;
					}
					blockInOtherDisk[pos] = disks[j][i];
					pos++;
				}
				for(int j=1; j<blockInOtherDisk.length; j++) {
					blockInOtherDisk[0] ^= blockInOtherDisk[j];
				}
				disks[repairDiskPos][i] = blockInOtherDisk[0];
			}
		}
		
		
		/*****************************************
		 * ���ģ�		                         *
		 * @param blockPos                       *
		 * @return                               *
		 *****************************************/
		public String getBlock(int blockPos) {
			// �����洢�ռ�
			if(blockPos>=bandNum*bandSize*(disks.length-1)) {
				return CAN_NOT_READ;
			}
			// ��������Ϊ������λ���������������ż�������ƫ�Ʊ�ʾ
			int bandPos = blockPos/bandSize;
			int bandPosInOneDisk = bandPos/(disks.length-1);
			int diskPosBias = bandPos%(disks.length-1);
			int blockPosInBand = blockPos%bandSize;
			int validationPos = disks.length-1-(bandPosInOneDisk%disks.length);
			int diskPos = (validationPos+1+diskPosBias)%disks.length;
			// ���̲�����
			if(disks[diskPos]==null) {
				return CAN_NOT_READ;
			}
			long block = disks[diskPos][bandPosInOneDisk*bandSize+blockPosInBand];
			String bs = Long.toHexString(block);
			// ��Ҫ����0ʹ���ַ���Ϊ8λ
			while(bs.length()<8){
				bs = "0"+bs;
			}
			// ת��д
			return bs.toUpperCase();
		}

	}
	
	Raid raid;
	public void run() {
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(isr);
//		String nsl = br.readLine();
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		int s = Integer.parseInt(input.next());
		int l = Integer.parseInt(input.next());
		raid = new Raid(n, s);
		
		for(int i=0; i<l; i++) {
			int diskPos = Integer.parseInt(input.next());
			String content = input.next();
			raid.addDisk(diskPos, content);
		}
		raid.repair();
		
		int m = input.nextInt();
		for(int i=0; i<m; i++) {
			System.out.println(raid.getBlock(Integer.parseInt(input.next())));
		}
		input.close();
	}//

}
