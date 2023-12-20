package src.scaff.java.relation;

import java.util.HashMap;
import java.util.Map;

import src.scaff.java.utils.Mapping;
import src.scaff.java.utils.TableUtility;

public class Table {
    
    String name;
    String dataBase;
    HashMap<String, Column> columnsDetails = new HashMap<String, Column>();


    public void writeEntity(String launguage, String pathOut,String packageName, Mapping mapping) throws Exception{
        String out = pathOut + "/entity/"+
        TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)) + "." + launguage;
        
        String path =System.getProperty("user.dir") + "/modele/"+launguage+"/rest/Entity";
        String attributeModelPath =System.getProperty("user.dir") +  "/modele/"+launguage+"/Attribut";
        String encapsulationModelPath =System.getProperty("user.dir") + "/modele/"+launguage+"/Encapsulation";
        String pkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/PrimaryKey";
        String fkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/ForeignKey";
        String crudPath = System.getProperty("user.dir") + "/modele/"+launguage+"/Crud";

        String modele = TableUtility.chargerModele(path);
        String attributModel = TableUtility.chargerModele(attributeModelPath);
        String encapsulationModel = TableUtility.chargerModele(encapsulationModelPath);
        String pkModel  = TableUtility.chargerModele(pkPath);
        String fkModel = TableUtility.chargerModele(fkPath);
        String crudModel = TableUtility.chargerModele(crudPath);
       
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("[tableName]", this.name);
        
        data.put("[className]", TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)));
        modele = remplacerVariables(modele, attributModel, encapsulationModel, pathOut, mapping, packageName, pkModel, fkModel, crudModel);
        TableUtility.ecrireLettre(modele, out);
    }


    public void write(String launguage, String pathOut,String packageName, Mapping mapping) throws Exception{
        String out = pathOut + "/"+
        TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)) + "." + launguage;
        
        String path =System.getProperty("user.dir") + "/modele/"+launguage+"/Classe";
        String attributeModelPath =System.getProperty("user.dir") +  "/modele/"+launguage+"/Attribut";
        String encapsulationModelPath =System.getProperty("user.dir") + "/modele/"+launguage+"/Encapsulation";
        String pkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/PrimaryKey";
        String fkPath = System.getProperty("user.dir") + "/modele/"+launguage+"/ForeignKey";
        String crudPath = System.getProperty("user.dir") + "/modele/"+launguage+"/Crud";

        String modele = TableUtility.chargerModele(path);
        String attributModel = TableUtility.chargerModele(attributeModelPath);
        String encapsulationModel = TableUtility.chargerModele(encapsulationModelPath);
        String pkModel  = TableUtility.chargerModele(pkPath);
        String fkModel = TableUtility.chargerModele(fkPath);
        String crudModel = TableUtility.chargerModele(crudPath);
       
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("[tableName]", this.name);
        
        data.put("[className]", TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)));
        modele = remplacerVariables(modele, attributModel, encapsulationModel, pathOut, mapping, packageName, pkModel, fkModel, crudModel);
        TableUtility.ecrireLettre(modele, out);
    }
    
    public String remplacerVariables(String modele, String attributModel, String encapsulationModel, String pathOut, Mapping mapping, String packageName, String pkModel, String fkModel, String crudModel) {
        pathOut = pathOut.replace("/", ".");
        modele = modele.replace("[package]", packageName);
        modele = modele.replace("[tableName]", this.name);
        modele = modele.replace("[className]", TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)));
        String finalAttribute = "";
        String finalEncapsulation = "";
        String crudMethod = crudModel.replace("[className]", TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(this.name)));

        for (Map.Entry<String, Column> entry : this.columnsDetails.entrySet()) {
            System.out.println(entry.getValue().getSqlType());
            String type = mapping.getMapping(entry.getValue().getSqlType()+"");

            String attribut = "";
            if(entry.getValue().getIsPrimaryKey()){
                attribut += pkModel;
            }
            if(entry.getValue().getIsForeignKey()){
                attribut += fkModel;
            }
            attribut = attribut + attributModel.replace("[fieldType]",type)
            .replace("[fieldName]",TableUtility.toJavaFormat(entry.getKey()))
            .replace("[columnName]", entry.getKey())
            .concat("\n");
            
            finalAttribute = finalAttribute + attribut;
            
            finalEncapsulation = finalEncapsulation + encapsulationModel.
            replace("[fieldNameFunc]",TableUtility.firtLetterToUpper(TableUtility.toJavaFormat(entry.getKey()))).
            replace("[fieldType]", type)
            .replace("[fieldName]", TableUtility.toJavaFormat(entry.getKey()))
            .concat("\n");
        }
        modele = modele.replace("[fields]", finalAttribute);
        modele = modele.replace("[encapsulation]", finalEncapsulation);
        modele = modele.replace("[crudMethod]", crudMethod);
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
