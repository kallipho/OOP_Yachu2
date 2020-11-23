import java.util.Random;

class Dice {
	private int Eye;
	private boolean isLock;
	
	public void roll() {
		if(!isLock) {
			Random rand = new Random();
			Eye = 1 + rand.nextInt(5);
		}
	}
	
	public void lock(){
		isLock = true;
	}
	
	public void unlock() {
		isLock = false;
	}
	
	public void reverseLock() {
		isLock = !isLock;
	}
	
	public int getEye() {
		return Eye;
	}
	
	public boolean getIsLock(){
		return isLock;
	}
	
	Dice(){
		Random rand = new Random();
		this.Eye = 1 + rand.nextInt(5);
		this.isLock = false;
	}
}

public class MultipleDice {
	private Dice[] Dices = new Dice[5];
	
	MultipleDice() {
		for(int i=0; i<Dices.length; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public int[] toIntDices() {
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = Dices[i].getEye();
		}
		return intDice;
	}
	
	public int getEye(int n) {
		return Dices[n].getEye();
	}
	
	public void doRollDices(){
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].roll();
		}
	}
	
	public void setDefaultValue() {
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].unlock();
			Dices[i].roll();
		}
	}
	
	public void reverseSelectedDice(int SelectList) {
		Dices[SelectList-1].reverseLock();
	}
}
