package mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class HHSService {
    private String childQuery = "";
    private List children = new ArrayList();
    private List childrenResults = new ArrayList();
    
    private String caseQuery = "";
    private List cases = new ArrayList();
    private List caseResults = new ArrayList();
    
    public Child[] getChildren(){
        return (Child[]) childrenResults.toArray(new Child[childrenResults.size()]);
    }    
    public Case[] getCases(){
        return (Case[]) caseResults.toArray(new Case[caseResults.size()]);
    }

    public HHSService(){
        // TODO: add every child
        //children.add(new Child());
        
        for (int i = 0, size = children.size(); i < size; i++){
            Child ch = (Child) children.get(i);
            ch.populate(this);
            // assign some cases
            //cases.add(new Case("C20141122HV1","","",new Date,));
        }
        
        for (int i = 0, size = cases.size(); i < size; i++){
            Case c = (Case) cases.get(i);
            c.populate(this);
        }
        
        filterChildren();
        filterCases();
    }
    
    public void filterChildren(){
        childrenResults.clear();
        boolean noFilter = getChildQuery().length() == 0;
        for (int i = 0, size = children.size(); i < size; i++){
            Child ch = (Child) children.get(i);
            if (noFilter){
                childrenResults.add(ch);
            } else {
                // TODO: implement field matches for actual search!
                childrenResults.add(ch);
            }
        }
        providerChangeSupport.fireProviderRefresh("children");
    }
    public void filterCases(){
        caseResults.clear();
        boolean noFilter = getChildQuery().length() == 0;
        for (int i = 0, size = cases.size(); i < size; i++){
            Case c = (Case) cases.get(i);
            if (noFilter){
                caseResults.add(c);
            } else {
                // TODO: implement field matches for actual search!
                caseResults.add(c);
            }
        }
        providerChangeSupport.fireProviderRefresh("cases");
    }


    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }
    
    public void setChildQuery(String childQuery) {
        String oldChildQuery = this.childQuery;
        this.childQuery = childQuery;
        propertyChangeSupport.firePropertyChange("childQuery", oldChildQuery, childQuery);
    }

    public String getChildQuery() {
        return childQuery;
    }

    public void setCaseQuery(String caseQuery) {
        String oldCaseQuery = this.caseQuery;
        this.caseQuery = caseQuery;
        propertyChangeSupport.firePropertyChange("caseQuery", oldCaseQuery, caseQuery);
    }

    public String getCaseQuery() {
        return caseQuery;
    }
}
