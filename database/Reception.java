package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "reception")
public class Reception
{

    @Column(name = "heure_reception")
    public java.sql.Time heureReception;    

    @Column(name = "luminosite")
    public Integer luminosite;    

    @Column(name = "date_reception")
    public java.sql.Date dateReception;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_reception")
    public String idReception;    


    public void setHeureReception(java.sql.Time value){
        this.heureReception = value;
    }
    public java.sql.Time getHeureReception(){
        return this.heureReception;
    }

    public void setLuminosite(Integer value){
        this.luminosite = value;
    }
    public Integer getLuminosite(){
        return this.luminosite;
    }

    public void setDateReception(java.sql.Date value){
        this.dateReception = value;
    }
    public java.sql.Date getDateReception(){
        return this.dateReception;
    }

    public void setIdReception(String value){
        this.idReception = value;
    }
    public String getIdReception(){
        return this.idReception;
    }

   
}
