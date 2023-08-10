public class OptionsClass{

    public OptionsClass(){
        inputs sc = new inputs();
        //user types what they serach
        System.out.println("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):
                """);
        int userResponse = sc.getInt(1, 5);

        //if one is typed enter a condition (Switch Case)
        switch (userResponse){
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }


    }
}
