package org.example.pojo;

import java.io.Serializable;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-13 14:59:19
 */
public class UserDO {

    private Integer id;
    private String userId;
    private String userName;
    private String mobilePhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
