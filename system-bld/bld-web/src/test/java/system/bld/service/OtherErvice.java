package system.bld.service;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/8/25
 * @Time: 15:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class OtherErvice {

	public static void main(String[] args) {

		String pwd= DigestUtils.md5Hex("a83cc221a44a4009a8cdfd5a05cd392c" + "0a113ef6b61820daa5611c870ed8d5ee");

		System.out.println(pwd);
	}
}
