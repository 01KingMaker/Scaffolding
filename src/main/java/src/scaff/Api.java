package src.scaff;

import src.scaff.java.connexion.Connexion;
import src.scaff.java.relation.Database;

public class Api {
    public static void main(String[] args) throws Exception {
        Connexion connexion = new Connexion();
        try(java.sql.Connection c = connexion.enterBdd()) {
            Database database = new Database();
            database.setDatabase(c);
            database.writeRestAPI(args[1], args[2], args[4]);
        }
    }    
}
