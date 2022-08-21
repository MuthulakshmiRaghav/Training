package week1.day2;

public class FindCharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Good Day";
		int count = 0;

		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'o')
				count++;
		}
		System.out.println(count);
	}

}
