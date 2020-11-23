import java.util.HashMap;
import java.util.Map;

public class Scoreboard { //�������� Ŭ����
	private Map<String, Integer> scoreboard = new HashMap<String, Integer>(); //�������� �� ���¸� ������, String (ī������) - Int(��� ����) �����Դϴ�
	static public String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"}; //������ ī�� ���յ�
	static public String[] intCombList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"}; // ���ʽ� ������ ���õ� ���� ���� ������
	
	Scoreboard() {
		for(String x: combList) {
			scoreboard.put(x, -1); //���� �ʱⰪ�� -1 (��� X)
		}
	}
	
	public void check(String combName, int score) { //�����ǿ� ���� �Է�
		scoreboard.replace(combName, score);
	}
	
	public boolean isEnd() { //�������� �� ���� ������ �������� Ȯ��
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x) == -1) return false;
		}
		return true;
	}
	
	public int BonusSum() { //���ʽ� ������ ��� ���ִ� ���� ���� �������� ��
		int subSum = 0;
		for (String x: Scoreboard.intCombList) {
			if(scoreboard.get(x)>-1) subSum += scoreboard.get(x); //-1���̸� �� ���ؾߵ�.
		}
		return subSum;
	}
	
	public int Sum() { //���� ����(���ʽ� ���� ����)
		int sum = 0;
		for (String x: Scoreboard.combList) {
			if(scoreboard.get(x)>-1) sum += scoreboard.get(x);
		}
		return sum + (BonusSum() >= 63 ? 35 : 0); //���� ���� ������ ���� 63�� ������ ���ʽ� ���� 35
	}
	
	public boolean isMinusOne(String CombName) { //�ش� ������ ������ -1���� �ƴ��� (�ʱⰪ���� �ƴ���; �ڽ��� ���� �Է��� �ߴ��� ���ߴ���)
		if (scoreboard.get(CombName)==-1) return true;
		else return false;
	}
	
	public void printScoreboard(MultipleDice Dices) { //������ ���
		for (String x: combList) {
			System.out.printf("%-20s", x);
			if(scoreboard.get(x)==-1) System.out.printf("%-5s", "-");
			else System.out.printf("%-5d", scoreboard.get(x));
			System.out.printf("%-5d\n", CombCal.Combination(Dices, x));
		}
	}
	
}
