package org.example;

import org.example.pojo.UserDO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-13 14:57:18
 */
public class UserRowMapper implements IRowMapper<List<UserDO>> {
    @Override
    public List<UserDO> mapping(ResultSet rs) throws SQLException {
        List<UserDO> userDOList = new ArrayList<>();
        while (rs.next()) {
            UserDO userDO = new UserDO();
            userDO.setId(rs.getInt("id"));
            userDO.setUserId(rs.getString("user_id"));
            userDO.setUserName(rs.getString("user_name"));
            userDO.setMobilePhone(rs.getString("mobile_phone"));
            userDOList.add(userDO);
        }
        return userDOList;
    }
}
