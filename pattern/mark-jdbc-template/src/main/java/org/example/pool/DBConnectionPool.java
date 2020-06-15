package org.example.pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Clock;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 18:20:22
 */
public final class DBConnectionPool extends AbstractPool {

    /**
     * Saving free connections
     */
    private final Vector<Connection> freeConnections = new Vector<>();

    private String password;

    private String username;

    private String url;

    /**
     * Free conn count
     */
    private static int freeNum = 0;

    /**
     * Can be activation connection count;
     */
    private static int activeNum = 0;

    public static AbstractPool getInstance() {
        if (null == INSTANCE) {
            synchronized (DBConnectionPool.class) {
                if (null == INSTANCE) {
                    INSTANCE = new DBConnectionPool();
                }
            }
        }
        return INSTANCE;
    }

    private DBConnectionPool () {
        super();
        try {
            this.init();
            for (int i = 0; i < normalConnectCount; i++) {
                Connection conn = this.newConnection();

                if (null != conn) {
                    System.out.println("Created a new connection");
                    freeConnections.addElement(conn);
                    freeNum++;
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream(super.propertiesName));
        this.username = prop.getProperty("jdbcUser");
        this.password = prop.getProperty("jdbcUserPassword");
        this.url = prop.getProperty("jdbcUrl");
    }

    @Override
    public synchronized Connection getConnection() {
        Connection conn = null;
        if (!freeConnections.isEmpty()) {
            conn = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            freeNum--;
            try {
                if (conn.isClosed()) {
                    conn = getConnection();
                }
            } catch (SQLException e) {
                System.out.println("Deleted invalid connection");
                e.printStackTrace();
                conn = getConnection();
            }
            return conn;
        }

        if (maxConnectCount == 0 || activeNum < maxConnectCount) {
            try {
                conn = newConnection();
                activeNum++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    @Override
    public synchronized Connection getConnection(long time) {
        Clock clock = Clock.systemDefaultZone();
        long startTime = clock.millis();
        Connection conn;
        while (null == (conn = getConnection())) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((clock.millis() - startTime) >= time) {
                return null;
            }
        }

        return conn;
    }

    @Override
    public void freeConnection(Connection conn) {
        freeConnections.addElement(conn);
        freeNum++;
        activeNum--;
        notifyAll();
    }

    private Connection newConnection() throws SQLException {
        if (null == this.username) {
            return DriverManager.getConnection(this.url);
        } else {
            return DriverManager.getConnection(this.url, this.username, this.password);
        }
    }

    public static int getFreeNum() {
        return freeNum;
    }

    public static int getActiveNum() {
        return activeNum;
    }

    @Override
    protected void release() throws SQLException {
        try {
            Enumeration<Connection> elements = freeConnections.elements();
            while (elements.hasMoreElements()) {
                Connection conn = elements.nextElement();
                if (null != conn) {
                    conn.close();
                    freeNum--;
                }
            }
            freeConnections.removeAllElements();
            activeNum = 0;
        } finally {
            super.release();
        }
    }
}
