import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); //참고로 Justin은 내 이름임
	
	static public String combSelect() {
		String[] combList = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a kind", "Four of a kind", "Full house", "Small straight", "Large straight", "Chance", "Yahtzee"};
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
	
	static String SB_toString(Dice[] dices) {
		String str = "";
		for(int i=0; i<5; i++) {
			str += (i+1) + ":";
			if(dices[i].kept) str+="■";
			else str+="□";
			str += "|";
		}
		str += "6:Roll Again|7:No more Roll";
		return str;
	}
	
	public boolean Select() {
		System.out.println(Game.SB_toString(p1.dice));
		Scanner sc = new Scanner(System.in);
		//TODO userInput이 1과 7사이 정수인지 확인하는 코드 추가 필요
		int userInput = sc.nextInt();
		if(userInput<6) {
			p1.dice[userInput-1].kept = !p1.dice[userInput-1].kept;
		}
		else if(userInput == 6) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
