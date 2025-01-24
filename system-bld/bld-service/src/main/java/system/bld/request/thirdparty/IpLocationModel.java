package system.bld.request.thirdparty;

import java.io.Serializable;

/**
 * @author litao
 * @date 2021-09-29
 * @Desc
 */
public class IpLocationModel implements Serializable {
    private static final long serialVersionUID = 3341458612209282997L;

    /**
     * 用户在高德地图的应用高德Key
     */
    private String key;

    /**
     * 值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     */
    private  Integer type;

    public IpLocationModel() {
    }

    public IpLocationModel(String key, Integer type, String ip) {
        this.key = key;
        this.type = type;
        this.ip = ip;
    }

    /**
     *
     */
    private String ip;

    /**
     * 数字签名认证用户必填
     */
    private String sig;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}
