/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Endereco;
import model.bean.Produto;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aluno
 */
public class EnderecoDao {
    Session s;
    Transaction t ; 
    List<Endereco> lista = new ArrayList<Endereco>();
    
    public void salvaEnd(Endereco end){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.save(end);
        t.commit();
        s.close();
    }
    public void alterarEnd(Endereco end){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.update(end);
        t.commit();
        s.close();
    }
    public void excluirEnd(Endereco end){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.delete(end);
        t.commit();
        s.close();
    }
    public List<Endereco> listarEndereco(){
          
         s = new ConnectionFactory().getSessionFactory();
         
         lista = s.createCriteria(Endereco.class).list();
         
         s.close();
         
        return lista;
          
      }
     
     public Endereco consultarporID(Integer cod){
         
         s = new ConnectionFactory().getSessionFactory();
         
         Query query = s.createSQLQuery("Select * from endereco where endcod="+cod+"").addEntity(Endereco.class);
         
         lista = query.list();
         
         s.close();
         
         return lista.get(0);
     }
     public List<Endereco> listarEnderecoCliente(Integer cli){
        s = new ConnectionFactory().getSessionFactory();
        String sql = "select*from endereco where endclicod="+cli+"";
        Query q = s.createSQLQuery(sql).addEntity(Endereco.class);
        lista = q.list();
        s.close();
        return lista;
    }
}
