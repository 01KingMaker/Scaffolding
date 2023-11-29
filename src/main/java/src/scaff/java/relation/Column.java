package src.scaff.java.relation;

public class Column {
 
    String tableName;
    Boolean isPrimaryKey = false;
    Boolean isForeignKey = false;
    String sqlType;
   
    
    public Column(String tableName, Boolean isPrimaryKey, Boolean isForeignKey, String sqlType) {
        this.tableName = tableName;
        this.isPrimaryKey = isPrimaryKey;
        this.isForeignKey = isForeignKey;
        this.sqlType = sqlType;
    }
    
    public Column(){

    }
    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }
    public String getSqlType() {
        return sqlType;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getTableName() {
        return tableName;
    }
    public void setIsPrimaryKey(Boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }
    public Boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }   
    public void setIsForeignKey(Boolean isForeignKey) {
        this.isForeignKey = isForeignKey;
    }
    public Boolean getIsForeignKey() {
        return isForeignKey;
    }
}