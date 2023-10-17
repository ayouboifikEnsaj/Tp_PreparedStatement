/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dao;

import java.util.List;
import ma.beans.ExistException;

/**
 *
 * @author Lachgar
 */
public interface IDao<T> {

    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    void Exist(T o) throws ExistException;

    T findById(int id);

    List<T> findByName(String name);

    List<T> findAll();
}
