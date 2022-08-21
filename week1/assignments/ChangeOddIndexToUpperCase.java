package week1.assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo Code Declare String Input as Follow String test = "changeme"; a)
		 * Convert the String to character array b) Traverse through each character
		 * (using loop) c)find the odd index within the loop (use mod operator) d)within
		 * the loop, change the character to uppercase, if the index is odd else don't
		 * change
		 */

		String word = "changeme"; // input declaration

		char[] wordChar = word.toCharArray(); // covert the String into char array
		int wordLength = word.length();

		for (int i = 0; i < wordLength - 1; i++) {
			if (i % 2 == 0)
				wordChar[i] = Character.toUpperCase(wordChar[i]);
		}
		System.out.print(wordChar);
	}

}
