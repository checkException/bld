package system.bld.service.impl.user;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserLoginLogDao;
import system.bld.model.UserBase;
import system.bld.model.UserLoginLog;
import system.bld.request.user.UserLoginLogReq;
import system.bld.service.user.UserLoginLogService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author litao
 * @date 2021-09-24
 * @Desc
 */
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {

    @Autowired
    UserLoginLogDao userLoginLogDao;

    /**
     * 列表查询
     *
     * @param userLoginLogReq
     * @return
     */
    @Override
    public Page<UserLoginLog> queryPageList(UserLoginLogReq userLoginLogReq) {

        UserLoginLog userLoginLog=new UserLoginLog();

        BeanUtil.copyProperties(userLoginLogReq,userLoginLog);

        Map<String,Object> params=BeanUtil.beanToMap(userLoginLog);

        PageHelper.startPage(userLoginLogReq.getPageNum(),userLoginLogReq.getPageSize());

        Page<UserLoginLog> basePage=(Page<UserLoginLog>) userLoginLogDao.selectPageList(params);

        return basePage;
    }

    @Override
    public List<UserLoginLog> queryListLimit100() {
        return userLoginLogDao.selectListLimit100();
    }

    /**
     * 记录日志
     * @param userLoginLogReq
     * @return
     */
    @Override
    public Boolean saveLoginLog(UserLoginLogReq userLoginLogReq) {

        UserLoginLog userLoginLog=new UserLoginLog();

        BeanUtil.copyProperties(userLoginLogReq,userLoginLog);

        int res=userLoginLogDao.insert(userLoginLog);

        return res>0?Boolean.TRUE:Boolean.FALSE;
    }

}
