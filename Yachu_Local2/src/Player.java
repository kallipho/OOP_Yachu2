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
	
	public void rollDices() { //�ֻ����� ����
		for (Dice x : dice){
			x.Roll();
		}
	}
}
