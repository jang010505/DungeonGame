package DUNGEONGAME;
import java.util.Scanner;

public class StartGame {
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int chk1=0, chk2=0, round=0, job_tmp=0;
		while(true) {
			System.out.println("-------Menu-------");
			System.out.println("1. ���̵� �����ϱ�");
			System.out.println("2. ���� �����ϱ�");
			System.out.println("3. �����ϱ�");
			System.out.print("����: ");
			int tmp = sc.nextInt();
			while(tmp<1 || 3<tmp) {
				System.out.println("�߸��� �����Դϴ�.");
				System.out.print("����: ");
				tmp = sc.nextInt();
			}
			if(tmp==1) {
				if(chk1==1)
					System.out.println("�̹� ���̵��� �����ϼ̽��ϴ�.");
				else {
					System.out.println("[���̵� ����]");
					System.out.println("1. ����  2. ����  3. �����");
					System.out.print("����: ");
					int level = sc.nextInt();
					while(level<1 || 3<level) {
						System.out.println("�߸��� �����Դϴ�.");
						System.out.print("����: ");
						level = sc.nextInt();
					}
					round=level+2;
					chk1=1;
				}
			}
			else if(tmp==2) {
				if(chk2==1)
					System.out.println("�̹� ������ �����ϼ̽��ϴ�.");
				else {
					System.out.println("[���� ����]");
					System.out.println("1. ����  2. ������  3. ����");
					System.out.print("����: ");
					job_tmp = sc.nextInt();
					while(job_tmp<1 || 3<job_tmp) {
						System.out.println("�߸��� �����Դϴ�.");
						System.out.print("����: ");
						job_tmp = sc.nextInt();
					}
					chk2=1;
				}
			}
			else if(tmp==3) {
				if(chk1==1 && chk2==1) {
					System.out.println("������ �����մϴ�!");
					break;
				}
				else
					System.out.println("��� ������ �� ������ �ȵƽ��ϴ�.");
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
					System.out.printf("��� : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("��� : HP(%d)\n", enemy.getHp());
					System.out.println("1. �Ϲݰ���  2. ��ų���");
					System.out.printf("���� : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("���� : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP�� �����մϴ�. ��ų��뿡 �����߽��ϴ�.");
							System.out.println();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("����� �й��Ͽ����ϴ٤�");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("���� óġ�Ͽ����ϴ�.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("����� �¸��ϼ̽��ϴ�!");
		}
		else if(job_tmp==2) {
			Wizard job=new Wizard();
			int gameoverchk=1;
			for(int i=1;i<=round;i++) {
				int turn=1;
				Enemy enemy = new Enemy();
				while(true) {
					System.out.printf("<ROUND %d-%d>\n", i, turn);
					System.out.printf("��� : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("��� : HP(%d)\n", enemy.getHp());
					System.out.println("1. �Ϲݰ���  2. ��ų���");
					System.out.printf("���� : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("���� : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP�� �����մϴ�. ��ų��뿡 �����߽��ϴ�.");
							System.out.println();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("����� �й��Ͽ����ϴ٤�");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("���� óġ�Ͽ����ϴ�.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("����� �¸��ϼ̽��ϴ�!");
		}
		else if(job_tmp==3) {
			Rogue job=new Rogue();
			int gameoverchk=1;
			for(int i=1;i<=round;i++) {
				int turn=1;
				Enemy enemy = new Enemy();
				while(true) {
					System.out.printf("<ROUND %d-%d>\n", i, turn);
					System.out.printf("��� : HP(%d)	MP(%d)\n", job.getHp(), job.getMp());
					System.out.printf("��� : HP(%d)\n", enemy.getHp());
					System.out.println("1. �Ϲݰ���  2. ��ų���");
					System.out.printf("���� : ");
					int tmp=sc.nextInt();
					while(tmp<1 || 2<tmp) {
						System.out.printf("���� : ");
						tmp=sc.nextInt();
					}
					if(tmp==1) {
						int myDamage=job.getDamage()-enemy.getArmor();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", myDamage);
						enemy.setHp(enemy.getHp()-myDamage);
						System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
						job.setHp(job.getHp()-enemyDamage);
					}
					else if(tmp==2) {
						int skillDamage=job.skill();
						int enemyDamage=enemy.getDamage()-job.getArmor();
						if(skillDamage==0) {
							System.out.println("MP�� �����մϴ�. ��ų��뿡 �����߽��ϴ�.");
							System.out.println();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
						else {
							skillDamage=skillDamage-enemy.getArmor();
							System.out.printf("����� ��뿡�� %d�� ���ظ� �������ϴ�.\n", skillDamage);
							enemy.setHp(enemy.getHp()-skillDamage);
							System.out.printf("����� ���κ��� %d�� ���ظ� �Ծ����ϴ�.\n", enemyDamage);
							job.setHp(job.getHp()-enemyDamage);
						}
					}
					if(job.getHp()<=0) {
						System.out.println("����� �й��Ͽ����ϴ٤�");
						i=10;
						gameoverchk=0;
						break;
					}
					else if(enemy.getHp()<=0) {
						System.out.println("���� óġ�Ͽ����ϴ�.");
						break;
					}
					turn++;
				}
			}
			if(gameoverchk==1)
				System.out.println("����� �¸��ϼ̽��ϴ�!");
		}
	}
}












