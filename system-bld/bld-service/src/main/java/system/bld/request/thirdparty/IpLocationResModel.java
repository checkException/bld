package system.bld.request.thirdparty;

import java.io.Serializable;

/**
 * @author litao
 * @date 2021-09-29
 * @Desc
 */
public class IpLocationResModel implements Serializable {
    private static final long serialVersionUID = 5727275653891531634L;

    /**
     *国家（或地区），中文
     */
    private String country;

    /**
     *省（二级），中文
     */
    private String province;

    /**
     *市（三级），中文
     */
    private String city;

    /**
     *区（四级），中文
     */
    private String district;

    /**
     *运营商 如电信、联通、移动
     */
    private String isp;

    /**
     * 经纬度
     */
    private String location;

    /**
     *IP地址 提交的 Ipv4/ Ipv6地址。
     */
    private String Ip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }
}
