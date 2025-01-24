package system.bld.request;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public class UserRoleReq {

    private static final long serialVersionUID = -3677424272734668451L;

    private Long id;

    private Long userId;

    private Long roleId;

    private String roleName;

    private String roleCode;

    private Integer status;

    public Long getId() {
        return id;
    }

    public UserRoleReq setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRoleReq setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public UserRoleReq setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public UserRoleReq setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public UserRoleReq setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserRoleReq setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
