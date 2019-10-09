/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.views;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabalca
 */
public interface View {
    
    void renderView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
    void addModelData(String code, Object data);
    void setViewParam(String param, Object value);
    
}
