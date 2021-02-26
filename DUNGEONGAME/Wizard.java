package DUNGEONGAME;

public class Wizard extends Character{
	public Wizard(){
		this.setHp(120);
		this.setMp(80);
		this.setArmor(7);
		this.setDamage(10);	
	}
	public int skill() {
		if(this.getMp()<10) {
			return 0;
		}
		else {
			this.setMp(this.getMp()-10);
			return 30;
		}
	}
}