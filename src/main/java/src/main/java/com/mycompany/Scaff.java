/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package src.main.java.com.mycompany;

import java.io.Console;
import java.sql.SQLException;

import src.main.java.com.mycompany.scaff.java.connexion.Connexion;
import src.main.java.com.mycompany.scaff.java.relation.Database;

/**
 *
 * @author fabien
 */
public class Scaff {

    public static void main(String[] args) throws Exception, ClassNotFoundException{
    
        Connexion connexion;
        try {
          connexion = new Connexion(/*"chat" args[0], args[1], password*/);
          java.sql.Connection c = connexion.enterBdd(); 
          Database database = new Database();
          database.setDatabase(c);
          database.writeClasses(args[1],args[2], args[3], args[4]);
          c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());//.printStackTrace();
        }
    }       
}
