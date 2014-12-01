package mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class CompItem {
    private double itemValue;
    private String itemLabel;
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public CompItem() {
        super();
    }
    
    public CompItem( double itemValue, String itemLabel) {
        this.itemValue = itemValue;
        this.itemLabel = itemLabel;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setItemValue(double itemValue) {
        double oldItemValue = this.itemValue;
        this.itemValue = itemValue;
        propertyChangeSupport.firePropertyChange("itemValue", oldItemValue, itemValue);
    }

    public double getItemValue() {
        return itemValue;
    }

    public void setItemLabel(String itemLabel) {
        String oldItemLabel = this.itemLabel;
        this.itemLabel = itemLabel;
        propertyChangeSupport.firePropertyChange("itemLabel", oldItemLabel, itemLabel);
    }

    public String getItemLabel() {
        return itemLabel;
    }

}
