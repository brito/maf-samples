package mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Location {
    public String locationId;
    public String locationName;
    
    public String street;
    public String city;
    public String state;
    public String zipCode;

    public Location(String locationId, String locationName, String street, String city, String state, String zipCode) {
        super();
        this.locationId = locationId;
        this.locationName = locationName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setLocationId(String locationId) {
        String oldLocationId = this.locationId;
        this.locationId = locationId;
        propertyChangeSupport.firePropertyChange("locationId", oldLocationId, locationId);
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationName(String locationName) {
        String oldLocationName = this.locationName;
        this.locationName = locationName;
        propertyChangeSupport.firePropertyChange("locationName", oldLocationName, locationName);
    }

    public String getLocationName() {
        return locationName;
    }

    public void setStreet(String street) {
        String oldStreet = this.street;
        this.street = street;
        propertyChangeSupport.firePropertyChange("street", oldStreet, street);
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }

    public String getState() {
        return state;
    }

    public void setZipCode(String zipCode) {
        String oldZipCode = this.zipCode;
        this.zipCode = zipCode;
        propertyChangeSupport.firePropertyChange("zipCode", oldZipCode, zipCode);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
