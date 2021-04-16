package system.bld.service.impl.permission;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.MenuDao;
import system.bld.enums.ErrorCodeEnum;
import system.bld.model.Menu;
import system.bld.service.permission.MenuService;

import java.util.Date;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao,Menu> implements MenuService {

    private static final Logger log= LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    MenuDao menuDao;

    @Override
    public Boolean addMenu(Menu menu) {

        log.info("MenuServiceImpl.addMenu,menu:{}",menu.toString());

        Assert.isNull(menu.getTitle(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        menu.setCreateTime(new Date());

        menu.setModifyTime(new Date());

        menu.setStatus(1);

        if(menu.getLeft()==null){

            menu.setLeft(false);

        }

        if(menu.getTop()==null){

            menu.setTop(false);

        }

        return super.insert(menu);

    }

    @Override
    public Boolean editMenu(Menu menu) {

        log.info("MenuServiceImpl.editMenu,menu:{}",menu.toString());

        Assert.isNull(menu.getId(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        menu.setModifyTime(new Date());

        return super.updateById(menu);
    }
}
