package system.bld.service.user;

import system.bld.model.UserPassword;

/**
 * @author litao
 * @date 2020-12-02
 * @Desc
 */
public interface UserPasswordService {

    /**
     * add
     * @param userPassword
     * @return
     */
    Boolean addPassword(UserPassword userPassword);

    /**
     * 修改
     * @param userPassword
     * @return
     */
    Boolean updPassword(UserPassword userPassword);

    /**
     * query
     * @param userId
     * @return
     */
    UserPassword queryUserPassword(Long userId);
}
