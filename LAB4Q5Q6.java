package com.company;

import java.util.Scanner;
// Author: Parker Amundsen
//Date: 10-23-18
public class LAB4Q5Q6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("what size would you like your rectangle to be? ");
        int size = reader.nextInt();
        straightLine(size);
        System.out.println("What would you like the width of the box to be? ");
        int width = reader.nextInt();
        boxMaker(width);

    }

    public static void straightLine(int size) {
        for (int counter0 = 0; counter0 < size; counter0++) {
            for (int counter = 0; counter < size; counter++) {
                System.out.print('*');
            }
            System.out.println("");
        }
    }

    public static void boxMaker(int width) {
        for (int counter = 0; counter < width; counter++) {
            System.out.print('*');
        }
        System.out.println();

        for (int counter = 2; counter < width; counter++) {
            System.out.print('*');

            for (int counter1 = 2; counter1 < width; counter1++) {
                System.out.print(' ');
            }
            System.out.println('*');
        }

        for (int counter = 0; counter < width; counter++) {
            System.out.print('*');
        }
    }


}


