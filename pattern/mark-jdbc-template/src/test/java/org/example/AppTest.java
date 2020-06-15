package org.example;

import static org.junit.Assert.assertTrue;

import org.example.pojo.UserDO;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void query() {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        List<UserDO> userDOList = JdbcTemplate.select(sql, new UserRowMapper(), "22222222");
        System.out.println(userDOList);
    }

    @Test
    public void queryCount() {
        String sql = "SELECT COUNT(1) total FROM user";
        Long count = JdbcTemplate.select(sql, new IRowMapper<Long>() {
            @Override
            public Long mapping(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    return rs.getLong("total");
                }
                return null;
            }
        });
        System.out.println(count);
    }

    @Test
    public void save() {
        String sql = "INSERT INTO `user` (user_id, user_name, mobile_phone) VALUES (?, ?, ?)";
        UserDO userDO = new UserDO();
        userDO.setUserId("44444444");
        userDO.setUserName("TEST");
        userDO.setMobilePhone("13844444444");
        int result = JdbcTemplate.insert(sql, userDO.getUserId(), userDO.getUserName(), userDO.getMobilePhone());
        System.out.println(result);
    }

    @Test
    public void update() {
        String sql = "UPDATE `user` SET user_name = ? WHERE id = ?";
        UserDO userDO = new UserDO();
        userDO.setUserName("TEST_UPDATE");
        int result = JdbcTemplate.update(sql, userDO.getUserName(), "4");
        System.out.println(result);
    }

    @Test
    public void delete() {
        String sql = "DELETE FROM user WHERE id = ?";
        int result = JdbcTemplate.delete(sql, "4");
        System.out.println(result);
    }
}
