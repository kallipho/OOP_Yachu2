import java.util.Random;

public class Dice { //주사위 하나
	private int Eye; //나온 눈
	private boolean isLock; //선택되어서 굴릴지 안 굴릴지
	
	public void Roll() { //주사위 굴리기
		if(!isLock) {
			Random rand = new Random();
			Eye = 1 + rand.nextInt(5);
		}
	}
	
	public void Lock(){ //선택하기	
		isLock = true;
	}
	
	public void Unlock() { //선택 상태 풀기
		isLock = false;
	}
	
	public void ReverseLock() { //선택 상태 바꾸기 (선택이면 선택 안함으로, 선택 안함이면 선택으로)
		isLock = !isLock;
	}
	
	public int getEye() { //눈이 무엇이 나왔는가
		return Eye;
	}
	
	public boolean getIsLock(){ //선택 되었는지 안 되었는지
		return isLock;
	}
	
	Dice(){ //생성자 (rand로 초기값)
		Random rand = new Random();
		this.Eye = 1 + rand.nextInt(5);
		this.isLock = false;
	}
}
