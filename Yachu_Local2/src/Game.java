import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임
	
	public int Select() {
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		for(int i=0; i<userInput.length(); i++) {
			int userChar = userInput.charAt(i)-'0';
			if(1<=userChar && userChar<=7) {
				return userChar;
			}
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
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.Run();
	}
}
