import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Game{
	Player P = new Player("Default Name");
	String UserName;
	
	Dimension dim = new Dimension(400, 400);
	JFrame frame = new JFrame("Yachu: Yahtzee made with Java");
	
	String PlayerNameText; GridBagConstraints PlayerNameGBC = new GridBagConstraints(); JLabel PlayerNameLabel = new JLabel();
	String ScoreboardHeaderText[]; String[][] ScoreboardContentText; GridBagConstraints ScoreboardGBC = new GridBagConstraints(); DefaultTableModel model; JTable ScoreboardTable;
	String ScoreText; GridBagConstraints ScoreGBC = new GridBagConstraints(); JLabel ScoreLabel = new JLabel();
	String[] DiceText = new String[5]; Color[] DiceColor = new Color[5]; ActionListener[] DiceActionListener = new ActionListener[5];GridBagConstraints[] DiceGBC = new GridBagConstraints[5]; JButton[] DiceButton = new JButton[5];
	String RollButtonText; GridBagConstraints RollButtonGBC = new GridBagConstraints(); JButton RollButton = new JButton();
	String SubmitButtonText; GridBagConstraints SubmitButtonGBC = new GridBagConstraints(); JButton SubmitButton = new JButton();
	GridBagConstraints InputFieldGBC = new GridBagConstraints(); JTextField InputField = new JTextField(); 
	
	Game(){
		//»ý¼ºÀÚ
	}
	
	public String ScoreToString(int n) {
		if(n==-1) return "-";
		else return Integer.toString(n);
	}
	
	public void DiceActionListenerRender() {
		DiceActionListener[0] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[0].reverseLock();
				backRender();
				frontRender();
			}
		};
		DiceActionListener[1] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[1].reverseLock();
				backRender();
				frontRender();
			}
		};
		DiceActionListener[2] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[2].reverseLock();
				backRender();
				frontRender();
			}
		};
		DiceActionListener[3] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[3].reverseLock();
				backRender();
				frontRender();
			}
		};
		DiceActionListener[4] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[4].reverseLock();
				backRender();
				frontRender();
			}
		};
	}
	
	public void initialRender() {
		
		PlayerNameGBC.fill = GridBagConstraints.HORIZONTAL; PlayerNameGBC.gridx = 3; PlayerNameGBC.gridy = 0; PlayerNameGBC.gridwidth = 2; PlayerNameGBC.gridheight = 1;
		ScoreboardGBC.fill = GridBagConstraints.HORIZONTAL; ScoreboardGBC.gridx = 0; ScoreboardGBC.gridy = 1; ScoreboardGBC.gridwidth = 6; ScoreboardGBC.gridheight = 6;
		ScoreGBC.fill = GridBagConstraints.HORIZONTAL; ScoreGBC.gridx = 0; ScoreGBC.gridy = 7; ScoreGBC.gridwidth = 6; ScoreGBC.gridheight = 1;
		for(int i=0; i<5; i++) {
			DiceGBC[i] = new GridBagConstraints();
			DiceGBC[i].fill = GridBagConstraints.HORIZONTAL; DiceGBC[i].gridx = i; DiceGBC[i].gridy = 8; DiceGBC[i].gridwidth = 1; DiceGBC[i].gridheight = 1;
		}
		RollButtonGBC.fill = GridBagConstraints.HORIZONTAL; RollButtonGBC.gridx = 5; RollButtonGBC.gridy = 8; RollButtonGBC.gridwidth = 1; RollButtonGBC.gridheight = 1;
		InputFieldGBC.fill = GridBagConstraints.HORIZONTAL; InputFieldGBC.gridx = 0; InputFieldGBC.gridy = 9; InputFieldGBC.gridwidth = 5; InputFieldGBC.gridheight = 1;
		SubmitButtonGBC.fill = GridBagConstraints.HORIZONTAL; SubmitButtonGBC.gridx = 5; SubmitButtonGBC.gridy = 9; SubmitButtonGBC.gridwidth = 1; SubmitButtonGBC.gridheight = 1;
		
		PlayerNameText = P.playerName;
		
		ScoreboardHeaderText = new String[3];
		ScoreboardHeaderText[0] = "Combination";
		ScoreboardHeaderText[1] = "Estimate";
		ScoreboardHeaderText[2] = "Checked";
		
		ScoreboardContentText = new String[13][3];
		for(int i=0; i<13; i++) {
			ScoreboardContentText[i][0] = Scoreboard.combList[i];
			ScoreboardContentText[i][1] = "-";
			ScoreboardContentText[i][2] = "-";
		}
		model = new DefaultTableModel(ScoreboardContentText, ScoreboardHeaderText);
		ScoreboardTable = new JTable(model);
		
		ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0; i<5; i++) {
			DiceButton[i] = new JButton();
			DiceActionListenerRender();
			DiceButton[i].addActionListener(DiceActionListener[i]);
		}
		
		RollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P.reRoll();
				backRender();
				frontRender();
			}
		});
		
		InputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = InputField.getText();
				if(P.isValidComb(userInput)) {
					P.doCheck(userInput);
					if(P.isEnd()) {
						frame.setVisible(false);
						EndScreen();
					}
					P.startTurn();
					InputField.setText("");
					backRender();
					frontRender();
				}
				else {
					InputField.setText("");
				}
			}
		});
		
		SubmitButtonText = "Submit";
		SubmitButton.setText(SubmitButtonText);
		
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = InputField.getText();
				if(P.isValidComb(userInput)) {
					P.doCheck(userInput);
					if(P.isEnd()) {
						frame.setVisible(false);
						EndScreen();
					}
					P.startTurn();
					InputField.setText("");
					backRender();
					frontRender();
				}
				else {
					InputField.setText("");
				}
			}
		});
	}
	
	public void backRender() {
		for(int i=0; i<13; i++) {
			if(P.scoreboard.accessBoard(Scoreboard.combList[i])!=-1) model.setValueAt("-", i, 1);
			else model.setValueAt(ScoreToString(CombCal.Combination(P.Dices, Scoreboard.combList[i])), i, 1);
			model.setValueAt(ScoreToString(P.scoreboard.accessBoard(Scoreboard.combList[i])), i, 2);
		}
		
		ScoreText = String.format("Score : %d (Bonus: %d)", P.scoreboard.getSum(), P.scoreboard.getBonusSum());
		
		for(int i=0; i<5; i++) {
			DiceText[i] = Integer.toString(P.Dices[i].getEye());
			DiceColor[i] = P.Dices[i].getIsLock() ? Color.GRAY : Color.LIGHT_GRAY;
		}
		
		RollButtonText = String.format("%d Roll", P.getRollNum());
	}
	
	public void frontRender() {
		PlayerNameLabel.setText(PlayerNameText);
		ScoreLabel.setText(ScoreText);
		for(int i=0; i<5; i++) {
			DiceButton[i].setText(DiceText[i]);
			DiceButton[i].setBackground(DiceColor[i]);
		}
		RollButton.setText(RollButtonText);
	}
	
	public void initialBoot() {
		frame.setLocation(0, 0);
		frame.setPreferredSize(dim);
		GridBagLayout GBL = new GridBagLayout();
		frame.setLayout(GBL);
		
		frame.add(PlayerNameLabel, PlayerNameGBC);
		frame.add(ScoreboardTable, ScoreboardGBC);
		frame.add(ScoreLabel, ScoreGBC);
		for(int i=0; i<5; i++) {
			frame.add(DiceButton[i], DiceGBC[i]);
		}
		frame.add(RollButton, RollButtonGBC);
		frame.add(InputField, InputFieldGBC);
		frame.add(SubmitButton, SubmitButtonGBC);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void MainScreen() {
		JFrame MainFrame = new JFrame("Yachu: Yahtzee made with Java");
		GridBagLayout MainGBL = new GridBagLayout();
		MainFrame.setLayout(MainGBL);
		MainFrame.setPreferredSize(dim);
		
		JLabel title = new JLabel("Yachu");
		title.setFont(title.getFont().deriveFont(20f));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints TitleGBC = new GridBagConstraints();
		TitleGBC.fill = GridBagConstraints.HORIZONTAL;TitleGBC.gridx=0; TitleGBC.gridy=0; TitleGBC.gridwidth=5; TitleGBC.gridheight=2; 
		
		JTextField NameField = new JTextField();
		NameField.setToolTipText("Input your name here");
		NameField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints NameGBC = new GridBagConstraints();
		NameGBC.fill = GridBagConstraints.HORIZONTAL; NameGBC.gridx=1; NameGBC.gridy=2; NameGBC.gridwidth=3; TitleGBC.gridheight=1; 
		JButton StartButton = new JButton("Start");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserName = NameField.getText();
				MainFrame.setVisible(false);
				RunGame(UserName);
			}
		});
		StartButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints StartGBC = new GridBagConstraints();
		StartGBC.gridx=1; StartGBC.gridy=3; StartGBC.gridwidth=3; StartGBC.gridheight=1; 

		JButton HelpButton = new JButton("Help");
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
		GridBagConstraints HelpGBC = new GridBagConstraints();
		HelpGBC.gridx=1; HelpGBC.gridy=4; HelpGBC.gridwidth=3; HelpGBC.gridheight=1; 
		

		JButton GithubButton = new JButton("Github");
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
		GridBagConstraints GithubGBC = new GridBagConstraints();
		GithubGBC.gridx=1; GithubGBC.gridy=5; GithubGBC.gridwidth=3; GithubGBC.gridheight=1; 
		
		MainFrame.add(title, TitleGBC);
		MainFrame.add(NameField, NameGBC);
		MainFrame.add(StartButton, StartGBC);
		MainFrame.add(HelpButton, HelpGBC);
		MainFrame.add(GithubButton, GithubGBC);
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
	public void EndScreen() {
		JFrame MainFrame = new JFrame("Yachu: Yahtzee made with Java");
		GridBagLayout MainGBL = new GridBagLayout();
		MainFrame.setLayout(MainGBL);
		MainFrame.setPreferredSize(dim);
		
		JLabel title = new JLabel(String.format("You scored %d", P.scoreboard.getSum()));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints TitleGBC = new GridBagConstraints();
		TitleGBC.gridx=0; TitleGBC.gridy=0; TitleGBC.gridwidth=5; TitleGBC.gridheight=2; 
		
		JButton MoreButton = new JButton("Play again");
		MoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Yachu: Yahtzee made with Java");
				MainFrame.setVisible(false);
				RunGame(UserName);
			}
		});
		MoreButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints MoreGBC = new GridBagConstraints();
		MoreGBC.gridx=1; MoreGBC.gridy=2; MoreGBC.gridwidth=3; MoreGBC.gridheight=1; 

		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
			}
		});
		ExitButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints ExitGBC = new GridBagConstraints();
		ExitGBC.gridx=1; ExitGBC.gridy=3; ExitGBC.gridwidth=3; ExitGBC.gridheight=1; 
		
		MainFrame.add(title, TitleGBC);
		MainFrame.add(MoreButton, MoreGBC);
		MainFrame.add(ExitButton, ExitGBC);
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
	public void RunGame(String Text) {
		P.resetEverything(Text);
		P.startTurn();
		initialRender();
		backRender();
		frontRender();
		initialBoot();
	}
	
	public static void main(String[] args) {
		Game G = new Game();
		G.MainScreen();
	}
}