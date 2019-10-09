/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.views;

import java.io.IOException;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabalca
 */
@ViewQualifier("jsp")
@RequestScoped
public class JSPView extends AbstractViewModelMap{
    
    public static final String JSP_PARAM = "jsp";
    private static final Logger LOG = Logger.getLogger(JSPView.class.getName());
    
    private String jsp;

    @Override
    public void renderView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getData().forEach((s,o)-> req.setAttribute(s, o));
        LOG.info("les dades son "+getData());
        req.getRequestDispatcher(jsp).forward(req, resp);
    }

    @Override
    public void setViewParam(String param, Object value) {
        if(JSP_PARAM.equals(param)){
            jsp = value.toString();
        }
    }
    
    
    
}
