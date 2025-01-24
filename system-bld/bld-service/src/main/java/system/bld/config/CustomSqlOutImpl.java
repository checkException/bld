package system.bld.config;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * @author litao
 * @date 2021-08-30
 * @Desc 打印SQL 语句，SQL不完整，如要取消 可注释properties中 mybatis-plus.configuration.log-impl
 */
public class CustomSqlOutImpl implements Log {

    public CustomSqlOutImpl() {
    }

    public CustomSqlOutImpl(String log) {
        //Logger logger = LoggerFactory.getLogger(log);
        //System.out.println(log);
        //System.out.println(logger instanceof LocationAwareLogger);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable throwable) {

    }

    @Override
    public void error(String s) {
    }

    @Override
    public void debug(String s) {
        if(s.startsWith("==>  Preparing:")){
            System.out.println("CustomSqlOutImpl.debug:"+s);
        }else if(s.startsWith("==> Parameters:")){
            System.out.println("CustomSqlOutImpl.debug:"+s);
        }

    }

    @Override
    public void trace(String s) {

    }

    @Override
    public void warn(String s) {
    }
}
