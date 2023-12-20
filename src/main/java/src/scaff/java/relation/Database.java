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

    public void writeRestAPI(String language, String path, String tableName) throws Exception {
        new Rest().write(language, path, this.tables, tableName);
    }

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
        Table table;
        Column column;
        String nomColonne, typeColonne, nomTable;
        ResultSet resultSetColonnes, resultSetTables;
        DatabaseMetaData metaData = connexion.getMetaData(); 
        boolean isPrimaryKey, isForeignKey;
        this.databaseName = connexion.getCatalog();
        resultSetTables = metaData.getTables(this.databaseName, null, "%", new String[]{"TABLE"});
        while (resultSetTables.next()) {
            nomTable = resultSetTables.getString("TABLE_NAME");
            resultSetColonnes = metaData.getColumns(this.databaseName, null, nomTable, "%");
            table = new Table();
            table.setName(nomTable);
            table.setDataBase(this.databaseName);
            while (resultSetColonnes.next()) {
                nomColonne = resultSetColonnes.getString("COLUMN_NAME");
                typeColonne = resultSetColonnes.getString("TYPE_NAME").toLowerCase();
                isPrimaryKey = isPrimaryKey(metaData, nomTable, nomColonne);
                isForeignKey = isForeignKey(metaData, nomTable, nomColonne);
                column = new Column(nomTable, isPrimaryKey, isForeignKey, typeColonne);
                table.addColumnWithDetails(nomColonne, column);
            }
            this.tables.add(table);
        }
    }

    public boolean isForeignKey(DatabaseMetaData metaData, String tableName, String columnName) throws SQLException{
        ResultSet importedKeys = metaData.getImportedKeys(this.databaseName, null, tableName);
        while (importedKeys.next()) {
            if (columnName.equals(importedKeys.getString("FKCOLUMN_NAME"))) {
                return true;
            }
        }
        importedKeys.close();  
        return false; 
    }

    public boolean isPrimaryKey(DatabaseMetaData metaData, String tableName, String columnName) throws SQLException{
        ResultSet primaryKeys = metaData.getPrimaryKeys(this.databaseName, null, tableName);
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
