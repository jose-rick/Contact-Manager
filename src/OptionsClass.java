public class OptionsClass {
    static inputs sc = new inputs();

    public static void showMenu() {
        //user types what they serach
        System.out.println("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):
                """);
    }

    public static void displayall() {
        PathingToContacts displayAll = new PathingToContacts();
        displayAll.displayAllContacts();

    }

    public static void addingName() {
        PathingToContacts addname = new PathingToContacts();
        System.out.println("Enter the name you want added");
        String username = sc.getString();
        long usernum = 0;
        do {
            System.out.println("Enter there number make sure its 7 digits long");
            usernum = sc.getlong();
        } while (Long.toString(usernum).length() != 10);
        addname.addToContacts(username, usernum);
    }
    public static void searchName(){
        do {
            String userinput = sc.getString("Enter the name of a contact");
            Contact hashingnames = new Contact();
            hashingnames.toHashMap();

        } while (true);
    }

    public OptionsClass() {

        //if one is typed enter a condition (Switch Case)
        do {
            showMenu();
            int userResponse = sc.getInt(1, 5);
            switch (userResponse) {
                case 1 -> {
                    displayall();
                }
                case 2 -> {
                    addingName();
                    displayall();
                }
                case 3 -> {
                    searchName();
                }
                case 4 -> {

                }
                case 5 -> {

                }
            }

        } while (sc.yesNo("Try again? [y/n]"));


    }
}
