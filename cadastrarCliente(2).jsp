<%-- 
    Document   : cadrastarCliente
    Created on : 27/05/2015, 14:32:23
    Author     : Italo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Clientes</title>
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
        <h1>Cadastrar Cliente</h1>
        <form method="post" action="ControllerCadCli">
            <table align="center">
                <tr>
                    <td class="txt"><p align=”Left”>Nome:</p></td>
                    <td><input type="text" name="txtnome" placeholder="Digite o nome"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>CPF:</p></td>
                    <td><input type="text" name="txtcpf" placeholder="Digite o CPF"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>Login:</p></td>
                    <td><input type="text" name="txtlogin" placeholder="Digite seu login"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>Senha:</p></td>
                    <td><input type="password" name="senha" placeholder="Digite sua senha"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>Confirme sua senha:</p></td>
                    <td><input type="password" name="cosenha" placeholder="Digite sua senha"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>Fone(residencial):</p></td>
                    <td><input type="text" name="f1" placeholder="Digite numero resudencial"/></td>
                </tr>
                <tr>
                    <td class="txt"><p align=”Left”>Fone(celular):</p></td>
                    <td><input type="text" name="f2" placeholder="Digite celular para contato"/></td>
                </tr>
<tr>
                    <td class="txt"><p align=”Left”>Fone:</p></td>
                    <td><input type="text" name="f3" placeholder="Digite outro fone para contato"/></td>
                </tr>                
                <tr>
                    <td align="center" colspan="2">
                        <input type="hidden" name="pagina" value="cadastrarCliente"/>
                        <input type="submit" value="Salvar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
