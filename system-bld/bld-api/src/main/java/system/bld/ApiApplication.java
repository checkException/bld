package system.bld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 15:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@SpringBootApplication
@MapperScan("system.bld.dao")
public class ApiApplication {

	public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class,args);

    }

}
