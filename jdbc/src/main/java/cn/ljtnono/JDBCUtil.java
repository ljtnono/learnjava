package cn.ljtnono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 *  jdbc工具类
 *  @author 凌家童
 *  @date 2019/6/24
 *  @version 1.0
 *
*/
public class JDBCUtil {

    private final static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    private static String DRIVER  = null;

    private static String URL = null;

    private static String USERNAME = null;

    private static String PASSWORD = null;

    private static final String CONFIG_LOCATION = "jdbc/target/classes/db.properties";

    private JDBCUtil(){}

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
            inputStream = new FileInputStream(CONFIG_LOCATION);
            Properties properties = new Properties();
            properties.load(inputStream);
            setPropertiesValue(properties);
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("找不到配置文件：" + CONFIG_LOCATION );
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
     * 获取连接
     * @return Connection 连接对象
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        // 2.建立连接 参数一：协议 + 访问的数据库， 参数二：用户名，参数三：密码
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 释放资源
     * @param connection 数据库连接对象
     * @param st 语句对象
     * @param rs 结果集对象
     */
    public static void release(Connection connection, Statement st, ResultSet rs) {
        closeResources(rs);
        closeResources(st);
        closeResources(connection);
    }


    /**
     * 关闭资源, 当资源是ResultSet 或 Statement 或 Connection 类型时关闭资源
     * @param rs 需要关闭的资源对象
     */
    private static void closeResources(AutoCloseable rs) {
        if (rs instanceof ResultSet || rs instanceof  Statement || rs instanceof  Connection) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
