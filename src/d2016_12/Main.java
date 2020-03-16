package d2016_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * һ���û�-�������ɫ -�����Ȩ��
 * �û�������ɫ����Сд��ĸ�ַ���������С�ڵ���32
 * Ȩ�ޣ�|-�ֵȼ�Ȩ��-|-Ȩ��������Сд��ĸС�ڵ���32�ַ�����
 *      |            |-Ȩ�޵ȼ���0-9������Խ��ȼ�Խ�ߣ�
 *      |               �ߵȼ�Ȩ�ް����͵ȼ�Ȩ�ޣ�
 *      |
 *      |-���ֵȼ�Ȩ��-Ȩ������
 * 
 * 
 * Ŀ�꣺�ش��������û���Ȩ�޵Ĳ�ѯ
 * 
 * ��ѯ���ࣺ1.���ֵȼ�Ȩ�޲�ѯ�������Ƿ���и�Ȩ��
 *          2.�ֵȼ�Ȩ�޵Ĵ��ȼ���ѯ�������Ƿ���иõȼ�Ȩ��
 *          3.�ֵȼ�Ȩ�޵Ĳ����ȼ���ѯ������ ���û����Ȩ�޵ȼ� �� ��
 * 
 * 
 * ��˼·����mapģ�����ݿ��ϵ��
 * 
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
    /*
     * <Ȩ���������Ȩ�޵ȼ�>
     *  -1��ʾ�޵ȼ�Ȩ��
     */
    Map<String, Integer> authorities = new HashMap<String, Integer>();
    
    // <��ɫ����<Ȩ���������û�Ȩ�޵ȼ�>>
    Map<String, Map<String, Integer>> roles = new HashMap<String, Map<String, Integer>>();
    
    // <�û�����<��ɫ��>>
    Map<String, String[]> users = new HashMap<String, String[]>();

    
    public void run() {
    	Scanner input = new Scanner(System.in);
    	
    	// ���Ȩ��
    	int p = input.nextInt();
    	for(int i=0; i<p; i++) {
    		String a = input.next();
    		String[] b = a.split(":");
    		if(b.length==1) {
    			authorities.put(b[0], -1);
    		} else if(b.length>1){
    			authorities.put(b[0], Integer.parseInt(b[1]));
    		} else {
    			System.out.println("p error");
    		}
    	}
    		
    	int r = input.nextInt();
    	for(int i=0; i<r; i++) {
    		String roleName = input.next();
    		Integer rightsNum = input.nextInt();
    		Map<String, Integer> rights = new HashMap<String, Integer>();
    		for(int j=0; j<rightsNum; j++) {
    			String right = input.next();
    			String[] aright = right.split(":");
    			if(aright.length==1) {
    				rights.put(aright[0], -1);
    			} else if(aright.length>1){
    				rights.put(aright[0], Integer.parseInt(aright[1]));
    			} else {
    				System.out.println("r error");
    			}
    		}
    		roles.put(roleName, rights);
    	}
    	
    	int t = input.nextInt();
    	for(int i=0; i<t; i++) {
    		String userName = input.next();
    		int rolesNum = input.nextInt();
    		String[] roles = new String[rolesNum];
    		for(int j=0; j<rolesNum; j++) {
    			roles[j] = input.next();
    		}
    		users.put(userName, roles);
    		//System.out.println(userName);
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
        //System.out.println(input.nextLine())
        //System.out.print("\""+s+"\"");
        int queryNum = input.nextInt();
        
        while(--queryNum>=0) {
        	String userName = input.next();
        	String[] rolesName = users.get(userName);
        	if(rolesName==null) {
        		System.out.println("false");
        		continue;
        	}
        	
        	String queryRight = input.next();
        	String[] queryRights = queryRight.split(":");
        	String rightName = queryRights[0];
        	
        	int rank = -1;
        	if(queryRights.length>1) {
        		rank = Integer.parseInt(queryRights[1]);
        		if(rank<0 || rank>9) {
            		System.out.println("false");
            		continue;
            	}
        	}    	
        	
        	
        	// 0-9 Ϊ��Ȩ��ָ�-1Ϊ��Ȩ��ָ�-2Ϊ������
        	int maxRank = -2;
        	for(String roleName: rolesName) {
        	    Map<String, Integer> rights = roles.get(roleName);
        	    Integer rankNow = rights.get(rightName);
        	    if(rankNow!=null) {
        	    	maxRank = maxRank>rankNow?maxRank:rankNow;
        	    }
        	}
        	
        	if(maxRank==-2) {  // �����ڸ�Ȩ��
        		System.out.println("false");
        	} else if(maxRank==-1) {  // �޵ȼ�Ȩ��
        		if(rank==-1) {
        			System.out.println("true");
        		} else {
        			System.out.println("false");
        		}
        	} else {  //�еȼ�Ȩ��
        		if(rank==-1) {  //�����ȼ���ѯ
        			System.out.println(maxRank);
        		} else if(rank<=maxRank) {
        			System.out.println("true");
        		} else {
        			System.out.println("false");
        		}
        	}
        	
        }
    }
    
    public void read() {
    	
    	

    	//System.out.println("read over");
    	
    	// ����close��
    	//input.close();
    }
}
