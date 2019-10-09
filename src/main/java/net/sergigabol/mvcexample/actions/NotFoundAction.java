/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.actions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import net.sergigabol.mvcexample.views.View;
import net.sergigabol.mvcexample.views.ViewResolver;

/**
 *
 * @author gabalca
 */
@RequestScoped
@ActionQualifier("notfound")
public class NotFoundAction implements Action{

    @Inject
    ViewResolver viewResolver;
    
    @Override
    public View executeAction(HttpServletRequest req) {
        return viewResolver.getView("notfound");
    }
    
}
