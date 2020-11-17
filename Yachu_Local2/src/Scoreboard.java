import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	Map<String, Integer> scoreboard = new HashMap<String, Integer>();
	static String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
	
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
	
	public void check(String combName, int score) {
		scoreboard.replace(combName, score);
	}
	
	public boolean isEnd() {
		if(scoreboard.get("Ones") != -1 && scoreboard.get("Twos") != -1 && scoreboard.get("Threes") != -1 && scoreboard.get("Fours") != -1 && scoreboard.get("Fives") != -1 && scoreboard.get("Sixes") != -1 && scoreboard.get("Three of a kind") != -1 && scoreboard.get("Four of a kind") != -1 && scoreboard.get("Full House") != -1 && scoreboard.get("Small straight") != -1 && scoreboard.get("Large straight") != -1 && scoreboard.get("Chance") != -1 && scoreboard.get("YAHTZEE") != -1 ) {
			return false;
		}
		else return true;
	}
	
	public int Sum() {
		int sum = scoreboard.get("Ones") + scoreboard.get("Twos") + scoreboard.get("Threes") + scoreboard.get("Fours") + scoreboard.get("Fives") + scoreboard.get("Sixes");
		int bonus = sum >= 63 ? 35 : 0;
		return sum + bonus + scoreboard.get("Three of a kind") + scoreboard.get("Four of a kind") + scoreboard.get("Full House") + scoreboard.get("Small straight") + scoreboard.get("Large straight") + scoreboard.get("Chance") + scoreboard.get("YAHTZEE");
	}
	
}
