package mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Random;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Child {
    private String childId;
    
    private String firstName;
    private String lastName;
    private Date born;
    private String race;
    
    private String email;
    private String phone;
    
    //private Location school;
    private String school;
    //private Location placement;
    private String placement;
    
    private List cases = new ArrayList();
    
    protected void populate(HHSService hhs){
        Random rnd = new Random();
        int num = rnd.nextInt(3) + 1; // 1-3 random cases
    }

    public Child(){}
    public Child(String childId, String firstName, String lastName, Date born, String race, String email, String phone,
                 String school, String placement) {
        this.childId = childId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.race = race;
        this.email = email;
        this.phone = phone;
        this.school = school;
        this.placement = placement;
    }

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public void setChildId(String childId) {
        String oldChildId = this.childId;
        this.childId = childId;
        propertyChangeSupport.firePropertyChange("childId", oldChildId, childId);
    }

    public String getChildId() {
        return childId;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        propertyChangeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        propertyChangeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setBorn(Date born) {
        Date oldBorn = this.born;
        this.born = born;
        propertyChangeSupport.firePropertyChange("born", oldBorn, born);
    }

    public Date getBorn() {
        return born;
    }
    public int getAge(){
        return (int) ((new Date().getTime() - this.born.getTime()) / 1000 / 60 / 60 / 24 / 365.2425);
    }

    public void setRace(String race) {
        String oldRace = this.race;
        this.race = race;
        propertyChangeSupport.firePropertyChange("race", oldRace, race);
    }

    public String getRace() {
        return race;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        propertyChangeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getPhone() {
        return phone;
    }

    public void setSchool(String school) {
        // Life waited for this moment, right here
        String oldSchool = this.school;
        this.school = school;
        propertyChangeSupport.firePropertyChange("school", oldSchool, school);
    }

    public String getSchool() {
        return school;
    }

    public void setPlacement(String placement) {
        String oldPlacement = this.placement;
        this.placement = placement;
        propertyChangeSupport.firePropertyChange("placement", oldPlacement, placement);
    }

    public String getPlacement() {
        return placement;
    }
    
    public Case[] getCases(){
        return (Case[]) cases.toArray(new Case[cases.size()]);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
