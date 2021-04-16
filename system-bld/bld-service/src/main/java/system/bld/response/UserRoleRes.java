package system.bld.response;

import system.bld.model.Role;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public class UserRoleRes {

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

    public UserRoleRes setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRoleRes setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public UserRoleRes setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public UserRoleRes setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public UserRoleRes setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserRoleRes setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
