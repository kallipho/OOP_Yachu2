import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); // Justin은 그냥 이름
	
	public int Select() { // 숫자 입력하기
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
	
	public boolean isValidComb(String CombName) { // 이 조합이 현재 주사위 눈들로 만들 수 있는 조합인지를 확인
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
	
	public void Run() { // 게임 실행 
		while(!p1.isEnd()) { // 게임이 끝났는지 확인(한 턴마다 확인)
			p1.SetDefaultValue(); // 턴마다 플레이어 상태 초기화
			while(p1.getRollNum()>0) { // 굴릴 횟수가 0보다 크다면~
				p1.printMyGame(); // 화면 출력
				int userInt = Select(); // 숫자 입력
				if(1<=userInt && userInt<=5) { // 1 ~ 5 입력 시 해당 주사위 상태 바꾸기 
					p1.ReverseLockByArray(userInt);
				}
				else if(userInt == 6) { // 다시 굴리기
					p1.PlayerRollsDices();
				}
				else if(userInt == 7) { // 끝내기 (조합 체크로 넘어감)
					p1.SetRollNumtoZero();
				}
			}
			String userInput; // 조합 이름을 나타냄
			do { 
				p1.printMyGame(); // 화면 출력
				userInput = combSelect(); // 어떤 조합에 점수를 체크할 것인가?
			} while(!isValidComb(userInput));
			p1.Check(userInput); // 점수 체크 (입력)
		}
		p1.printMyGame(); // 마지막 화면 출력
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.Run();
	}
}
