package practice.Self;

public class DisplayFibonacciSeries {

	public static void main(String[] args) {

		System.out.println(fibonacci());

	}

	public static int fibonacci() {

		int first = 0;
		int second = 1;

		int fibn = 0;

		while (fibn <= 100) {

			fibn = first + second;

			first = second;
			second = fibn;

		}
		return fibn;
	}
}
