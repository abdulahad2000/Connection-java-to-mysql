package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null ;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        //int id;
        //String user;
        //String password;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales?user=root&password=oglu2001");

            statement =connection.createStatement();

            resultSet =statement.executeQuery("select * from user");

            while (resultSet.next()){
                int id =resultSet.getInt("user_id");
                String user =resultSet.getString("user");
                String password =resultSet.getString("password");
                System.out.println("  id : "+ id+"  user : "+ user+"  password : "+password);
            }

        }catch (SQLException ex){

            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}