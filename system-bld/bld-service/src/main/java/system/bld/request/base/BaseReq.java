package system.bld.request.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @author litao
 * @date 2020-12-30
 * @Desc
 */
public class BaseReq implements Serializable {
    private static final long serialVersionUID = -8533896521917360177L;

    private Integer pageNum=Integer.valueOf(1);

    private Integer pageSize=Integer.valueOf(20);

    private String token;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
