
public class MultipleDice {
	private Dice[] Dices = new Dice[5];
	
	MultipleDice() {
		for(int i=0; i<Dices.length; i++) {
			Dices[i] = new Dice();
		}
	}
	
	public int[] intDices() {
		int[] intDice = new int[5];
		for (int i=0; i<5; i++) {
			intDice[i] = Dices[i].getEye();
		}
		return intDice;
	}
	
	public void RollDices(){
		for(Dice x: Dices) {
			x.Roll();
		}
	}
	
	public void SetDefaultValue() {
		for(Dice x: Dices) {
			x.Unlock();
			x.Roll();
		}
	}
	
	public void ReverseLockByArray(int SelectList) {
		Dices[SelectList-1].ReverseLock();
	}
	
	public void printEyes() {
		for(Dice x: Dices) {
			System.out.printf("%-3d", x.getEye());
		}
		System.out.printf("\n");
	}
	
	public void printLocks() {
		for(Dice x: Dices) {
			if(x.getIsLock()) System.out.printf("%-3s", "бс");
			else System.out.printf("%-3s", "бр");
		}
		System.out.printf("\n");
	}
}
