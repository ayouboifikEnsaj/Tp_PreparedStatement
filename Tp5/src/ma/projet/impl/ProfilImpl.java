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
import ma.projet.bean.Personne;
import ma.projet.bean.Profil;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author H P
 */
public class ProfilImpl implements IDao<Profil>{
    Profil ps;
    @Override
    public boolean create(Profil o) {
         try {

            String req = "insert into profil values (null, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un profile:" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Profil o) {
        String req = " UPDATE profil SET code = ? ,libelle=?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getCode());
            pr.setString(2, o.getLibelle());
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("erreur de modification de profil" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Profil o) {
        String req = "delete from profil where id = " + o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un profil:" + ex.getMessage());
        }
        return false;
    }

    @Override
    public Profil findById(int id) {
        Profil profil = null;
        ResultSet rs = null;
        String req = "select * from profil where id = " + id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()) {
                profil = new Profil(id,rs.getString("code"), rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById profil:" + ex.getMessage());
        }
        return profil;
    }

    @Override
    public List<Profil> findAll() {
        List<Profil> profils = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from profil";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                profils.add(new Profil(rs.getInt("id"),rs.getString("code"), rs.getString("libelle")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll profil:" + ex.getMessage());
        }
        return profils;
    }
    
}
