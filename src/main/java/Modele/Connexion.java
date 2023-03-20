package Modele;

import java.sql.*;

public class Connexion {

    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.cj.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/"+ nameDatabase;
        //création d'une connexion JDBC à la base
        Connection conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
        String requete;
        ResultSet resultats=null;
        /*try {
            Statement stmt = conn.createStatement();
            int nbMaj = stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        requete = "SELECT * FROM dept";

        try {
            Statement stmt = conn.createStatement();
           resultats = stmt.executeQuery(requete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData rsmd = resultats.getMetaData();
        System.out.println(rsmd.getColumnCount());
        while (resultats.next()){
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.println(resultats.getString(i+1) + "" );
            }

        }
        resultats.close();
    }
}
