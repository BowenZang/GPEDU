package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-13 14:55:50
 */
public interface IRowMapper<T> {

    T mapping(ResultSet rs) throws SQLException;

}
