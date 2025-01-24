package system.bld.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.file.FileReader;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserBaseDao;
import system.bld.enums.ErrorCodeEnum;
import system.bld.model.UserBase;
import system.bld.request.UserBaseReq;
import system.bld.service.UserBaseService;
import system.bld.service.thirdparty.GaoDeServiceImpl;
import system.common.utils.AssertUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/11
 * @Time: 15:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {
    private static final Logger logger = LoggerFactory.getLogger(UserBaseServiceImpl.class);

	@Autowired
	UserBaseDao userBaseDao;

    @Autowired
    GaoDeServiceImpl gaoDeService;


    //private static final FileReader reader = new FileReader("D:\\action.js");

    /*static {
        if(reader == null ){
            try {
                reader=new FileReader(UserBaseServiceImpl.class.getClassLoader().getResource("en.js").getPath());
            } catch (FileNotFoundException e) {
                logger.error("error:{}",e);
            }
        }
    }*/

    /**
     * 查询 根据用户id
     *
     * @param id
     * @return
     */
	@Override
	public UserBase queryUserById(Long id) {
		return userBaseDao.selectByPrimaryKey(id);
	}

    @Override
    public List<UserBase> queryList() {

        return userBaseDao.selectAll();
    }

    @Override
    public Page<UserBase> queryListPage(UserBaseReq userBaseReq) {

        UserBase userBase=new UserBase();

        BeanUtil.copyProperties(userBaseReq,userBase);

        Map<String,Object> params=BeanUtil.beanToMap(userBaseReq);

        PageHelper.startPage(userBaseReq.getPageNum(),userBaseReq.getPageSize());

        List<UserBase> list= userBaseDao.selectBySelecter(params);

        Page<UserBase> basePage= (Page<UserBase>)list;

        return basePage;
    }

    @Override
    public Boolean addUserBase(UserBase userBase) {
        userBase.setType(1);
        userBase.setStatus(1);
        userBase.setCreateTime(new Date());
        userBase.setModifyTime(new Date());
        return userBaseDao.insert(userBase)>0?Boolean.TRUE:Boolean.FALSE;
    }

    /**
     * 修改
     *
     * @param userBase
     * @return
     */
    @Override
    public Boolean editUserBase(UserBase userBase) {

        logger.info("editUserBase.userBase:{}",userBase);

        AssertUtils.isNotNull(userBase.getId(), ErrorCodeEnum.ILLEGAL_ARGUMENT);
        AssertUtils.isNotBlank(userBase.getUserName(), ErrorCodeEnum.ILLEGAL_ARGUMENT);

        userBase.setModifyTime(new Date());

        return userBaseDao.updateSelectiveByPrimaryKey(userBase)>0?Boolean.TRUE:Boolean.FALSE;
    }

    /**
     * java 读取 javaScript测试
     */
    public void readerJavaScript(){

        /*ScriptEngine engine = new ScriptEngineManager()
                .getEngineByName("JavaScript");
        logger.info("UserBaseServiceImpl.queryListPage,1");
        Object object=null;
        try {
            engine.eval(reader.getReader());
            logger.info("UserBaseServiceImpl.queryListPage,2");
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                JavaScriptInterface executeMethod = invocable
                        .getInterface(JavaScriptInterface.class);
                return executeMethod.getEncryption(pwd, user, random);
                logger.info("UserBaseServiceImpl.queryListPage,3");
                object=invocable.invokeFunction("getEncryption","litao123","litao123","123");
            }
            logger.info("out UserBaseServiceImpl.queryListPage,object:{}",object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.getReader().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
