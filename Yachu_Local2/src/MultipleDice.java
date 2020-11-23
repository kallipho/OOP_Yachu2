
public class MultipleDice { //주사위 5 개
	private Dice[] Dices = new Dice[5];
	
	MultipleDice() {
		for(int i=0; i<Dices.length; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public int[] intDices() { //주사위 5개 눈 리턴
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = Dices[i].getEye();
		}
		return intDice;
	}
	
	public void RollDices(){ //5개 모두 굴리기
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].Roll();
		}
	}
	
	public void SetDefaultValue() { //초기화
		for(int i = 0; i < Dices.length; i++) {
			Dices[i].Unlock();
			Dices[i].Roll();
		}
	}
	
	public void ReverseLockByArray(int SelectList) { //주사위 1개 선택 상태 바꾸기
		Dices[SelectList-1].ReverseLock();
	}
	
	public void printEyes() { //주사위 5개 눈 출력
		for(Dice x: Dices) {
			System.out.printf("%-3d", x.getEye());
		}
		System.out.printf("\n");
	}
	
	public void printLocks() {//주사위 5개 선택 상태 표시
		for(Dice x: Dices) {
			if(x.getIsLock()) System.out.printf("%-3s", "■");
			else System.out.printf("%-3s", "□");
		}
		System.out.printf("\n");
	}
}
