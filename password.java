package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Character;
// Mahmut Sacit Meydanal 200316057 2.Education
public class Main {
    private static boolean eightCharsRule=true;       //In here I've created global variables to use them in both main and methods.
                                                      // As I am not sure if we did see this in lectures I wanted to use it regardless.
    private static boolean twoDigitRule=true;
    private static boolean twoLetterRule=true;
    private static boolean onlyLettersAndDigitsRule=true;
    public static void main(String[] args) {   //I've tried to keep main method as clean as possible

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a password that will be checked.");
        String password = scanner.nextLine();
        System.out.println(passwordChecker(password));
        System.out.println("Values that returned are booleans of respectively:8 chars rule,two digit rule,two letter rule and only digits and letters rule.");
wrongOnes(password);

while (!eightCharsRule||!twoDigitRule||!twoLetterRule||!onlyLettersAndDigitsRule) { //This loop checks the critters while one of the variables is false.
    System.out.println("Atleast eight chars rule: " + eightCharsRule + ".");
    System.out.println("Atleast two digits rule: " + twoDigitRule + ".");
    System.out.println("Atleast two letters rule: " + twoLetterRule + ".");
    System.out.println("Only letters and digits rule: " + onlyLettersAndDigitsRule + ".");
    System.out.println("Please enter another password that would fit criteria.");
    password= scanner.nextLine(); //Gets a new password from user.
     wrongOnes(password);          //calls the checkerMethod and changes the variable again.
}
        System.out.println("Password fits the requirements and its accepted.");

    }


    //creating a method to check password that will inputted by user and sent it to method as parameter
    public static ArrayList passwordChecker(String password) {
        ArrayList<Boolean> arrayList=new ArrayList();
        Boolean leastTwoDigit = true;
        Boolean leastTwoLetter = true;
        Boolean leastEightChars = true;
        Boolean onlyDigitsAndLetters = true;     //I've created booleans to check them and add them to array later on.
        int digitCounter = 0;
        int stringCounter = 0; //This two counter will be used to check 2 letters and digits rule.

        if (password.length() < 8) {    //Checks the 8 chars rule.
            leastEightChars = false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
                onlyDigitsAndLetters = false;
            }
            if (Character.isDigit(password.charAt(i))) {
                digitCounter++;                            //If char is digit it will go up by one.
            }
            if (Character.isLetter(password.charAt(i))) {
                stringCounter++;                            //If char is letter it will go up by one.
            }
        }
        if (digitCounter<2) {
            leastTwoDigit=false;
        }
        if (stringCounter<2){
            leastTwoLetter=false;
        }
        arrayList.add(leastEightChars);        //I've added them to arraylists to use this later on and I will have to remember which index represents what.
        arrayList.add(leastTwoDigit);
        arrayList.add(leastTwoLetter);
        arrayList.add(onlyDigitsAndLetters);
        return arrayList;


    }
    public static void wrongOnes(String password) {
        eightCharsRule=true;
        twoDigitRule=true;       //I have to make every variable true at the beginning in order to be sure that every variable checked again.
        twoLetterRule=true;
        onlyLettersAndDigitsRule=true;
        ArrayList array = passwordChecker(password);
        ArrayList indexesOfFalse = new ArrayList();

        for (int i=0;i<array.size();i++) {
            if (array.get(i).equals(false)) {        //I get the index of false and as I know what index represents what I can change the variables according to that.
                indexesOfFalse.add(i);
            }
        }

        for (int x=0;x<indexesOfFalse.size();x++) {
            if (indexesOfFalse.get(x).equals(0)) {
                eightCharsRule=false;
            }
            if (indexesOfFalse.get(x).equals(1)) {
                twoDigitRule=false;
            }
            if (indexesOfFalse.get(x).equals(2)) {
                twoLetterRule=false;
            }
            if (indexesOfFalse.get(x).equals(3)) {
                onlyLettersAndDigitsRule=false;
            }
        }
    }

}