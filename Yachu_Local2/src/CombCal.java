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
	
	static public boolean isAdjust(int[] Dice, int S, int E) {//S부터 E까지 인접한지 확인
		for(int i=1; i<Arr.length; i++) {
			if(Arr[i] != Arr[i-1]+1) return false;
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
			if(CountInt(Dice, Dice[0]) * CountInt(Dice, Dice[Dice.length-1]) == 6) {//이 코드는 개수가 2, 3혹은 3, 2일때만 통과됨
				return 25;
			}
			else {
				return 0;
			}
		}
		case "Small straight":
			Arrays.sort(Dice);
			if(isAdjust(Dice.))
	}
	static public void main(String[] args) {
		
	}
}
