package com.company;

import java.util.*;

public class Main {
    //I Tried to keep the main class as clean ass possible with using methods as much as possible.
    public static void main(String[] args) {
        System.out.println(decryptService(messageService(), 3));

    }

    //I've created this method in order to getting the message and making it as indicated in rules.
    public static String messageService() {

        Scanner getMessage = new Scanner(System.in); //I wanted to define the scanner here in order to
                                                    // get the message in here instead of main.
        System.out.println("Please enter the message that you want to decrypt.");

        String message = getMessage.nextLine();
        boolean isMessageWrong = false; //I've created a dummy boolean to use it afterwards
                                        // to save and see if the message was wrong.

        for (int index = 0; index < message.length(); index++) { //in this loop I've tried to see if there was anything else than
                                                                // a blank space or String if so i've wanted a new input from user.

            if (!(Character.isLetter(message.charAt(index))) && message.charAt(index) != ' ') {
                System.out.println("Your message includes different types than strings which is integer much likely.\n Please enter new line according to rules.");
                isMessageWrong = true;
            }
            if (isMessageWrong == true) {
                index = -1;                                //I made it -1 because index will added one after loop completes so it must be -1 to full restarted.
                message = getMessage.nextLine();
            }
            isMessageWrong = false;                      // After every compilation of a loop i've set isMessageWrong variable to false
                                                        // otherwise it would stuck in isMessageWrong==True condition.
        }
        message = message.toUpperCase();               // with this I made the message all capital letters
        return message;
    }

    //I've dedicated this whole method to decrypt the line.
    public static String decryptService(String message, int shiftBy) {
        String decrypted = ""; // I made a dummy string variable to return here
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i);      // I got the ascii code of char here.
            ascii = ascii - (shiftBy % 26);     // I used the formula here to decrypt which is f(p-3)mod26.
            if (ascii < 'A') {                 // In here if its the first three letters of alphabet ++
                                               // ++ i 've adjusted them to make them shift to last three letters..
                ascii = ascii + 26;
            }
            decrypted = decrypted + (char) ascii;
        }
        decrypted = decrypted.replace("7", " "); //I'm replacing the char 7 with blank space to make
                                                                 // seperated words are seperated with blank space
                                                                // instead of 7
        return decrypted;
    }

}
