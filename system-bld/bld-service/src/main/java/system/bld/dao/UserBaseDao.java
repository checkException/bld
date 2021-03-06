package system.bld.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import system.bld.model.UserBase;

@Repository
public interface UserBaseDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_base
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_base
     *
     * @mbg.generated
     */
    int insert(UserBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_base
     *
     * @mbg.generated
     */
    UserBase selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_base
     *
     * @mbg.generated
     */
    List<UserBase> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_base
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserBase record);
}