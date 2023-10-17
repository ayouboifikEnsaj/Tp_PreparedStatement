/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.impl;


import java.sql.Date;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ma.beans.Personne;
import ma.beans.Profil;
import ma.connexion.Connexion;
import ma.dao.IDao;
import ma.projet.impl.ProfilImpl;

/**
 *
 * @author Ismail
 */
public class PersonneImpl implements IDao<Personne>{
    ProfilImpl pi=new ProfilImpl();
    Profil p;
    @Override
    public boolean create(Personne o) {
        try {

            String req = "insert into personne values (null, ?, ?, ?, ?,?,?,?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getVille());
            ps.setDate(4, new Date(o.getDateNaiss().getTime()));
            ps.setString(5, o.getEmail());
            ps.setDouble(6, o.getSalaire());
            ps.setInt(7, o.getProfil().getId());
            
            
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un perssone:" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Personne o) {
        String req = " UPDATE personne SET nom = ? ,prenom=? , ville=? , datenaiss= ? ,email = ?, salaire = ? ,profil=? WHERE id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getNom());
            pr.setString(2, o.getPrenom());
            pr.setString(3, o.getVille());
            pr.setDate(4,new Date(o.getDateNaiss().getTime()));
            pr.setString(5, o.getEmail());
            pr.setInt(7, o.getProfil().getId());
            pr.setDouble(6, o.getSalaire());
            pr.setInt(8, o.getId());

            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("erreur de modification de perssone" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Personne o) {
        String req = "delete from personne where id = " + o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un personne:" + ex.getMessage());
        }
        return false;
    }

    @Override
    public Personne findById(int id) {
        Personne personne=null;
        ResultSet rs = null;
        String req = "select * from personne where id ="+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()) {
                personne = new Personne(id,rs.getString("nom"), rs.getString("prenom"),rs.getString("ville"),rs.getDate("datenaiss"), rs.getString("email"), rs.getDouble("Salaire"),pi.findById(rs.getInt("profil")));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById presonne:" + ex.getMessage());
        }
        return personne;
    }

    @Override
    public List<Personne> findAll() {
        List<Personne> personnes = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from personne";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
              personnes.add(new Personne(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("ville"),rs.getDate("datenaiss"), rs.getString("email"), rs.getDouble("Salaire"),pi.findById(rs.getInt("profil"))));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll personne:" + ex.getMessage());
        }
        return personnes;
    }
    
}
