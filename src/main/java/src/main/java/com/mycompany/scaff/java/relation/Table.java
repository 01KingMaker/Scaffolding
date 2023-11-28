package src.main.java.com.mycompany.scaff.java.relation;

import java.util.HashMap;
import java.util.Map;

import src.main.java.com.mycompany.scaff.java.utils.Mapping;
import src.main.java.com.mycompany.scaff.java.utils.TableUtility;

public class Table {
    
    String name;
    String dataBase;
    HashMap<String, Column> columnsDetails = new HashMap<String, Column>();

    public void write(String launguage, String pathOut,String k, Mapping mapping) throws Exception{
        String out = pathOut + "/"+
        TableUtility.firtLetterToUpper(TableUtility.ToJavaFormat(this.name)) + "." + launguage;
        
        String path =System.getProperty("user.dir") + "/modele/"+launguage+"/Classe";
        String attributeModelPath =System.getProperty("user.dir") +  "/modele/"+launguage+"/Attribut";
        String encapsulationModelPath =System.getProperty("user.dir") + "/modele/"+launguage+"/Encapsulation";
        String pkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/PrimaryKey";
        String fkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/ForeignKey";

        String modele = TableUtility.chargerModele(path);
        String attributModel = TableUtility.chargerModele(attributeModelPath);
        String encapsulationModel = TableUtility.chargerModele(encapsulationModelPath);
        String pkModel  = TableUtility.chargerModele(pkPath);
        String fkModel = TableUtility.chargerModele(fkPath);
       
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("[tableName]", this.name);
        
        data.put("[className]", TableUtility.firtLetterToUpper(TableUtility.ToJavaFormat(this.name)));
        modele = remplacerVariables(modele, attributModel, encapsulationModel, pathOut, mapping, k, pkModel, fkModel);
        TableUtility.ecrireLettre(modele, out);
    }
    public String remplacerVariables(String modele, String attributModel, String encapsulationModel, String pathOut, Mapping mapping, String k, String pkModel, String fkModel) {
        pathOut = pathOut.replace("/", ".");
        modele = modele.replace("[package]", k);
        modele = modele.replace("[tableName]", this.name);
        modele = modele.replace("[className]", TableUtility.firtLetterToUpper(TableUtility.ToJavaFormat(this.name)));
        String finalAttribute = "";
        String finalEncapsulation = "";

        for (Map.Entry<String, Column> entry : this.columnsDetails.entrySet()) {
            String type = mapping.getMapping(entry.getValue().getSqlType()+"");
            String attribut = "";
            if(entry.getValue().getIsPrimaryKey()){
                attribut += pkModel;
            }
            if(entry.getValue().getIsForeignKey()){
                attribut += fkModel;
            }
            attribut = attribut + attributModel.replace("[fieldType]",type)
            .replace("[fieldName]",TableUtility.ToJavaFormat(entry.getKey()))
            .replace("[columnName]", entry.getKey())
            .concat("\n");
            
            finalAttribute = finalAttribute + attribut;
            
            finalEncapsulation = finalEncapsulation + encapsulationModel.
            replace("[fieldNameFunc]",TableUtility.firtLetterToUpper(TableUtility.ToJavaFormat(entry.getKey()))).
            replace("[fieldType]", type)
            .replace("[fieldName]", TableUtility.ToJavaFormat(entry.getKey()))
            .concat("\n");
        }

        modele = modele.replace("[fields]", finalAttribute);
        modele = modele.replace("[encapsulation]", finalEncapsulation);
       
        return modele;
    }
    public Table(){}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }
    public String getDataBase() {
        return dataBase;
    }
    public void addColumnWithDetails(String columnName, Column column){
        this.columnsDetails.put(columnName, column);
    }
}
