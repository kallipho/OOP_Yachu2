import java.util.Random;
public class Dice {
	protected int eyes;
	protected boolean kept; //True�� ŵ �Ȱ� 
	
	protected void Roll() {
		if(!kept) {
			Random rand = new Random();
			eyes = 1 + rand.nextInt(5); //rand.nextInt(5)�� 0~5���� Int�� ������Ű�� 1�� ���ϸ� 1~6�� ��.
		}
	}
	
	Dice(){
		Random rand = new Random();
		this.eyes = 1 + rand.nextInt(5); //������ �� �������� �ʱ�ȭ
		this.kept = false;
	}
}
