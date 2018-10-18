package com.company;
import java.util.Scanner;


public class MainQ3 {
	public static void main(String[] args) {
	   //This short program gives you the first 10 digits in the multiplication table.
	    Scanner q1 = new Scanner(System.in);
	    System.out.println("Please enter a number between 1 and 10: ");
	    int firstNum = q1.nextInt();
	    int firstNumCopy = firstNum;
	    System.out.printf("The first 10 numbers in the multiplication table for the number %d are: ", firstNumCopy);
	    System.out.printf(" %d", firstNumCopy);
	    System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);
        System.out.printf(" %d", firstNumCopy += firstNum);







    }
}
