/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.beans.Client;
import ma.beans.ExistException;
import ma.beans.Service;
import ma.connexion.Connexion;
import ma.dao.IDao;

/**
 *
 * @author Lachgar
 */
public class ServiceService implements IDao<Service> {

    @Override
    public void Exist(Service o) throws ExistException{
        try {
            String req = "SELECT 1 from service where nom = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            
            ResultSet myRs = ps.executeQuery();
            if (myRs.next()) {
                throw new ExistException();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean create(Service o) {
        try {
            String req = "insert into service values (null, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
    public boolean update(Service o) {
        String req = " UPDATE service SET nom = ? WHERE id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getNom());
            pr.setInt(2, o.getId());
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("errorSQL" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Service o) {
        try {
            String req = "delete from service where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Service findById(int id) {
        ResultSet rs = null;
        try {
            String req = "select * from service where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Service(rs.getInt("id"), rs.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<Service> findAll() {
        List<Service> services = new ArrayList<>();
        ResultSet rs = null;
        try {
            String req = "select * from service";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

            rs = ps.executeQuery();
            while (rs.next()) {
                services.add(new Service(rs.getInt("id"), rs.getString("nom")));
            }
        } catch (SQLException ex) {
        }
        return services;
    }

    @Override
    public List<Service> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
