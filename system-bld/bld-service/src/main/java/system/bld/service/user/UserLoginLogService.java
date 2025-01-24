package system.bld.service.user;

import com.github.pagehelper.Page;
import system.bld.model.UserLoginLog;
import system.bld.request.user.UserLoginLogReq;

import java.util.List;


/**
 * @author litao
 * @date 2021-09-24
 * @Desc
 */
public interface UserLoginLogService {

    /**
     * 列表查询
     * @param userLoginLogReq
     * @return
     */
    Page<UserLoginLog> queryPageList(UserLoginLogReq userLoginLogReq);

    List<UserLoginLog> queryListLimit100();

    /**
     * 记录日志
     * @param userLoginLogReq
     * @return
     */
    Boolean saveLoginLog(UserLoginLogReq userLoginLogReq);
}
