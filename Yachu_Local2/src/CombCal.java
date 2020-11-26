import java.util.Arrays;

public class CombCal {
	static public int CountInt(int[] Dice, int N) { // 배열 Dice 안 N의 개수를 세기
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int MaxSameEle(int[] Dice) { // 배열 Dice 안의 같은 눈을 가진 주사위 수 중 가장 큰 개수 (ex 44421처럼 되어있으면 4가 3개로 제일 많으므로 3을 리턴)
		int[] cnt = new int[6];
		for (int x: Dice) {
			cnt[x-1]++;
		}
		Arrays.sort(cnt);
		return cnt[cnt.length-1];
	}
	
	static public int EleSum(int[] Dice) { //배열 Dice 안 주사위 눈 총합 리턴
		int cnt = 0;
		for (int x: Dice) {
			cnt += x;
		}
		return cnt;
	}
	
	static public boolean isAdjust(int[] Dice, int S, int E) {//S부터 E까지 인접한지 확인
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
			if(CountInt(intDice, intDice[0]) * CountInt(intDice, intDice[intDice.length-1]) == 6) {//이 코드는 개수가 2, 3혹은 3, 2일때만 통과됨
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
			return -1; //이론적으로는 -1이 리턴될 수 없음. CombCal은 올바른 조합 이름이 들어와야 인식할 수 있음.
		}
	}
}
