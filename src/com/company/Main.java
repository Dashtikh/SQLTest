package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)  {
        try(Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Dashtikh","dashti1565")){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into person (id,name,city) values (?,?,?)");
            preparedStatement.setLong(1,1);
            preparedStatement.setString(2,"javad");
            preparedStatement.setString(3,"Tehran");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
