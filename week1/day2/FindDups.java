package week1.day2;

import java.util.Arrays;

public class FindDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 22, 23, 66, 55, 6373, 5364, 88, 88, 99, 99, 398, 2219, 82, 0, 45, 37 };

		Arrays.sort(numbers);
		int length = numbers.length;
		System.out.println("Length of the Array " + length);

		for (int i = 0; i < length - 1; i++) {
			if (numbers[i] == numbers[i + 1])
				System.out.println("The duplicate number is " + numbers[i]);
		}
	}

}
