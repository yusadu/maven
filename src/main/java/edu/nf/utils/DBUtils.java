package edu.nf.utils;

import java.sql.*;

public class DBUtils {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static String user="root";
    private static String pwd="root";

    static {
        try{
            Class.forName(driver);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,pwd);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("获取连接异常",e);
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement !=null){
                statement.close();
            }
            if(resultSet !=null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
