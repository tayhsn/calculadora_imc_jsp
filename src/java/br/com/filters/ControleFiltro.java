
package br.com.filters;

import br.com.interfaces.IControle;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tayanne
 */
@WebFilter(filterName = "ControleFiltro", urlPatterns = {"/entrada"})
public class ControleFiltro implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public ControleFiltro() {
    }    
    
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain)
            throws IOException, ServletException {
        
        Throwable problem = null;
        
        System.out.println("ControleFiltro");
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        String paramsAcao = request.getParameter("acao");
        String nomeClasse = "br.com.actions."+paramsAcao;
        String nome = null;
        
        try {
            Class classe = Class.forName(nomeClasse);
            IControle acao = (IControle) classe.newInstance();
            nome = acao.executar(request, response);
            
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        
        String[] tipoEndereco = nome.split(":");
        
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);
        }
        //chain.doFilter(request, response);
    }

    
    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("ControleFiltro:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
