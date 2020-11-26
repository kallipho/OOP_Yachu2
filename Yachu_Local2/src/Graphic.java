import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Graphic{
	Player p1 = new Player("Justin");
	String CombText; GridBagConstraints CombGBC = new GridBagConstraints();
	String PlayerScoreText; GridBagConstraints PlayerScoreGBC = new GridBagConstraints();
	String EstimateScoreText; GridBagConstraints EstimateScoreGBC = new GridBagConstraints();
	String PlayerScoreSumText; GridBagConstraints PlayerScoreSumGBC = new GridBagConstraints();
	int[] DiceText = new int[5];
	boolean[] ButtonColor = new boolean[5];
	
	static Color OffC = Color.lightGray;
	static Color OnC = Color.gray;
	
	Dimension dim = new Dimension(500, 500);
	JFrame frame = new JFrame("Yachu: Yahtzee made with Java");
	
	JLabel CombLabel = new JLabel();
	JLabel PlayerScoreLabel = new JLabel();
	JLabel EstimateScoreLabel = new JLabel();
	JLabel PlayerScoreSumLabel = new JLabel();
	JLabel PScoreLabel = new JLabel();
	JLabel EScoreLabel = new JLabel();
	JButton button1 = new JButton(); GridBagConstraints button1GBC = new GridBagConstraints();
	JButton button2 = new JButton(); GridBagConstraints button2GBC = new GridBagConstraints();
	JButton button3 = new JButton(); GridBagConstraints button3GBC = new GridBagConstraints();
	JButton button4 = new JButton(); GridBagConstraints button4GBC = new GridBagConstraints();
	JButton button5 = new JButton(); GridBagConstraints button5GBC = new GridBagConstraints();
	JButton button6 = new JButton(); GridBagConstraints button6GBC = new GridBagConstraints();
	JButton button7 = new JButton(); GridBagConstraints button7GBC = new GridBagConstraints();
	
	public void runBackRender() {
		CombGBC.fill = GridBagConstraints.HORIZONTAL; CombGBC.gridx = 0; CombGBC.gridy = 0; CombGBC.gridwidth = 3; CombGBC.gridheight = 7;
		PlayerScoreGBC.fill = GridBagConstraints.HORIZONTAL;PlayerScoreGBC.gridx = 3; PlayerScoreGBC.gridy = 0; PlayerScoreGBC.gridwidth = 3; PlayerScoreGBC.gridheight = 7;
		EstimateScoreGBC.fill = GridBagConstraints.HORIZONTAL;EstimateScoreGBC.gridx = 6; EstimateScoreGBC.gridy = 0; EstimateScoreGBC.gridwidth = 3; EstimateScoreGBC.gridheight = 7;
		
		button1GBC.gridx = 1; button1GBC.gridy = 7; button1GBC.gridwidth = 1; button1GBC.gridheight = 1;
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.Dices.reverseSelectedDice(0);
				runUpdateRender();
			}
		});
		
		button2GBC.gridx = 2; button2GBC.gridy = 7; button2GBC.gridwidth = 1; button2GBC.gridheight = 1;
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.Dices.reverseSelectedDice(1);
				runUpdateRender();
			}
		});
		
		button3GBC.gridx = 3; button3GBC.gridy = 7; button3GBC.gridwidth = 1; button3GBC.gridheight = 1;
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.Dices.reverseSelectedDice(2);
				runUpdateRender();
			}
		});
		
		button4GBC.gridx = 4; button4GBC.gridy = 7; button4GBC.gridwidth = 1; button4GBC.gridheight = 1;
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.Dices.reverseSelectedDice(3);
				runUpdateRender();
			}
		});
		
		button5GBC.gridx = 5; button5GBC.gridy = 7; button5GBC.gridwidth = 1; button5GBC.gridheight = 1;
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.Dices.reverseSelectedDice(4);
				runUpdateRender();
			}
		});
		
		button6.setText("Roll again");
		button6GBC.gridx = 6; button6GBC.gridy = 7; button6GBC.gridwidth = 2; button6GBC.gridheight = 1;
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.doRoll();
				runUpdateRender();
			}
		});
		
		button7.setText("End turn");
		button7GBC.gridx = 8; button7GBC.gridy = 7; button7GBC.gridwidth = 2; button7GBC.gridheight = 1;
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.endTurn();
				runUpdateRender();
			}
		});
	}
	
	public void runUpdateRender() {
		CombText = "<html>";
		for (String x: Scoreboard.combList) {
			CombText += x + "<br/>";
		}
		CombText += "</html>";
		CombLabel.setText(CombText);
		
		PlayerScoreText = "<html>";
		for (String x: Scoreboard.combList) {
			PlayerScoreText += p1.scoreboard.accessBoard(x) + "<br/>";
		}
		PlayerScoreText += "</html>";
		
		PScoreLabel.setHorizontalTextPosition(JLabel.CENTER);
		PScoreLabel.setText(PlayerScoreText);
		
		EstimateScoreText = "<html>";
		for (String x: Scoreboard.combList) {
			EstimateScoreText += CombCal.Combination(p1.Dices, x) + "<br/>";
		}
		EstimateScoreText += "</html>";	
		EScoreLabel.setText(EstimateScoreText);
		GridBagConstraints EstimateScoreGBC = new GridBagConstraints();
		
		DiceText = p1.Dices.toIntDices();
		ButtonColor = p1.Dices.toLockDices();
		
		button1.setText(Integer.toString(DiceText[0]));
		if(ButtonColor[0]) button1.setBackground(OffC);
		else button1.setBackground(OnC);
		
		button2.setText(Integer.toString(DiceText[1]));
		if(ButtonColor[1]) button2.setBackground(OffC);
		else button2.setBackground(OnC);
		
		button3.setText(Integer.toString(DiceText[2]));
		if(ButtonColor[2]) button3.setBackground(OffC);
		else button3.setBackground(OnC);
		
		button4.setText(Integer.toString(DiceText[3]));
		if(ButtonColor[3]) button4.setBackground(OffC);
		else button4.setBackground(OnC);
		
		button5.setText(Integer.toString(DiceText[4]));
		if(ButtonColor[4]) button5.setBackground(OffC);
		else button5.setBackground(OnC);
	}
	
	public void runFrontRender() {
		frame.setLocation(0, 0);
		frame.setPreferredSize(dim);
		GridBagLayout gbl = new GridBagLayout();
		frame.setLayout(gbl);
		
		frame.add(CombLabel, CombGBC);
		frame.add(PScoreLabel, PlayerScoreGBC);
		frame.add(EScoreLabel, EstimateScoreGBC);
		frame.add(button1, button1GBC);
		frame.add(button2, button2GBC);
		frame.add(button3, button3GBC);
		frame.add(button4, button4GBC);
		frame.add(button5, button5GBC);
		frame.add(button6, button6GBC);
		frame.add(button7, button7GBC);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void run() {
		p1.startTurn();
		runBackRender();
		runUpdateRender();
		runFrontRender();
	}
	
	public static void main(String[] args) {
		Graphic g = new Graphic();
		g.run();
	}
}