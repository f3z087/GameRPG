package professions;

import java.util.Scanner;

public class Guardian extends Profession {
	
	@Override
	public String toString() {
		return "Guardian [getStrength()=" + getStrength() + ", getDefense()=" + getDefense() + ", getHealthPoints()="
				+ getHealthPoints() + ", getPlayerName()=" + getPlayerName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	//Constants for a guardian's attributes
	private static final int GUARDIAN_STRENGTH_VALUE = 30;
	private static final int GUARDIAN_DEFENSE_VALUE = 35;
	private static final int GUARDIAN_HEALTH_POINTS_MAXIMUM = 275;
	private static final double GUARDIAN_NORMAL_ACCURACY = .9;
	private static final double GUARDIAN_STRONG_ACCURACY = .6;
	
	public Guardian(){
		//Sets a warrior's attributes
		setStrength(GUARDIAN_STRENGTH_VALUE);
		setDefense(GUARDIAN_DEFENSE_VALUE);
		setHealthPoints(GUARDIAN_HEALTH_POINTS_MAXIMUM);
				
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
		if(Math.random() <= GUARDIAN_STRONG_ACCURACY)
			return true;
		else {
			return false;
		}
	}
	
	public boolean normalAttackStatus() {
		if(Math.random() <= GUARDIAN_NORMAL_ACCURACY)
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
				"\nStarting Health Ponts: " + GUARDIAN_HEALTH_POINTS_MAXIMUM + "\n";
		
	}
}
