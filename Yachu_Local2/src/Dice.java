import java.util.Random;
public class Dice {
	protected int eyes;
	protected boolean kept; //True면 킵 된거 
	
	protected void Roll() {
		if(!kept) {
			Random rand = new Random();
			eyes = 1 + rand.nextInt(5); //rand.nextInt(5)는 0~5까지 Int를 생성시키고 1을 더하면 1~6이 됨.
		}
	}
	
	Dice(){
		Random rand = new Random();
		this.eyes = 1 + rand.nextInt(5); //생성할 때 랜덤으로 초기화
		this.kept = false;
	}
}
