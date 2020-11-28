import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainScreen implements Screen{
	JFrame MainFrame = new JFrame("Yachu: Yahtzee made with Java");
	GridBagLayout MainGBL = new GridBagLayout();
	JLabel title = new JLabel("Yachu");
	GridBagConstraints TitleGBC = new GridBagConstraints();
	JTextField NameField = new JTextField();
	GridBagConstraints NameGBC = new GridBagConstraints();
	JButton StartButton = new JButton("Start");
	GridBagConstraints StartGBC = new GridBagConstraints();
	JButton HelpButton = new JButton("Help");
	GridBagConstraints HelpGBC = new GridBagConstraints();
	JButton GithubButton = new JButton("Github");
	GridBagConstraints GithubGBC = new GridBagConstraints();
	
	public void BackRender() {
		title.setFont(title.getFont().deriveFont(20f));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		TitleGBC.fill = GridBagConstraints.HORIZONTAL;TitleGBC.gridx=0; TitleGBC.gridy=0; TitleGBC.gridwidth=5; TitleGBC.gridheight=2;
		
		NameField.setToolTipText("Input your name here");
		NameField.setHorizontalAlignment(SwingConstants.CENTER);
		NameGBC.fill = GridBagConstraints.HORIZONTAL; NameGBC.gridx=1; NameGBC.gridy=2; NameGBC.gridwidth=3; TitleGBC.gridheight=1;
		
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				GameScreen G = new GameScreen(NameField.getText());
				G.OpenScreen();
			}
		});
		StartButton.setHorizontalAlignment(SwingConstants.CENTER);
		StartGBC.gridx=1; StartGBC.gridy=3; StartGBC.gridwidth=3; StartGBC.gridheight=1; 
		
		HelpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
						Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Yahtzee"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		HelpButton.setHorizontalAlignment(SwingConstants.CENTER);
		HelpGBC.gridx=1; HelpGBC.gridy=4; HelpGBC.gridwidth=3; HelpGBC.gridheight=1;
		
		GithubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
						Desktop.getDesktop().browse(new URI("https://github.com/kallipho/OOP_Yachu2"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GithubButton.setHorizontalAlignment(SwingConstants.CENTER);
		GithubGBC.gridx=1; GithubGBC.gridy=5; GithubGBC.gridwidth=3; GithubGBC.gridheight=1; 
	};
	
	public void FrontRender() {
		MainFrame.setLayout(MainGBL);
		MainFrame.setPreferredSize(ScreenSize);
		
		MainFrame.add(title, TitleGBC);
		MainFrame.add(NameField, NameGBC);
		MainFrame.add(StartButton, StartGBC);
		MainFrame.add(HelpButton, HelpGBC);
		MainFrame.add(GithubButton, GithubGBC);
	};
	
	public void OpenScreen() {
		BackRender();
		FrontRender();
		MainFrame.pack();
		MainFrame.setVisible(true);
	};
}
