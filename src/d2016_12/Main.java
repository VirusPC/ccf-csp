package d2016_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个用户-》多个角色 -》多个权限
 * 用户名及角色名：小写字母字符串，长度小于等于32
 * 权限：|-分等级权限-|-权限类名（小写字母小于等于32字符串）
 *      |            |-权限等级（0-9，数字越大等级越高，
 *      |               高等级权限包括低等级权限）
 *      |
 *      |-不分等级权限-权限类名
 * 
 * 
 * 目标：回答多个关于用户和权限的查询
 * 
 * 查询分类：1.不分等级权限查询：返回是否具有该权限
 *          2.分等级权限的带等级查询：返回是否具有该等级权限
 *          3.分等级权限的不带等级查询：返回 该用户最高权限等级 或 否
 * 
 * 
 * 总思路：用map模拟数据库关系表
 * 
 * @author PengCheng
 *
 */
public class Main {
    public static void main(String[] args) {
    	new Main().run();
    }
    
    /*
     * <权限名，最高权限等级>
     *  -1表示无等级权限
     */
    Map<String, Integer> authorities = new HashMap<String, Integer>();
    
    // <角色名，<权限名，该用户权限等级>>
    Map<String, Map<String, Integer>> roles = new HashMap<String, Map<String, Integer>>();
    
    // <用户名，<角色名>>
    Map<String, String[]> users = new HashMap<String, String[]>();

    
    public void run() {
    	Scanner input = new Scanner(System.in);
    	
    	// 添加权限
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
        	
        	
        	// 0-9 为有权限指令，-1为无权限指令，-2为不存在
        	int maxRank = -2;
        	for(String roleName: rolesName) {
        	    Map<String, Integer> rights = roles.get(roleName);
        	    Integer rankNow = rights.get(rightName);
        	    if(rankNow!=null) {
        	    	maxRank = maxRank>rankNow?maxRank:rankNow;
        	    }
        	}
        	
        	if(maxRank==-2) {  // 不存在该权限
        		System.out.println("false");
        	} else if(maxRank==-1) {  // 无等级权限
        		if(rank==-1) {
        			System.out.println("true");
        		} else {
        			System.out.println("false");
        		}
        	} else {  //有等级权限
        		if(rank==-1) {  //不带等级查询
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
    	
    	// 不能close掉
    	//input.close();
    }
}
