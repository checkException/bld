package system.bld.utils;

import cn.hutool.core.lang.Dict;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * aes 加解密
 * @Author: LiTao
 * @Date: 2020/4/8
 * @Time: 17:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AesUtils {
	private static String publicKey="litaolitaolitao_";

	/**
	 * 明文字符串（要加密的内容）
	 * @param publicKey 公钥
	 * @param object 要加密的对象
	 * @return
	 */
	public static String encrypt(String publicKey,Object object){

		String content= JSONUtil.toJsonStr(object);

		//加密
		String encrypt = SecureUtil.aes(publicKey.getBytes()).encryptHex(content.getBytes());

		return encrypt;
	}

	/**
	 * 解密
	 * @param publicKey 公钥
	 * @param object 解密对象
	 * @return
	 */
	public static String decrypt(String publicKey,Object object){

		String content= JSONUtil.toJsonStr(object);

		//加密
		String encrypt = SecureUtil.aes(publicKey.getBytes()).decryptStr(content);

		return encrypt;
	}

    public static String encode(byte[] data, String base64Key) throws GeneralSecurityException
    {
        final Key dataKey = new SecretKeySpec(Base64.decodeBase64(base64Key), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, dataKey);
        byte[] encryptData = cipher.doFinal(data);
        return Base64.encodeBase64String(encryptData).replaceAll("\r", "").replaceAll("\n", "");
    }



	public static void main(String[] args) {
		/*Map<String,Object> map=new HashMap<>();

		String encrypt=encrypt(publicKey, Dict.create().set("name","litao").set("age","26"));

		System.out.println(encrypt);

		System.out.println("-- ".concat(decrypt(publicKey,encrypt)));*/

        System.out.println(Base64.encodeBase64String("XGAXicVG5GMBsx5bueOe4w==".getBytes()));

    }
}
