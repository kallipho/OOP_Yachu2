public class Player {
	private String playerName;
	private Scoreboard scoreboard = new Scoreboard();
	private MultipleDice Dices = new MultipleDice();
	private int rollNum;
	
	Player(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
	}
	
	public void PlayerRollsDices() { //주사위를 굴림
		--rollNum;
		Dices.RollDices();
	}
	
	public void SetDefaultValue() {
		rollNum = 2;
		Dices.SetDefaultValue();
	}
	
	public void SetRollNumtoZero() {
		rollNum = 0;
	}
	
	private void printBar() {
		System.out.println("==============================");
	}
	
	private void printScore() {
		System.out.printf("%s : %d (For Bonus : %d)\n", playerName, scoreboard.Sum(), scoreboard.BonusSum());
	}
	
	private static void clearScreen() {  
		for(int i=0; i<10; i++) {
			System.out.printf("\n");
		}
	}  
	
	public boolean isEnd() {
		return scoreboard.isEnd();
	}
	
	public int getRollNum() {
		return rollNum;
	}
	
	public void ReverseLockByArray(int SelectList) {
		Dices.ReverseLockByArray(SelectList);
	}
	
	public void Check(String CombName) {
		scoreboard.check(CombName, CombCal.Combination(Dices, CombName));
	}
	
	public boolean isEmpty(String CombName) {
		if(scoreboard.isMinusOne(CombName)) return true;
		else return false;
	}
	
	public void printMyGame() {
		clearScreen();
		scoreboard.printScoreboard(Dices);
		printBar();
		printScore();
		printBar();
		Dices.printEyes();
		Dices.printLocks();
		printBar();
		System.out.printf("%d roll left| 6: Roll | 7: End\n", rollNum);
		if(isEnd()) {
			System.out.println("Game Over!!!");
		}
	}
}
