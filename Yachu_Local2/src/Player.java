public class Player {
	private String playerName;
	Scoreboard SB = new Scoreboard();
	Dice[] dice = new Dice[5];
	public int rollNum;
	
	Player(String Name) {
		this.playerName = Name;
		this.rollNum = 3;
		for(int i=0; i<5; i++) {
			dice[i] = new Dice();
		}
	}
	
	public void rollDices() { //주사위를 굴림
		--rollNum;
		for (Dice x : dice){
			x.Roll();
		}
	}
	
	public void resetDiceKeeps() {
		for (Dice x: dice) {
			x.kept = false;
		}
	}
	
	public void resetRollNum() {
		this.rollNum = 3;
	}
}
