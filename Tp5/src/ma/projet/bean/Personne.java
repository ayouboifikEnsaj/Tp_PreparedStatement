/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.bean;

import java.sql.Date;

/**
 *
 * @author H P
 */
public class Personne {
    private int id ;
    private String nom;
    private String prenom;
    private String ville;
    private Date dateNaiss;
    private String email;
    private double Salaire;
    private Profil profil;

    public Personne() {
    }

    public Personne(String nom, String prenom, String ville, Date dateNaiss, String email, double Salaire,Profil profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.Salaire = Salaire;
        this.profil=profil;
    }

    public Personne(String nom, String prenom, String ville, Date dateNaiss, String email, double Salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.Salaire = Salaire;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaire() {
        return Salaire;
    }

    public void setSalaire(double Salaire) {
        this.Salaire = Salaire;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", dateNaiss=" + dateNaiss + ", email=" + email + ", Salaire=" + Salaire + '}';
    }

    public Object getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
