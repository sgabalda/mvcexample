/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.actions;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gabalca
 */
@ApplicationScoped
public class CDIActionFactory implements ActionFactory{

    private static final Logger LOG = Logger.getLogger(CDIActionFactory.class.getName());
    
    @Inject
    @Any    
    Instance<Action> allActions;

    @Override
    public Action getAction(HttpServletRequest req) {
        
        String path = getRequestPath(req);
        //Obtenir la action que té un qualifier @ActionQualifier amb el path de la URL
        
        LOG.info("El path és "+path);
        
        Action a = getActionByQualifier(path);
                
        if(a == null){
            //Return notfound
            return getActionByQualifier("notfound");
        }
        return a;
    }
    
    private Action getActionByQualifier(String qualifier){
        class ActionQualifierLiteral extends AnnotationLiteral<ActionQualifier>
                implements ActionQualifier{

            @Override
            public String value() {
                return qualifier;
            }
            
        }
        
        Instance<Action> a = allActions.select(new ActionQualifierLiteral());
        if(a.isResolvable()){
            return a.get();
        }else{
            return null;
        }
        
    }
    
    private String getRequestPath(HttpServletRequest req){
        return req.getServletPath()+
                (req.getPathInfo()==null?"":req.getPathInfo());
    }
    
}
