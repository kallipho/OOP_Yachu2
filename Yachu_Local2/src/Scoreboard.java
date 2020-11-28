import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	private Map<String, Integer> CheckBoard = new HashMap<String, Integer>();
	static public String[] Categories = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
	static public String[] UpperCategories = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"};
	
	Scoreboard() {
		for(String x: Categories) {
			CheckBoard.put(x, -1);
		}
	}
	
	public Integer AccessBoard(String x) {
		return CheckBoard.get(x);
	}
	
	public void Check(String combName, int score) {
		CheckBoard.replace(combName, score);
	}
	
	public boolean IsEnd() {
		for (String x: Scoreboard.Categories) {
			if(CheckBoard.get(x) == -1) return false;
		}
		return true;
	}
	
	public int GetBonusSum() {
		int subSum = 0;
		for (String x: Scoreboard.UpperCategories) {
			if(CheckBoard.get(x)>-1) subSum += CheckBoard.get(x); //-1점이면 안 더해야됨.
		}
		return subSum;
	}
	
	public int GetSum() { //static List 추가해서 최적화시켜놨음.
		int sum = 0;
		for (String x: Scoreboard.Categories) {
			if(CheckBoard.get(x)>-1) sum += CheckBoard.get(x);
		}
		return sum + (GetBonusSum() >= 63 ? 35 : 0);
	}	
}
