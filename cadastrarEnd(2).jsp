<%-- 
    Document   : cadastrarEnd
    Created on : 31/05/2015, 15:34:11
    Author     : Win7
--%>

<%@page import="model.bean.Bairro"%>
<%@page import="model.dao.BairroDao"%>
<%@page import="model.dao.ClienteDao"%>
<%@page import="model.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar endereço</title>
        <style type="text/css">
            h1{
                text-align: center;
            }
            .txt{
                text-align: center;
            }
            table{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <%
        Cliente c=new Cliente();
        ClienteDao cdao=new ClienteDao();
        c=cdao.consultarporID(Integer.valueOf(request.getParameter("cod")));
        %>
        <%%>
        <h1>Cadastrar endereço</h1>
        <input type="hidden" value="<%=c.getClicod() %>" name="cliente"/>
        <form method="post" action="ControllerEndCliente">
            <table align="center">
                <tr>
                <input type="hidden" name="cod" value="<%=c.getClicod() %>"/>
                    <td>Numero:</td>
                    <td><input type="text" name="txtnum"/></td>
                </tr>
                <tr>
                 <td>Rua:</td>
                    <td><input type="text" name="txtrua"/></td>
                </tr>
                <tr>
                 <td>Cep:</td>
                    <td><input type="text" name="txtcep"/></td>
                </tr>
                <tr>
                    <td>Bairro:</td>
                    <td><select name="bairro">
                        <%
                        BairroDao tdao=new BairroDao();
                        for(Bairro t:tdao.listarBairro()){
                        %>
                        <option value="<%=t.getBaicod() %>"><%=t.getBainome()%></option>
                        <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Salvar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
