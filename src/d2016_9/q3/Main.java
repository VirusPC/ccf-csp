package d2016_9.q3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	class Role {
		int atk;
		int hp;
		public Role(int atk, int hp) {
			this.atk = atk;
			this.hp = hp;
		}
		
	}
	
	class BattleGround{
		int maxRole = 7;
		int playerHP = 30;
		
		Role[][] battleGround = new Role[2][maxRole+1];
		
		public BattleGround() {
			Role player0 = new Role(0, playerHP);
			Role player1 = new Role(0, playerHP);
			battleGround[0][0] = player0;
			battleGround[1][0] = player1;
		}
		
		/**
		 * 召唤
		 * @param player 玩家编号
		 * @param position 位置
		 * @param attack 攻击力
		 * @param health 生命值
		 * @return 召唤是否成功
		 */
		public boolean summon(int player, int position, int atk, int hp) {
			// 场上角色满了时禁止插入
			if(battleGround[player][maxRole]!=null) {
				return false;
			}
			Role role = new Role(atk, hp);
			
			for(int i=maxRole; i>position; i--) {
				battleGround[player][i] = battleGround[player][i-1];
			}
			battleGround[player][position] = role;			
			return true;
		}
		
		/**
		 * 攻击
		 * @param position0 玩家0的对应角色位置
		 * @param position1 玩家1的对应角色位置
		 * @return -1:继续   0:玩家0赢   1:玩家1赢 由于设定玩家本身无攻击力，故不可能平局
		 */
		public int attack(int position0, int position1) {
			Role role0 = battleGround[0][position0];
			Role role1 = battleGround[1][position1];

			role0.hp -= role1.atk;
			role1.hp -= role0.atk;
			
			if(role0.hp<=0) {
				if(position0 == 0) {
					return 1;
				}
				deleteRole(0, position0);
			} 
			
			if(role1.hp<=0) {
				if(position1 == 0) {
					return 0;
				}
				deleteRole(1, position0);
			}
			
			return -1;
		}
		
		public void deleteRole(int player, int position) {
			for(int i=position; i<maxRole; i++) {
				battleGround[player][i] = battleGround[player][i+1];
			}
			battleGround[player][maxRole] = null;
		}
		
		public int getNumOfRoles(int player) {
			for(int i=1; i<=maxRole; i++) {
				if(battleGround[player][i] == null) {
					return i-1;
				}
			}
			return 7;
		}
		
		public void printInfo() {
			int first = 0;
			for(int j=0; j<2; j++) {
				System.out.println(battleGround[first][0].hp);
				int num = getNumOfRoles(first);
				System.out.print(num);
				for(int i=1; i<=num; i++) {
					System.out.print(" "+battleGround[first][i].hp) ;
				}
				System.out.println();
				first = 1-first;
			}
		}
		
		public void printBattleGround() {
			int first = 0;
			for(int j=0; j<2; j++) {
				System.out.println(battleGround[first][0].hp);
				int num = getNumOfRoles(first);
				for(int i=1; i<=num; i++) {
					System.out.println(battleGround[first][i].atk+" "+battleGround[first][i].hp) ;
				}
				first = 1-first;
				System.out.print("===========");
			}
			System.out.println();
		}
		
	}
	

	String end ="end";
	String summon = "summon";
	String attack = "attack";
	
	public void run() {
		BattleGround bg = new BattleGround();
		int player = 0;
		int result = -1;
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		for(int i=0; i<n; i++) {
			String command = input.nextLine();
			String[] words = command.split(" ");
			if(end.equals(words[0])) {  // 结束回合，切换玩家
				player = 1-player;
			} else if(summon.equals(words[0])) {  // 召唤
				bg.summon(player, Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]));
			} else { // 攻击
				if(player==0) {
					result = bg.attack(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
				} else {
					result = bg.attack(Integer.parseInt(words[2]), Integer.parseUnsignedInt(words[1]));
				}
				if(result!=-1) {
					break;
				}
			}
		}
		System.out.println(resultF(result));
		bg.printInfo();
	}
	
	// 结果转化为题目输出要求的格式
	public int resultF(int result) {
		if(result==0) {
			return 1;
		}
		if(result==1) {
			return -1;
		}
		return 0;
	}

	

}
