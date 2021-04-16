package system.bld.service.permission;

import com.baomidou.mybatisplus.service.IService;
import system.bld.model.Menu;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public interface MenuService extends IService<Menu>{

    Boolean addMenu(Menu menu);

    Boolean editMenu(Menu menu);

}
