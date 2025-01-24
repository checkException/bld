package system.bld.aop;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author litao
 * @date 2021-01-26
 * @Desc aop  日志打印
 */
@Aspect
@Component
public class ApiLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ApiLogAspect.class);

    /**
     * 切入点描述 这个是controller包的切入点
     * controllerLog() 签名，可以理解成这个切入点的一个名称
     */
    @Pointcut("execution(public * system.bld.controller..*.*(..))")
    public void controllerLog(){}

    /**
     * 在切入点的方法run之前要干的
     * @param proceedingJoinPoint
     */
    @Around("controllerLog()")
    public Object doControllerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 计算action method执行方法
        long startTime = System.currentTimeMillis();
        long executionTime = 0L;

        Object[] args= proceedingJoinPoint.getArgs();

        for (Object o:args) {
            if(o instanceof HttpServletRequest){

            }else if(o instanceof HttpServletResponse){

            }else{
                logger.info("controller.args:{}", JSON.toJSONString(o));
            }
        }
        //让目标方法执行
        Object result = proceedingJoinPoint.proceed();

        executionTime = System.currentTimeMillis() - startTime;

        logger.info("controller.spend:{}",executionTime);
        //移除进程唯一id
        MDC.remove("apiTraceId");

        return result;

    }



/**
     * 在切入点的方法run之前要干的
     * @param throwable
     *//*

    @AfterThrowing(throwing = "throwable",value = "controllerLog()")
    public void doControllerErrorAround(Throwable throwable){

        logger.info("error:{}",throwable.getMessage());
        logger.error("error:"+throwable);

    }
*/

}
