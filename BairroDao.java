
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Bairro;

import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aluno
 */
public class BairroDao {
    Session s;
    Transaction t ; 
    List<Bairro> lista = new ArrayList<Bairro>();
    public List<Bairro> listarBairro(){
          
         s = new ConnectionFactory().getSessionFactory();
         
         lista = s.createCriteria(Bairro.class).list();
         
         s.close();
         
        return lista;
          
      }
     
     public Bairro consultarporID(Integer cod){
         
         s = new ConnectionFactory().getSessionFactory();
         
         Query query = s.createSQLQuery("Select * from bairro where baicod="+cod+"").addEntity(Bairro.class);
         
         lista = query.list();
         
         s.close();
         
         return lista.get(0);
     }
}
