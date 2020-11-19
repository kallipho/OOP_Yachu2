import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임
	
	public int Select() {
		int userChar = 0;
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.length() == 1) {
			userChar = userInput.charAt(0)-'0';
		}
		if(1<=userChar && userChar<=7) {
			return userChar;
		}
		return -1;
	}
	
	public boolean isValidComb(String CombName) {
	for (String x: Scoreboard.combList) {
		if(CombName.equals(x) && p1.isEmpty(CombName)) return true;
		}
	return false;
	}
	
	static public String combSelect() {
		System.out.println("Enter Combination Name");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void Run() {
		while(!p1.isEnd()) {
			p1.SetDefaultValue();
			while(p1.getRollNum()>0) {
				p1.printMyGame();
				int userInt = Select();
				if(1<=userInt && userInt<=5) {
					p1.ReverseLockByArray(userInt);
				}
				else if(userInt == 6) {
					p1.PlayerRollsDices();
				}
				else if(userInt == 7) {
					p1.SetRollNumtoZero();
				}
			}
			String userInput;
			do {
				p1.printMyGame();
				userInput = combSelect();
			} while(!isValidComb(userInput));
			p1.Check(userInput);
		}
		p1.printMyGame();
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.Run();
	}
}
