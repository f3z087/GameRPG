//add rules button
//add buttons that show stats


package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

import professions.Guardian;
import professions.Profession;
import professions.Warrior;

public class GameGUI extends JFrame {
	
	//Player objects
	private Profession player1 = new Warrior();
	private Profession player2 = new Guardian();
	private JPanel contentPane;
	private JTextArea outputArea = new JTextArea(20, 20);	
	private JPanel panel = new JPanel();
	private JScrollPane outputAreaScroller = new JScrollPane();
	private JButton p1NormalAttackButton = new JButton("Player 1 Normal Attack");
	private JButton p2NormalAttackButton = new JButton("Player 2 Normal Attack");
	private JButton p1StrongAttackButton = new JButton("Player 1 Strong Attack");
	private JButton p2StrongAttackButton = new JButton("Player 2 Strong Attack");
	private JButton p1ShowAttributesButton = new JButton("Player 1 Attributes");
	private JButton p2ShowAttributesButton = new JButton("Player 2 Attributes");
	private JButton displayRulesButton = new JButton("Game Rules");
	
	public class P1NormalAttackButton1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(player2.getHealthPoints() <= 0) {
				outputArea.append("Stop, he's already dead!\n");
			}
			else {
				outputArea.append(player1.getPlayerName() + " is attacking " + player2.getPlayerName() + "\n");
				player1.normalAttack(player2);
				if(player1.normalAttack(player2) == true) { 
					outputArea.append("Your strong attack landed!\n");			
					outputArea.append(player2.getPlayerName() + "'s Health Points: "+ player2.getHealthPoints());
				}
				else {
					outputArea.append("Your strong attack missed!\n");
					outputArea.append(player2.getPlayerName() + "'s Health Points: "+ player2.getHealthPoints());
				}
		
				if(player2.getHealthPoints() <= 0) {
					outputArea.append("Player 1 is dead!\n");
				}
				outputArea.append("\n");
			}
		}
	}
	
	public class P2NormalAttackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(player1.getHealthPoints() <= 0) {
				outputArea.append("Stop, he's already dead!\n");
			}
			else {
				outputArea.append(player2.getPlayerName() + " is attacking " + player1.getPlayerName() + "\n");
				player2.normalAttack(player1);
				if(player2.normalAttack(player1) == true) {
					outputArea.append("Your strong attack landed!\n");			
					outputArea.append(player1.getPlayerName() + "'s Health Points: "+ player1.getHealthPoints());
				}
				else {
					outputArea.append("Your strong attack missed!\n");
					outputArea.append(player1.getPlayerName() + "'s Health Points: "+ player1.getHealthPoints());
				}
				if(player1.getHealthPoints() <= 0) {
					outputArea.append("Player 1 is dead!\n");
				}
				outputArea.append("\n");
			}
		}
	}
	
	public class P1StrongAttackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(player2.getHealthPoints() <= 0) {
				outputArea.append("Stop, he's already dead!\n");
			}
			else {
				outputArea.append(player1.getPlayerName() + " is attacking " + player2.getPlayerName() + "\n");
				player1.strongAttack(player2);
				if(player1.strongAttack(player2) == true) { 
					outputArea.append("Your strong attack landed!\n");			
					outputArea.append(player2.getPlayerName() + "'s Health Points: "+ player2.getHealthPoints());
				}
				else {
					outputArea.append("Your strong attack missed!\n");
					outputArea.append(player2.getPlayerName() + "'s Health Points: "+ player2.getHealthPoints());
				}
				if(player2.getHealthPoints() <= 0) {
					outputArea.append("Player 2 is dead!\n");
				}
				outputArea.append("\n");
			}
		}
	}
	
	public class P2StrongAttackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(player1.getHealthPoints() <= 0) {
				outputArea.append("Stop, he's already dead!\n");
			}
			else {
				outputArea.append(player2.getPlayerName() + " is attacking " + player1.getPlayerName() + "\n");
				player2.strongAttack(player1);
				if(player2.strongAttack(player1) == true) {
					outputArea.append("Your strong attack landed!\n");			
					outputArea.append(player1.getPlayerName() + "'s Health Points: "+ player1.getHealthPoints());
				}
				else {
					outputArea.append("\nYour strong attack missed!\n");
					outputArea.append(player1.getPlayerName() + "'s Health Points: "+ player1.getHealthPoints());
				}
				if(player1.getHealthPoints() <= 0) {
					outputArea.append("Player 1 is dead!\n");
				}
				outputArea.append("\n");
			}
		}
	}
	
	public class P1ShowAttributesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			outputArea.append(player1.showPlayerAttributes());
			outputArea.append("");
		}
	}
	
	public class P2ShowAttributesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			outputArea.append(player2.showPlayerAttributes());
			outputArea.append("");
		}
	}
	
	public class DisplayRulesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			outputArea.append("Two people will fight to the death: The Warrior and the Guardian.\n"
					+ "The Warrior has lesser health and accuracy, but can deal more damage. The Guadian\n"
					+ "has more health accuracy, but has weaker damage. You will be able to use two attacks:\n"
					+ "normal, and strong. Normal attacks do less damage, but with a more likely chance to hit\n."
					+ "Stong attacks deal more damage, but are less accurate. You can check each of these two's attributes.\n");
		}
	}
	
	//Constructs game GUI
	public GameGUI(){
		//Name and behavior of the GUI
		super("My Game");
		setSize(640 , 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new FlowLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		outputArea.setEditable(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);		

		actionListeners();
		addPanels();
		addComponents();
		outputArea.setBorder(new TitledBorder(null, "Moves Made", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(outputArea, BorderLayout.SOUTH);
//		outputAreaScroller = new JScrollPane(outputArea);
//		add(outputAreaScroller);
		
	}
	
	public void actionListeners() {
		P1NormalAttackButton1Listener listener1 = new P1NormalAttackButton1Listener();
		P2NormalAttackButtonListener listener2 = new P2NormalAttackButtonListener();
		P1StrongAttackListener listener3 = new P1StrongAttackListener();
		P2StrongAttackButtonListener listener4 = new P2StrongAttackButtonListener();
		P1ShowAttributesButtonListener listener5 = new P1ShowAttributesButtonListener();
		P2ShowAttributesButtonListener listener6 = new P2ShowAttributesButtonListener();
		DisplayRulesButtonListener listener7 = new DisplayRulesButtonListener();
		
		p1NormalAttackButton.addActionListener(listener1);
		p2NormalAttackButton.addActionListener(listener2);
		p1StrongAttackButton.addActionListener(listener3);
		p2StrongAttackButton.addActionListener(listener4);
		p1ShowAttributesButton.addActionListener(listener5);
		p2ShowAttributesButton.addActionListener(listener6);
		displayRulesButton.addActionListener(listener7);
	}
	
	public void addPanels() {
		//Adds components to the container
		panel.add(p1NormalAttackButton);
		panel.add(p2NormalAttackButton);
		panel.add(p1StrongAttackButton);
		panel.add(p2StrongAttackButton);
		panel.add(p1ShowAttributesButton);
		panel.add(p2ShowAttributesButton);
		panel.add(displayRulesButton);
	}
	
	public void addComponents() {
		add(panel);
	}
	
	
	public static void main(String[] args) {
		GameGUI gameInterface = new GameGUI();
		gameInterface.setVisible(true);
		System.out.println();
		
		
	}

}
