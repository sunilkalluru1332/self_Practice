package practice.Self;

import java.util.ArrayList;

public class DisplayPrimeNumbersBetweenTwoIntervals {

	public static void main(String[] args) {
		// TODO : a number is prime if it cant be divided by any other number except
		// itself
				
		
		int num = 10;

		int num2 = 50;

		int j;

		boolean flag = false;

		for (j = num; j <= num2; j++) {

			for (int i = 2; i <= j / 2; i++) {

				if (j % i == 0) {

					flag = true;
					break;
				} else {
					flag = false;
				}

			}

			if (flag == true) {
				System.out.printf("%d is NOT Prime", j);
				System.out.println(" ");
			} else if (flag == false){
				System.out.printf("%d PRIME ", j);
				System.out.println(" ");
			}

		}

	}

}
