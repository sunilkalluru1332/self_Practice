package practice.Self;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.net.ssl.SSLContext;

public class ZipFileHandling {

	public static void main(String[] args) throws IOException {
		
		/*
		 * ZipFile zipFile = new ZipFile("D:\\Practice\\Test.zip");
		 * 
		 * Enumeration<? extends ZipEntry> entries = zipFile.entries();
		 * 
		 * while(entries.hasMoreElements()){ ZipEntry entry = entries.nextElement();
		 * InputStream stream = zipFile.getInputStream(entry);
		 * System.out.println(stream.toString()); }
		 */
		
		
		if(unpackZip("D:\\Practice\\", "Test.zip")) {
			
			System.out.println("Unzipped SuccessFully");
			
		}else {
			System.out.println("Unzipp FAIled");
		}
		
		
		
		
		

	}
	
	private static boolean unpackZip(String path, String zipname)
	{       
	     InputStream is;
	     ZipInputStream zis;
	     try 
	     {
	         is = new FileInputStream(path + zipname);
	         zis = new ZipInputStream(new BufferedInputStream(is));          
	         ZipEntry ze;

	         while((ze = zis.getNextEntry()) != null) 
	         {
	             ByteArrayOutputStream baos = new ByteArrayOutputStream();
	             byte[] buffer = new byte[1024];
	             int count;

	             String filename = ze.getName();
	             FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "\\Temp\\extract" + File.separator + "unzipped");

	             // reading and writing
	             while((count = zis.read(buffer)) != -1) 
	             {
	                 baos.write(buffer, 0, count);
	                 byte[] bytes = baos.toByteArray();
	                 fout.write(bytes);             
	                 baos.reset();
	             }

	             fout.close();               
	             zis.closeEntry();
	         }

	         zis.close();
	     } 
	     catch(IOException e)
	     {
	         e.printStackTrace();
	       return false;
	     }

	    return true;
	}

}
