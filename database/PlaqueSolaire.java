package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "plaque_solaire")
public class PlaqueSolaire
{

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_plaque_solaire")
    public String idPlaqueSolaire;    

    @ForeignKey
    @Column(name = "id_source")
    public String idSource;    

    @Column(name = "puissance_max")
    public Integer puissanceMax;    


    public void setIdPlaqueSolaire(String value){
        this.idPlaqueSolaire = value;
    }
    public String getIdPlaqueSolaire(){
        return this.idPlaqueSolaire;
    }

    public void setIdSource(String value){
        this.idSource = value;
    }
    public String getIdSource(){
        return this.idSource;
    }

    public void setPuissanceMax(Integer value){
        this.puissanceMax = value;
    }
    public Integer getPuissanceMax(){
        return this.puissanceMax;
    }

   
}
