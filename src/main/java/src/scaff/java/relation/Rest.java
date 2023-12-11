package src.scaff.java.relation;

import java.util.List;
import src.scaff.java.utils.TableUtility;

public class Rest {
    public void write(String language, String path, List<Table> tables, String tableName) throws Exception {
        for (Table table : tables) {
            if (tableName.equals("all")) {
                this.writeRepository(language, path, table);
                this.writeControlleur(language, path, table);
                this.writeService(language, path, table);
                System.out.println("Rest " + TableUtility.firtLetterToUpper(table.getName()) + " created at " + path);
            } else {
                if (table.getName().toLowerCase().equals(tableName.toLowerCase())) {
                    this.writeRepository(language, path, table);
                    this.writeControlleur(language, path, table);
                    this.writeService(language, path, table);
                    System.out.println("Rest " + TableUtility.firtLetterToUpper(table.getName()) + " created at " + path);
                }
            }
        }
    }

    public void writeControlleur(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/controlleur/" + TableUtility.firtLetterToUpper(table.getName()) + "Controlleur."
                + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/spring-boot/Controller";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[package]", "controlleur");
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeRepository(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/repository/" + TableUtility.firtLetterToUpper(table.getName()) + "Repository."
                + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/spring-boot/Repository";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeService(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/service/" + TableUtility.firtLetterToUpper(table.getName()) + "Service." + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/spring-boot/Service";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

}
