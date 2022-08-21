package week1.day2;

import java.util.Arrays;

public class FindMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 232, 398, 2219, 82, 0, 45, 37 };
		int length = numbers.length;
		System.out.println("Total values " + length);

		Arrays.sort(numbers);

		System.out.println("Minimum Number is " + numbers[0]);
		System.out.println("Max num is " + numbers[length - 1]);
	}

}
