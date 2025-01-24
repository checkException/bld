package system.common.utils;

import com.baomidou.kisso.common.CookieHelper;
import com.baomidou.kisso.common.encrypt.Algorithm;
import com.baomidou.kisso.common.encrypt.MD5;
import com.baomidou.kisso.common.encrypt.base64.UrlBase64;
import com.baomidou.kisso.exception.KissoException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Key;

/**
 * @author litao
 * @date 2022-06-07
 * @Desc
 */
public class KissoDecryptUtils {
    private final static String ENCODING= "UTF-8";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        /** 相关引用依赖
         <dependency>
             <groupId>com.baomidou</groupId>
             <artifactId>kisso</artifactId>
             <version>3.6.13</version>
         </dependency>
         */

        //生产环境解码key
        String pro_key ="hige51lMBq08sC0j8p";
        //测试环境解码key
        String dev_key ="h2wmABdfM7i3K80sso";

        /**
         * 获取名称为tuid(测试环境)的cookie值（生产环境为uid的cookie值）
         */
        String dev_cookieName="tuid";
        String pro_cookieName="uid";

       /* HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie uid = CookieHelper.findCookieByName(request, dev_cookieName);
        String encryptStr = uid.getValue();*/

        //cookie值的示例
        String encryptStr="d8AZUpWrOsfV1GUYswbdixom5hesDuIqitAKxhHIWjS2333WU8-mFXW_Mjkw8zXKYt0qpT6TpzQ72ao-d6ZV-D0ECWWu5vNskEfx9vwWb1CsW8GBW4SIzQ8BRPKKE-O9uleirT_F_XmJjpevGE6Fc0r6U7KMrX6CBljYgYeeFNqaJTwHKOz-wJNVb0AQm-4.";


        //解码demo2
        System.out.println(decodeMethod2(encryptStr,pro_key));

    }


    public static String decodeMethod2(String encryptStr, String key){

        Algorithm algorithm=Algorithm.RC4;

        String userInfoStr=null;
        try {

            //此处 为 kisso包的 base64工具解码
            byte[] b = decrypt(algorithm, UrlBase64.decode(encryptStr.getBytes(ENCODING)), key);

            userInfoStr = new String(b, "UTF-8").split("#")[0];
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return userInfoStr;
    }

    public static byte[] decrypt(Algorithm algorithm, byte[] data, String key) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm.toString());
            cipher.init(2, toKey(algorithm, key));
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new KissoException(e);
        }
    }

    private static Key toKey(Algorithm algorithm, String strKey) throws Exception {
        byte[] key = MD5.md5Raw(strKey.getBytes(ENCODING));
        return new SecretKeySpec(key, algorithm.getKey());
    }
}
