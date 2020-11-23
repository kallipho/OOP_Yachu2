import java.util.HashMap;
import java.util.Map;

public class Scoreboard { //점수판의 클래스
	private Map<String, Integer> scoreboard = new HashMap<String, Integer>(); //점수판은 맵 형태를 가지며, String (카드조합) - Int(얻는 점수) 형태입니다
	static public String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"}; //가능한 카드 조합들
	static public String[] intCombList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"}; // 보너스 점수에 관련된 여섯 가지 점수들
	
	Scoreboard() {
		for(String x: combList) {
			scoreboard.put(x, -1); //점수 초기값은 -1 (출력 X)
		}
	}
	
	public void check(String combName, int score) { //점수판에 점수 입력
		scoreboard.replace(combName, score);
	}
	
	public boolean isEnd() { //점수판이 다 차서 게임이 끝났는지 확인
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x) == -1) return false;
		}
		return true;
	}
	
	public int BonusSum() { //보너스 점수를 얻게 해주는 여섯 가지 점수들의 합
		int subSum = 0;
		for (String x: Scoreboard.intCombList) {
			if(scoreboard.get(x)>-1) subSum += scoreboard.get(x); //-1점이면 안 더해야됨.
		}
		return subSum;
	}
	
	public int Sum() { //점수 총합(보너스 점수 포함)
		int sum = 0;
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x)>-1) sum += scoreboard.get(x);
		}
		return sum + (BonusSum() >= 63 ? 35 : 0); //여섯 가지 점수의 합이 63이 넘으면 보너스 점수 35
	}
	
	public boolean isMinusOne(String CombName) { //해당 조합의 점수가 -1인지 아닌지 (초기값인지 아닌지; 자신이 점수 입력을 했는지 안했는지)
		if (scoreboard.get(CombName)==-1) return true;
		else return false;
	}
	
	public void printScoreboard(MultipleDice Dices) { //점수판 출력
		for (String x: combList) {
			System.out.printf("%-20s", x);
			if(scoreboard.get(x)==-1) System.out.printf("%-5s", "-");
			else System.out.printf("%-5d", scoreboard.get(x));
			System.out.printf("%-5d\n", CombCal.Combination(Dices, x));
		}
	}
	
}
