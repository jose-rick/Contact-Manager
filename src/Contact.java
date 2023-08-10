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

    //othermethods
    public String toString(){
        return "name: " + contactName + "   |   " + " number: " + contactNum + " ~";
    }
    public Map toHashMap(){
        HashMap<String, Long> ppl = new HashMap<>();
        ppl.put(contactName, contactNum);
        return ppl;
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
