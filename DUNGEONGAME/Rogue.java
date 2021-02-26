package DUNGEONGAME;

public class Rogue extends Character{
	public Rogue(){
		this.setHp(120);
		this.setMp(60);
		this.setArmor(7);
		this.setDamage(16);	
	}
	public int skill() {
		if(this.getMp()<10) {
			return 0;
		}
		else {
			this.setMp(this.getMp()-10);
			return 24;
		}
	}
}