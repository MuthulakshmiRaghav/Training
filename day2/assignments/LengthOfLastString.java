package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLastString {

	public static void main(String[] args) {

		/*
		 * Given a string s consisting of words and spaces, return the length of the
		 * last word in the string. A word is a maximal substring consisting of
		 * non-space characters only.
		 * 
		 * Example 1: Input: s = "Hello World" Output: 5 Explanation: The last word is
		 * "World" with length 5. Example 2: Input: s = "   fly me   to   the moon  "
		 * Output: 4 Explanation: The last word is "moon" with length 4.
		 * 
		 */

		// Declare the input and split the String
		String str = "fly me to the moon";
		String[] input = str.split(" ");

		// Declare a List and add the String into the list
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {
			list.add(input[i]);
		}
		System.out.println(list);
		
		// Get the last word of the input and get the length of the same
		String lastWord = list.get(input.length - 1);
		System.out.println("Last Word in the String: " + lastWord);
		System.out.println("Length of the Last word: " + lastWord.length());

	}

}
