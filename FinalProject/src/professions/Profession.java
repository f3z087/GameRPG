package professions;

import java.util.Scanner;

public abstract class Profession {
	//Player attributes
	private int strength;
	private int defense;
	private int healthPoints;
	private String playerName;
	
	//Getters and setters for all derived classes
	public int getStrength() {
		return strength;
	}
	public int getDefense() {
		return defense;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	
	//Method stubs defined in derived classes
	public abstract boolean normalAttack(Profession otherPlayer);
	public abstract boolean strongAttack(Profession otherPlayer);
	public abstract String showPlayerAttributes();
	
}
