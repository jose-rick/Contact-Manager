import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PathingToContacts {
    //path to contact.txt
    Path contactsPath = Paths.get("src/contacts.txt");
    //contact obj

    public static final int MAX_NAME_LENGTH = 15;
    public static final int MAX_PHONE_LENGTH = 13;

    //array list to display all contact
    public List<String> contacts = new ArrayList<>();

    //    contactsPath equals to the absoulute path of contacts.txt
    public void displayAllContacts() {
//        try {
//            List<String> contacts = Files.readAllLines(contactsPath);
//            System.out.println("| Name | Phone number |");
//            System.out.println("----------------------");
//            for (String contact : contacts) {
//                System.out.printf("| %-10s |\n",contact);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<String> contacts = Files.readAllLines(contactsPath);
            System.out.println("| Name            | Phone number  |");
            System.out.println("|-----------------|---------------|");
            for (String contact : contacts) {
                // Assuming the contact is stored as "Name | PhoneNumber" in the file.
                String[] splitContact = contact.split("\\|");
                if(splitContact.length == 2) {
                    String name = splitContact[0].trim();
                    String phoneNumber = splitContact[1].trim();
                    System.out.printf("| %-15s | %-13s |\n", name, phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void addToContacts(String userinput, long usernum) {
//        String truncatedName = userinput.length() > MAX_NAME_LENGTH ? userinput.substring(0, MAX_NAME_LENGTH) : userinput;
//
//        // Convert the phone number to String and truncate if it's too long
//        String phoneStr = String.valueOf(usernum);
//        String truncatedPhone = phoneStr.length() > MAX_PHONE_LENGTH ? phoneStr.substring(0, MAX_PHONE_LENGTH) : phoneStr;
//
//        Contact contact = new Contact(truncatedName, Long.parseLong(truncatedPhone));
//        contacts.add(contact.toString());
//
//        try {
//            Set<String> exisitingNames = new HashSet<>(Files.readAllLines(contactsPath));
//            for (String name : contacts) {
//                if (!exisitingNames.contains(name)) {
//                    Files.write(contactsPath, Collections.singletonList(name), StandardOpenOption.APPEND);
//                    exisitingNames.add(name);
//                } else {
//                    System.out.println("There is a " + name + " already.");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
public void addToContacts(String userinput, long usernum) {
    String truncatedName = userinput.length() > MAX_NAME_LENGTH ? userinput.substring(0, MAX_NAME_LENGTH) : userinput;

    // Convert the phone number to String and truncate if it's too long
    String phoneStr = String.valueOf(usernum);
    String truncatedPhone = phoneStr.length() > MAX_PHONE_LENGTH ? phoneStr.substring(0, MAX_PHONE_LENGTH) : phoneStr;

    Contact contact = new Contact(truncatedName, Long.parseLong(truncatedPhone));
    contacts.add(contact.toString());

    try {
        Set<String> existingNames = new HashSet<>(Files.readAllLines(contactsPath));
        for (String name : contacts) {
            if (!existingNames.contains(name.toLowerCase())) {
                Files.write(contactsPath, Collections.singletonList(name), StandardOpenOption.APPEND);
                existingNames.add(name.toLowerCase());
            } else {
                System.out.println("There is a " + name + " already.");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public String readAndPrintContacts(String userinput) {
        String personfound = "Not found";
        boolean found = false;
        try {
            List<String> contacts = Files.readAllLines(contactsPath);
            for (String person : contacts) {
                if (person.toLowerCase().contains(userinput.toLowerCase())) {
                    personfound = person;
                    found = true;
                    break;
                }
            }
            if (!found) {
                personfound = "Not found";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personfound;
    }

    public void deleteContactByName(String userinput){
        try {
            List<String> contacts = Files.readAllLines(contactsPath);
            List<String> updatedContacts = contacts.stream()
                    .filter(person -> !person.toLowerCase().contains(userinput.toLowerCase()))
                    .collect(Collectors.toList());

            Files.write(contactsPath, updatedContacts);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}