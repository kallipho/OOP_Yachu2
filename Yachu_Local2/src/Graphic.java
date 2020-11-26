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
	
	public void runBackRender() {
		CombText = "<html>";
		for (String x: Scoreboard.combList) {
			CombText += x + "<br/>";
		}
		CombText += "</html>";
		
		PlayerScoreText = "<html>";
		for (String x: Scoreboard.combList) {
			PlayerScoreText += p1.scoreboard.accessBoard(x) + "<br/>";
		}
		PlayerScoreText += "</html>";
		
		EstimateScoreText = "<html>";
		for (String x: Scoreboard.combList) {
			EstimateScoreText += CombCal.Combination(p1.Dices, x) + "<br/>";
		}
		EstimateScoreText += "</html>";	
		
		DiceText = p1.Dices.toIntDices();
		ButtonColor = p1.Dices.toLockDices();
	}
	
	public void runFrontRender() {
		Dimension dim = new Dimension(500, 500);
		JFrame frame = new JFrame("Yachu: Yahtzee made with Java");
		frame.setLocation(0, 0);
		frame.setPreferredSize(dim);
  
		GridBagLayout gbl = new GridBagLayout();
		frame.setLayout(gbl);
		
		//CombLabel 세팅
		JLabel CombLabel = new JLabel();
		JLabel PlayerScoreLabel = new JLabel();
		JLabel EstimateScoreLabel = new JLabel();
		JLabel PlayerScoreSumLabel = new JLabel();
		CombLabel.setText(CombText);
		CombGBC.fill = GridBagConstraints.HORIZONTAL; CombGBC.gridx = 0; CombGBC.gridy = 0; CombGBC.gridwidth = 3; CombGBC.gridheight = 7;
		frame.add(CombLabel, CombGBC);
		
		//PScoreLabel 세팅
		JLabel PScoreLabel = new JLabel();
		PScoreLabel.setHorizontalTextPosition(JLabel.CENTER);
		PScoreLabel.setText(PlayerScoreText);
		PlayerScoreGBC.fill = GridBagConstraints.HORIZONTAL;PlayerScoreGBC.gridx = 3; PlayerScoreGBC.gridy = 0; PlayerScoreGBC.gridwidth = 3; PlayerScoreGBC.gridheight = 7;
		frame.add(PScoreLabel, PlayerScoreGBC);
  
		JLabel EScoreLabel = new JLabel();
		EScoreLabel.setText(EstimateScoreText);
		GridBagConstraints EScoregbc = new GridBagConstraints();
		EScoregbc.fill = GridBagConstraints.HORIZONTAL;EScoregbc.gridx = 6; EScoregbc.gridy = 0; EScoregbc.gridwidth = 3; EScoregbc.gridheight = 7;
		frame.add(EScoreLabel, EScoregbc);
  
		JButton[] buttons = new JButton[5];
		GridBagConstraints[] buttonGBC = new GridBagConstraints[5];
		for(int i=0; i<5; i++) {
			buttons[i] = new JButton(Integer.toString(DiceText[i]));
			buttonGBC[i] = new GridBagConstraints();
			buttonGBC[i].gridx = i; buttonGBC[i].gridy = 7; buttonGBC[i].gridwidth = 1; buttonGBC[i].gridheight = 1;
			if(ButtonColor[i]) buttons[i].setBackground(Color.RED);
			else buttons[i].setBackground(Color.BLUE);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Hello");
				}
			});
			frame.add(buttons[i], buttonGBC[i]);
		}
  
		frame.pack();
		frame.setVisible(true);
	}
	
	public void run() {
		p1.startTurn();
		runBackRender();
		runFrontRender();
	}
	
	public static void main(String[] args) {
		run();
	}
}