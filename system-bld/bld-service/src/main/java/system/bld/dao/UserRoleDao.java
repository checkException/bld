package system.bld.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import system.bld.model.UserRole;

@Repository
public interface UserRoleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    List<UserRole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserRole record);

    /**
     * 查询用户所属角色列表
     * @param userId
     * @return java.util.List<system.bld.model.UserRole>
     * @author litao
     * @date 2021/4/19 10:34
     */
    List<UserRole> queryListByUserId(Long userId);
}