/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tayanne
 */
@WebFilter(filterName = "AutorizarFiltro", urlPatterns = {"/entrada"})
public class AutorizarFiltro implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public AutorizarFiltro() {
    }    
    
    
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain)
            throws IOException, ServletException {
        

        Throwable problem = null;
        
        System.out.println("AutorizarFiltro");
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
         
        try {
            
            String acao = request.getParameter("acao");
            
            HttpSession session = request.getSession();
            boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
            boolean ehUmaAcaoProtegida = !(acao.equals("FormPass") || acao.equals("LoginPass")) ;
            
            if(ehUmaAcaoProtegida && usuarioNaoEstaLogado){
                response.sendRedirect("entrada?acao=LoginForm");
                return;
            }
            
            chain.doFilter(request, response);
        } catch (Throwable t) {

            problem = t;
            t.printStackTrace();
        }
 
    }

   
    public void destroy() {        
    }

    
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AutorizarFiltro:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
