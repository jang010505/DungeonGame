package DUNGEONGAME;
import java.util.Scanner;

public class StartGame {
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int chk1=0, chk2=0, round=0, job_tmp=0;
		while(true) {
			System.out.println("-------Menu-------");
			System.out.println("1. 난이도 설정하기");
			System.out.println("2. 직업 선택하기");
			System.out.println("3. 게임하기");
			System.out.print("선택: ");
			int tmp = sc.nextInt();
			while(tmp<1 || 3<tmp) {
				System.out.println("잘못된 선택입니다.");
				System.out.print("선택: ");
				tmp = sc.nextInt();
			}
			if(tmp==1) {
				if(chk1==1)
					System.out.println("이미 난이도를 선택하셨습니다.");
				else {
					System.out.println("[난이도 선택]");
					System.out.println("1. 쉬움  2. 보통  3. 어려움");
					System.out.print("선택: ");
					int level = sc.nextInt();
					while(level<1 || 3<level) {
						System.out.println("잘못된 선택입니다.");
						System.out.print("선택: ");
						level = sc.nextInt();
					}
					round=level+2;
					chk1=1;
				}
			}
			else if(tmp==2) {
				if(chk2==1)
					System.out.println("이미 직업을 선택하셨습니다.");
				else {
					System.out.println("[직업 선택]");
					System.out.println("1. 전사  2. 마법사  3. 도적");
					System.out.print("선택: ");
					job_tmp = sc.nextInt();
					while(job_tmp<1 || 3<job_tmp) {
						System.out.println("잘못된 선택입니다.");
						System.out.print("선택: ");
						job_tmp = sc.nextInt();
					}
					chk2=1;
				}
			}
			else if(tmp==3) {
				if(chk1==1 && chk2==1) {
					System.out.println("게임을 시작합니다!");
					break;
				}
				else
					System.out.println("모든 설정이 다 설정이 안됐습니다.");
			}
		}
		System.out.println();
		if(job_tmp==1) {
			Warrior job=new Warrior();
			int gameoverchk=1;
			for(int i=1;i<=round;i++) {
				int turn=1;
				Enemy enemy = new Enemy();
				while(true) {
					System.out.printf("<ROUND %d-%d>\n", i, turn);
					System.out.printf("당신 : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("상대 : HP(%d)\n", enemy.getHp());
					System.out.println("1. 일반공겨  2. 스킬사용");
					System.out.printf("선택 : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("선택 : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP가 부족합니다. 스킬사용에 실패했습니다.");
							System.out.println();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("당신은 패배하였습니다ㅜ");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("적을 처치하였습니다.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("당신은 승리하셨습니다!");
		}
		else if(job_tmp==2) {
			Wizard job=new Wizard();
			int gameoverchk=1;
			for(int i=1;i<=round;i++) {
				int turn=1;
				Enemy enemy = new Enemy();
				while(true) {
					System.out.printf("<ROUND %d-%d>\n", i, turn);
					System.out.printf("당신 : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("상대 : HP(%d)\n", enemy.getHp());
					System.out.println("1. 일반공겨  2. 스킬사용");
					System.out.printf("선택 : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("선택 : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP가 부족합니다. 스킬사용에 실패했습니다.");
							System.out.println();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("당신은 패배하였습니다ㅜ");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("적을 처치하였습니다.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("당신은 승리하셨습니다!");
		}
		else if(job_tmp==3) {
			Rogue job=new Rogue();
			int gameoverchk=1;
			for(int i=1;i<=round;i++) {
				int turn=1;
				Enemy enemy = new Enemy();
				while(true) {
					System.out.printf("<ROUND %d-%d>\n", i, turn);
					System.out.printf("당신 : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("상대 : HP(%d)\n", enemy.getHp());
					System.out.println("1. 일반공겨  2. 스킬사용");
					System.out.printf("선택 : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("선택 : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP가 부족합니다. 스킬사용에 실패했습니다.");
							System.out.println();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("당신은 상대에게 %d의 피해를 입혔습니다.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("당신은 상대로부터 %d의 피해를 입었습니다.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("당신은 패배하였습니다ㅜ");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("적을 처치하였습니다.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("당신은 승리하셨습니다!");
		}
	}
}












