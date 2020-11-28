class GamePlayer {
	protected String playerName;
	protected Scoreboard scoreboard = new Scoreboard();
	protected Dice[] Dices = new Dice[5];
	protected int rollNum = 2;
	
	GamePlayer(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
		for(int i=0; i<5; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public void reRoll() { //주사위를 굴림
		if(rollNum>0) {
			--rollNum;
			for(int i=0; i<5; i++) {
				Dices[i].roll();
			}
		}
	}
	
	public void startTurn() {
		this.rollNum = 2;
		for(int i=0; i<5; i++) {
			Dices[i].setDefaultValue();
		}
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

