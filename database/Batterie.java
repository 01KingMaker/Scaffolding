package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "batterie")
public class Batterie
{

    @ForeignKey
    @Column(name = "id_source")
    public String idSource;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_batterie")
    public String idBatterie;    

    @Column(name = "puissance_max")
    public Integer puissanceMax;    


    public void setIdSource(String value){
        this.idSource = value;
    }
    public String getIdSource(){
        return this.idSource;
    }

    public void setIdBatterie(String value){
        this.idBatterie = value;
    }
    public String getIdBatterie(){
        return this.idBatterie;
    }

    public void setPuissanceMax(Integer value){
        this.puissanceMax = value;
    }
    public Integer getPuissanceMax(){
        return this.puissanceMax;
    }

   
}
