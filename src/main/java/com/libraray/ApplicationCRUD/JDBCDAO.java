package com.libraray.ApplicationCRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

//Class for jdbc operation
public class JDBCDAO {
    private final static String userName = "root";
    private final static String password = "KavinDharani@3";

    private final static String url = "jdbc:mysql://localhost:3306/librarydatabase";
    private final static String driver = "com.mysql.cj.jdbc.Driver";

    private final static Connection connection;

    static {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //getting connection instantiated during loading the  class
    private static Connection getConnection() throws SQLException{
        try{
            Class.forName(driver);

            return DriverManager.getConnection(url, userName, password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    //Used to retrieve data from database
    public static ResultSet fetchData(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //Update data
    public static int update(String query){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            return preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
