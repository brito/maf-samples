package mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Case {
    private String caseId;
    
    private String priority;
    private String type;
    private Date scheduled;
    
    private Child regarding;
    
    private List history = new ArrayList();
    
    protected static String[] priorities = {"Urgent", "Upcoming", "FYI"};
    
    protected void populate (HHSService hhs){}


    public Case(String caseId, String priority, String type, Date scheduled, Child regarding) {
        super();
        this.caseId = caseId;
        this.priority = priority;
        this.type = type;
        this.scheduled = scheduled;
        this.regarding = regarding;
    }
}
