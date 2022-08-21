package week4.day2;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
