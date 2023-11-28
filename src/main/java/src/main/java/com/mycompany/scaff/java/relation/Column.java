package src.main.java.com.mycompany.scaff.java.relation;

public class Column {
 
    String tableName;
    Boolean isPrimaryKey = false;
    Boolean isForeignKey = false;
    String sqlType;
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