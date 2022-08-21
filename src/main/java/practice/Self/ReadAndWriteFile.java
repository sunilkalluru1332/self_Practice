package practice.Self;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteFile {

	

	public static void main(String[] args) {
		
		File cars = new File(System.getProperty("user.dir")+"//IOfile//cars.txt");
		
		try {
			FileInputStream fis = new FileInputStream(cars);
			
		
			
			System.out.println(fis.available());
			
			byte[] data = fis.readAllBytes();
			
			System.out.println(data.length);
			
			
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//IOfile//carsP.txt");
			
			
				fos.write(data);				
	
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
