import java.util.Arrays;

public class CombCal {
	static public int CountInt(int[] Dice, int N) { // �迭 Dice �� N�� ������ ����
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int MaxSameEle(int[] Dice) { // �迭 Dice ���� ���� ���� ���� �ֻ��� �� �� ���� ū ���� (ex 44421ó�� �Ǿ������� 4�� 3���� ���� �����Ƿ� 3�� ����)
		int[] cnt = new int[6];
		for (int x: Dice) {
			cnt[x-1]++;
		}
		Arrays.sort(cnt);
		return cnt[cnt.length-1];
	}
	
	static public int EleSum(int[] Dice) { //�迭 Dice �� �ֻ��� �� ���� ����
		int cnt = 0;
		for (int x: Dice) {
			cnt += x;
		}
		return cnt;
	}
	
	static public boolean isAdjust(int[] Dice, int S, int E) {//S���� E���� �������� Ȯ��
		for(int i=S; i<=E; i++) {
			if(Dice[i] != Dice[i-1]+1) return false;
		}
		return true;
	}
	
	static public int Combination(MultipleDice Dices, String Comb) {
		int[] intDice = new int[5];
		intDice = Dices.toIntDices();
		switch(Comb) {
		case "Ones":
			return 1*CombCal.CountInt(intDice, 1);
		case "Twos":
			return 2*CombCal.CountInt(intDice, 2);
		case "Threes":
			return 3*CombCal.CountInt(intDice, 3);
		case "Fours":
			return 4*CombCal.CountInt(intDice, 4);
		case "Fives":
			return 5*CombCal.CountInt(intDice, 5);
		case "Sixes":
			return 6*CombCal.CountInt(intDice, 6);
		case "Three of a kind":
			if(CombCal.MaxSameEle(intDice)>=3) {
				return CombCal.EleSum(intDice);
			}
			else {
				return 0;
			}
		case "Four of a kind":
			if(CombCal.MaxSameEle(intDice)>=4) {
				return CombCal.EleSum(intDice);
			}
			else {
				return 0;
			}
		case "Full house":
			Arrays.sort(intDice);
			if(CountInt(intDice, intDice[0]) * CountInt(intDice, intDice[intDice.length-1]) == 6) {//�� �ڵ�� ������ 2, 3Ȥ�� 3, 2�϶��� �����
				return 25;
			}
			else {
				return 0;
			}
		case "Small straight":
			Arrays.sort(intDice);
			if(isAdjust(intDice, 1, 3) || isAdjust(intDice, 2, 4)) {
				return 30;
			}
			else {
				return 0;
			}
		case "Large straight":
			Arrays.sort(intDice);
			if(isAdjust(intDice, 1, 4)) {
				return 40;
			}
			else {
				return 0;
			}
		case "Chance":
			return CombCal.EleSum(intDice);
		case "Yahtzee":
			if(CombCal.MaxSameEle(intDice)==5) {
				return 50;
			}
			else {
				return 0;
			}
		default:
			return -1; //�̷������δ� -1�� ���ϵ� �� ����. CombCal�� �ùٸ� ���� �̸��� ���;� �ν��� �� ����.
		}
	}
}
