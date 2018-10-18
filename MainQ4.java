package com.company;
import java.util.Scanner;
public class MainQ4 {
    /*This is a program that will take the cost for 4 meals, the desired tip, and tax rate in the area and give the total
    before and after tip and tax. */
    public static void main(String[] args) {
        //The below scanners meal_1, 2, 3, 4 take the cost of the 4 meals.
        Scanner meal_1 = new Scanner(System.in);
        System.out.println("Please enter the price of the first meal: ");
        double meal1 = meal_1.nextDouble();

        Scanner meal_2 = new Scanner(System.in);
        System.out.println("Please enter the price of the second meal: ");
        double meal2 = meal_2.nextDouble();

        Scanner meal_3 = new Scanner(System.in);
        System.out.println("Please enter the price of the third meal: ");
        double meal3 = meal_3.nextDouble();

        Scanner meal_4 = new Scanner(System.in);
        System.out.println("Please enter the price of the fourth meal: ");
        double meal4 = meal_4.nextDouble();

        //The below scanner tax takes take rate as a percent.
        Scanner tax = new Scanner(System.in);
        System.out.println("Please enter the the tax rate in your area as a percentage: ");
        double taxRate = tax.nextDouble();
        taxRate = taxRate/100;

        //The below scanner takes the tip amount.
        Scanner tip = new Scanner(System.in);
        System.out.println("Please enter the tip amount: ");
        double tipAmount = tip.nextDouble();

        //subTotal represents the cost of the meals before tip and tax
        double subTotal = (meal1 + meal2 + meal3 + meal4);
        subTotal = Math.round(subTotal*100.0)/100.0;

        //subTotal2 represents the cost of the 4 meals after tax.
        double subTotal2 = (subTotal * (taxRate + 1));
        subTotal2 = Math.round(subTotal2 * 100.0)/100.0;

        // total represents the final amount after tax and tip.
        double total = (subTotal2 + tipAmount);
        total = Math.round(total*100.0)/100.0;



        System.out.println();
        System.out.println("The subtotal before tax and tip is: " + subTotal);
        System.out.println();
        System.out.println("The subtotal before tip and after tax is: " + subTotal2);
        System.out.println();
        System.out.println("The total after tax and tip is: " + total);






	}
}
