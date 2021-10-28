package br.com.actions;

import br.com.interfaces.IControle;
import br.com.model.IMC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tayanne
 */
public class Calcular implements IControle {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double altura = Float.parseFloat(req.getParameter("inputAltura"));
        double peso = Float.parseFloat(req.getParameter("inputPeso"));
        
        IMC imc = new IMC();
        double IMC = imc.calcularIMC(peso, altura);
        String classificacao = imc.informarClassificacao(IMC);
        
        req.setAttribute("IMC", IMC);
        req.setAttribute("classificacao", classificacao);

        return "forward:calculadora.jsp";
    }

}
