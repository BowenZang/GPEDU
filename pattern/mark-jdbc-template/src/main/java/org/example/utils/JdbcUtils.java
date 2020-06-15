package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-13 14:21:20
 */
public final class JdbcUtils {

    private static final Properties prop = new Properties();

    static {
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
            prop.load(inputStream);
            Class.forName(prop.getProperty("jdbcDriver"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getJdbcConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("jdbcUrl"), prop.getProperty("jdbcUser"), prop.getProperty("jdbcUserPassword"));
    }

    public static void close(Connection conn, Statement s, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != s) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
