package com.company;

import java.util.*;

public class HW3V2 {

    public static int userPoints = 25;
    public static int allowedAttempts = 5;

    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter (h)elp, (p)lay, (c)onfigure, (r)eport, (q)uit");
            char choice = reader.next().charAt(0);
            switch (choice) {
                case 'h':
                    helpMenu();
                    break;

                case 'p':
                    play(reader);
                    break;

                case 'c':
                    allowedAttempts = configure(reader);
                    break;

                case 'r':
                    report();
                    break;

                case 'q':
                    quit();
                    return;

                default:
                    invalidInput();
                    break;


            }
        }
    }

    /*configure() takes a scanner as a parameter to ask the user a passcode. The passcode will then be manipulated to a
    value between 3 and 7, this value represents the number of allowed attempts.
    */
    public static int configure(Scanner reader) {
        //use scanner to collect passphrase that will be used to calculate the number of attempts(return value)
        System.out.println("To configure the number of attempts please enter a pass phrase! ");
        reader.nextLine();
        String passPhrase = reader.nextLine();

        //sums ascii values of characters the user enters in passPhrase into numOfAttempts
        double numOfAttempts = 0;
        for (int counter = 0; counter < passPhrase.length(); counter += 1) {
            numOfAttempts = numOfAttempts + ((int) passPhrase.charAt(counter));
        }

        //rounds numOfAttempts to whole number then takes modulo of numOfAttempts
        numOfAttempts = Math.round(numOfAttempts / passPhrase.length());
        numOfAttempts = numOfAttempts % 5;

        //changes numOfAttempts to type int
        int returnValue = (int) numOfAttempts;
        returnValue += 3;
        System.out.println("Your number of allowed attempts is " + returnValue);
        return returnValue;
    }


    // helpMenu() simply prints information about the program and how it works to the user.
    public static void helpMenu() {
        System.out.println("******************************************************************************");
        System.out.println();
        System.out.println("Welcome to UW CSS 142 Point Machine.");
        System.out.println("This machine choses a number between 1-100 at random.");
        System.out.println("You need to guess the number, You (i.e the user) will have fixed number of attempts to guess the number.");
        System.out.println("If you guess it correct, you will earn points based on the number of attempts taken.");
        System.out.println("If you cannot guess it, you will lose points");
        System.out.println("To proceed, please select (h)elp , (p)lay, (c)onfigure, (r)eport, (q)uit");
        System.out.println();
        System.out.println("******************************************************************************");
    }

    // quit() simply terminates the program when called.
    public static void quit() {
        System.exit(0);
    }

    // invalidInput() simply prints a message to the user if they give input that is not supported
    public static void invalidInput() {
        System.out.println("That isn't a valid input please enter one of the choices in parenthesis below: ");
    }

    // chooseRandomNumber() is the method that chooses a random number that the user has to guess
    public static int chooseRandomNumber() {
        // create random object
        Random r = new Random();

        // create random number between 1-100
        int computerChosenNumber = r.nextInt(100);

        // log/return computerChoseNumber
        //System.out.println(computerChosenNumber);
        return computerChosenNumber;
    }

    /* playSession() takes a Scanner, output from chooseRandomNumber() and allowedAttempts as parameters.
    takes guess from user and gives hints until user guesses correctly or runs out of attempts, returns number of attempts. */

    public static int playSession(Scanner reader, int computerChosenNumber, int allowedAttempts) {
        int originalAllowedAttempts = allowedAttempts;
        while (allowedAttempts > 0) {
            System.out.println();
            System.out.println(allowedAttempts + " attempts left.");
            allowedAttempts--;
            System.out.println("Enter your guess as a whole number between 0 and 100.");
            int userGuess = reader.nextInt();

            //checks that userGuess is within accepted values
            while (userGuess > 100 || userGuess < 0) {
                System.out.println(userGuess + " is not between 0 and 100, try again. " + allowedAttempts + " attempts left.");
                userGuess = reader.nextInt();
                allowedAttempts--;
            }
            //checks if userGuess is correct
            if (userGuess == computerChosenNumber) {
                System.out.println("Great guess!! You got it! ");
                break;
            } else {
                // Makes a string version of userGuess and computerChosenNumber so it can be split into characters to
                // check unit and tens digits.
                String userGuessStr = Integer.toString(userGuess);
                String computerChosenNumberStr = Integer.toString(computerChosenNumber);

                char userTens;
                char userUnits;
                char computerTens;
                char computerUnits;

                //Below if/else statements separate userGuess into separate tens and unit digits
                if (userGuessStr.length() < 2) {
                    userTens = 0;
                    userUnits = userGuessStr.charAt(0);

                } else if (userGuessStr.length() == 3) {
                    userTens = 0;
                    userUnits = 0;

                } else {
                    userTens = userGuessStr.charAt(0);
                    userUnits = userGuessStr.charAt(1);

                }
                if (computerChosenNumberStr.length() < 2) {
                    computerTens = 0;
                    computerUnits = computerChosenNumberStr.charAt(0);

                } else if (computerChosenNumberStr.length() == 3) {
                    computerTens = 0;
                    computerUnits = 0;

                } else {
                    computerTens = computerChosenNumberStr.charAt(0);
                    computerUnits = computerChosenNumberStr.charAt(1);
                }
                //initialize integer/assign versions of units and tens digits for computerChosenNumber
                int computerTensInt = computerTens - '0';
                int computerUnitsInt = computerUnits - '0';
                //initialize integer/assign versions of units and tens digits for userGuess
                int userTensInt = userTens - '0';
                int userUnitsInt = userUnits - '0';

                if (computerTensInt > userTensInt && computerUnitsInt > userUnitsInt) {
                    System.out.println("HINT: The number's tens and unit digits are both larger than your guess. ");

                } else if (computerTensInt < userTensInt && computerUnitsInt < userUnitsInt) {
                    System.out.println("HINT: The number's tens and unit digits are both smaller than your guess. ");

                } else if (computerTensInt > userTensInt && computerUnitsInt < userUnitsInt) {
                    System.out.println("HINT: The number's tens is larger than your guess. The number's unit digit is smaller than" +
                            " your guess. ");

                } else if (computerTensInt < userTensInt && computerUnitsInt > userUnitsInt) {
                    System.out.println("HINT: The number's tens digis is smaller than your guess. The number's unit digit is larger " +
                            "than your guess. ");

                } else if (computerTensInt == userTensInt && computerUnitsInt > userUnitsInt) {
                    System.out.println("HINT: The number's ten digit is the same as yours, but the unit digit of the number is larger than yours. ");

                } else if (computerTensInt == userTensInt && computerUnitsInt < userUnitsInt) {
                    System.out.println("HINT: The number's ten digit is the same as yours, but the unit digit of the number is smaller than yours. ");

                } else if (computerTensInt > userTensInt && computerUnitsInt == userUnitsInt) {
                    System.out.println("HINT: The number's ten digit is larger than yours, but the unit digit of the number is the same as yours. ");

                } else if (computerTensInt < userTensInt && computerUnitsInt == userUnitsInt) {
                    System.out.println("HINT: The number's ten digit is smaller than yours, but the unit digit of the number is the same as yours. ");

                } else {
                    System.out.println("HINT: The number's tens and unit digits are the same as your guess, however, the computers " +
                            "number and your number are not the same.");
                }
            }

        }
        int attemptsUsed = (originalAllowedAttempts - allowedAttempts);
        return attemptsUsed;
    }

    // returns the number of points earned, takes the number of attempts and the allowed attempts as parameters
    public static int pointsScored(int attempts, int allowedAttempts) {
        int pointsEarned;
        if (attempts <= allowedAttempts) {
            pointsEarned = 15 - allowedAttempts - attempts;
        } else {
            switch (allowedAttempts) {
                case 7:
                    pointsEarned = -1;
                    break;

                case 6:
                    pointsEarned = -3;
                    break;

                case 5:
                    pointsEarned = -5;
                    break;

                case 4:
                    pointsEarned = -7;
                    break;

                default:
                    pointsEarned = -9;
                    break;

            }
        }
        return pointsEarned;
    }

    /* playAgain checks to see if the user has anymore points left, if not game over, if they do, will ask user
     if they would like to play again. */

    public static boolean playAgain(Scanner reader) {
        if (userPoints <= 0) {
            System.out.println("Game over, thank you for playing! ");
            return false;
        }

        while (true) {
            System.out.println("Would you like to play again? YES/NO ");
            String userResponse = reader.next();
            userResponse = userResponse.toUpperCase();
            if (userResponse.equals("YES") || userResponse.equals("Y")) {
                return true;
            } else if (userResponse.equals("NO") || userResponse.equals("N")) {
                return false;
            } else {
                System.out.println("Not a valid respond, enter YES or NO");
            }
        }
    }

    // report() prints the userPoints when called, takes no parameters.
    public static void report() {
        System.out.println("You have " + userPoints + " points!");
    }

    /* play() connects chooseRandomNumber(), playSession(), playAgain(), and pointsScored() to make the guessing part of the program.
    Only takes the reader Scanner as its parameter.*/
    public static void play(Scanner reader) {
        do {
            int computerChosenNumber = chooseRandomNumber();
            int attempts = playSession(reader, computerChosenNumber, allowedAttempts);
            int pointsScored = pointsScored(attempts, allowedAttempts);
            System.out.println(" Allowed attempts: " + allowedAttempts);
            System.out.println(" Attempts taken: " + attempts);
            System.out.println(" Old Score: " + userPoints);
            System.out.println(" Points earned: " + pointsScored);
            System.out.println(" New Score: " + (userPoints + pointsScored));
            userPoints += pointsScored;
        } while (playAgain(reader));
        System.out.println("Thank you for playing!!");
    }
}

