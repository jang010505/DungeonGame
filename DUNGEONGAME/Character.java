package DUNGEONGAME;

public abstract class Character {
	private int Hp;
	private int Mp;
	private int Armor;
	private int Damage;
	public void setHp(int Hp) {
		this.Hp=Hp;
	}
	public int getHp() {
		return this.Hp;
	}
	public void setMp(int Mp) {
		this.Mp=Mp;
	}
	public int getMp() {
		return this.Mp;
	}
	public void setArmor(int Armor) {
		this.Armor=Armor;
	}
	public int getArmor() {
		return this.Armor;
	}
	public void setDamage(int Damage) {
		this.Damage=Damage;
	}
	public int getDamage() {
		return this.Damage;
	}
	abstract int skill();
}