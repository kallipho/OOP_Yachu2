import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	//private Scoreboard //Dictionary ����. �� ���ھ�带 ��Ÿ��
	//public void check(String combName) //���� üũ
	//public boolean isEnd() //üũ�� ĭ�� �����ִ��� üũ
	//public int Sum() //���� ������ Return (Bonus ���� ����) 
	
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
