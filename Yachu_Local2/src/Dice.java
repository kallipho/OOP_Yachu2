import java.util.Random;

public class Dice {
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
	
	public void setDefaultValue() {
		unlock();
		roll();
	}
}