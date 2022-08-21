package week1.assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo code
		 * 
		 * a) Use the declared String text as input String text =
		 * "We learn java basics as part of java sessions in java week1"; b) Initialize
		 * an integer variable as count c) Split the String into array and iterate over
		 * it d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. f) if the count > 1 then
		 * replace the word as "" g) Displaying the String without duplicate words
		 * 
		 */

		String text = "We learn java learn basics as part of java sessions in java week1";
		String[] str = text.split(" ");
		int sLength = str.length;

		for (int i = 0; i < sLength; i++) {
			int count = 0;
			{
				for (int j = i+1; j < sLength; j++) {

					if (str[i].equalsIgnoreCase(str[j])) {
						str[j] = "";
						count++;
					}
				}
			}
			if (count > 1) {
				for (int k = 0; k < str.length; k++) {
					System.out.print(str[k] + " ");
				}
			}
		}
	}
}
