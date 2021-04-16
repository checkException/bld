package system.bld.service.impl.user;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserPasswordDao;
import system.bld.model.UserPassword;
import system.bld.service.user.UserPasswordService;
import system.common.utils.UUIDUtils;

import java.util.Date;


/**
 * @author litao
 * @date 2020-12-02
 * @Desc
 */
@Service
public class UserPasswordServiceImpl implements UserPasswordService {
    @Autowired
    UserPasswordDao userPasswordDao;

    @Override
    public Boolean addPassword(UserPassword userPassword) {

        UserPassword password= userPasswordDao.selectByUserId(userPassword.getUserId());

        if(ObjectUtil.isNotNull(password)){
            //TODO 后期加日志或者抛出异常
            return Boolean.FALSE;
        }
        password=new UserPassword();
        password.setUserId(userPassword.getUserId());
        password.setUserName(userPassword.getUserName());
        password.setCreateTime(new Date());
        password.setModifyTime(new Date());
        password.setLoginPasswordSalt(UUIDUtils.randomID());
        password.setLoginPassword(SecureUtil.md5(userPassword.getLoginPassword().concat(password.getLoginPasswordSalt())));
        userPasswordDao.insert(password);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updPassword(UserPassword userPassword) {

        UserPassword password= userPasswordDao.selectByUserId(userPassword.getUserId());
        password.setModifyTime(new Date());
        password.setLoginPasswordSalt(UUIDUtils.randomID());
        password.setLoginPassword(SecureUtil.md5(userPassword.getLoginPassword().concat(password.getLoginPasswordSalt())));
        userPasswordDao.updateByPrimaryKey(password);
        return Boolean.TRUE;
    }

    @Override
    public UserPassword queryUserPassword(Long userId) {

        UserPassword password= userPasswordDao.selectByUserId(userId);

        return password;
    }

}
