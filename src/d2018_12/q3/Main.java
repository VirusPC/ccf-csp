package d2018_12.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;



/**
 * Comparator������ʱǿ��ת��long->int���������为
 * ��׼�Ϳ���Ϊ�����ʡ��ǰ׺��
 * һ�����췽��������һ�����췽�����ڶ������췽���ĵ���Ҫ�ڵ�һ�����췽���ڲ��ĵ�һ��
 * ��ֻ��ע��λ������int��ʾ�޷����������绹��Ƚϴ�С�Լ��������㣬Ҫ��long��
 * 		�˴��������ʱҪ��������֮��ģ�Ҫ��long
 * ע��0Ҫ���⴦��
 * ��������λ������
 * 
 * @author PengCheng
 *
 */
public class Main {

	/**
	 * ��Ϣ��
	 * 
	 * ip��ַ��1.��ǰ����		2.4�Σ���ʡ�Ժ���ȫ��Ϊ0�ĶΣ�	3. ÿ�����ֲ�����255 
	 * ipǰ׺��1.�����Ԫ��<ip��len> 2.ip�ĵ�(32-len)λ����Ϊ0 3.0<=len<=32
	 * ǰ׺�б�һ������IPǰ׺�� ���� ���ظ� ����
	 * ip��ַ��ipǰ׺ƥ�䣺
	 * ƥ�伯�������0.0.0.0/0��ƥ�伯��ȫ��IP��ַ
	 * �ȼ�ǰ׺�б�ƥ�伯���
	 * 
	 * Ŀ�꣺�ҵ������ǰ׺�б�ȼ۵ģ���IPǰ׺��Ŀ���ٵ�ǰ׺�б�len����С��
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	
	

	
	
	
	class Ipp {
		final static int SEGMENT_NUM = 4;
		final static int SEGMENT_LEN = 8;
		//final static int SEGMENT_SIZE = 256;
		private long ip;
		private int len;
		
		Ipp(long ip, int len){
			this.ip = ip;
			this.len = len;
		}
		
		// ��ô���ǳ�ʱ��ֱ����split��
		Ipp(String s){
//			// ����ip��len
//			String[] two = s.split("/");
//			// �ָ�ip�����浽��������
//			String[] ips = two[0].split("\\.");
//			int[] ipa = new int[SEGMENT_NUM];
//			for(int i=0; i<ips.length; i++) {
//				ipa[i] = Integer.parseInt(ips[i]);
//			}
//			
//			// ��ip
//			int pos = 0;
//			while(pos<ipa.length) {
//				ip = (ip<<SEGMENT_LEN)|ipa[pos];
//				pos++;
//			}
//			
//			// ��len
//			if(two.length<=1) {
//				// ע����Ҫ���⴦��
//				if(ips.length==1 && ipa[0]==0){
//					len = 0;
//				} else {
//					len = ips.length*SEGMENT_LEN;
//				}
//			} else {
//				len = Integer.parseInt(two[1]);
//			}
			ip=0;
			len=0;
			int pointNum = 0;
			int pos = 0;
			boolean hasLen = false;
			StringBuilder sb = new StringBuilder();
			while(pos<s.length()) {
				char c = s.charAt(pos);
				if(c=='.') {
					pointNum++;
					ip = ip<<SEGMENT_LEN | Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				} else if(c=='/') {
					hasLen = true;
					ip = ip<<SEGMENT_LEN | Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				} else {
					sb.append(c);
				}
				pos++;
			}
			
			if(hasLen) {
				this.len = Integer.parseInt(sb.toString());
			} else {
				ip = (ip<<SEGMENT_LEN) |Integer.parseInt(sb.toString());
				// δ�������ȣ���ipΪ0ʱ��lenȡĬ��ֵ0
				if(ip!=0) {
					this.len = (pointNum+1)*SEGMENT_LEN;
				}
			}
			ip = ip<<((SEGMENT_NUM-pointNum-1)*SEGMENT_LEN);
		}
		
		public long getIp() {
			return ip;
		}

		public int getLen() {
			return len;
		}

		@Override
		public String toString() {
			String s = "";
			long temp = ip;
			
			for(int i=0; i<SEGMENT_NUM; i++) {
				s = String.valueOf(ip&0xFF) +"."+ s;
				ip = ip>>SEGMENT_LEN;
			}
			
			s = s.substring(0, s.length()-1);
			s += "/" + String.valueOf(len);
			
			return s;
		}
		
	}
	
	class MyComparator implements Comparator<Ipp>{
		@Override
		public int compare(Ipp ipp1, Ipp ipp2) {
			long ip1 = ipp1.getIp();
			long ip2 = ipp2.getIp();
			// !!����ֱ��return(int)(ip1-ip2)�����ܳ��ָ���
			if(ip1>ip2) {
				return 1;
			} else if(ip1<ip2) {
				return -1;
			}
			return ipp1.getLen()-ipp2.getLen();
		}		
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		List<Ipp> ipps = new ArrayList<Ipp>();
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			ipps.add(new Ipp(s));
		}
		br.close();
		//input.close();
		//Collections.sort(ipps, new MyComparator());
		ipps.sort(new MyComparator());
		//ipps = unionFromSmallToBig(ipps);
		//ipps = unionSameRank(ipps);
		for(Ipp ipp: ipps) {
			System.out.println(ipp);
		}
	}
	
	
	public List<Ipp> unionFromSmallToBig(List<Ipp> ipps){
		int pos=0;
		while(pos<ipps.size()-1) {
			Ipp ipp1 = ipps.get(pos);
			Ipp ipp2 = ipps.get(pos+1);
			long ip1 = ipp1.getIp();
			long ip2 = ipp2.getIp();
			int len1 = ipp1.getLen();
			int len2 = ipp2.getLen();
			if(len1<=len2 
					&& ip1>>(32-len1) == ip2>>(32-len1)) {
			} else {
				pos++;
			}
			
		}
		return ipps;
	}
	
	public List<Ipp> unionSameRank(List<Ipp> ipps){
		int pos=0;
		while(pos<ipps.size()-1) {
			Ipp ipp1 = ipps.get(pos);
			Ipp ipp2 = ipps.get(pos+1);
			//long ip1 = ipp1.getIp();
			//long ip2 = ipp2.getIp();
			//int len1 = ipp1.getLen();
			//int len2 = ipp2.getLen();
			int move = 32-ipp1.len+1;
			if(ipp1.len==ipp2.len
					&& (ipp1.ip>>(move)==ipp2.ip>>(move)) ) {
				ipps.remove(pos);
				ipps.remove(pos);
				Ipp newIpp = new Ipp(ipp1.ip>>move<<move, ipp1.len-1);
				ipps.add(pos, newIpp);
			} else {
				pos++;
			}
		}
		return ipps;
	}
}