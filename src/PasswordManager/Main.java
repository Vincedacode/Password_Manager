package PasswordManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        Password_Manager passwordManager = new Password_Manager(new ArrayList<Entry>());

        boolean loop = true;
        passwordManager.loadFromFile();
        try{
          while (loop){
              System.out.println("Vincedacode's personal password manager📕");
              System.out.println("Pick an option😁");
              System.out.println("1. Add new site details👌");
              System.out.println("2. View all saved sites🙂");
              System.out.println("3. Search saved sites😉");
              System.out.println("4. Edit saved sites😎");
              System.out.println("5. Delete saved sites😢");
              System.out.println("6. Save and Exit😘");
              int userchoice = myscanner.nextInt();
              myscanner.nextLine();
              switch (userchoice){
                  case 1:
                      System.out.println("Enter Sitename");
                      String sitename = myscanner.nextLine();

                      System.out.println("Enter Username/Email");
                      String username = myscanner.nextLine();

                      System.out.println("Enter Password");
                      String password = myscanner.nextLine();

                      Entry newentry = new Entry(sitename, username, password);
                      passwordManager.addentry(newentry);
                      break;
                  case 2:
                      passwordManager.viewSavedSites();
                      break;
                  case 3:
                      System.out.println("Enter sitename");
                      String site = myscanner.nextLine();
                      passwordManager.searchSiteName(site);
                      break;
                  case 4:
                      System.out.println("Enter sitename");
                      String editsite = myscanner.nextLine();
                      passwordManager.editSite(editsite);
                      break;
                  case 5:
                      System.out.println("Enter sitename");
                      String deletesite = myscanner.nextLine();
                      passwordManager.deleteSite(deletesite);
                      break;
                  case 6:
                      passwordManager.saveToFile();
                      System.out.println("Saving and exiting!");
                      loop = false;
                      break;

                  default:
                      System.out.println("Please enter a valid input between 1-6!");
              }
          }
        }
        catch (InputMismatchException e){
            System.out.println("Enter a valid input!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
