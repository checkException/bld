package system.common.utils;

import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author litao
 * @date 2021-04-19
 * @Desc
 */
public class BeanConvertUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanConvertUtils.class);

    public BeanConvertUtils() {
    }


    public static <T> List<T> convertList(Collection sourceList, Class<T> destinationClass) {
        if (sourceList == null) {
            return null;
        } else {
            List<T> destinationList = new ArrayList();
            Iterator i$ = sourceList.iterator();

            while(i$.hasNext()) {

                Object sourceObject = i$.next();

                T destinationObject = BeanUtil.copyProperties(sourceObject,destinationClass);

                destinationList.add(destinationObject);
            }

            return destinationList;
        }
    }

}
