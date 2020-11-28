public class Player {
	protected String Name;
	protected CheckBoard CheckBoard = new CheckBoard();
	protected Dice[] Dices = new Dice[5];
	protected int RollsLeft = 2;
	
	Player(){
		this.Name = "Anonymous";
		this.RollsLeft = 2;
		for(int i=0; i<5; i++) {
			Dices[i] = new Dice();
		}
	}
	
	Player(String Name) {
		this.Name = Name;
		this.RollsLeft = 2;
		for(int i=0; i<5; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public void ReRoll() { //주사위를 굴림
		if(RollsLeft>0) {
			--RollsLeft;
			for(int i=0; i<5; i++) {
				Dices[i].Roll();
			}
		}
	}
	
	public void StartTurn() {
		this.RollsLeft = 2;
		for(int i=0; i<5; i++) {
			Dices[i].SetDefault();
		}
	}
	
	public int GetRollsLeft() {
		return RollsLeft;
	}
	
	public void Check(String CombName) {
		CheckBoard.Check(CombName, Categories.ScoreCalculator(Dices, CombName));
	}
	
	public boolean IsValidCategory(String CombName) {
		for (String x: CheckBoard.Categories) {
			if(CombName.equals(x) && CheckBoard.AccessBoard(CombName)==-1) return true;
			}
		return false;
	}
	
	public boolean IsGameEnd() {
		for (String x: CheckBoard.Categories) {
			if(CheckBoard.AccessBoard(x)==-1) return false;
		}
		return true;
	}
	
	public void StartNewGame(String Text) {
		Name = Text;
		CheckBoard = new CheckBoard();
		for(int i=0; i<5; i++) {
			Dices[i] = new Dice();
		}
		RollsLeft = 2;
	}
}
