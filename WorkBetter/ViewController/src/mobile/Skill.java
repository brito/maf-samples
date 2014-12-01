package mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Skill {
    private String skill;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Skill() {
    }
    
    public Skill(String skill) {
        this.skill = skill;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setSkill(String skill) {
        String oldSkill = this.skill;
        this.skill = skill;
        propertyChangeSupport.firePropertyChange("skill", oldSkill, skill);
    }

    public String getSkill() {
        return skill;
    }

}
