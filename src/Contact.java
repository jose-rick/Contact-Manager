import java.util.HashMap;
import java.util.Map;

public class Contact {
    private String contactName;
    private long contactNum;


    //constructor
    public Contact(String contactName, long contactNum) {
        this.contactName = contactName;
        this.contactNum = contactNum;
    }
    public Contact(String contactName) {
        this.contactName = contactName;
        this.contactNum;
    }

    //othermethods
    public String toString(){
        return  contactName +" " +contactNum ;
    }


    //getters and setters
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }
}
