package mobile;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Case {
    private String recordId;

    private String priority;
    private String type;
    private String status;
    
    private Child[] regarding;
    private List notes = new ArrayList();
    private List tasks = new ArrayList();
    private List images = new ArrayList();
    
    public void setTask(Task task){
        List oldTasks = this.tasks;
        this.tasks.add(task);
        propertyChangeSupport.firePropertyChange("tasks", oldTasks, task);
    }
    public Task[] getTasks(){
        return (Task[]) this.tasks.toArray(new Task[tasks.size()]);
    }
    
    private Date scheduled;

    public Case(String status, String date, String type, String note) {
        this.recordId = this.getClass().getName() +
                      Long.toString(System.currentTimeMillis(), 36) +
                      new Random().nextInt(5); // threads/cores
        
        this.status = status;
        this.type = type;
        // TODO this.notes.add(new Message(type, author, content, time));
        this.notes.add(note);

        // the recommended approach is
        // DateFormatter.parse(string)
        // but the resulting compiler requirements
        // are a good example of a terrible architectural decision
        this.scheduled = new Date(date);
    }
    
    // TODO: remove(image), get(index)
    public void setImage(String image){
        List oldImages = this.images;
        this.images.add(image);
        propertyChangeSupport.firePropertyChange("images", oldImages, image);
    }
    public String getImage(){
        return (String) this.images.get(0);
    }

    public void setNote(String note){
        List oldNotes = this.notes;
        this.notes.add(note);
        propertyChangeSupport.firePropertyChange("notes", oldNotes, note);
    }
    public String[] getNotes(){
        return (String[]) this.notes.toArray(new String[this.notes.size()]);
    }

    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    /* GENERATED */

    public void setRecordId(String recordId) {
        String oldRecordId = this.recordId;
        this.recordId = recordId;
        propertyChangeSupport.firePropertyChange("recordId", oldRecordId, recordId);
    }

    public String getRecordId() {
        return recordId;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getStatus() {
        return status;
    }

    public void setPriority(String priority) {
        String oldPriority = this.priority;
        this.priority = priority;
        propertyChangeSupport.firePropertyChange("priority", oldPriority, priority);
    }

    public String getPriority() {
        return priority;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public String getType() {
        return type;
    }

    public void setScheduled(Date scheduled) {
        Date oldScheduled = this.scheduled;
        this.scheduled = scheduled;
        propertyChangeSupport.firePropertyChange("scheduled", oldScheduled, scheduled);
    }

    public Date getScheduled() {
        return scheduled;
    }

    public void setRegarding(Child[] regarding) {
        Child[] oldRegarding = this.regarding;
        this.regarding = regarding;
        propertyChangeSupport.firePropertyChange("regarding", oldRegarding, regarding);
    }

    public Child[] getRegarding() {
        return regarding;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
