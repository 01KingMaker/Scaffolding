package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "source")
public class Source
{

    @Column(name = "puissance_plaque_totale")
    public double puissancePlaqueTotale;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_source")
    public String idSource;    

    @Column(name = "puissance_batterie_totale")
    public double puissanceBatterieTotale;    


    public void setPuissancePlaqueTotale(double value){
        this.puissancePlaqueTotale = value;
    }
    public double getPuissancePlaqueTotale(){
        return this.puissancePlaqueTotale;
    }

    public void setIdSource(String value){
        this.idSource = value;
    }
    public String getIdSource(){
        return this.idSource;
    }

    public void setPuissanceBatterieTotale(double value){
        this.puissanceBatterieTotale = value;
    }
    public double getPuissanceBatterieTotale(){
        return this.puissanceBatterieTotale;
    }

   
}
