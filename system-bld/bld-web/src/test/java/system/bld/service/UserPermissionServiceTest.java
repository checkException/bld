package system.bld.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.bld.AppTest;
import system.bld.model.Menu;
import system.bld.service.permission.MenuService;

import java.util.Date;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public class UserPermissionServiceTest extends AppTest {

    @Autowired
    MenuService menuService;

    @Test
    public void addTest(){

        Menu menu=new Menu();

        menu.setTitle("菜单二");

        menu.setStatus(1);

        menu.setLeft(true);

        menu.setSort(10);

        menu.setCreateTime(new Date());

        menu.setModifyTime(new Date());

        menu.setTop(false);

        boolean res=menuService.insert(menu);

        System.out.println(menu.toString());

        System.out.println(res);
    }
}
