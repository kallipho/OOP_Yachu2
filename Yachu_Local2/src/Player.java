import javax.swing.JFrame;
import javax.swing.JLabel;

class GamePlayer {
	protected String playerName;
	protected Scoreboard scoreboard = new Scoreboard();
	protected MultipleDice Dices = new MultipleDice();
	protected int rollNum;
	
	GamePlayer(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
	}
	
	public void doRoll() { //주사위를 굴림
		--rollNum;
		Dices.doRollDices();
	}
	
	public void startTurn() {
		rollNum = 2;
		Dices.setDefaultValue();
	}
	
	public void endTurn() {
		rollNum = 0;
	}
	
	public int getRollNum() {
		return rollNum;
	}
	
	public void doCheck(String CombName) {
		scoreboard.doCheck(CombName, CombCal.Combination(Dices, CombName));
	}
}

public class Player extends GamePlayer{
	
	Player(String Name) {
			super(Name);
	}
	
	public String PScore() {
		
	}
}

