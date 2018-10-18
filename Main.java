package com.company;
import java.util.Scanner;
public class Main {
    /*
    * CSS142C HW 2
    * @author (Parker Amundsen)
    * @version (10-17-2018)
    * */

    public static void main(String[] args) {

        double total = computeTotal();  //total before tax tip and discount

        total = Math.round(total * 100);
        total = total/100;
        System.out.println("The total of the four meals is : " + total);

       double disc = computeDiscount();

        total = applyDiscount(total , disc);  //total after discount
        total = Math.round(total * 100);
        total = total/100;
        System.out.println("Your discount has been accepted, your new total is " + total);

        double taxRate = computeTax();
        System.out.println("Your tax rate is " + taxRate + "%." );
        total = applyTax(taxRate, total);  //total after tax and discount
        total = Math.round(total * 100);
        total = total/100;
        System.out.println(total);

        total = computeAndApplyTip(total);  //total after tax, tip, and discount

        total = Math.round(total * 100);
        total = total/100;
        double share = total/4;
        share = Math.round(share * 100);
        share = share/100;
        System.out.println("The total after tax and tip is: " + total);

        System.out.println("So each persons share is: " + share );




    }
//computeTotal asks the user to provide the cost of 4 meals before tax/tip/discount then returns the total.
    public static double computeTotal(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the cost of the first Meal: ");
        double meal1 = reader.nextDouble();

        System.out.println("Please enter the cost of the second Meal: ");
        double meal2 = reader.nextDouble();

        System.out.println("Please enter the cost of the third Meal: ");
        double meal3 = reader.nextDouble();

        System.out.println("Please enter the cost of the fourth Meal: ");
        double meal4 = reader.nextDouble();

        double total = (meal1+meal2+meal3+meal4);
        System.out.println(total);
        return total;
   }
   //computeDiscount takes the users coupon code and returns a value that is the discount based on the characters entered.
    public static double computeDiscount(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your 6 digit coupon code: ");
        String code = reader.nextLine();
        double disc = 0;
        if (code.length() == 6){
            for (int counter = 0; counter < code.length(); counter += 1){
                disc = disc + ((int) code.charAt(counter));
            }
       }else{
           System.out.println("incorrect number of characters, discount defaulted to 3%");
            disc = .03;
            return disc;
       }

        disc = Math.round(disc/6);
        disc = disc%10;
        disc = disc/100;
        System.out.println("Your discount percentage is " + disc + ".");
    return disc;}


    //applyDiscount applies the discount from computeDiscount to the total from computeTotal.
    public static double applyDiscount(double total, double disc){
        total = (total - (total * disc));
        return total;
    }


