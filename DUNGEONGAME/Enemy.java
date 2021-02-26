package DUNGEONGAME;

public class Enemy extends Character{
	public Enemy() {
		this.setHp(40);
		this.setMp(0);
		this.setArmor(5);
		this.setDamage(15);
	}
	public int skill() {
		return 0;
	}
}