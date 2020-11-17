import java.util.Random;

public class Dice {
	private int Eye;
	private boolean isLock;
	
	public void Roll() {
		if(!isLock) {
			Random rand = new Random();
			Eye = 1 + rand.nextInt(5);
		}
	}
	
	public void Lock(){
		isLock = true;
	}
	
	public void Unlock() {
		isLock = false;
	}
	
	public void ReverseLock() {
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
