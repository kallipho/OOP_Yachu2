import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	//private Scoreboard //Dictionary 형태. 내 스코어보드를 나타냄
	//public void check(String combName) //조합 체크
	//public boolean isEnd() //체크할 칸이 남아있는지 체크
	//public int Sum() //현재 점수합 Return (Bonus 점수 포함) 
	
	Map<String, Integer> scoreboard = new HashMap<String, Integer>();
	
	Scoreboard() {
		scoreboard.put("Ones", -1);
		scoreboard.put("Twos", -1);
		scoreboard.put("Threes", -1);
		scoreboard.put("Fours", -1);
		scoreboard.put("Fives", -1);
		scoreboard.put("Sixes", -1);
		scoreboard.put("Three of a kind", -1);
		scoreboard.put("Four of a kind", -1);
		scoreboard.put("Full House", -1);
		scoreboard.put("Small straight", -1);
		scoreboard.put("Large straight", -1);
		scoreboard.put("Chance", -1);
		scoreboard.put("YAHTZEE", -1);
	}
	
	public void check(String combName) {
		
	}
	
	public boolean isEnd() {
		
	}
	
	public int Sum() {
		
	}
	
}