    //This is a method that computes the sales tax based on the postal code that the user enters.
    public static double computeTax(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your two digit postal code EX: CA: ");
        String postalCode = reader.nextLine();
        postalCode = postalCode.toUpperCase();
        double taxRate;
        if (postalCode.length() == 2 ) {
            switch (postalCode) {
                case "AL":
                    taxRate = 9.10;
                    break;

                case "AK":
                    taxRate = 1.76;
                    break;

                case "AZ":
                    taxRate = 8.33;
                    break;

                case "AR":
                    taxRate = 9.41;
                    break;

                case "CA":
                    taxRate = 8.54;
                    break;

                case "CO":
                    taxRate = 7.52;
                    break;

                case "CT":
                    taxRate = 6.35;
                    break;

                case "DE":
                    taxRate = 0;
                    break;

                case "Fl":
                    taxRate = 6.80;
                    break;

                case "GA":
                    taxRate = 7.15;
                    break;

                case "HI":
                    taxRate = 4.35;
                    break;

                case "ID":
                    taxRate = 6.03;
                    break;

                case "IL":
                    taxRate = 8.70;
                    break;

                case "IN":
                    taxRate = 7.00;
                    break;

                case "IA":
                    taxRate = 6.80;
                    break;
                case "KS":
                    taxRate = 8.68;
                    break;

                case "KY":
                    taxRate = 6.00;
                    break;

                case "LA":
                    taxRate = 10.02;
                    break;

                case "ME":
                    taxRate = 5.50;
                    break;
                case "MD":
                    taxRate = 6.00;
                    break;

                case "MA":
                    taxRate = 6.25;
                    break;

                case "MI":
                    taxRate = 6.00;
                    break;

                case "MN":
                    taxRate = 7.42;
                    break;

                case "MS":
                    taxRate = 7.07;
                    break;

                case "MO":
                    taxRate = 8.03;
                    break;

                case "MT":
                    taxRate = 0;
                    break;

                case "NE":
                    taxRate = 6.89;
                    break;
                case "NV":
                    taxRate = 8.14;
                    break;

                case "NH":
                    taxRate = 0;
                    break;

                case "NJ":
                    taxRate = 6.60;
                    break;

                case "NM":
                    taxRate = 7.66;
                    break;
                case "NY":
                    taxRate = 8.49;
                    break;

                case "NC":
                    taxRate = 6.95;
                    break;

                case "ND":
                    taxRate = 6.80;
                    break;

                case "OH":
                    taxRate = 7.15;
                    break;
                case "OK":
                    taxRate = 8.91;
                    break;

                case "OR":
                    taxRate = 0;
                    break;

                case "PA":
                    taxRate = 6.34;
                    break;

                case "RI":
                    taxRate = 7.00;
                    break;
                case "SC":
                    taxRate = 7.37;
                    break;

                case "SD":
                    taxRate = 6.40;
                    break;

                case "TN":
                    taxRate = 9.46;
                    break;

                case "TX":
                    taxRate = 8.17;
                    break;

                case "UT":
                    taxRate = 6.77;
                    break;

                case "VT":
                    taxRate = 6.18;
                    break;

                case "VA":
                    taxRate = 5.63;
                    break;

                case "WA":
                    taxRate = 9.18;
                    break;
                case "WV":
                    taxRate = 6.37;
                    break;

                case "WI":
                    taxRate = 5.42;
                    break;

                case "WY":
                    taxRate = 5.46;
                    break;

                default:
                    System.out.println("You did not enter a valid two digit postal code. Defaulting to 10% tax.");
                    taxRate = 10;


            }
        }       else{
                    System.out.println("You entered a code that was not two digits. Defaulting to 10% tax");
                    taxRate = 10;
        }
                return taxRate;}

    public static double applyTax(double taxRate, double total){
        taxRate = taxRate/100;
        total = total * (1 + taxRate);
        return total;
    }
    //This simply computes the tip as an absolute value
    public static double computeTip(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the amount you would like to tip: ");
        double tip = reader.nextDouble();
        if (tip < 0 || tip > 100){
            System.out.println("Tip must be bewteen 0 and 100, Tip has been set to 25.");
            tip = 25;
        }
        return tip;
    }

    //This computes the tip amount as a percentage of the total after tax and discount
    public static double computeTip(double total){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the percent you would like to tip as a whole number (example: ENTER 18 for 18%): ");
        double tip = reader.nextDouble();
        if (tip < 0 || tip > 100){
            System.out.println("You must have a tip percentage between 0 and 100 percent, tip has been set to 33%");
            tip = 33;
            tip = tip/100;
            tip = (tip*total);
        }else {
            tip = tip/100;
            tip = (tip*total);
        }
        return (tip);
    }
    //computeAndApplyTip asks the user to select tip as a percentage or as absolute value. Then applies tip using one of computeTip() methods.
    public static double computeAndApplyTip( double total){
        Scanner reader = new Scanner(System.in);
        System.out.println("Would you like to tip as a percentage (ENTER \"P\") or as an absolute value" +
                " (ENTER \"A\"?");
        String choice = reader.nextLine();
        choice = choice.toUpperCase();
        double tip;
        if (choice.equals("A")  ||  choice.equals("ABSOLUTE")){
            tip = computeTip();
        }else if (choice.equals("P")  || choice.equals("PERCENT") || choice.equals("PERCENTAGE") ){
            tip = computeTip(total);
        }else{
            System.out.println("That is not a supported response, tip has been set to 18%");
            tip = (.18 * total);
        } return(tip + total);
    }
}

