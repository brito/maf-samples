package mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class Department {
    private int deptId;
    private String deptName;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal;
    private int deptMgrId;
    private String deptMgrFirst;
    private String deptMgrLast;
    private String deptMgrTitle;
    private String deptMgrEmail;
    private String latCoord;
    private String longCoord;
    private String color;
    private List reports = new ArrayList();
    private List teampPerfs = new ArrayList();
    private List piecomps = new ArrayList();
    private List events = new ArrayList();
    private List filtered_events = new ArrayList();
    private double avgTotalComp = 0;
    private int avgCompRatio = 0;
    private int avgPerfRating = 0;
    private int avgPerfPotential = 0;
    private static boolean showMeeting = true;
    private static boolean showEvent = true;
    private static boolean showTraining = true;
    private static boolean showTimeOff = true;

    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public Department() {
        super();
    }

    public Department(int deptId, String deptName, String address, String city, String state, String country,
                      String postal, int deptMgrId, String deptMgrFirst, String deptMgrLast, String latCoord,
                      String longCoord, String color) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal = postal;
        this.deptMgrId = deptMgrId;
        this.deptMgrFirst = deptMgrFirst;
        this.deptMgrLast = deptMgrLast;
        this.latCoord = latCoord;
        this.longCoord = longCoord;
        this.color = color;
    }

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

    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
        propertyChangeSupport.firePropertyChange("deptId", oldDeptId, deptId);
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
        propertyChangeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getAddress() {
        return address;
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

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }

    public void setPostal(String postal) {
        String oldPostal = this.postal;
        this.postal = postal;
        propertyChangeSupport.firePropertyChange("postal", oldPostal, postal);
    }

    public String getPostal() {
        return postal;
    }

    public void setDeptMgrId(int deptMgrId) {
        int oldDeptMgrId = this.deptMgrId;
        this.deptMgrId = deptMgrId;
        propertyChangeSupport.firePropertyChange("deptMgrId", oldDeptMgrId, deptMgrId);
    }

    public int getDeptMgrId() {
        return deptMgrId;
    }

    public void setDeptMgrFirst(String deptMgrFirst) {
        String oldDeptMgrFirst = this.deptMgrFirst;
        this.deptMgrFirst = deptMgrFirst;
        propertyChangeSupport.firePropertyChange("deptMgrFirst", oldDeptMgrFirst, deptMgrFirst);
    }

    public String getDeptMgrFirst() {
        return deptMgrFirst;
    }

    public void setDeptMgrLast(String deptMgrLast) {
        String oldDeptMgrLast = this.deptMgrLast;
        this.deptMgrLast = deptMgrLast;
        propertyChangeSupport.firePropertyChange("deptMgrLast", oldDeptMgrLast, deptMgrLast);
    }

    public String getDeptMgrLast() {
        return deptMgrLast;
    }

    public void setDeptMgrTitle(String deptMgrTitle) {
        String oldDeptMgrTitle = this.deptMgrTitle;
        this.deptMgrTitle = deptMgrTitle;
        propertyChangeSupport.firePropertyChange("deptMgrTitle", oldDeptMgrTitle, deptMgrTitle);
    }

    public String getDeptMgrTitle() {
        return deptMgrTitle;
    }

    public void setDeptMgrEmail(String deptMgrEmail) {
        String oldDeptMgrEmail = this.deptMgrEmail;
        this.deptMgrEmail = deptMgrEmail;
        propertyChangeSupport.firePropertyChange("deptMgrEmail", oldDeptMgrEmail, deptMgrEmail);
    }

    public String getDeptMgrEmail() {
        return deptMgrEmail;
    }

    public void setLatCoord(String latCoord) {
        String oldLatCoord = this.latCoord;
        this.latCoord = latCoord;
        propertyChangeSupport.firePropertyChange("latCoord", oldLatCoord, latCoord);
    }

    public String getLatCoord() {
        return latCoord;
    }

    public void setLongCoord(String longCoord) {
        String oldLongCoord = this.longCoord;
        this.longCoord = longCoord;
        propertyChangeSupport.firePropertyChange("longCoord", oldLongCoord, longCoord);
    }

    public String getLongCoord() {
        return longCoord;
    }

    public double getAvgTotalComp() {
        return avgTotalComp;
    }

    public int getAvgCompRatio() {
        return avgCompRatio;
    }

    public String getAvgPerfRating() {
        return calcNboxString(avgPerfRating);
    }

    public String getAvgPerfPotential() {
        return calcNboxString(avgPerfPotential);
    }
    
    public String getImage() {
        return getDeptImage(this.deptId);
    }
    
    public String getDeptMgrImage() {
        return getDeptImage(this.deptMgrId);
    }

    private String getDeptImage(int id) {
        String image = "nopic.png";
        Integer i = new Integer(id);
        if( i.intValue() < 158 ) {
            image = i.toString() + ".png";
        }
        return image;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setShowMeeting(boolean showMeeting) {
        boolean oldShowMeeting = Department.showMeeting;
        Department.showMeeting = showMeeting;
        propertyChangeSupport.firePropertyChange("showMeeting", oldShowMeeting, showMeeting);
    }

    public boolean isShowMeeting() {
        return showMeeting;
    }

    public void setShowEvent(boolean showEvent) {
        boolean oldShowEvent = Department.showEvent;
        Department.showEvent = showEvent;
        propertyChangeSupport.firePropertyChange("showEvent", oldShowEvent, showEvent);
    }

    public boolean isShowEvent() {
        return showEvent;
    }

    public void setShowTraining(boolean showTraining) {
        boolean oldShowTraining = Department.showTraining;
        Department.showTraining = showTraining;
        propertyChangeSupport.firePropertyChange("showTraining", oldShowTraining, showTraining);
    }

    public boolean isShowTraining() {
        return showTraining;
    }

    public void setShowTimeOff(boolean showTimeOff) {
        boolean oldShowTimeOff = Department.showTimeOff;
        Department.showTimeOff = showTimeOff;
        propertyChangeSupport.firePropertyChange("showTimeOff", oldShowTimeOff, showTimeOff);
    }

    public boolean isShowTimeOff() {
        return showTimeOff;
    }

    private String calcNboxString(int value) {
        String ret = "low";
        if (value == 3 || value == 4) {
            ret = "med";
        } else if (value == 5) {
            ret = "high";
        }
        return ret;
    }

    public Employee[] getReports() {
        return (Employee[]) reports.toArray(new Employee[reports.size()]);
    }

    public int getReportCount() {
        return reports.size();
    }

    public CompItem[] getPieComps() {
        return (CompItem[]) piecomps.toArray(new CompItem[piecomps.size()]);
    }

    public Performance[] getTeamPerfs() {
        return (Performance[]) teampPerfs.toArray(new Performance[teampPerfs.size()]);
    }

    public Event[] getEvents() {
        refreshEvents();
        return (Event[]) filtered_events.toArray(new Event[filtered_events.size()]);
    }

    protected void createChildren(HRService hr) {
        int lowComp = 0;
        int medComp = 0;
        int highComp = 0;

        int count = hr.s_employees.size();
        for (int x = 0; x < count; x++) {
            Employee e = (Employee) hr.s_employees.get(x);
            if (e.getDeptId() == this.deptId) {
                if (e.getEmpId() == deptMgrId) {
                    this.setDeptMgrTitle(e.getTitle());
                    this.setDeptMgrEmail(e.getEmail());
                }

                reports.add(e);
                teampPerfs.add(new Performance(e.getEmpId(), e.getEmpId(), e.getRating(), e.getPotential(),
                                               new Date()));
                int comp = e.getCompRatio();
                if (comp < 95) {
                    lowComp++;
                } else if (comp > 105) {
                    highComp++;
                } else {
                    medComp++;
                }

                int eventCount = e.events.size();
                for (int y = 0; y < eventCount; y++) {
                    Event evt = (Event) e.events.get(y);
                    events.add(new Event(events.size() + 1, evt.getType(),
                                         e.getFirstName() + ": " + evt.getDescription(), evt.getStart(), evt.getEnd()));
                }

                avgTotalComp += e.getSalary() + e.getBonus() + e.getCommission();
                avgCompRatio += e.getCompRatio();
                avgPerfRating += e.getRating();
                avgPerfPotential += e.getPotential();
            }
        }
        
        refreshEvents();

        avgTotalComp /= reports.size();
        avgCompRatio /= reports.size();
        avgPerfRating /= reports.size();
        avgPerfPotential /= reports.size();

        piecomps.add(new CompItem(lowComp, "Below 95%"));
        piecomps.add(new CompItem(medComp, "95% to 105%"));
        piecomps.add(new CompItem(highComp, "Above 105%"));
    }
    
    public void refreshEvents() {
        filtered_events.clear();

        int count = events.size();

        for (int x = 0; x < count; x++) {
            boolean addIt = false;
            Event e = (Event) events.get(x);
            int type = e.getType();
            switch (type) {
            case 1:
                if (showMeeting)
                    addIt = true;
                break;
            case 2:
                if (showEvent)
                    addIt = true;
                break;
            case 3:
                if (showTraining)
                    addIt = true;
                break;
            case 4:
                if (showTimeOff)
                    addIt = true;
                break;
            }
            if (addIt) {
                filtered_events.add(e);
            }
        }        
    }
    
    public void filterEvents() {
        providerChangeSupport.fireProviderRefresh("events");
    }
    
}
