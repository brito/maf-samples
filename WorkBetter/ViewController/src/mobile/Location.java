package mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Location {
    private String recordId;
    
    private String type;
    private String name;
    
    private String street;
    private String zip;
    
    // https://en.wikipedia.org/wiki/Geo_URI#Example
    private int latitude;
    private int longitude;
    private int altitude;
    private int uncertainty;

    public Location(String type, String name, String street, String zip) {
        this.recordId = this.getClass().getName() +
                      Long.toString(System.currentTimeMillis(), 36) +
                      new Random().nextInt(5); // threads/cores
        
        this.type = type;
        this.name = name;
        this.street = street;
        this.zip = zip;
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
    
    /* GENERATED  */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setLatitude(int latitude) {
        int oldLatitude = this.latitude;
        this.latitude = latitude;
        propertyChangeSupport.firePropertyChange("latitude", oldLatitude, latitude);
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLongitude(int longitude) {
        int oldLongitude = this.longitude;
        this.longitude = longitude;
        propertyChangeSupport.firePropertyChange("longitude", oldLongitude, longitude);
    }

    public int getLongitude() {
        return longitude;
    }

    public void setAltitude(int altitude) {
        int oldAltitude = this.altitude;
        this.altitude = altitude;
        propertyChangeSupport.firePropertyChange("altitude", oldAltitude, altitude);
    }

    public int getAltitude() {
        return altitude;
    }

    public void setUncertainty(int uncertainty) {
        int oldUncertainty = this.uncertainty;
        this.uncertainty = uncertainty;
        propertyChangeSupport.firePropertyChange("uncertainty", oldUncertainty, uncertainty);
    }

    public int getUncertainty() {
        return uncertainty;
    }

    public void setImages(List images) {
        List oldImages = this.images;
        this.images = images;
        propertyChangeSupport.firePropertyChange("images", oldImages, images);
    }

    public List getImages() {
        return images;
    }

    public void setRecordId(String recordId) {
        String oldRecordId = this.recordId;
        this.recordId = recordId;
        propertyChangeSupport.firePropertyChange("recordId", oldRecordId, recordId);
    }

    public String getRecordId() {
        return recordId;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setStreet(String street) {
        String oldStreet = this.street;
        this.street = street;
        propertyChangeSupport.firePropertyChange("street", oldStreet, street);
    }

    public String getStreet() {
        return street;
    }

    public void setZip(String zip) {
        String oldZip = this.zip;
        this.zip = zip;
        propertyChangeSupport.firePropertyChange("zip", oldZip, zip);
    }

    public String getZip() {
        return zip;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
