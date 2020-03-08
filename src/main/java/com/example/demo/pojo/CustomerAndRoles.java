package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 顾客信息和角色信息关联实体类
 * @author 
 */
@TableName("customer_roles")
public class CustomerAndRoles implements Serializable {
    /**
     * 顾客信息ID
     */
    private Integer customerid;

    /**
     * 角色信息编号
     */
    private Integer rolesid;

    private static final long serialVersionUID = 1L;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CustomerAndRoles other = (CustomerAndRoles) that;
        return (this.getCustomerid() == null ? other.getCustomerid() == null : this.getCustomerid().equals(other.getCustomerid()))
            && (this.getRolesid() == null ? other.getRolesid() == null : this.getRolesid().equals(other.getRolesid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerid() == null) ? 0 : getCustomerid().hashCode());
        result = prime * result + ((getRolesid() == null) ? 0 : getRolesid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerid=").append(customerid);
        sb.append(", rolesid=").append(rolesid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}