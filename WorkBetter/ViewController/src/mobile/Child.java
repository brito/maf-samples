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
    
    // "focus for group loyalty"
    // http://en.wikipedia.org/wiki/House_system
    private String house;
    
    private String[] contact = {};
    
    private Location school;
    private Location placement;
    
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
    }
    // generate code below (makes it easier to delete/regenerate)
    // constructors
    // getters/setters
}
