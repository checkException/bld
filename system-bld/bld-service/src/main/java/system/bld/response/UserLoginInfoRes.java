package system.bld.response;

import java.io.Serializable;

/**
 * @author litao
 * @date 2020-12-03
 * @Desc
 */
public class UserLoginInfoRes implements Serializable{

    private static final long serialVersionUID = -4733384384483499273L;

    /**
     * id
     */
    private Long userId;

    /**
     * pid
     */
    private Long pid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * token
     */
    private String authToken;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPid() {
        return pid;
    }

    public UserLoginInfoRes setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
