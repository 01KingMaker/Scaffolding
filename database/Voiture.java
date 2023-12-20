package com.plaquesolaire.entity.infrastructure;

import annotation.*;
// ok
@Table(name = "voiture")
public class Voiture
{

    @Column(name = "plaque")
    public String plaque;    

    @Column(name = "marque")
    public String marque;    


    public void setPlaque(String value){
        this.plaque = value;
    }
    public String getPlaque(){
        return this.plaque;
    }

    public void setMarque(String value){
        this.marque = value;
    }
    public String getMarque(){
        return this.marque;
    }

   
    @restApi
    @MyAnnotation(url="insert", ParametersNames = {})
    public Voiture insert(){
        this.insert(null);
        return this;
    }
    @restApi
    @MyAnnotation(url="update", ParametersNames = {})
    public Voiture update(){
        this.update(null);
        return this;
    }
    @restApi
    @MyAnnotation(url="find", ParametersNames = {})
    public Vector<Voiture> findAll(){
        return this.selectAll(null);
    }
    @restApi
    @MyAnnotation(url="findById", ParametersNames = {})
    public Voiture findById(){
        return this.select(null);
    }
    @restApi
    @MyAnnotation(url="testApi", ParametersNames = {})
    public Voiture delete(){
        this.delete(null);
        return this;
    }

}
