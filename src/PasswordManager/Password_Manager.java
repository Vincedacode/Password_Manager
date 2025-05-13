package PasswordManager;
import java.security.MessageDigest;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Password_Manager {
    protected ArrayList<Entry> myentry;

    Scanner myscanner = new Scanner(System.in);



    public Password_Manager(ArrayList<Entry> myentry) {
        this.myentry = myentry;
    }

    public void addentry(Entry newentry) {
        try {
            boolean add = myentry.add(newentry);
            if (add) {
                System.out.println("'" + newentry.sitename + "'" + " login details has been successfully saved!");
            } else {
                System.out.println("Adding details failed!😢");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewSavedSites() {
        try {
            if (myentry.isEmpty()) {
                System.out.println("No details have been saved yet!");
                return;
            }

            System.out.println("Saved site entries:");
            for (Entry everyentry : myentry) {
                System.out.println(everyentry);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchSiteName(String siteName) {
        try {
            boolean find = false;
            Pattern sitename = Pattern.compile(siteName, Pattern.CASE_INSENSITIVE);
            for (Entry theentry : myentry) {
                Matcher ismatching = sitename.matcher(theentry.getSitename());
                if (ismatching.find()) {

                    System.out.println("Site found!");
                    System.out.println(theentry);
                    find = true;
                }

            }
            if (!find) {
                System.out.println("Site not found!");
            }
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void editSite(String sitename) {
        try {
            Iterator<Entry> iterator = myentry.iterator();
            boolean check = false;

            while (iterator.hasNext()) {
                Entry getentry = iterator.next();
                if (sitename.equalsIgnoreCase(getentry.getSitename())) {
                    System.out.println("Enter new username/email");
                    String username = myscanner.nextLine();

                    System.out.println("Enter new password");
                    String password = myscanner.nextLine();

                    getentry.setUsername(username);
                    getentry.setPassword(password);

                    System.out.println("'" + getentry.getSitename() + "' details have been successfully edited!");
                    check = true;
                    break;
                }

            }

            if (!check) {
                System.out.println("Site not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSite(String sitename) {
        try {
            Iterator<Entry> iterator = myentry.iterator();
            boolean check = false;

            while (iterator.hasNext()) {
                Entry theentry = iterator.next();
                if (sitename.equalsIgnoreCase(theentry.getSitename())) {
                    System.out.println("'" + theentry.getSitename() + "' details have been successfully deleted!");
                    iterator.remove();
                    check = true;
                    break;
                }
            }

            if (!check) {
                System.out.println("Site not found!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile() {
        try {
            ObjectOutputStream saveobject = new ObjectOutputStream(new FileOutputStream("details.txt"));
            saveobject.writeObject(myentry);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadFromFile() {
        try {
            ObjectInputStream savedobjects = new ObjectInputStream(new FileInputStream("details.txt"));
            myentry = (ArrayList<Entry>) savedobjects.readObject();
            System.out.println("Details loaded successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

