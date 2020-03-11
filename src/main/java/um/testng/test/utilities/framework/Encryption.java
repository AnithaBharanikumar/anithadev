package um.testng.test.utilities.framework;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryption {
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * String
	 * To encry the password
	 */
	public static String encrypt(String value) {
        try {
        	String key="Bar12345Bar12345";
        	String initVector="RandomInitVector";
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * String
	 * To decrypt the password by taking encryted password as input
	 */
    public static String decrypt(String encrypted) {
        try {
        	String key="Bar12345Bar12345";
        	String initVector="RandomInitVector";
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            //System.out.println(new String(original));
            return new String(original);
         
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        encrypt("");
}

}
