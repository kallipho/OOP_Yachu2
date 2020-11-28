import java.util.Random;

public class Dice {
	private int Eye; //�ֻ��� ���� ���� �����ִ� ��
	private boolean IsLock; //�ֻ����� Keep�Ǿ��ִ���(Keep�� �ֻ����� �ٽ� ������ ����)
	
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