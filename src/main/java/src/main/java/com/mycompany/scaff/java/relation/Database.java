package src.main.java.com.mycompany.scaff.java.relation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.mycompany.scaff.java.utils.Mapping;

public class Database {
    
    String databaseName;
    List<Table> tables;

    public void writeClasses(String language, String path, String k) throws Exception{
        Mapping mapping = new Mapping();
        mapping.setMappingFromList(language);
        for (Table table : this.tables) {
            table.write(language, path, k, mapping);
            System.out.println("Class " + table.getName() + " created at " + path);
        }
    }

    public void writeClasses(String language, String path, String k, String tableName) throws Exception{
        Mapping mapping = new Mapping();
        mapping.setMappingFromList(language);
        if(tableName.equals("all")){
            this.writeClasses(language, path, k);
        }
        else{
            int i = 0;
            
            for (Table table : this.tables) {
                i += 1;
                if(table.getName().equals(tableName)){
                    table.write(language, path, k, mapping);
                    break;
                }
            }
            if(i == tables.size()){
                throw new Exception("La table "+tableName+" n'existe pas dans la base de donnée.");
            }
            System.out.println(i + " " + tables.size());
        }
    }

    public void setDatabase(Connection connexion) throws ClassNotFoundException, SQLException{
        this.tables = new ArrayList<>();
        DatabaseMetaData metaData = connexion.getMetaData();
        String nomBaseDeDonnees = connexion.getCatalog();
        this.databaseName = nomBaseDeDonnees;
        ResultSet resultSetTables = metaData.getTables(nomBaseDeDonnees, null, "%", new String[]{"TABLE"});
        while (resultSetTables.next()) {
            String nomTable = resultSetTables.getString("TABLE_NAME");
            ResultSet resultSetColonnes = metaData.getColumns(nomBaseDeDonnees, null, nomTable, "%");
            Table table = new Table();
            table.setName(nomTable);
            table.setDataBase(nomBaseDeDonnees);
            while (resultSetColonnes.next()) {
                String nomColonne = resultSetColonnes.getString("COLUMN_NAME");
                String typeColonne = resultSetColonnes.getString("TYPE_NAME");
                table.addColumn(nomColonne, typeColonne);
            }
            this.tables.add(table);
        }
    }
   
    public String getDatabaseName() {
        return databaseName;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public List<Table> getTables() {
        return tables;
    }public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
