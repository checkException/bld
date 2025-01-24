package system.bld.service.impl.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import system.bld.service.user.UserOperatorService;

/**
 * @author litao
 * @date 2021-09-27
 * @Desc
 */
@Service
public class UserOperatorServiceImpl implements UserOperatorService {
    private  static  final Logger logger= LoggerFactory.getLogger(UserOperatorServiceImpl.class);

    @Override
    public void operatorRecord() {

        logger.info("操作记录");
    }
}
