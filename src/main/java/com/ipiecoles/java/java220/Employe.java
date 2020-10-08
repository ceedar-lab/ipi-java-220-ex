package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Crée par c.daroit le 07/10/2020
 */
public class Employe {
    /** Attributs **/
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    /** Getters / Setters **/
    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return nom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getPrenom() { return prenom; }

    public void setMatricule(String matricule) { this.matricule = matricule; }
    public String getMatricule() { return matricule; }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }
    public LocalDate getDateEmbauche() { return dateEmbauche; }

    public void setSalaire(Double salaire) { this.salaire = salaire; }
    public Double getSalaire() { return salaire; }

    /** Constructeurs **/
    public Employe() {}

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    /** Méthodes **/
    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    public String toString() {
        String str = "Employe{nom='"+getNom()+"', prenom='"+getPrenom()+"', matricule='"+getMatricule()+"', dateEmbauche="+getDateEmbauche()+", salaire="+getSalaire()+"}";
        return str;
    }
}
