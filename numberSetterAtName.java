package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        String firstname = "Sacit";
        String lastname = "Meydanal";

        String result;

        result = Character.toString(firstname.charAt(0)); // First char
        if (lastname.length() > 5)
            result += lastname.substring(0, 5);
        else
            result += lastname;
        result += Integer.toString(rnd.nextInt(99));
        System.out.println(result);
    }
}
