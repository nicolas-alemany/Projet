package Controlleur;

import Modele.Connexion;
import Vue.Fenetre;

import java.sql.SQLException;

public class Exec {
    public static void main(String[] args) {
        new Fenetre();
        try {
            new Connexion("test","root","");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
