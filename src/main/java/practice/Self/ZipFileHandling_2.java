package practice.Self;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileHandling_2 {

	public static void main(String[] args) {

		
		unZipFile();
		

	}
	
	public static void unZipFile() {
		String zipFilename = "";

		// Creating a File object for directory
		File directoryPath = new File(System.getProperty("user.dir") + "\\Temp\\data");
		// List of all files and directories
		String contents[] = directoryPath.list();
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
			if (contents[i].endsWith(".zip")) {
				zipFilename = contents[i];
				break;
			}
		}
		File dir = new File(System.getProperty("user.dir") + "\\Temp\\data\\extract");
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\Temp\\data" + File.separator + zipFilename);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(
						System.getProperty("user.dir") + "\\Temp\\data\\extract" + File.separator + fileName);
				System.out.println("Unzipping to " + newFile.getAbsolutePath());
				// create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
			
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
