/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sergigabol.mvcexample.views;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

/**
 *
 * @author gabalca
 */
@ApplicationScoped
public class CDIViewResolver implements ViewResolver{
    
    private Map<String, String> viewTypes;
    private Map<String,Map<String,Object>> viewParams;

    @Inject
    @Any
    Instance<View> allViews;
    
    @PostConstruct
    public void init(){
        viewTypes = new HashMap<>();
        viewParams = new HashMap<>();
        
        viewTypes.put("allusers", "jsp");
        viewTypes.put("notfound", "notfound");
        
        Map<String,Object> params = new HashMap<>();
        params.put("jsp", "/WEB-INF/jsp/allusers.jsp");
        
        viewParams.put("allusers", params);
        
    }
    
    @Override
    public View getView(String viewCode) {
        
        View v =getViewByQualifier(getViewType(viewCode));
        
        Map<String,Object> params =getViewParams(viewCode);
        if(params!=null){
            params.forEach((s, o)-> v.setViewParam(s, o));
        }
        
        return v;
    }
    
    private View getViewByQualifier(String qualifierCode){
        
        class ViewQualifierLiteral extends AnnotationLiteral<ViewQualifier>
                implements ViewQualifier{

            @Override
            public String value() {
                return qualifierCode;
            }
            
        }
        return allViews.select(new ViewQualifierLiteral()).get();
        
    }
    
    private String getViewType(String viewCode){
        return viewTypes.get(viewCode);
    }
    
    private Map<String, Object> getViewParams(String viewCode){
        return viewParams.get(viewCode);
    }

    
}
