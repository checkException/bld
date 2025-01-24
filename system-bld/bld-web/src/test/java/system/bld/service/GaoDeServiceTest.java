package system.bld.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.bld.AppTest;
import system.bld.constans.ApplicationProperties;
import system.bld.request.thirdparty.IpLocationModel;
import system.bld.request.thirdparty.IpLocationResModel;
import system.bld.service.thirdparty.GaoDeServiceImpl;

/**
 * @author litao
 * @date 2021-09-29
 * @Desc
 */
public class GaoDeServiceTest extends AppTest {

    @Autowired
    GaoDeServiceImpl gaoDeService;

    @Test
    public void getIpLocation() throws Exception {
        IpLocationModel ipLocationModel = new IpLocationModel();

        ipLocationModel.setIp("117.88.4.189");

        ipLocationModel.setKey(ApplicationProperties.HAODMAP_BLD_WEB_KEY);

        ipLocationModel.setType(4);

        IpLocationResModel ipLocationResModel= gaoDeService.ipLocation(ipLocationModel);

        System.out.println(JSON.toJSONString(ipLocationResModel));

    }
}
