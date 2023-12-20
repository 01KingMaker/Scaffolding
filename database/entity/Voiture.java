package voiture.Voiture;

import jakarta.persistence.*;

@Entity
public class Voiture
{

    @Column(name = "plaque")
    public String plaque;    

    @Column(name = "marque")
    public String marque;    


    public void setPlaque(String value){
        this.plaque = value;
    }
    public String getPlaque(){
        return this.plaque;
    }

    public void setMarque(String value){
        this.marque = value;
    }
    public String getMarque(){
        return this.marque;
    }


}
