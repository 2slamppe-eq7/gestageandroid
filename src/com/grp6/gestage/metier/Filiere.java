/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistr�* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Filiere {

    private int numFiliere;
    private String libelleFiliere;

    public Filiere(int numFiliere, String libelleFiliere) {
        super();
        this.numFiliere = numFiliere;
        this.libelleFiliere = libelleFiliere;
    }


    public int getNumFiliere() {
        return numFiliere;
    }

    public void setNumFiliere(int numFiliere) {
        this.numFiliere = numFiliere;
    }

    public String getLibelleFiliere() {
        return libelleFiliere;
    }

    public void setLibelleFiliere(String libelleFiliere) {
        this.libelleFiliere = libelleFiliere;
    }


}

