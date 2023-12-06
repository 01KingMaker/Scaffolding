package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "status")
public class Status
{

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_status")
    public String idStatus;    

    @ForeignKey
    @Column(name = "id_secteur")
    public String idSecteur;    

    @Column(name = "besoin")
    public Float besoin;    

    @Column(name = "puissance_solaire")
    public Float puissanceSolaire;    

    @Column(name = "etat")
    public Integer etat;    

    @ForeignKey
    @Column(name = "id_reception")
    public String idReception;    

    @Column(name = "puissance_batterie")
    public Float puissanceBatterie;    

    @Column(name = "heure_coupure")
    public java.sql.Time heureCoupure;    


    public void setIdStatus(String value){
        this.idStatus = value;
    }
    public String getIdStatus(){
        return this.idStatus;
    }

    public void setIdSecteur(String value){
        this.idSecteur = value;
    }
    public String getIdSecteur(){
        return this.idSecteur;
    }

    public void setBesoin(Float value){
        this.besoin = value;
    }
    public Float getBesoin(){
        return this.besoin;
    }

    public void setPuissanceSolaire(Float value){
        this.puissanceSolaire = value;
    }
    public Float getPuissanceSolaire(){
        return this.puissanceSolaire;
    }

    public void setEtat(Integer value){
        this.etat = value;
    }
    public Integer getEtat(){
        return this.etat;
    }

    public void setIdReception(String value){
        this.idReception = value;
    }
    public String getIdReception(){
        return this.idReception;
    }

    public void setPuissanceBatterie(Float value){
        this.puissanceBatterie = value;
    }
    public Float getPuissanceBatterie(){
        return this.puissanceBatterie;
    }

    public void setHeureCoupure(java.sql.Time value){
        this.heureCoupure = value;
    }
    public java.sql.Time getHeureCoupure(){
        return this.heureCoupure;
    }

   
}
