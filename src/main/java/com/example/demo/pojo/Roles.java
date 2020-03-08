package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/3/7 13:19
 * @version: 1.0
 */
@TableName("roles")
public class Roles implements Serializable {
    /**
     * 角色编号
     */
    private int rolesId;
    /**
     * 角色名称
     */
    private String rolesName;

    public Roles() {
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        Roles roles = (Roles) o;
        return getRolesId() == roles.getRolesId() &&
                Objects.equals(getRolesName(), roles.getRolesName());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "rolesId=" + rolesId +
                ", rolesName='" + rolesName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRolesId(), getRolesName());
    }
}




