package src.scaff.java.relation;

import java.util.List;

import src.scaff.java.utils.Mapping;
import src.scaff.java.utils.TableUtility;

public class Rest {

    public void write(String language, String path, List<Table> tables, String tableName) throws Exception {
        Mapping mapping = new Mapping();
        mapping.setMappingFromList(language);
        for (Table table : tables) {
            if (tableName.equals("all")) {
                this.writeRepository(language, path, table);
                this.writeControlleur(language, path, table);
                this.writeService(language, path, table);
                table.writeEntity(language, path, tableName, mapping);
            } else {
                if (table.getName().toLowerCase().equals(tableName.toLowerCase())) {
                    this.writeRepository(language, path, table);
                    this.writeControlleur(language, path, table);
                    this.writeService(language, path, table);
                    table.writeEntity(language, path, tableName, mapping);
                }
            }
        }
    }

    public void writeControlleur(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/controlleur/" + TableUtility.firtLetterToUpper(table.getName()) + "Controlleur."
                + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/Controller";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[package]", "controlleur");
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeRepository(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/repository/" + TableUtility.firtLetterToUpper(table.getName()) + "Repository."
                + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/Repository";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[package]", "repository");
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeService(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/service/" + TableUtility.firtLetterToUpper(table.getName()) + "Service." + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/Service";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[package]", "service");
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeEntity(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/service/" + TableUtility.firtLetterToUpper(table.getName()) + "." + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/Entitys";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[package]", "controlleur");
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }
}
