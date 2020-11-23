public class Player {
	private String playerName; // �÷��̾� �̸�
	private Scoreboard scoreboard = new Scoreboard();
	private MultipleDice Dices = new MultipleDice();
	private int rollNum; // ���� �� �ִ� Ƚ��
	
	Player(String Name) {
		this.playerName = Name;
		this.rollNum = 2;
	}
	
	public void PlayerRollsDices() { // �ֻ����� ����
		--rollNum;
		Dices.RollDices();
	}
	
	public void SetDefaultValue() { // �� �ϸ��� �ʱ�ȭ����(���� �� �ִ� Ƚ�� 2�� �ʱ�ȭ, �ֻ��� �⺻������ 1�� ������)
		rollNum = 2;
		Dices.SetDefaultValue();
	}
	
	public void SetRollNumtoZero() { // �� �̻� ���� �� ���� (�� �Ͽ��� End ������ �� ����)
		rollNum = 0;
	}
	
	private void printBar() { // ��� ����
		System.out.println("==============================");
	}
	
	private void printScore() { // ���� ���
		System.out.printf("%s : %d (Bonus : %d)\n", playerName, scoreboard.Sum(), scoreboard.BonusSum());
	}
	
	private static void clearScreen() { // ��ũ�� �ʱ�ȭ
		for(int i=0; i<50; i++) {
			System.out.printf("\n");
		}
	}  
	
	public boolean isEnd() { // ������ ��������
		return scoreboard.isEnd();
	}
	
	public int getRollNum() { // ���� ���� �� �ִ� Ƚ���� ��� ���Ҵ���
		return rollNum;
	}
	
	public void ReverseLockByArray(int SelectList) { // �ش� �ֻ����� ���� ���� �ٲٱ�
		Dices.ReverseLockByArray(SelectList);
	}
	
	public void Check(String CombName) { // �����ǿ� ���� �Է�
		scoreboard.check(CombName, CombCal.Combination(Dices, CombName));
	}
	
	public boolean isEmpty(String CombName) { // �� ���� ĭ�� ���� ���𰡸� �Է��ߴ���, �ƴϸ� �׳� �ʱ� ��������
		if(scoreboard.isMinusOne(CombName)) return true;
		else return false;
	}
	
	public void printMyGame() { // ��� ���
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
