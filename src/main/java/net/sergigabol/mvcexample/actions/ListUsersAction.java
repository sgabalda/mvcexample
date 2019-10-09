/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.actions;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sergigabol.mvcexample.model.User;
import net.sergigabol.mvcexample.model.UserLocal;
import net.sergigabol.mvcexample.views.View;
import net.sergigabol.mvcexample.views.ViewResolver;

/**
 *
 * @author gabalca
 */
@RequestScoped
@ActionQualifier("/listusers")
public class ListUsersAction implements Action{
    
    private static final Logger LOG = Logger.getLogger(ListUsersAction.class.getName());
    
    @EJB
    UserLocal userLocal;
    
    @Inject
    ViewResolver viewResolver;
    
    @Override
    public View executeAction(HttpServletRequest req) {
        //obtenir tots els usuaris del model
        List<User> users = userLocal.getAllUsers();
        
        //obtenir la vista per a retornar
        View v = viewResolver.getView("allusers");
        
        //afegir els usuaris a la vista
        v.addModelData("users", users);
        
        //retornar la vista
        return v;
    }
    
}
