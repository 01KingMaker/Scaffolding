package src.scaff;

import src.scaff.java.connexion.Connexion;
import src.scaff.java.relation.Database;

/**
 *
 * @author fabien
 */
public class Scaff {

    public static void main(String[] args) throws Exception {
        Connexion connexion;
        connexion = new Connexion();
        try(java.sql.Connection c = connexion.enterBdd()) {
            Database database = new Database();
            database.setDatabase(c);
            database.writeClasses(args[1],args[2], args[3], args[4]);
            database.writeRestAPI(args[1], args[2], args[4]);
        }
    }       
}
