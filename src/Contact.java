import java.util.HashMap;
import java.util.Map;

public class Contact {
    //Fields and properties
    private String contactName;
    private long contactNum;

    public Colors color = new Colors();


    //constructor
    public Contact(String contactName, long contactNum) {
        this.contactName = contactName;
        this.contactNum = contactNum;
    }


    //othermethods
    //making a string out of our contact name and long contactnum
    public String toString() {
        return  contactName + " | "  + contactNumToString();
    }
    //adding hyphens to the long checking wether to add one or two hyphens
    public String contactNumToString() {
        String number = Long.toString(contactNum);
        String num = "";
        if (number.length() == 10) {
            num = number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6, number.length());
        } else {
            num = number.substring(0, 3) + "-" + number.substring(3, number.length());
        }
        return num;
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

    public void setContactNum(long contactNum) {
        this.contactNum = contactNum;
    }
}
