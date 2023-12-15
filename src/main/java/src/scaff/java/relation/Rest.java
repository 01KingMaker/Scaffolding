package src.scaff.java.relation;

import java.util.List;
import src.scaff.java.utils.TableUtility;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

interface MyFunction {
    void execute(String language, String path, Table table);
}

public class Rest {
    public void write(String language, String path, List<Table> tables, String tableName) throws Exception {
        for (Table table : tables) {
            if (tableName.equals("all")) {
                this.write(language, path, table);
                System.out.println("Rest " + TableUtility.firtLetterToUpper(table.getName()) + " created at " + path);
            } else {
                if (table.getName().toLowerCase().equals(tableName.toLowerCase())) {
                    this.write(language, path, table);
                    System.out
                            .println("Rest " + TableUtility.firtLetterToUpper(table.getName()) + " created at " + path);
                }
            }
        }
    }

    public void write(String language, String path, Table table) throws Exception {
        Map<String, MyFunction> functionMap = new HashMap<>();
        functionMap.put("repository", (language, path, table) -> this.writeRepository(language, path, table));
        functionMap.put("controller", (language, path, table) -> this.writeControlleur(language, path, table));
        functionMap.put("service", (language, path, table) -> this.writeService(language, path, table));

        File dossier = new File(System.getProperty("user.dir") + "/modele/" + language + "/rest/");
        if (dossier.isDirectory()) {
            File[] fichiers = dossier.listFiles();
            for (File fichier : fichiers) {
                if (functionMap.containsKey(fichier.getName().toLowerCase()))
                    functionMap.get(fichier.getName().toLowerCase()).execute(language, path, table);
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
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

    public void writeService(String launguage, String pathOut, Table table) throws Exception {
        String out = pathOut + "/service/" + TableUtility.firtLetterToUpper(table.getName()) + "Service." + launguage;
        String path = System.getProperty("user.dir") + "/modele/" + launguage + "/rest/Service";
        String modele = TableUtility.chargerModele(path);
        modele = modele.replace("[Name]", TableUtility.firtLetterToUpper(table.getName()));
        TableUtility.ecrireLettre(modele, out);
    }

}
