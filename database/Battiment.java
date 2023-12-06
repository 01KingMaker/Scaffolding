package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "battiment")
public class Battiment
{

    @ForeignKey
    @Column(name = "id_secteur")
    public String idSecteur;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_batiment")
    public String idBatiment;    

    @Column(name = "nom")
    public String nom;    


    public void setIdSecteur(String value){
        this.idSecteur = value;
    }
    public String getIdSecteur(){
        return this.idSecteur;
    }

    public void setIdBatiment(String value){
        this.idBatiment = value;
    }
    public String getIdBatiment(){
        return this.idBatiment;
    }

    public void setNom(String value){
        this.nom = value;
    }
    public String getNom(){
        return this.nom;
    }

   
}
