import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임
	
	static public String combSelect() {
		Scanner sc = new Scanner(System.in);
		String userInput = null;
		while(true) {
		userInput = sc.nextLine();
		for (String x: Scoreboard.combList) {
			if(userInput.equals(x)) return userInput; //코드 수정 완료
			}
		}
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
