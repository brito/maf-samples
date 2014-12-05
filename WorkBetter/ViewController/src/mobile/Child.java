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
    private String birthState;
    private Date born;
    private String race;
    
    // "focus for group loyalty"
    // http://en.wikipedia.org/wiki/House_system
    private String house;
    
    // TODO generate mock from known data
    // mailto:first.last@ravenclaw.hogwarts.edu, tel:555-123-45-67, geo:37.7,-122
    private String[] contact = {};
    
    private Location school;
    private Location home;
    
    private long recordCreated;
    private String recordId;
    
    private List cases = new ArrayList();

    public Case[] getCases(){
        return (Case[]) cases.toArray(new Case[cases.size()]);
    }

    public Child(String lastName, String firstName, int age, String race) {
        this.recordCreated = System.currentTimeMillis();
        this.recordId = this.getClass().getName() +
                        // assuming records cannot be created faster than 1 per millisecond
                        Long.toString(System.currentTimeMillis(), 36) +
                        // otherwise "increase this number"
                        // aka use a proper sequence generator or something
                        new Random().nextInt(5); // <- this one over here

        this.firstName = firstName;
        this.lastName = lastName;
        this.born = new Date((long)(System.currentTimeMillis() - (age * 1000 * 60 * 60 * 24 * 365.2425)));
        this.race = race;
        // bornState + stuff
        this.childId = "UTAE" + new StringBuilder(this.recordId).reverse().substring(0,6);
        // how much time do the last 5 digits in a base36 string buy you in milliseconds = collision
    }
    
    // TODO: remove(image), get(index)
    private List images = new ArrayList();
    public void setImage(String image){
        List oldImages = this.images;
        this.images.add(image);
        propertyChangeSupport.firePropertyChange("images", oldImages, image);
    }
    public String getImage(){
        return (String) this.images.get(0);
    }
    
    /* GENERATED */
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

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

    public void setRace(String race) {
        String oldRace = this.race;
        this.race = race;
        propertyChangeSupport.firePropertyChange("race", oldRace, race);
    }

    public String getRace() {
        return race;
    }

    public void setHouse(String house) {
        String oldHouse = this.house;
        this.house = house;
        propertyChangeSupport.firePropertyChange("house", oldHouse, house);
    }

    public String getHouse() {
        return house;
    }

    public void setContact(String[] contact) {
        String[] oldContact = this.contact;
        this.contact = contact;
        propertyChangeSupport.firePropertyChange("contact", oldContact, contact);
    }

    public String[] getContact() {
        return contact;
    }

    public void setSchool(Location school) {
        Location oldSchool = this.school;
        this.school = school;
        propertyChangeSupport.firePropertyChange("school", oldSchool, school);
    }

    public Location getSchool() {
        return school;
    }

    public void setHome(Location home) {
        Location oldHome = this.home;
        this.home = home;
        propertyChangeSupport.firePropertyChange("home", oldHome, home);
    }

    public Location getHome() {
        return home;
    }

    public void setRecordCreated(long recordCreated) {
        long oldRecordCreated = this.recordCreated;
        this.recordCreated = recordCreated;
        propertyChangeSupport.firePropertyChange("recordCreated", oldRecordCreated, recordCreated);
    }

    public long getRecordCreated() {
        return recordCreated;
    }

    public void setRecordId(String recordId) {
        String oldRecordId = this.recordId;
        this.recordId = recordId;
        propertyChangeSupport.firePropertyChange("recordId", oldRecordId, recordId);
    }

    public String getRecordId() {
        return recordId;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
