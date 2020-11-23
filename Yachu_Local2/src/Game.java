import java.util.Scanner;

public class Game {
	public Player p1 = new Player("Justin"); // Justin�� �׳� �̸�
	
	public int Select() { // ���� �Է��ϱ�
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
	
	public boolean isValidComb(String CombName) { // �� ������ ���� �ֻ��� ����� ���� �� �ִ� ���������� Ȯ��
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
	
	public void Run() { // ���� ���� 
		while(!p1.isEnd()) { // ������ �������� Ȯ��(�� �ϸ��� Ȯ��)
			p1.SetDefaultValue(); // �ϸ��� �÷��̾� ���� �ʱ�ȭ
			while(p1.getRollNum()>0) { // ���� Ƚ���� 0���� ũ�ٸ�~
				p1.printMyGame(); // ȭ�� ���
				int userInt = Select(); // ���� �Է�
				if(1<=userInt && userInt<=5) { // 1 ~ 5 �Է� �� �ش� �ֻ��� ���� �ٲٱ� 
					p1.ReverseLockByArray(userInt);
				}
				else if(userInt == 6) { // �ٽ� ������
					p1.PlayerRollsDices();
				}
				else if(userInt == 7) { // ������ (���� üũ�� �Ѿ)
					p1.SetRollNumtoZero();
				}
			}
			String userInput; // ���� �̸��� ��Ÿ��
			do { 
				p1.printMyGame(); // ȭ�� ���
				userInput = combSelect(); // � ���տ� ������ üũ�� ���ΰ�?
			} while(!isValidComb(userInput));
			p1.Check(userInput); // ���� üũ (�Է�)
		}
		p1.printMyGame(); // ������ ȭ�� ���
	}
	
	static public void main(String args[]) {
		Game g = new Game();
		g.Run();
	}
}
