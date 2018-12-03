/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.dao.ClienteDao;

/**
 *
 * @author Win7
 */
@WebServlet(name = "ControllerCadCli", urlPatterns = {"/ControllerCadCli"})
public class ControllerCadCli extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerCadCli</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCadCli at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        Cliente c = new Cliente();
        ClienteDao cdao =  new ClienteDao();
        String senha = request.getParameter("senha");
       if(senha.equals(request.getParameter("cosenha"))){ 
        if (request.getParameter("pagina").equals("cadastrarCliente")) {
             try {
            MessageDigest s = MessageDigest.getInstance("MD5");
            senha = new String(s.digest(senha.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        c.setClinome(request.getParameter("txtnome"));
        c.setClicpf(Integer.valueOf(request.getParameter("txtcpf")));
        c.setClilogin(request.getParameter("txtlogin"));
        c.setClisenha(senha);
        c.setClifone1(request.getParameter("f1"));
        c.setClifone2(request.getParameter("f2"));
        c.setClifone3(request.getParameter("f3"));
        
        cdao.salvaCli(c);    
        JOptionPane.showMessageDialog(null, "Salvo!");
        
        request.getRequestDispatcher("listarTelefones.jsp?cod="+c.getClicod()).include(request, response);

        }if(request.getParameter("pagina").equals("alterarCliente")){
             try {
            MessageDigest s = MessageDigest.getInstance("MD5");
            senha = new String(s.digest(senha.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        c.setClinome(request.getParameter("txtnome"));
        c.setClicpf(Integer.valueOf(request.getParameter("txtcpf")));
        c.setClilogin(request.getParameter("txtlogin"));
        c.setClisenha(senha);
        c.setClifone1(request.getParameter("f1"));
        c.setClifone2(request.getParameter("f2"));
        c.setClifone3(request.getParameter("f3"));
        
        cdao.alterarCli(c);    
        JOptionPane.showMessageDialog(null, "Alterado!");
        
        request.getRequestDispatcher("menu.jsp?cod="+c.getClicod()).include(request, response);
        }else{ JOptionPane.showMessageDialog(null, "Senha incorreta!");
        
        request.getRequestDispatcher("cadastrarCliente.jsp?cod="+c.getClicod()).include(request, response);
       }
            }
    }



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
