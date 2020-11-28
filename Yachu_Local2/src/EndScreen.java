import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EndScreen implements Screen{
	int Score; String Name;
	
	JFrame MainFrame = new JFrame("Yachu: Yahtzee made with Java");
	GridBagLayout MainGBL = new GridBagLayout();
	JLabel title = new JLabel();
	GridBagConstraints TitleGBC = new GridBagConstraints(); 
	JButton MoreButton = new JButton("Play again");
	GridBagConstraints MoreGBC = new GridBagConstraints();
	JButton ExitButton = new JButton("Exit");
	GridBagConstraints ExitGBC = new GridBagConstraints();
	
	EndScreen(String Name, int Score){
		this.Name = Name;
		this.Score = Score;
	}
	
	public void BackRender() {
		MainFrame.setLayout(MainGBL);
		MainFrame.setPreferredSize(ScreenSize);
		
		title.setText(String.format("You scored %d!", Score));
		title.setFont(title.getFont().deriveFont(30f));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		TitleGBC.gridx=0; TitleGBC.gridy=0; TitleGBC.gridwidth=3; TitleGBC.gridheight=2; 
		
		MoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				GameScreen G = new GameScreen(Name);
				G.OpenScreen();
			}
		});
		MoreButton.setHorizontalAlignment(SwingConstants.CENTER);
		MoreGBC.gridx=1; MoreGBC.gridy=2; MoreGBC.gridwidth=3; MoreGBC.gridheight=1;
		
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
			}
		});
		ExitButton.setHorizontalAlignment(SwingConstants.CENTER);
		ExitGBC.gridx=1; ExitGBC.gridy=3; ExitGBC.gridwidth=3; ExitGBC.gridheight=1; 
	}
	
	public void FrontRender() {
		MainFrame.add(title, TitleGBC);
		MainFrame.add(MoreButton, MoreGBC);
		MainFrame.add(ExitButton, ExitGBC);
	}
	
	public void OpenScreen() {
		BackRender();
		FrontRender();
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
}
