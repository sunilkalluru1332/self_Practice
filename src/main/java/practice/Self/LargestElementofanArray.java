package practice.Self;

import java.lang.reflect.Array;

public class LargestElementofanArray {

	public static void main(String[] args) {
		double[] numbers = {10,20,-13,12.5,16,20.02,0.1,37,39};
		
		double large = 0;
		
		for(double i:numbers) {
			if(i >= large) {
				large = i;
			}
			
		}
		
		System.out.println(large);
	}

}
