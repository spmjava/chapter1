package com.spmjava.dao;

import com.spmjava.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 齐伟超
 * @date 2018-09-05 11:23
 * @since 1.0.0
 **/
public final class DatabaseHelper {
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<>();
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    public static Connection getConnection() {
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        if (Objects.isNull(connection)) {
            connection = JdbcUtils.getConnection();
            CONNECTION_THREAD_LOCAL.set(connection);
        }
        return connection;
    }

    public static void closeConnection() {
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                CONNECTION_THREAD_LOCAL.remove();
            }
        }
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> entityList = null;
        try {
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return entityList;
    }

    public static <T> T getEntity(Class<T> clazz, String sql, Object... params) {
        Connection conn = getConnection();
        T entity = null;
        try {
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return entity;
    }

    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> result = new ArrayList<>();
        Connection conn = getConnection();
        try {
            result = QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public static int executeUpdate(String sql, Objects... params) {
        int rows = 0;
        Connection conn = getConnection();
        try {
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return rows;
    }
}
