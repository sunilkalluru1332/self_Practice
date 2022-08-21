package practice.Self;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileHandling_Final {

	static String zipFileName;
	static String testFile;

	public static void main(String[] args) {

		File zipPath = new File(System.getProperty("user.dir") + "\\temp\\data");

		String[] fileList = zipPath.list();

		for (String i : fileList) {
			System.out.println(i);

			if (i.endsWith("zip")) {
				zipFileName = i;
				break;

			}

		}

		System.out.println(zipFileName);

		File extractLocation = new File(System.getProperty("user.dir") + "\\temp\\data\\extract");

		if (!extractLocation.exists()) {
			extractLocation.mkdirs();
			System.out.println("Created");
		} else {
			System.out.println("No need");
		}

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\temp\\data" + File.separator + zipFileName);

			ZipInputStream zis = new ZipInputStream(fis);

			while (zis != null) {
				String fileName = zis.getNextEntry().getName();
				if (fileName.contains("manifest")) {
					testFile = fileName;
					break;
				}
			}

			File needFile = new File(
					System.getProperty("user.dir") + "\\temp\\data\\extract" + File.separator + testFile);

			FileOutputStream fos = new FileOutputStream(needFile);
			byte[] data = zis.readAllBytes();
			fos.write(data);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
