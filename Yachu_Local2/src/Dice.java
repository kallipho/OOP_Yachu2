import java.util.Random;
public class Dice {
	protected int eyes;
	protected boolean kept; //True�� ŵ �Ȱ� 
	
	Dice(){
		this.eyes = 0;
		this.kept = false;
	}
	
	protected void Roll() {
		if(!kept) {
			Random rand = new Random();
			eyes = 1 + rand.nextInt(5); //rand.nextInt(5)�� 0~5���� Int�� ������Ű�� 1�� ���ϸ� 1~6�� ��.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
