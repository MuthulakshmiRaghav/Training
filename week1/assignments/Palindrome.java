package week1.assignments;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo Code a) Declare A String value as"madam" b) Declare another String rev
		 * value as "" c) Iterate over the String in reverse order d) Add the char into
		 * rev e) Compare the original String with the reversed String, if it is same
		 * then print palinDrome Hint: Use .equals or .equalsIgnoreCase when you compare
		 * a String
		 */

		String word = "madam";
		String rev_Word = "";
		int wordLength = word.length();

		for (int i = wordLength - 1; i >= 0; i--) {
			rev_Word = rev_Word + word.charAt(i);
		}

		if (word.equalsIgnoreCase(rev_Word))
			System.out.println("The word " + word + " is Palindrome");

		else
			System.out.println("The word " + word + " is not Palindrome");
	}

}
