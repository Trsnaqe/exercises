package com.company;
//Ad-Soyad:Mahmut Sacit Meydanal No: 200316057 2nd education
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        play(); //With doing almost everything on play I've made the program easier to read.
    }

    public static int diceRoll() {      //In here I've created a method to simulate dice roll everytime it is called.
        Random random = new Random();

        int dice = random.nextInt(6) + 1;
        System.out.println("dice rolled: " + dice);
        return dice;
    }

    public static int playerA(int location) {    //I've used the saved location and added the result of dice and returned back to play method again.
        int saved;
        saved = location + diceRoll();
        System.out.println("Location of player A is now " + saved);
        return saved;
    }

    public static int playerB(int location) {  //I did everything as I did on player A but only specified for player B.
        int saved;
        saved = location + diceRoll();
        System.out.println("Location of player B is now " + saved);
        return saved;
    }

    public static void play() { //In here i've created dummy variables to change them dynamically later on.
        int resultOfA = 0;
        int resultofB = 0;
        int diceRolledForA = 0;
        int diceRolledForB = 0;
        resultOfA = playerA(resultOfA) + resultOfA;
        resultofB = playerB(resultofB) + resultofB;
        while (resultOfA < 100 && resultofB < 100) { //In here I've forced them into loop unless one of them reaches the location 100.
            resultOfA = playerA(resultOfA);
            resultofB = playerB(resultofB);
            if (resultOfA % 10 == 0) {        //In here I followed the rule which is if the number is divisible 10 it should go forward by 2.
                resultOfA = resultOfA + 2;
                System.out.println("Player A is on a location which is divisible by 10 so he goes up by 2. It's new location is " + resultOfA);

            }
            if (resultofB % 10 == 0) {        //Same as the condition up above but specified for player B.
                resultofB = resultofB + 2;
                System.out.println("Player B is on a location which is divisible by 10 so he goes up by 2. It's new location is " + resultofB);
            }
            if (resultOfA > 10) {        // In here as I have the knowledge that integer can only contain 2 digits
                // I've converted the integer to string and i've just compared the first two chars, if they are same it's palendrome
                //  and followed the rule accordingly.
                String value = String.valueOf(resultOfA);
                if (value.charAt(0) == value.charAt(1)) {
                    resultOfA--;
                    System.out.println("Player A is on a location which is palindromic so he goes back by one. It's new location is: " + resultOfA);
                }
                if (resultofB > 10) {    //Just same palendrome rule as above just specified for player B.
                    String value2 = String.valueOf(resultofB);
                    if (value2.charAt(0) == value2.charAt(1)) {
                        resultofB--;
                        System.out.println("Player B is on a location which is palindromic so he goes back by one. It's new location is: " + resultofB);
                    }
                }

                if (resultOfA >= 100) { //In here if one of them makes it 100 I let the user know and broke the loop.
                    System.out.println("Player A made it. He ended up in location of " + resultOfA + " \nand it only took " + diceRolledForA + " rolls of dice which rolled " + (diceRolledForA+diceRolledForB) + " times.");
                    break;
                }
                diceRolledForA++; //I've increased the dice in here specificly for A because if it wins it shouldn't roll.
                if (resultofB >= 100) {
                    System.out.println("Player B made it. He ended up in location of " + resultofB + " \nand it only took " + diceRolledForB + " rolls of dice which rolled " + (diceRolledForA + diceRolledForB)+ " times.");
                break;
                }
                diceRolledForB++;
            }
        }
    }
}