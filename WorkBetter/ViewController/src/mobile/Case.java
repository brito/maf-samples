package mobile;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Case {
    private String caseId;
    
    private String status;
    private String priority;
    private String type;
    private Date scheduled;
    // private Event[] history;
    private String notes;
    
    private Child regarding;
    
    private List history = new ArrayList();

    public Case(String status, String date, String type, String notes) {
        this.caseId = this.getClass().getName() +
                      Long.toString(System.currentTimeMillis(), 36) +
                      new Random().nextInt(5); // threads/cores
        
        this.status = status;
        this.type = type;
        // this should be an Event[]
        this.notes = notes;

        // the recommended approach is
        // DateFormatter.parse(string)
        // but the resulting compiler requirements
        // are a good example of a terrible architectural decision
        this.scheduled = new Date(date);
    }
    
    
}
