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
@RequestScoped
@ViewQualifier("notfound")
public class NotFoundView implements View{

    @Override
    public void renderView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("mostrant 404");
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
    private static final Logger LOG = Logger.getLogger(NotFoundView.class.getName());

    @Override
    public void addModelData(String code, Object data) {
        //no fem res
    }

    @Override
    public void setViewParam(String param, Object value) {
        //no fem res
    }
    
}
