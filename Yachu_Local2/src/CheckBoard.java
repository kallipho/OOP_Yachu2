
import java.util.HashMap;
import java.util.Map;

class ScoreBoard {
	protected Map<String, Integer> Board = new HashMap<String, Integer>();
	static public String[] Categories = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
	static public String[] UpperCategories = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"};
	
	ScoreBoard() {
		for(String x: Categories) {
			Board.put(x, -1);
		}
	}
	
	public int GetBonusSum() {
		int subSum = 0;
		for (String x: ScoreBoard.UpperCategories) {
			if(Board.get(x)>-1) subSum += Board.get(x); //-1점이면 안 더해야됨.
		}
		return subSum;
	}
	
	public int GetSum() { //static List 추가해서 최적화시켜놨음.
		int sum = 0;
		for (String x: ScoreBoard.Categories) {
			if(Board.get(x)>-1) sum += Board.get(x);
		}
		return sum + (GetBonusSum() >= 63 ? 35 : 0);
	}
}

public class CheckBoard extends ScoreBoard{
	
	CheckBoard() {
		for(String x: Categories) {
			Board.put(x, -1);
		}
	}
	
	public Integer AccessBoard(String x) {
		return Board.get(x);
	}
	
	public void Check(String combName, int score) {
		Board.replace(combName, score);
	}
	
	public boolean IsEnd() {
		for (String x: CheckBoard.Categories) {
			if(Board.get(x) == -1) return false;
		}
		return true;
	}
}
