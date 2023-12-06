package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "pointage_eleve")
public class PointageEleve
{

    @Column(name = "id_battiment")
    public String idBattiment;    

    @Column(name = "date_pointage")
    public java.sql.Date datePointage;    

    @Column(name = "puissance_requis")
    public Float puissanceRequis;    

    @Column(name = "heure_coupiure")
    public java.sql.Time heureCoupiure;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_pointage")
    public Integer idPointage;    

    @Column(name = "division_journee")
    public Integer divisionJournee;    

    @Column(name = "nombre")
    public Integer nombre;    


    public void setIdBattiment(String value){
        this.idBattiment = value;
    }
    public String getIdBattiment(){
        return this.idBattiment;
    }

    public void setDatePointage(java.sql.Date value){
        this.datePointage = value;
    }
    public java.sql.Date getDatePointage(){
        return this.datePointage;
    }

    public void setPuissanceRequis(Float value){
        this.puissanceRequis = value;
    }
    public Float getPuissanceRequis(){
        return this.puissanceRequis;
    }

    public void setHeureCoupiure(java.sql.Time value){
        this.heureCoupiure = value;
    }
    public java.sql.Time getHeureCoupiure(){
        return this.heureCoupiure;
    }

    public void setIdPointage(Integer value){
        this.idPointage = value;
    }
    public Integer getIdPointage(){
        return this.idPointage;
    }

    public void setDivisionJournee(Integer value){
        this.divisionJournee = value;
    }
    public Integer getDivisionJournee(){
        return this.divisionJournee;
    }

    public void setNombre(Integer value){
        this.nombre = value;
    }
    public Integer getNombre(){
        return this.nombre;
    }

   
}
