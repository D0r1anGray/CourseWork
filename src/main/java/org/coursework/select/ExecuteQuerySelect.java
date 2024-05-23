package org.coursework.select;

import org.coursework.database.ConnectionToDatabase;
import org.coursework.execution.ExecuteQuery;

import java.sql.*;

public class ExecuteQuerySelect extends ExecuteQuery {
    @Override
    public void execute_query(ConnectionToDatabase con, String sql_query){
        System.out.println(sql_query);
        try{
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(sql_query);
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql_query);
            ResultSet rs = preparedStatement.executeQuery();

            // System.out.println(rs);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                String password = rs.getString("password");
                System.out.println(id + "," + name/* + "," + email + "," + country + "," + password*/);
            }

        }catch (SQLException e){
            printSQLException(e);
        }
    }
}
