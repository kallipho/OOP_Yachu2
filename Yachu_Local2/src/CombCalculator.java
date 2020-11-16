
public class CombCalculator {
	static public int CountInt(int[] Dice, int N) { // 배열 Dice 안 N의 개수를 세기
		int cnt = 0;
		for (int x: Dice) {
			if(x == N) cnt++;
		}
		return cnt;
	}
	
	static public int Combination(int[] Dice, String Comb) {
		switch(Comb) {
		case "One":
			return CountInt(Dice, 1);
		}
		case "Two":
			
		
	}
	public void main(String[] args) {
		
	}
}
