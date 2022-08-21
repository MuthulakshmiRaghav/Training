package week1.day2;


public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "welcome";
		char ch[] = str.toCharArray();
		int length = str.length();

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

}
