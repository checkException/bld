package system.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author litao
 * @date 2020-12-02
 * @Desc
 */
public class UUIDUtils {

    private static int RANDOM_LENGTH = 7;

    public UUIDUtils() {
    }

    public static String randomID(String scenecode) {
        String result = StringUtils.isBlank(scenecode) ? "" : scenecode;
        result = scenecode.concat(DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
        Random random = new Random();
        String randomNum = String.valueOf(random.nextInt(10000000));
        int zeroLength = RANDOM_LENGTH - randomNum.length();
        if (zeroLength > 0) {
            for(int i = 0; i < zeroLength; ++i) {
                result = result.concat("0");
            }
        }

        result = result.concat(randomNum);
        return result;
    }

    public static String randomID() {
        return randomID("");
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
