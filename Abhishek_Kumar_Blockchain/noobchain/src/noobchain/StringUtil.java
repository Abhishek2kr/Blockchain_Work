package noobchain;
import java.security.MessageDigest;


public class StringUtil {

	// Applies Sha256 to a string and returns the result.
	public static String applySha256(String input) {
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//Applies sha 256 to our output
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			// This will contain hash as hexadecimal
			StringBuffer hexString = new StringBuffer();
			for(int i = 0; i < hash.length; i++) {
				 String hex = Integer.toHexString(0xff & hash[i]);
				 if(hex.length() == 1) hexString.append('0');
				 hexString.append(hex);
				
			}
			
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}