import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임

	public void printMyGame() {
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = p1.dice[i].eyes;
		}
		System.out.printf("====================\n");
		for (String x: Scoreboard.combList) {
			System.out.printf("%-20s%-5d%-5d\n", x, p1.SB.scoreboard.get(x), CombCal.Combination(intDice, x));
		}
		System.out.printf("====================\n");	
		System.out.printf("%-3d%-3d%-3d%-3d%-3d\n", intDice[0], intDice[1], intDice[2], intDice[3], intDice[4]);
		System.out.printf("%-3s%-3s%-3s%-3s%-3s\n", p1.dice[0].kept?"■":"□",p1.dice[1].kept?"■":"□",p1.dice[2].kept?"■":"□",p1.dice[3].kept?"■":"□",p1.dice[4].kept?"■":"□");
	}
	
	public boolean Select() {
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		while(true) {
			printMyGame();
			while(userInput<1 || 7<userInput) {
				userInput = sc.nextInt();
			}
			if(userInput<6) {
				p1.dice[userInput-1].kept = !p1.dice[userInput-1].kept; //Keep 혹은 Unkeep 반전
			}
			else {
				if(userInput==6) return false;
				else return true;
			}
		}
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.printMyGame();
	}
}
