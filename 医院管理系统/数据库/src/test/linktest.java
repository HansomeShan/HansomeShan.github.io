package test;

import Linkd.linkdatebase;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class linktest {
    static Connection connection;
    public linktest(){

        //1.读取配置文件中的4个基本信息
        InputStream is = linkdatebase.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        try {
            pros.load(is);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "无法读取数据库数据！","系统提示",JOptionPane.ERROR_MESSAGE);
        }
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        try {
            Class.forName(driverClass);

            //3.获取连接

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","123456");
            System.out.println(connection);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据库连接不成功！","系统提示",JOptionPane.ERROR_MESSAGE);
        }

    }
    public static Connection getConnection(){
        new linkdatebase();
        return connection;
    }
     public static void main(String[] args) {
    linktest t=new linktest();

    }

    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection con){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(ps != null){
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }

        if(con != null){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
