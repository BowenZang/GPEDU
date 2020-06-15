package org.example.pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:52:07
 */
public abstract class AbstractPool {

    protected String propertiesName = "db.properties";

    /**
     * Single instance
     */
    protected static AbstractPool INSTANCE;

    /**
     * Active connect count
     */
    protected int normalConnectCount = 10;

    /**
     * Max connect count
     */
    protected int maxConnectCount = 100;

    /**
     * Database driver class name
     */
    protected String driverName;

    /**
     * Database driver
     */
    protected Driver driver;

    /**
     * Protected construct method
     */
    protected AbstractPool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loading config
     */
    private void init() throws IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream(propertiesName));
        this.normalConnectCount = Integer.parseInt(prop.getProperty("normalConnectCount"));
        this.maxConnectCount = Integer.parseInt(prop.getProperty("maxConnectCount"));
        this.driverName = prop.getProperty("jdbcDriver");
        System.out.println("Jdbc config load success! " + this.toString());
    }

    /**
     * Loading driver
     * @param driverName driver class name
     */
    private void loadDrivers(String driverName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.driver = (Driver) Class.forName(driverName).newInstance();
        DriverManager.registerDriver(driver);
        System.out.println("Jdbc driver load success! " + driverName);
    }

    /**
     * Getting a connection, less than maxConnectionCount
     * @return Connection
     */
    public abstract Connection getConnection() throws SQLException;

    /**
     * Getting a connection that set expire time, less than maxConnectionCount
     * @param time expire time
     * @return Connection
     */
    public abstract Connection getConnection(long time);

    /**
     * Freeing a connection
     * @param conn Connection
     */
    public abstract void freeConnection(Connection conn);

    /**
     * Releasing all resources
     */
    protected void release() throws SQLException {
        if (null != driver) {
            synchronized (AbstractPool.class) {
                if (null != driver) {
                    DriverManager.deregisterDriver(driver);
                    System.out.println("Releasing jdbc driver");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AbstractPool{" +
                "normalConnectCount=" + normalConnectCount +
                ", maxConnectCount=" + maxConnectCount +
                ", driverName='" + driverName + '\'' +
                ", driver=" + driver +
                '}';
    }
}
