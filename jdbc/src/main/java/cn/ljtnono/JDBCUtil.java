package cn.ljtnono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 *
 * @author 凌家童
 * @version 1.0
 * @date 2019/6/24
 */
public class JDBCUtil {

    private final static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    private static String DRIVER = null;

    private static String URL = null;

    private static String USERNAME = null;

    private static String PASSWORD = null;

    private static final String CONFIG_LOCATION = "db.properties";

    private JDBCUtil() {}

    /**
     * 初始化配置
     */
    static {
        try {
            // 1.读取配置文件
            loadConfig();
            // 2.注册驱动
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            if (logger.isErrorEnabled()) {
                logger.error("注册驱动错误：" + e.getMessage());
            }
        }
    }

    /**
     * 设置properties的各种值
     * @param properties 需要设置properties值的对象
     */
    private static void setPropertiesValue(Properties properties) {
        DRIVER = properties.getProperty("jdbc.driver");
        URL = properties.getProperty("jdbc.url");
        USERNAME = properties.getProperty("jdbc.username");
        PASSWORD = properties.getProperty("jdbc.password");
    }

    /**
     * 读取db.properties文件
     */
    private static void loadConfig() {
        InputStream inputStream = null;
        try {
            inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream(CONFIG_LOCATION);
            Properties properties = new Properties();
            properties.load(inputStream);
            setPropertiesValue(properties);
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("找不到配置文件：" + CONFIG_LOCATION);
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取连接
     *
     * @return Connection 连接对象
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 释放资源
     *
     * @param connection 数据库连接对象
     * @param st         语句对象
     * @param rs         结果集对象
     */
    public static void release(Connection connection, Statement st, ResultSet rs) {
        closeAutoCloseableResources(rs);
        closeAutoCloseableResources(st);
        closeAutoCloseableResources(connection);
    }


    /**
     * 关闭AutoCloseable类型资源
     * @param rs 需要关闭的资源对象
     */
    private static void closeAutoCloseableResources(AutoCloseable rs) {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
