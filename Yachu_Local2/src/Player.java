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
		for (Dice x : dice){
			x.Roll();
		}
	}
	
	public void select(String Comb) {
		//TODO 내용 추가 필요
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
