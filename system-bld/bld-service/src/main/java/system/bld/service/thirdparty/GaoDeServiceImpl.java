package system.bld.service.thirdparty;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import system.bld.request.thirdparty.IpLocationModel;
import system.bld.request.thirdparty.IpLocationResModel;


/**
 * @author litao
 * @date 2021-09-29
 * @Desc
 */
@Service
public class GaoDeServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(GaoDeServiceImpl.class);

    private static final String iplocationUrl="https://restapi.amap.com/v5/ip";

    /**
     * ip定位功能
     * @return
     */
    public IpLocationResModel ipLocation(IpLocationModel ipLocationModel){

        logger.info("GaoDeServiceImpl.ipLocation,ipLocationModel：{}", JSON.toJSONString(ipLocationModel));

        IpLocationResModel ipLocationResModel = new IpLocationResModel();
        try {
            //.concat("%output=JSON")
            String paramters="key=".concat(ipLocationModel.getKey()).concat("&type=").concat(String.valueOf(ipLocationModel.getType()))
                    .concat("&ip=").concat(ipLocationModel.getIp());

            logger.info("GaoDeServiceImpl.ipLocation,request:{}",iplocationUrl.concat("?").concat(paramters));

            String result= HttpRequest.get(iplocationUrl.concat("?").concat(paramters)).timeout(5000).execute().body();

            logger.info("GaoDeServiceImpl.ipLocation,response:{}",result);

            JSONObject jsonObject = JSON.parseObject(result);

            if(StringUtils.isNotBlank(result)&&jsonObject.getIntValue("status")==1){

                ipLocationResModel.setCountry(jsonObject.getString("country"));

                ipLocationResModel.setProvince(jsonObject.getString("province"));

                ipLocationResModel.setCity(jsonObject.getString("city"));

                ipLocationResModel.setDistrict(jsonObject.getString("district"));

                ipLocationResModel.setIsp(jsonObject.getString("isp"));

                ipLocationResModel.setLocation(jsonObject.getString("location"));

                ipLocationResModel.setIp(jsonObject.getString("ip"));

            }

        }catch (Exception e){
            logger.info("GaoDeServiceImpl.ipLocation,error");
            logger.error("GaoDeServiceImpl.ipLocation,error:{}",e.getMessage());
        }

        return ipLocationResModel;
    }

}
