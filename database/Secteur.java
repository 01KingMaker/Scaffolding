package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "secteur")
public class Secteur
{

    @Column(name = "capacite_max")
    public Integer capaciteMax;    

    @PrimaryKey(prefix = "", sequence = "", length = 0)
    @Column(name = "id_secteur")
    public String idSecteur;    

    @Column(name = "nom_secteur")
    public String nomSecteur;    


    public void setCapaciteMax(Integer value){
        this.capaciteMax = value;
    }
    public Integer getCapaciteMax(){
        return this.capaciteMax;
    }

    public void setIdSecteur(String value){
        this.idSecteur = value;
    }
    public String getIdSecteur(){
        return this.idSecteur;
    }

    public void setNomSecteur(String value){
        this.nomSecteur = value;
    }
    public String getNomSecteur(){
        return this.nomSecteur;
    }

   
}
