import java.util.Arrays;

public class Categories {
	static public int CountIntInArray(int[] Dice, int N) { // 배열 Dice 안 N의 개수를 세기
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int CountMaxSameElement(int[] Dice) { // 배열 Dice 안의 같은 눈을 가진 주사위 수 중 가장 큰 개수 (ex 44421처럼 되어있으면 4가 3개로 제일 많으므로 3을 리턴)
		int[] cnt = new int[6];
		for (int x: Dice) {
			cnt[x-1]++;
		}
		Arrays.sort(cnt);
		return cnt[cnt.length-1];
	}
	
	static public int ArraySum(int[] Dice) { //배열 Dice 안 주사위 눈 총합 리턴
		int cnt = 0;
		for (int x: Dice) {
			cnt += x;
		}
		return cnt;
	}
	
	static public boolean IsAdjustArray(int[] Dice, int S, int E) {//S부터 E까지 인접한지 확인
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
			if(CountIntInArray(intDice, intDice[0]) * CountIntInArray(intDice, intDice[intDice.length-1]) == 6) {//이 코드는 개수가 2, 3혹은 3, 2일때만 통과됨
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
			return -1; //이론적으로는 -1이 리턴될 수 없음. CombCal은 올바른 조합 이름이 들어와야 인식할 수 있음.
		}
	}
}
