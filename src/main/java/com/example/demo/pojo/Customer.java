package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 顾客信息实体层
 * @author: ZPX
 * @createDate: 2020/3/7 8:54
 * @version: 1.0
 */
public class Customer implements Serializable {
    /**
     * 顾客编号
     */
    private Integer customerid;

    /**
     * 顾客姓名
     */
    private String customername;

    /**
     * 顾客性别
     */
    private String customersex;

    /**
     * 顾客出生日期
     */
    private Date customerbirthday;

    /**
     * 顾客电话号码
     */
    private String customerphone;

    /**
     * 顾客信息注册地址
     */
    private String customeraddr;

    /**
     * 顾客注册地址邮箱编号
     */
    private String customerpostnumber;

    /**
     * 顾客注册电子邮箱
     */
    private String customeremail;

    private static final long serialVersionUID = 1L;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomersex() {
        return customersex;
    }

    public void setCustomersex(String customersex) {
        this.customersex = customersex;
    }

    public Date getCustomerbirthday() {
        return customerbirthday;
    }

    public void setCustomerbirthday(Date customerbirthday) {
        this.customerbirthday = customerbirthday;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomeraddr() {
        return customeraddr;
    }

    public void setCustomeraddr(String customeraddr) {
        this.customeraddr = customeraddr;
    }

    public String getCustomerpostnumber() {
        return customerpostnumber;
    }

    public void setCustomerpostnumber(String customerpostnumber) {
        this.customerpostnumber = customerpostnumber;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
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
        Customer other = (Customer) that;
        return (this.getCustomerid() == null ? other.getCustomerid() == null : this.getCustomerid().equals(other.getCustomerid()))
            && (this.getCustomername() == null ? other.getCustomername() == null : this.getCustomername().equals(other.getCustomername()))
            && (this.getCustomersex() == null ? other.getCustomersex() == null : this.getCustomersex().equals(other.getCustomersex()))
            && (this.getCustomerbirthday() == null ? other.getCustomerbirthday() == null : this.getCustomerbirthday().equals(other.getCustomerbirthday()))
            && (this.getCustomerphone() == null ? other.getCustomerphone() == null : this.getCustomerphone().equals(other.getCustomerphone()))
            && (this.getCustomeraddr() == null ? other.getCustomeraddr() == null : this.getCustomeraddr().equals(other.getCustomeraddr()))
            && (this.getCustomerpostnumber() == null ? other.getCustomerpostnumber() == null : this.getCustomerpostnumber().equals(other.getCustomerpostnumber()))
            && (this.getCustomeremail() == null ? other.getCustomeremail() == null : this.getCustomeremail().equals(other.getCustomeremail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerid() == null) ? 0 : getCustomerid().hashCode());
        result = prime * result + ((getCustomername() == null) ? 0 : getCustomername().hashCode());
        result = prime * result + ((getCustomersex() == null) ? 0 : getCustomersex().hashCode());
        result = prime * result + ((getCustomerbirthday() == null) ? 0 : getCustomerbirthday().hashCode());
        result = prime * result + ((getCustomerphone() == null) ? 0 : getCustomerphone().hashCode());
        result = prime * result + ((getCustomeraddr() == null) ? 0 : getCustomeraddr().hashCode());
        result = prime * result + ((getCustomerpostnumber() == null) ? 0 : getCustomerpostnumber().hashCode());
        result = prime * result + ((getCustomeremail() == null) ? 0 : getCustomeremail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerid=").append(customerid);
        sb.append(", customername=").append(customername);
        sb.append(", customersex=").append(customersex);
        sb.append(", customerbirthday=").append(customerbirthday);
        sb.append(", customerphone=").append(customerphone);
        sb.append(", customeraddr=").append(customeraddr);
        sb.append(", customerpostnumber=").append(customerpostnumber);
        sb.append(", customeremail=").append(customeremail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}