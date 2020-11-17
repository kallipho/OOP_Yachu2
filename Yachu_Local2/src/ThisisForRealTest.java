//테스트는 하고 싶은데 Github Branch 만들 줄 몰라서 만든 클래스
//테스트 용도로만 쓰고 최종 릴리즈 때 삭제할거임
public class ThisisForRealTest {

	public static void main(String[] args) {
		int[] surrogates = {0xD83D, 0xDC7D};
		String alienEmojiString = new String(surrogates, 0, surrogates.length);
		System.out.println(alienEmojiString);
		System.out.println("\uD83D\uDC7D");
	}

}
