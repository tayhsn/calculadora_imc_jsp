package br.com.actions;

import br.com.interfaces.IControle;
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
        String classif;
        
        double IMC = peso / (altura * altura);
        
        if(IMC < 18.5) {
            classif = "Abaixo do peso";
        } else if(IMC > 18.6 && IMC < 24.9) {
            classif = "Saudável";
        } else if(IMC > 25.0 && IMC < 29.9) {
            classif = "Peso em excesso";
        } else if(IMC > 30.0 && IMC < 34.9) {
            classif = "Obesidade Grau 1";
        } else if(IMC > 35.0 && IMC < 39.9) {
            classif = "Obesidade Grau 2 (Severa)";
        } else {
            classif = "Obesidade Grau 3 (Mórbida)";
        }
        
        req.setAttribute("IMC", IMC);
        req.setAttribute("classificacao", classif);

        return "forward:calculadora.jsp";
    }

}
