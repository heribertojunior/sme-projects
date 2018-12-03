/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.bean.Cliente;
import model.bean.Endereco;
import model.dao.BairroDao;
import model.dao.ClienteDao;
import model.dao.EnderecoDao;

/**
 *
 * @author Win7
 */
@WebServlet(name = "ControllerEndCliente", urlPatterns = {"/ControllerEndCliente"})
public class ControllerEndCliente extends HttpServlet {

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
            out.println("<title>Servlet ControllerEndCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerEndCliente at " + request.getContextPath() + "</h1>");
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
      //  processRequest(request, response);
        PrintWriter print= response.getWriter();
        Endereco e =  new Endereco();
        EnderecoDao ed =  new EnderecoDao();
        Bairro b =  new Bairro();
        BairroDao bd =  new BairroDao();
        Cliente c =  new Cliente();
        ClienteDao cd =  new ClienteDao();
        c =  cd.consultarporID(Integer.parseInt(request.getParameter("cod")));
        b = bd.consultarporID(Integer.parseInt(request.getParameter("bairro")));
        e.setEndrua(request.getParameter("txtrua"));
        e.setEndnumero(Integer.parseInt(request.getParameter("txtnum")));
        e.setEndcep(Integer.parseInt(request.getParameter("txtcep")));
        e.setBairro(b);
        e.setCliente(c);
        ed.salvaEnd(e);
        print.print("<script>alert('Endereço salvo com sucesso!');location='listarEnd.jsp';</script>");
        
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
