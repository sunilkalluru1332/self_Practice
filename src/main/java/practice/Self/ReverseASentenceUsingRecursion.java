package practice.Self;

public class ReverseASentenceUsingRecursion {

	public static void main(String[] args) {

		String sentence = "Go work";
		String reversed = reverse(sentence);
		System.out.println("The reversed sentence is: " + reversed);
	}

	public static String reverse(String sentence) {
		if (sentence.isEmpty()) {
			return sentence;
		}
		
		String abb = reverse(sentence.substring(1)) + sentence.charAt(0);

		return abb;
	}

}
