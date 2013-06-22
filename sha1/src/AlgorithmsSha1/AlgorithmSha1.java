package AlgorithmsSha1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JProgressBar;


public class AlgorithmSha1 {
	 public String sha1(String file,JProgressBar progressBar) 
	    {
	        MessageDigest sha1 = null;
			try {
				sha1 = MessageDigest.getInstance("SHA1");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        FileInputStream fis= null;
	        
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	        byte[] data = new byte[1024];
	        int read = 0; 
	        
	        
	        progressBar.setMinimum(0);
	        progressBar.setMaximum(file.length());
	      //  progressBar.setValue(30);
	        try {
				while ((read = fis.read(data)) != -1) {
				    sha1.update(data, 0, read);
				    progressBar.setValue(data.length);
				    
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	        byte[] hashBytes = sha1.digest();
	  
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < hashBytes.length; i++) {
	          sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        String fileHash = sb.toString();
	         
	        return fileHash;
	    }


	
}
	
	
	
	
