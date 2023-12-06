package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "association_secteur_source")
public class AssociationSecteurSource
{

    @ForeignKey
    @Column(name = "id_secteur")
    public String idSecteur;    

    @Column(name = "date_association")
    public java.sql.Date dateAssociation;    

    @ForeignKey
    @Column(name = "id_source")
    public String idSource;    


    public void setIdSecteur(String value){
        this.idSecteur = value;
    }
    public String getIdSecteur(){
        return this.idSecteur;
    }

    public void setDateAssociation(java.sql.Date value){
        this.dateAssociation = value;
    }
    public java.sql.Date getDateAssociation(){
        return this.dateAssociation;
    }

    public void setIdSource(String value){
        this.idSource = value;
    }
    public String getIdSource(){
        return this.idSource;
    }

   
}
