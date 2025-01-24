package system.common.utils;


import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author litao
 * @date 2022-06-06
 * @Desc
 */
public class EncryptDemo {


    public static void main(String[] args) {

        String encryptStr="czQNcbOw6hZf0QSueMqkZrvw2ZtxWvHBoq5rfiPGzlAgMuGpkzB8I0A5NnqanjgQuMEglcapzjRHRJ5M0OwpTEaMTh1LLnst8VZdMpe0vRFKFX50JkvaB1RkMKqnJy7VX32jpHXsGctIV-ljp6JHL0n0ARPz_Slt6I0zsoclGvWBdzwtSdGopiVt7VNLJMg.";
        String key ="h2wmABdfM7i3K80sso";
        try {

            byte[] bytesContent = encryptStr.getBytes("UTF-8");

            byte[] bytesKey = key.getBytes("UTF-8");

            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] md5buf = md5.digest(bytesKey);

            Key key1 = new SecretKeySpec(md5buf, "RC4");

            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(2, key1);

//            byte[] bytes64Content = Base64.getDecoder().decode(bytesContent);
            byte[] bytes64Content = Base64Utils.decodeUrlSafe(bytesContent);
            byte[] resultBytes = cipher.doFinal(bytes64Content);

            System.out.println(new String(resultBytes, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
