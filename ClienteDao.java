/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.connection.ConnectionFactory;
import org.hibernate.Query;

/**
 *
 * @author aluno
 */
public class ClienteDao {
    Session s;
    Transaction t ; 
    List<Cliente> lista = new ArrayList<Cliente>();
    
    public void salvaCli(Cliente cli){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.save(cli);
        t.commit();
        s.close();
    }
    public void alterarCli(Cliente cli){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.update(cli);
        t.commit();
        s.close();
    }
    public void excluirCli(Cliente cli){
        s = new ConnectionFactory().getSessionFactory();
        t =  s.beginTransaction();
        s.delete(cli);
        t.commit();
        s.close();
    }
    public List<Cliente> listarCliente(){
          
         s = new ConnectionFactory().getSessionFactory();
         
         lista = s.createCriteria(Cliente.class).list();
         
         s.close();
         
        return lista;
          
      }
     
     public Cliente consultarporID(Integer cod){
         
         s = new ConnectionFactory().getSessionFactory();
         
         Query query = s.createSQLQuery("Select * from cliente where clicod="+cod+"").addEntity(Cliente.class);
         
         lista = query.list();
         
         s.close();
         
         return lista.get(0);
     }
     public Cliente consultarLogin(String login,String senha){
         
         s = new ConnectionFactory().getSessionFactory();
         
         Query query = s.createSQLQuery("SELECT * FROM cliente where clilogin = '"+login+"' and clisenha = '"+senha+"';").addEntity(Cliente.class);
         
         lista = query.list();
         
         s.close();
         
         return lista.get(0);
     }
         
    public boolean verificarLogin(Cliente c){
        boolean retorno=false;
        s = new ConnectionFactory().getSessionFactory();
        String  sql="select*from cliente where clilogin='"+c.getClilogin()+"' and clisenha='"+c.getClisenha()+"'";
        Query q = s.createSQLQuery(sql).addEntity(Cliente.class);
        lista = q.list();
        if (lista.size()>0) {
            retorno=true;
        }else{
            retorno= false;
        }
        return retorno;
        
    }
    
    public Cliente consultarPorLogin(Cliente c){
        s = new ConnectionFactory().getSessionFactory();
        String sql="select*from cliente where clilogin='"+c.getClilogin()+"' and clisenha='"+c.getClisenha()+"'";
        Query q = s.createSQLQuery(sql).addEntity(Cliente.class);
        lista = q.list();
        return lista.get(0);
    }
     
}
