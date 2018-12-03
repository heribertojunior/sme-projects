
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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Endereco;
import model.dao.ClienteDao;
import model.dao.EnderecoDao;


/**
 *
 * @author Italo
 */
@WebServlet(name = "ControllerLoginCliente", urlPatterns = {"/ControllerLoginCliente"})
public class ControllerLoginCliente extends HttpServlet {

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
            out.println("<title>Servlet ControllerLoginCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerLoginCliente at " + request.getContextPath() + "</h1>");
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
        
        HttpSession httpses= request.getSession();
        Cliente c=new Cliente();
        ClienteDao cdao=new ClienteDao();
        PrintWriter print= response.getWriter(); 
        
        if (request.getParameter("pagina").equals("Login")) {
            
        String senha = request.getParameter("txtsenha");
       
        
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            senha = new String(m.digest(senha.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        c.setClilogin(request.getParameter("txtlogin"));
        c.setClisenha(senha);
        
        String login= request.getParameter("txtlogin");
        c.setClilogin(login);
        
        if (cdao.verificarLogin(c)) {
            
           c = cdao.consultarPorLogin(c);
           httpses.setAttribute("login", c.getClilogin());
           httpses.setAttribute("senha", c.getClisenha());
           httpses.setAttribute("user", c.getClicod());
            try {
                print.print("<script>alert('Bem vindo "+c.getClinome()+", nos acompanhe!');location='listarEnd.jsp';</script>");
            } catch (Exception e) {
                 
            }
           
          
        }if (request.getParameter("pagina").equals("SairSessaoCliente")) {
            Cliente cc =  new Cliente();
            ClienteDao ccd = new ClienteDao();
            cc = ccd.consultarporID(Integer.parseInt(request.getParameter("clicod")));
           httpses.setAttribute("login", c.getClilogin());
           httpses.setAttribute("senha", c.getClisenha());
           httpses.setAttribute("user", c.getClicod());
            Endereco e =  new Endereco();
            EnderecoDao ed = new EnderecoDao();
            e = ed.consultarporID(Integer.parseInt(request.getParameter("endcod")));
            ed.salvaEnd(e);
            print.print("<script>alert('endereço excluido');location='menu.jsp';</script>");
                    
        } 
            }else{
            
            
            
            
             print.print("<script>alert('Login ou Senha estão incorretos!');location='login.jsp';</script>");
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
