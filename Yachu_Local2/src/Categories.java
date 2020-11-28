import java.util.Arrays;

public class Categories {
	static public int CountIntInArray(int[] Dice, int N) { // �迭 Dice �� N�� ������ ����
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int CountMaxSameElement(int[] Dice) { // �迭 Dice ���� ���� ���� ���� �ֻ��� �� �� ���� ū ���� (ex 44421ó�� �Ǿ������� 4�� 3���� ���� �����Ƿ� 3�� ����)
		int[] cnt = new int[6];
		for (int x: Dice) {
			cnt[x-1]++;
		}
		Arrays.sort(cnt);
		return cnt[cnt.length-1];
	}
	
	static public int ArraySum(int[] Dice) { //�迭 Dice �� �ֻ��� �� ���� ����
		int cnt = 0;
		for (int x: Dice) {
			cnt += x;
		}
		return cnt;
	}
	
	static public boolean IsAdjustArray(int[] Dice, int S, int E) {//S���� E���� �������� Ȯ��
		for(int i=S; i<=E; i++) {
			if(Dice[i] != Dice[i-1]+1) return false;
		}
		return true;
	}
	
	static public int ScoreCalculator(Dice[] Dices, String Comb) {
		int[] intDice = new int[5];
		for(int i=0; i<5; i++) {
			intDice[i] = Dices[i].GetEye();
		}
		switch(Comb) {
		case "Ones":
			return 1*Categories.CountIntInArray(intDice, 1);
		case "Twos":
			return 2*Categories.CountIntInArray(intDice, 2);
		case "Threes":
			return 3*Categories.CountIntInArray(intDice, 3);
		case "Fours":
			return 4*Categories.CountIntInArray(intDice, 4);
		case "Fives":
			return 5*Categories.CountIntInArray(intDice, 5);
		case "Sixes":
			return 6*Categories.CountIntInArray(intDice, 6);
		case "Three of a kind":
			if(Categories.CountMaxSameElement(intDice)>=3) {
				return Categories.ArraySum(intDice);
			}
			else {
				return 0;
			}
		case "Four of a kind":
			if(Categories.CountMaxSameElement(intDice)>=4) {
				return Categories.ArraySum(intDice);
			}
			else {
				return 0;
			}
		case "Full house":
			Arrays.sort(intDice);
			if(CountIntInArray(intDice, intDice[0]) * CountIntInArray(intDice, intDice[intDice.length-1]) == 6) {//�� �ڵ�� ������ 2, 3Ȥ�� 3, 2�϶��� �����
				return 25;
			}
			else {
				return 0;
			}
		case "Small straight":
			Arrays.sort(intDice);
			if(IsAdjustArray(intDice, 1, 3) || IsAdjustArray(intDice, 2, 4)) {
				return 30;
			}
			else {
				return 0;
			}
		case "Large straight":
			Arrays.sort(intDice);
			if(IsAdjustArray(intDice, 1, 4)) {
				return 40;
			}
			else {
				return 0;
			}
		case "Chance":
			return Categories.ArraySum(intDice);
		case "Yahtzee":
			if(Categories.CountMaxSameElement(intDice)==5) {
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
