
public class CombCalculator {
	static public int CountInt(int[] Dice, int N) { // �迭 Dice �� N�� ������ ����
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
