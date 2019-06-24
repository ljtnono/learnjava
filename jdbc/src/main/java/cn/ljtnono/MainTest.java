package cn.ljtnono;

import java.sql.*;

/**
 * @author 凌家童
 * @version 1.0
 * @date 2019/6/24
 */
public class MainTest {

    // 使用JDBC的基本步骤

    /**  使用JDBC的基本步骤
     *  1. 注册驱动
     *  2.建立连接
     * 3.创建statement
     * 4.执行sql语句，得到ResultSet对象
     * 5.处理结果集对象
     * 6.释放资源
     *
     *   资源释放工作的整合
     *   将资源释放都封装为函数，方便调用
     *   驱动防二次注册
     *   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
     *   Driver 实现类中有静态代码块----> 类加载了，就执行了。 java.sql.DriverManager.registerDriver(new Driver());
     *  相当于执行了两次注册驱动
     *  最后形成以下代码即可
     *  Class.forName(com.mysql.cj.jdbc.Driver)
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement st = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            // 3.创建statement，跟数据库打交道，一定需要这个对象
            st = connection.createStatement();
            String sql = "select * from t_stu";
            resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("id = " + id + "===name=" + name + "==age=" + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, st, resultSet);
        }
    }
}
