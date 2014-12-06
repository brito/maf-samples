package mobile;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Task {
    private String title; // [title]
    private String detail; // > *
    
    private String status = "ok"; // [checked]
    private String type; // input[type]
    private String value = ""; // input[value]
    private String comments; // textarea.comments
    private List attributes = new ArrayList(); // [<any>]
    
    private List subtasks = new ArrayList();

    Task(String section) {
        this.title = section;    
    }
    Task(String section, String detail) {
        this.title = section;
        this.detail = detail;
    }

    public void setSubtasks(List subtasks) {
        List oldSubtasks = this.subtasks;
        this.subtasks = subtasks;
        propertyChangeSupport.firePropertyChange("subtasks", oldSubtasks, subtasks);
    }

    public Task[] getSubtasks() {
        // I feel like there is a better way with generics
        return (Task[]) subtasks.toArray(new Task[subtasks.size()]);
    }
    
    /* GENERATED  */

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getStatus() {
        return status;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        propertyChangeSupport.firePropertyChange("value", oldValue, value);
    }

    public String getValue() {
        return value;
    }

    public void setComments(String comments) {
        String oldComments = this.comments;
        this.comments = comments;
        propertyChangeSupport.firePropertyChange("comments", oldComments, comments);
    }

    public String getComments() {
        return comments;
    }

    public void setAttributes(List attributes) {
        List oldAttributes = this.attributes;
        this.attributes = attributes;
        propertyChangeSupport.firePropertyChange("attributes", oldAttributes, attributes);
    }

    public List getAttributes() {
        return attributes;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        propertyChangeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getTitle() {
        return title;
    }

    public void setDetail(String detail) {
        String oldDetail = this.detail;
        this.detail = detail;
        propertyChangeSupport.firePropertyChange("detail", oldDetail, detail);
    }

    public String getDetail() {
        return detail;
    }

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
