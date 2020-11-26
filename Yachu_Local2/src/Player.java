class GamePlayer {
	protected String playerName;
	protected Scoreboard scoreboard = new Scoreboard();
	protected MultipleDice Dices = new MultipleDice();
	protected int rollNum = 2;
	
	GamePlayer(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
	}
	
	public void doRoll() { //주사위를 굴림
		if(rollNum>0) {
			--rollNum;
			Dices.doRollDices();
		}
	}
	
	public void startTurn() {
		this.rollNum = 2;
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
	
	public boolean isValidComb(String CombName) {
		for (String x: Scoreboard.combList) {
			if(CombName.equals(x) && scoreboard.accessBoard(CombName)==-1) return true;
			}
		return false;
	}
	
	public boolean isEnd() {
		for (String x: Scoreboard.combList) {
			if(scoreboard.accessBoard(x)==-1) return false;
		}
		return true;
	}
}

