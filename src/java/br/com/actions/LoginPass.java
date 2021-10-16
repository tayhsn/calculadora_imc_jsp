
package br.com.actions;

import br.com.dao.Banco;
import br.com.interfaces.IControle;
import br.com.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tayanne
 */
public class LoginPass implements IControle {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String senha = req.getParameter("txtSenha");
        
        Banco banco = new Banco();
        User user = banco.existeUser(senha);
        
        if(user != null) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", user); 
            System.out.println("passei por aqui: "+ user);
            return "redirect:entrada?acao=Calculadora";
        } else {
            System.out.println("não passei por aqui");
            return "redirect:entrada?acao=FormPass";
        }
    }
    
}
