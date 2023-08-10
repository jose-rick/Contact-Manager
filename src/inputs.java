import java.util.Scanner;

public class inputs {
    //properties and fields
    private Scanner sc;

    //constructors


    public inputs() {
        this.sc = new Scanner(System.in);
    }

    //getters and setters
    public String getString() {
//        System.out.println("enter a string");
        return this.sc.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return this.getString();
    }


    //walkthrough version
    public boolean yesNo() {
        return this.getString().toLowerCase().startsWith("y");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        return this.getString().toLowerCase().startsWith("y");
    }

    //walkthrough
    public int getInt() {
        try {
            return Integer.parseInt(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a whole number.");
            return this.getInt();
        }
    }

    public int getInt(int min, int max) {
        int userint = this.getInt();
        if (userint >= min && userint <= max) {
            return userint;
        } else {
            System.out.println("must be between " + min + " and " + max + ".");
            return getInt(min, max);
        }
    }

    //walkthrough
    public double getDouble() {
        try {
            return Double.parseDouble(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number.");
            return this.getDouble();
        }
    }

    public double getDouble(double min, double max) {
        double userDouble = this.getDouble();
        if (userDouble >= min && userDouble <= max) {
            return userDouble;
        } else {
            System.out.println("must be between " + min + " and " + max + ".");
            return getDouble(min, max);
        }
    }

    public long getlong(){
        try {
            return Long.parseLong(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number.");
            return this.getlong();
        }
    }
    public long getLong(long min, long max) {
        long userlong = this.getlong();
        if (userlong >= min && userlong <= max) {
            return userlong;
        } else {
            System.out.println("must be between " + min + " and " + max + ".");
            return getLong(min, max);
        }
    }
//    public double getBinary(){
//        double userDouble = this.getDouble();
//
//    }
//    public double getHex(){
//
//    }
//    public int getBinary(){
//
//    }
//    public int getHex(){
//
//    }

}
