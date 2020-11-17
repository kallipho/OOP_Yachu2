import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임

	public void printMyGame() {
		for (String x: Scoreboard.combList) {
			System.out.printf("%-20s", x);
			if(p1.SB.scoreboard.get(x)==-1) System.out.printf("%-5s", "-");
			else System.out.printf("%-5d", p1.SB.scoreboard.get(x));
			System.out.printf("%-5d\n", CombCal.Combination(p1.dice, x));
		}
		System.out.printf("==============================\n");	
		System.out.printf("%-3d%-3d%-3d%-3d%-3d\n", p1.dice[0].eyes, p1.dice[1].eyes, p1.dice[2].eyes, p1.dice[3].eyes, p1.dice[4].eyes);
		System.out.printf("%-3s%-3s%-3s%-3s%-3s\n", p1.dice[0].kept?"■":"□",p1.dice[1].kept?"■":"□",p1.dice[2].kept?"■":"□",p1.dice[3].kept?"■":"□",p1.dice[4].kept?"■":"□");
		System.out.printf("%d roll left| 6: Roll | 7: End\n", p1.rollNum);
		System.out.printf("==============================\n");	
	}
	
	public void printMyDice() {	
		System.out.printf("%-3d%-3d%-3d%-3d%-3d\n", p1.dice[0].eyes, p1.dice[1].eyes, p1.dice[2].eyes, p1.dice[3].eyes, p1.dice[4].eyes);
		System.out.printf("%-3s%-3s%-3s%-3s%-3s\n", p1.dice[0].kept?"■":"□",p1.dice[1].kept?"■":"□",p1.dice[2].kept?"■":"□",p1.dice[3].kept?"■":"□",p1.dice[4].kept?"■":"□");
		System.out.printf("%d roll left| 6: Roll | 7: End\n", p1.rollNum);
		System.out.printf("==============================\n");
	}
	
	public boolean Select() {
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		while(true) {
			do {
				userInput = sc.nextInt();
			} while(!(1<=userInput && userInput<=7));
			if(userInput<=5) {
				p1.dice[userInput-1].kept = !p1.dice[userInput-1].kept; //Keep 혹은 Unkeep 반전
				printMyDice();
			}
			else {
				if(userInput==6) return true;
				else return false;
			}
		}
	}
	
	static public String combSelect() {
		System.out.println("Enter Combination Name");
		Scanner sc = new Scanner(System.in);
		String userInput = null;
		while(true) {
		userInput = sc.nextLine();
		for (String x: Scoreboard.combList) {
			if(userInput.equals(x)) return userInput;
			}
			System.out.println("Invalid Combination Name!");
		}
	}
	
	public void Run() {
		while(!p1.SB.isEnd()) {
			p1.resetRollNum();
			p1.rollDices();
			printMyGame();
			while(p1.rollNum>0 && Select()) {
				p1.rollDices();
				printMyGame();
			}
			String userInput = combSelect();	
			p1.SB.check(userInput, CombCal.Combination(p1.dice, userInput));
			p1.resetDiceKeeps();
		}
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.Run();
	}
}
