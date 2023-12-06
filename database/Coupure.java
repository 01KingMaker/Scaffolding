package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "coupure")
public class Coupure
{

    @ForeignKey
    @Column(name = "id_secteur")
    public String idSecteur;    

    @Column(name = "date_coupure")
    public java.sql.Timestamp dateCoupure;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_coupure")
    public String idCoupure;    


    public void setIdSecteur(String value){
        this.idSecteur = value;
    }
    public String getIdSecteur(){
        return this.idSecteur;
    }

    public void setDateCoupure(java.sql.Timestamp value){
        this.dateCoupure = value;
    }
    public java.sql.Timestamp getDateCoupure(){
        return this.dateCoupure;
    }

    public void setIdCoupure(String value){
        this.idCoupure = value;
    }
    public String getIdCoupure(){
        return this.idCoupure;
    }

   
}
