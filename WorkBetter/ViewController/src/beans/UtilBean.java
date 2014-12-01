package beans;

import java.util.Date;

import javax.el.MethodExpression;
import javax.el.ValueExpression;

import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class UtilBean {
    private String id = "";
    private int empId = 0;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private static final long day = (long) (1000 * 60 * 60 * 24);

    public UtilBean() {
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void sendEmail(ActionEvent actionEvent) {
        String email = (String) AdfmfJavaUtilities.evaluateELExpression("#{applicationScope.email}");
        DeviceManagerFactory.getDeviceManager().sendEmail(email, "", "", "", "", null, null);
    }

    public void sendSMS(ActionEvent actionEvent) {
        String sms = (String) AdfmfJavaUtilities.evaluateELExpression("#{applicationScope.sms}");
        DeviceManagerFactory.getDeviceManager().sendSMS(sms, "");
    }

    public void setEmpId(int empId) {
        int oldEmpId = this.empId;
        this.empId = empId;
        propertyChangeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public int getEmpId() {
        return empId;
    }

    public String followAction() {
        String outcome = "";

        if (empId == 0) {
            outcome = "detail";
        } else if (empId > 0) {
            setEmpId(0);
            MethodExpression me =
                AdfmfJavaUtilities.getMethodExpression("#{bindings.applyActiveEmpRow.execute}", Object.class, new Class[] {
                                                       });
            me.invoke(AdfmfJavaUtilities.getAdfELContext(), new Object[] { });
        }
        return outcome;
    }


    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public String getId() {
        return id;
    }

    public void gotoPersonDetail(ActionEvent action) {
        AdfmfContainerUtilities.resetFeature("People");
    }

    public void gotoDeptDetail(ActionEvent action) {
        AdfmfContainerUtilities.resetFeature("Organizations");
    }

    public void selectPersonDetail(SelectionEvent selectionEvent) {
        // This shouldn't be needed but the setPropertyListener as a child of an nbox Marker isn't firing
        setId(selectionEvent.getSelectedRowKeys()[0]);
        ///
        
        AdfmfContainerUtilities.resetFeature("People");
    }

    public void selectDeptDetail(SelectionEvent selectionEvent) {
        // This shouldn't be needed but the setPropertyListener as a child of an nbox Marker isn't firing
        setId(selectionEvent.getSelectedRowKeys()[0]);
        ///
        
        AdfmfContainerUtilities.resetFeature("Organizations");
    }

    public boolean getIsDetail() {
        boolean ret = false;
        if (id.length() > 0) {
            ret = true;
        }

        return ret;
    }

    public Date getTimelineStart() {
        return new Date(new Date().getTime() - (7 * day));
    }

    public Date getTimelineEnd() {
        return new Date(getTimelineStart().getTime() + (180 * day));
    }

}
