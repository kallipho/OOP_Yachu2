import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임
	static String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
	
	static public String combSelect() {
		Scanner sc = new Scanner(System.in);
		String userInput = null;
		boolean getout = true; //너도 좀 나가!!!!!!!!!!
		while(getout) {
		userInput = sc.nextLine();
		for (String x: combList) {
			if(userInput.equals(x)) getout = false; //This code looks like s**t. 수정필요.
			}
		}
		return userInput;
	}
	
	public void printMyGame() {
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = p1.dice[i].eyes;
		}
		for (String x: combList) {
			System.out.println(x + " / " + p1.SB.scoreboard.get(x) + " / " + CombCal.Combination(intDice, x));
		}
		System.out.println(intDice[0] + " / " + intDice[1] + " / " + intDice[2] + " / " + intDice[3] + " / " + intDice[4] + " / ");
		for (Dice x: p1.dice) {
			if(x.kept) {
				System.out.print("■ / ");
			}
			else {
				System.out.print("□ / ");
			}
		}
		System.out.println('\r');
	}
	
	public boolean Select() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int userInput = -1;
			printMyGame();
			while(userInput<1 || 7<userInput) {
				userInput = sc.nextInt();
			}
			if(userInput<6) {
				p1.dice[userInput-1].kept = !p1.dice[userInput-1].kept;
			}
			else {
				if(userInput==6) return false;
				else return true;
			}
		}
	}

}
