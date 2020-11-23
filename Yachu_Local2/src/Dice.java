import java.util.Random;

public class Dice { //�ֻ��� �ϳ�
	private int Eye; //���� ��
	private boolean isLock; //���õǾ ������ �� ������
	
	public void Roll() { //�ֻ��� ������
		if(!isLock) {
			Random rand = new Random();
			Eye = 1 + rand.nextInt(5);
		}
	}
	
	public void Lock(){ //�����ϱ�	
		isLock = true;
	}
	
	public void Unlock() { //���� ���� Ǯ��
		isLock = false;
	}
	
	public void ReverseLock() { //���� ���� �ٲٱ� (�����̸� ���� ��������, ���� �����̸� ��������)
		isLock = !isLock;
	}
	
	public int getEye() { //���� ������ ���Դ°�
		return Eye;
	}
	
	public boolean getIsLock(){ //���� �Ǿ����� �� �Ǿ�����
		return isLock;
	}
	
	Dice(){ //������ (rand�� �ʱⰪ)
		Random rand = new Random();
		this.Eye = 1 + rand.nextInt(5);
		this.isLock = false;
	}
}
