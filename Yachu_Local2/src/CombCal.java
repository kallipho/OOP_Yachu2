import java.util.Arrays;

public class CombCal {
	static public int CountInt(int[] Dice, int N) { // 배열 Dice 안 N의 개수를 세기
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
			if(CombCal.MaxSameEle(Dice)==3) {
				if(Arrays.sort(Dice);)
			}
	}
	static public void main(String[] args) {
		
	}
}
