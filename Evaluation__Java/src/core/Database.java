package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
     protected Connection connection=null;
     protected  PreparedStatement preparedStatement=null;

     public void openConnection() {
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost/devoir", "root", "");
       } catch (Exception e) {
          System.out.println("Erreur de connexion à la base de données");
       }
     }
     public void prepareStatementQuery(String sql){
        try {
            preparedStatement= connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'initialisation du PrepareStatement");
        }
     }
     public int executeUpdateQuery(){
        int numberOfRows=0;
          try {
            numberOfRows= preparedStatement.executeUpdate();
         } catch (SQLException e) {
            System.out.println("Erreur lors de l'exécution de la requête");
          }
        return numberOfRows;
     }


     public ResultSet executeSelectQuery(){
        ResultSet resultSet=null;
        try {
            resultSet= preparedStatement.executeQuery();
         } catch (SQLException e) {
            System.out.println("Erreur lors de l'exécution de la requête");
          }
          return resultSet;
     }

     public void closeConnection() throws SQLException {
        if (connection!=null) {
            connection.close();
        }
     }

}