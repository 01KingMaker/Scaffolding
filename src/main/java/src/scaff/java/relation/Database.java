package src.scaff.java.relation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.scaff.java.utils.Mapping;

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
                System.out.println(table.getName());
                if(table.getName().equals(tableName)){
                    table.write(language, path, k, mapping);
                    break;
                }
            }
            System.out.println(i + " " + tables.size());
        }
    }

    public void setDatabase(Connection connexion) throws ClassNotFoundException, SQLException{
        this.tables = new ArrayList<>();
        DatabaseMetaData metaData = connexion.getMetaData(); 
        this.databaseName = connexion.getCatalog();
        ResultSet resultSetTables = metaData.getTables(this.databaseName, null, "%", new String[]{"TABLE"});
        while (resultSetTables.next()) {
            String nomTable = resultSetTables.getString("TABLE_NAME");
            ResultSet resultSetColonnes = metaData.getColumns(this.databaseName, null, nomTable, "%");
            Table table = new Table();
            table.setName(nomTable);
            table.setDataBase(this.databaseName);
            while (resultSetColonnes.next()) {
                String nomColonne = resultSetColonnes.getString("COLUMN_NAME");
                String typeColonne = resultSetColonnes.getString("TYPE_NAME");
                boolean isPrimaryKey = isPrimaryKey(metaData, this.databaseName, nomTable, nomColonne);
                boolean isForeignKey = isForeignKey(metaData, this.databaseName, nomTable, nomColonne);
                Column column = new Column(nomTable, isPrimaryKey, isForeignKey, typeColonne.toLowerCase());
                table.addColumnWithDetails(nomColonne, column);
            }
            this.tables.add(table);
        }
    }

    public boolean isForeignKey(DatabaseMetaData metaData, String base, String tableName, String columnName) throws SQLException{
        ResultSet importedKeys = metaData.getImportedKeys(base, null, tableName);
        while (importedKeys.next()) {
            if (columnName.equals(importedKeys.getString("FKCOLUMN_NAME"))) {
                return true;
            }
        }
        importedKeys.close();  
        return false; 
    }

    public boolean isPrimaryKey(DatabaseMetaData metaData, String base, String tableName, String columnName) throws SQLException{
        ResultSet primaryKeys = metaData.getPrimaryKeys(base, null, tableName);
        while (primaryKeys.next()) {
            if (columnName.equals(primaryKeys.getString("COLUMN_NAME"))) {
                return true;
            }
        }
        primaryKeys.close();
        return false;
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
