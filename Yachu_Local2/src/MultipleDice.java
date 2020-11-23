
public class MultipleDice { //�ֻ��� 5 ��
	private Dice[] Dices = new Dice[5];
	
	MultipleDice() {
		for(int i=0; i<Dices.length; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public int[] intDices() { //�ֻ��� 5�� �� ����
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = Dices[i].getEye();
		}
		return intDice;
	}
	
	public void RollDices(){ //5�� ��� ������
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].Roll();
		}
	}
	
	public void SetDefaultValue() { //�ʱ�ȭ
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].Unlock();
			Dices[i].Roll();
		}
	}
	
	public void ReverseLockByArray(int SelectList) { //�ֻ��� 1�� ���� ���� �ٲٱ�
		Dices[SelectList-1].ReverseLock();
	}
	
	public void printEyes() { //�ֻ��� 5�� �� ���
		for(Dice x: Dices) {
			System.out.printf("%-3d", x.getEye());
		}
		System.out.printf("\n");
	}
	
	public void printLocks() {//�ֻ��� 5�� ���� ���� ǥ��
		for(Dice x: Dices) {
			if(x.getIsLock()) System.out.printf("%-3s", "��");
			else System.out.printf("%-3s", "��");
		}
		System.out.printf("\n");
	}
}
