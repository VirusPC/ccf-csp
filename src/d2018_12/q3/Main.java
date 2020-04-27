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
 * Comparator，返回时强制转换long->int可能由正变负
 * 标准型可视为特殊的省略前缀型
 * 一个构造方法调用另一个构造方法，第二个构造方法的调用要在第一个构造方法内部的第一行
 * 如只关注移位，则用int表示无符号整数；如还需比较大小以及其他运算，要用long。
 * 		此处由于输出时要计算余数之类的，要用long
 * 注意0要额外处理
 * 尽量用移位与或操作
 * 
 * @author PengCheng
 *
 */
public class Main {

	/**
	 * 信息：
	 * 
	 * ip地址：1.无前导零		2.4段（可省略后面全部为0的段）	3. 每段数字不超过255 
	 * ip前缀：1.有序二元组<ip，len> 2.ip的低(32-len)位必须为0 3.0<=len<=32
	 * 前缀列表：一个或多个IP前缀的 无序 可重复 集合
	 * ip地址与ip前缀匹配：
	 * 匹配集：特殊的0.0.0.0/0的匹配集是全体IP地址
	 * 等价前缀列表：匹配集相等
	 * 
	 * 目标：找到与给出前缀列表等价的，含IP前缀数目最少的前缀列表（len尽量小）
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
		
		// 怎么都是超时，直接用split吧
		Ipp(String s){
//			// 区分ip和len
//			String[] two = s.split("/");
//			// 分割ip并保存到整型数组
//			String[] ips = two[0].split("\\.");
//			int[] ipa = new int[SEGMENT_NUM];
//			for(int i=0; i<ips.length; i++) {
//				ipa[i] = Integer.parseInt(ips[i]);
//			}
//			
//			// 求ip
//			int pos = 0;
//			while(pos<ipa.length) {
//				ip = (ip<<SEGMENT_LEN)|ipa[pos];
//				pos++;
//			}
//			
//			// 求len
//			if(two.length<=1) {
//				// 注意零要额外处理
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
				// 未给出长度，且ip为0时，len取默认值0
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
			// !!不能直接return(int)(ip1-ip2)，可能出现负数
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