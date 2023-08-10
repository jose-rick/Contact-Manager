import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PathingToContacts {

    public PathingToContacts() {
    }


    public  DisplayAll(){
        //contactsPath equals to the absoulute path of contacts.txt
        Path contactsPath = Paths.get("/Users/josedelaluz/ideaprojects/Jose-Rick-Contact-Manager/src/contacts.txt");
        //array list to display all contact
        List<String> contacts = new ArrayList<>();

        try {
            contacts = Files.readAllLines(contactsPath);
            System.out.println(contacts);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
