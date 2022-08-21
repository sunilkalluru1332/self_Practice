package practice.Self;

public class NumberIsPrimeOrNot {

	public static void main(String[] args) {

//		We call a number as prime when it not divded by any other number except 1 and itself

		int num = 31;
		boolean flag = true;

		for (int i = 2; i <= num / 2; i++) {

			if (num % i == 0) {

				flag = false;
				break;

			}

		}

		if (flag) {
			System.out.printf("The number %d is a PRIME number ", num);
		} else {
			System.out.printf("The number %d is NOT a prime number ", num);

		}

	}

}
