package professions;

import java.util.Scanner;

public class Warrior extends Profession {
	
	//Constants for a warrior's attributes
	private static final int WARRIOR_STRENGTH_VALUE = 40;
	private static final int WARRIOR_DEFENSE_VALUE = 20;
	private static final int WARRIOR_HEALTH_POINTS_MAXIMUM = 250;
	private static final double WARRIOR_NORMAL_ACCURACY = .8;
	private static final double WARRIOR_STRONG_ACCURACY = .5;
	
	public Warrior(){
		//Sets a warrior's attributes
		setStrength(WARRIOR_STRENGTH_VALUE);
		setDefense(WARRIOR_DEFENSE_VALUE);
		setHealthPoints(WARRIOR_HEALTH_POINTS_MAXIMUM);
		
		//Sets player name to be user defined
		Scanner consoleScan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = consoleScan.nextLine();
		setPlayerName(name);
		//closing Scanner causes exception to be thrown? consoleScan.close()
	}
	
	//A weaker, but more accurate attack
	public boolean normalAttack(Profession otherPlayer){
		if(normalAttackStatus() == true){
			int damageDealt = this.getStrength() - otherPlayer.getDefense(); 
			otherPlayer.setHealthPoints(otherPlayer.getHealthPoints() - damageDealt);
			return true;
		}
		else {
			return false;
		}
	}
	
	//A stronger, but less accurate attack
	public boolean strongAttack(Profession otherPlayer){
		if(strongAttackStatus() == true){
			int damageDealt = 2 * this.getStrength() - otherPlayer.getDefense(); 
			otherPlayer.setHealthPoints(otherPlayer.getHealthPoints() - damageDealt);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean strongAttackStatus() {
		if(Math.random() <= WARRIOR_STRONG_ACCURACY)
			return true;
		else {
			return false;
		}
	}
	
	public boolean normalAttackStatus() {
		if(Math.random() <= WARRIOR_NORMAL_ACCURACY)
			return true;
		else {
			return false;
		}
	}
	
	//Displays all the player attributes
	public String showPlayerAttributes(){
		return this.getPlayerName() + "'s attributes are: \n" +
			"Profession: " + this.getClass() +
			"\nStrength: " + this.getStrength() +
			"\nDefense: " + this.getDefense() +
			"\nCurrent Health Points: " + this.getHealthPoints() + 
			"\nStarting Health Ponts: " + WARRIOR_HEALTH_POINTS_MAXIMUM + "\n";
	}
}

