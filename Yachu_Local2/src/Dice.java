import java.util.Random;

public class Dice {
	private int Eye; //주사위 위에 현재 향해있는 눈
	private boolean IsLock; //주사위가 Keep되어있는지(Keep된 주사위는 다시 굴리지 않음)
	
	public void Roll() {
		if(!IsLock) {
			Random rand = new Random();
			Eye = 1 + rand.nextInt(5);
		}
	}
	
	public void Lock(){
		IsLock = true;
	}
	
	public void Unlock() {
		IsLock = false;
	}
	
	public void ReverseLock() {
		IsLock = !IsLock;
	}
	
	public int GetEye() {
		return Eye;
	}
	
	public boolean GetIsLock(){
		return IsLock;
	}
	
	Dice(){
		Random rand = new Random();
		this.Eye = 1 + rand.nextInt(5);
		this.IsLock = false;
	}
	
	public void SetDefault() {
		Unlock();
		Roll();
	}
}