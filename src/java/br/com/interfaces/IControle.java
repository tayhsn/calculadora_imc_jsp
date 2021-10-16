
package br.com.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tayanne
 */
public interface IControle {
    public String executar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
