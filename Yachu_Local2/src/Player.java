public class Player {
	private String playerName; // 플레이어 이름
	private Scoreboard scoreboard = new Scoreboard();
	private MultipleDice Dices = new MultipleDice();
	private int rollNum; // 굴릴 수 있는 횟수
	
	Player(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
	}
	
	public void PlayerRollsDices() { // 주사위를 굴림
		--rollNum;
		Dices.RollDices();
	}
	
	public void SetDefaultValue() { // 한 턴마다 초기화해줌(굴릴 수 있는 횟수 2로 초기화, 주사위 기본적으로 1번 굴려짐)
		rollNum = 2;
		Dices.SetDefaultValue();
	}
	
	public void SetRollNumtoZero() { // 더 이상 굴릴 수 없음 (한 턴에서 End 선언할 시 실행)
		rollNum = 0;
	}
	
	private void printBar() { // 출력 참조
		System.out.println("==============================");
	}
	
	private void printScore() { // 점수 출력
		System.out.printf("%s : %d (Bonus : %d)\n", playerName, scoreboard.Sum(), scoreboard.BonusSum());
	}
	
	private static void clearScreen() { // 스크린 초기화
		for(int i=0; i<50; i++) {
			System.out.printf("\n");
		}
	}  
	
	public boolean isEnd() { // 게임이 끝났는지
		return scoreboard.isEnd();
	}
	
	public int getRollNum() { // 지금 굴릴 수 있는 횟수가 몇번 남았는지
		return rollNum;
	}
	
	public void ReverseLockByArray(int SelectList) { // 해당 주사위의 선택 상태 바꾸기
		Dices.ReverseLockByArray(SelectList);
	}
	
	public void Check(String CombName) { // 점수판에 점수 입력
		scoreboard.check(CombName, CombCal.Combination(Dices, CombName));
	}
	
	public boolean isEmpty(String CombName) { // 이 점수 칸에 내가 무언가를 입력했는지, 아니면 그냥 초기 상태인지
		if(scoreboard.isMinusOne(CombName)) return true;
		else return false;
	}
	
	public void printMyGame() { // 모든 출력
		clearScreen();
		scoreboard.printScoreboard(Dices);
		printBar();
		printScore();
		printBar();
		Dices.printEyes();
		Dices.printLocks();
		printBar();
		System.out.printf("%d roll left| 6: Roll | 7: End\n", rollNum);
	}
}
