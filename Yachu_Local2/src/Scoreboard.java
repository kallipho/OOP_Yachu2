import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	Map<String, Integer> scoreboard = new HashMap<String, Integer>();
	static String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
	static String[] intCombList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"};
	Scoreboard() {
		for(String x: combList) {
			scoreboard.put(x, -1);
		}
	}
	
	public void check(String combName, int score) {
		scoreboard.replace(combName, score);
	}
	
	public boolean isEnd() { //static List 추가해서 최적화시켜놨음.
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x) == -1) return false;
		}
		return true;
	}
	
	public int Sum() { //static List 추가해서 최적화시켜놨음.
		int subSum = 0;
		for (String x: Scoreboard.intCombList) {
			if(scoreboard.get(x)>-1) subSum += scoreboard.get(x); //-1점이면 안 더해야됨.
		}
		int sum = 0;
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x)>-1) sum += scoreboard.get(x);
		}
		return sum + subSum >= 63 ? 35 : 0;
	}
	
}
