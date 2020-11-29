import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GameScreen implements Screen{
	Player P = new Player("Default Name");
	JFrame MainFrame = new JFrame("Yachu: Yahtzee made with Java");
	GridBagLayout GBL = new GridBagLayout();
	
	
	String PlayerNameText; GridBagConstraints PlayerNameGBC = new GridBagConstraints(); JLabel PlayerNameLabel = new JLabel();
	String ScoreboardHeaderText[]; String[][] ScoreboardContentText; GridBagConstraints ScoreboardGBC = new GridBagConstraints(); DefaultTableModel model; JTable ScoreboardTable;
	String ScoreText; GridBagConstraints ScoreGBC = new GridBagConstraints(); JLabel ScoreLabel = new JLabel();
	String[] DiceText = new String[5]; Color[] DiceColor = new Color[5]; ActionListener[] DiceActionListener = new ActionListener[5];GridBagConstraints[] DiceGBC = new GridBagConstraints[5]; JButton[] DiceButton = new JButton[5];
	String RollButtonText; GridBagConstraints RollButtonGBC = new GridBagConstraints(); JButton RollButton = new JButton();
	String SubmitButtonText; GridBagConstraints SubmitButtonGBC = new GridBagConstraints(); JButton SubmitButton = new JButton();
	GridBagConstraints InputFieldGBC = new GridBagConstraints(); JTextField InputField = new JTextField(); 
	
	GameScreen(String Name){
		P.SetName(Name);
	}
	
	public void DiceActionListenerRender() {
		DiceActionListener[0] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[0].ReverseLock();
				PeriodicRender();
			}
		};
		DiceActionListener[1] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[1].ReverseLock();
				PeriodicRender();
			}
		};
		DiceActionListener[2] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[2].ReverseLock();
				PeriodicRender();
			}
		};
		DiceActionListener[3] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[3].ReverseLock();
				PeriodicRender();
			}
		};
		DiceActionListener[4] = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				P.Dices[4].ReverseLock();
				PeriodicRender();
			}
		};
	}
	
	public void BackRender() {
		MainFrame.setPreferredSize(ScreenSize);
		MainFrame.setLayout(GBL);
		MainFrame.setLocationRelativeTo(null);
		
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
		
		PlayerNameText = P.GetName();
		
		ScoreboardHeaderText = new String[3];
		ScoreboardHeaderText[0] = "Combination";
		ScoreboardHeaderText[1] = "Estimate";
		ScoreboardHeaderText[2] = "Checked";
		
		ScoreboardContentText = new String[13][3];
		for(int i=0; i<13; i++) {
			ScoreboardContentText[i][0] = CheckBoard.Categories[i];
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
				P.ReRoll();
				PeriodicRender();
			}
		});
		
		InputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = InputField.getText();
				if(P.IsValidCategory(userInput)) {
					P.Check(userInput);
					if(P.IsGameEnd()) {
						MainFrame.setVisible(false);
						EndScreen S = new EndScreen(P.GetName(), P.CheckBoard.GetSum());
						S.OpenScreen();
					}
					P.StartTurn();
					InputField.setText("");
					PeriodicRender();
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
				if(P.IsValidCategory(userInput)) {
					P.Check(userInput);
					if(P.IsGameEnd()) {
						MainFrame.setVisible(false);
						EndScreen S = new EndScreen(P.GetName(), P.CheckBoard.GetSum());
						S.OpenScreen();
					}
					P.StartTurn();
					InputField.setText("");
					PeriodicRender();
				}
				else {
					InputField.setText("");
				}
			}
		});
		
		PeriodicRender();
	}
	
	public void PeriodicRender() {
		for(int i=0; i<13; i++) {
			if(P.CheckBoard.AccessBoard(CheckBoard.Categories[i])!=-1) model.setValueAt("-", i, 1);
			else model.setValueAt(ScoreToString(Categories.ScoreCalculator(P.Dices, CheckBoard.Categories[i])), i, 1);
			model.setValueAt(ScoreToString(P.CheckBoard.AccessBoard(CheckBoard.Categories[i])), i, 2);
		}
		
		ScoreText = String.format("Score : %d (Bonus: %d)", P.CheckBoard.GetSum(), P.CheckBoard.GetBonusSum());
		
		for(int i=0; i<5; i++) {
			DiceText[i] = Integer.toString(P.Dices[i].GetEye());
			DiceColor[i] = P.Dices[i].GetIsLock() ? Color.GRAY : Color.LIGHT_GRAY;
		}
		
		RollButtonText = String.format("Roll (%d)", P.GetRollsLeft());
		
		PlayerNameLabel.setText(PlayerNameText);
		ScoreLabel.setText(ScoreText);
		for(int i=0; i<5; i++) {
			DiceButton[i].setText(DiceText[i]);
			DiceButton[i].setBackground(DiceColor[i]);
		}
		RollButton.setText(RollButtonText);
	}
	
	public void FrontRender() {
		MainFrame.add(PlayerNameLabel, PlayerNameGBC);
		MainFrame.add(ScoreboardTable, ScoreboardGBC);
		MainFrame.add(ScoreLabel, ScoreGBC);
		for(int i=0; i<5; i++) {
			MainFrame.add(DiceButton[i], DiceGBC[i]);
		}
		MainFrame.add(RollButton, RollButtonGBC);
		MainFrame.add(InputField, InputFieldGBC);
		MainFrame.add(SubmitButton, SubmitButtonGBC);
	}
	
	public void OpenScreen() {
		BackRender();
		FrontRender();
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
	public static String ScoreToString(int n) {
		if(n==-1) return "-";
		else return Integer.toString(n);
	}
}
