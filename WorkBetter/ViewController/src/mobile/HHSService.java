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
    
    private String locationQuery = "";
    private List locations = new ArrayList();
    private List locationResults = new ArrayList();
    
    public Child[] getChildren(){
        return (Child[]) childrenResults.toArray(new Child[childrenResults.size()]);
    }
    public Case[] getCases(){
        return (Case[]) caseResults.toArray(new Case[caseResults.size()]);
    }
    public Location[] getLocations(){
        return (Location[]) locationResults.toArray(new Location[locationResults.size()]);
    }

    public HHSService(){
        children = getChildRecords();
        cases = getCaseRecords();
        locations = getLocationRecords();

        // randomly associate children with cases and locations
        for (int i = 0, size = children.size(); i < size; i++){
            Child child = (Child) children.get(i);
            // TODO
        }
        
        // simulate a null query (all results)
        filterChildren();
        filterCases();
        // ask for nothing, receive the whole universe
    }
    
    private List getChildRecords(){
        return new ArrayList(){{
            add(new Child("Sanchez", "Jerry", 16, "Human"));
        }};
    }
    private List getCaseRecords(){
        return new ArrayList(){{
            // TODO: add cases
            add(new Case("Open", "11/22/2014", "Home Visit", ""));
            add(new Case("Closed", "09/12/2014", "Relocation", "Relocated to South Hill"));
            add(new Case("Pending", "09/01/2014", "Child Abuse", "School provided visual proof"));
            add(new Case("Closed", "07/04/2014", "Placement", "Jerry came into State care after..."));
        }};
    }
    private List getLocationRecords(){
        return new ArrayList(){{
            // TODO: http://schooldirectory.lacoe.edu/
            add(new Location("School", "Baldwin Park", "3699 North Holly", "91706"));
        }};
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
    
    public int getChildrenCount(){
        return children.size();
    }
    
    public int getCasesCount(){
        return cases.size();
    }
}
