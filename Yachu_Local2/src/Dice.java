import java.util.Random;
public class Dice {
	protected int eyes;
	protected boolean kept; //True면 킵 된거 
	
	Dice(){
		this.eyes = 0;
		this.kept = false;
	}
	
	protected void Roll() {
		if(!kept) {
			Random rand = new Random();
			eyes = 1 + rand.nextInt(5); //rand.nextInt(5)는 0~5까지 Int를 생성시키고 1을 더하면 1~6이 됨.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
