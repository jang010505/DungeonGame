package DUNGEONGAME;

public class Warrior extends Character{
	public Warrior(){
		this.setHp(150);
		this.setMp(60);
		this.setArmor(10);
		this.setDamage(13);	
	}
	public int skill() {
		if(this.getMp()<10) {
			return 0;
		}
		else {
			this.setMp(this.getMp()-10);
			return 15;
		}
	}
}