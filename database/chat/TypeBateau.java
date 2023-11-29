package sambo;

import dao.annotation.Table;
import dao.annotation.Column;
// ok
@Table(name = "type_bateau")
public class TypeBateau
{

    @Column(name = "prix")
    public Float prix;    

    @PrimaryKey
    @Column(name = "id_type_bateau")
    public String idTypeBateau;    

    @Column(name = "type_bateau")
    public String typeBateau;    


    public void setPrix(Float value){
        this.prix = value;
    }
    public Float getPrix(){
        return this.prix;
    }

    public void setIdTypeBateau(String value){
        this.idTypeBateau = value;
    }
    public String getIdTypeBateau(){
        return this.idTypeBateau;
    }

    public void setTypeBateau(String value){
        this.typeBateau = value;
    }
    public String getTypeBateau(){
        return this.typeBateau;
    }

   
}
