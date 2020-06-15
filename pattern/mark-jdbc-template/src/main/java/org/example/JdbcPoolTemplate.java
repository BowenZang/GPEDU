package org.example;

import org.example.pool.AbstractPool;
import org.example.pool.DBConnectionPool;
import org.example.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-13 14:45:26
 */
public class JdbcPoolTemplate {

    private static final AbstractPool abstractPool = DBConnectionPool.getInstance();

    public static <T> T select(String sql,IRowMapper<T> rowMapper, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = abstractPool.getConnection();
            ps = conn.prepareStatement(sql);

            int i = 1;
            for (String param : params) {
                ps.setObject(i++, param);
            }
            rs = ps.executeQuery();

            return rowMapper.mapping(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, ps, rs);
        }
        return null;
    }

    public static int insert(String sql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = abstractPool.getConnection();
            ps = conn.prepareStatement(sql);

            int i = 1;
            for (String param : params) {
                ps.setObject(i++, param);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }

    public static int update(String sql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = abstractPool.getConnection();
            ps = conn.prepareStatement(sql);

            int i = 1;
            for (String param : params) {
                ps.setObject(i++, param);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }



    public static int delete(String sql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = abstractPool.getConnection();
            ps = conn.prepareStatement(sql);

            int i = 1;
            for (String param : params) {
                ps.setObject(i++, param);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, ps, null);
        }
        return 0;
    }

}
