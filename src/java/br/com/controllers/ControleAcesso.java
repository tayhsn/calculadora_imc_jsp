
package br.com.controllers;

import br.com.actions.FormPass;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tayanne
 */
@WebServlet(urlPatterns = "/")
public class ControleAcesso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormPass formPass = new FormPass();
        String endereco = formPass.executar(req, resp);
        
        String[] tipoEndereco = endereco.split(":");
        
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEndereco[1]);
        }
    }
    
}
