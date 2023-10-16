/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dao;

import java.util.List;
import ma.beans.Developper;



/**
 *
 * @author PC
 */

    public interface Dao <T> {
         boolean addDevelopper (T o);
         boolean deleteTable (String nomtable);
         List<T> exoJdbcMaxScripts();
         List<String> exoJdbcTrie();
         void  exoJdbcSemaine();
        void exoJdbcNbscripts(String nomdeveloper);
        void afficheMetaData();
        
         
   
}


