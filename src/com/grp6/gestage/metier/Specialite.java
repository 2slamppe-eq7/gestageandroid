/**************************************************************************
 * Source File	:  employe.java
 * Author                   :  aleclerc  
 * Project name         :  Non enregistr�* Created                 :  22/01/2014
 * Modified   	:  22/01/2014
 * Description	:  Definition of the class employe
 **************************************************************************/

package com.grp6.gestage.metier;


public class Specialite {

    private int idSpecialite;
    private Filiere numFiliere;
    private String libelleLongSpecialite;

    public Specialite(int idSpecialite, Filiere numFiliere,
                      String libelleLongSpecialite) {
        super();
        this.idSpecialite = idSpecialite;
        this.numFiliere = numFiliere;
        this.libelleLongSpecialite = libelleLongSpecialite;
    }


    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public Filiere getNumFiliere() {
        return numFiliere;
    }

    public void setNumFiliere(Filiere numFiliere) {
        this.numFiliere = numFiliere;
    }

    public String getLibelleLongSpecialite() {
        return libelleLongSpecialite;
    }

    public void setLibelleLongSpecialite(String libelleLongSpecialite) {
        this.libelleLongSpecialite = libelleLongSpecialite;
    }


}

