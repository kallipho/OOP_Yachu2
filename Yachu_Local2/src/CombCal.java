import java.util.Arrays;

public class CombCal {
	static public int CountInt(int[] Dice, int N) { // �迭 Dice �� N�� ������ ����
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int MaxSameEle(int[] Dice) {
		int[] cnt = new int[6];
		for (int x: Dice) {
			cnt[x-1]++;
		}
		Arrays.sort(cnt);
		return cnt[cnt.length-1];
	}
	
	static public int EleSum(int[] Dice) {
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
	
	static public int Combination(int[] Dice, String Comb) {
		switch(Comb) {
		case "Ones":
			return CombCal.CountInt(Dice, 1);
		case "Twos":
			return CombCal.CountInt(Dice, 2);
		case "Threes":
			return CombCal.CountInt(Dice, 3);
		case "Fours":
			return CombCal.CountInt(Dice, 4);
		case "Fives":
			return CombCal.CountInt(Dice, 5);
		case "Sixes":
			return CombCal.CountInt(Dice, 6);
		case "Three of a kind":
			if(CombCal.MaxSameEle(Dice)>=3) {
				return CombCal.MaxSameEle(Dice);
			}
			else {
				return 0;
			}
		case "Four of a kind":
			if(CombCal.MaxSameEle(Dice)>=4) {
				return CombCal.MaxSameEle(Dice);
			}
			else {
				return 0;
			}
		case "Full House":
			Arrays.sort(Dice);
			if(CountInt(Dice, Dice[0]) * CountInt(Dice, Dice[Dice.length-1]) == 6) {//�� �ڵ�� ������ 2, 3Ȥ�� 3, 2�϶��� �����
				return 25;
			}
			else {
				return 0;
			}
		case "Small straight":
			Arrays.sort(Dice);
			if(isAdjust(Dice, 0, 3) || isAdjust(Dice, 1, 4)) {
				return 30;
			}
			else {
				return 0;
			}
		case "Large straight":
			Arrays.sort(Dice);
			if(isAdjust(Dice, 0, 4)) {
				return 40;
			}
			else {
				return 0;
			}
		case "Chance":
			return CombCal.EleSum(Dice);
		case "Yahtzee":
			if(CombCal.MaxSameEle(Dice)==5) {
				return 50;
			}
			else {
				return 0;
			}
		default:
			return -1; //�̷������δ� -1�� ���ϵ� �� ����. CombCal�� �ùٸ� ���� �̸��� ���;� �ν��� �� ����.
		}
	}
	static public void main(String[] args) {
		
	}
}
