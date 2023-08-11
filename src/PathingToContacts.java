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


    //array list to display all contact
    public List<String> contacts = new ArrayList<>();

    //    contactsPath equals to the absoulute path of contacts.txt
    public void displayAllContacts() {
        try {
            List<String> contacts = Files.readAllLines(contactsPath);
            System.out.println("| Name | Phone number |");
            System.out.println("----------------------");
            for (String contact : contacts) {
                System.out.printf("| %-10s |\n",contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToContacts(String userinput, long usernum) {
        Contact contact = new Contact(userinput, usernum);
        contacts.add(contact.toString());
        try {
            Set<String> exisitingNames = new HashSet<>(Files.readAllLines(contactsPath));
            for (String name : contacts) {
                if (!exisitingNames.contains(name)) {
                    Files.write(contactsPath, Collections.singletonList(name), StandardOpenOption.APPEND);
                    exisitingNames.add(name);
                } else {
                    System.out.println("there is a " + name + " already\n");
//                    System.out.println("somethings here" + exisitingNames);
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