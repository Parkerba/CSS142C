package com.company;

import java.util.*;

public class Lab9 {

    public static void main(String[] args) {
        //Arrays given in Lab 9 page.
        int[][] allneg = {{-10, -12, -3}, {-4, -5, -6, -8}, {-7, -8}};
        int[][] nonsquare = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        int[][] latin = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        int[][] notlatin = {{2, 1, 3}, {2, 3, 1}, {3, 1, 2}};

        //Using random() method and user input to create 5 different arrays with psuedorandom integers.
        Scanner reader = new Scanner(System.in);
        System.out.println("To test the random method please enter the size of the two dimensional array!");
        int size = reader.nextInt();
        System.out.println("Now enter the range of integers you would like to fill the array with. *smallest first");
        int min = reader.nextInt();
        int max = reader.nextInt();
        int[][] randomArray0 = random(size, min, max);
        int[][] randomArray1 = random(size, min, max);
        int[][] randomArray2 = random(size, min, max);
        int[][] randomArray3 = random(size, min, max);
        int[][] randomArray4 = random(size, min, max);

        //printing random arrays generated with random() method.
        System.out.println("Random array 0");
        print2DArr(randomArray0);
        System.out.println();
        System.out.println("Random array 1");
        print2DArr(randomArray1);
        System.out.println();
        System.out.println("Random array 2");
        print2DArr(randomArray2);
        System.out.println();
        System.out.println("Random array 3");
        print2DArr(randomArray3);
        System.out.println();
        System.out.println("Random array 4");
        print2DArr(randomArray4);
        System.out.println();

        //Printing the given two dimensional arrays.
        System.out.println("Below are the arrays given in the Lab 9 lab page.");
        System.out.println("allneg:");
        print2DArr(allneg);
        System.out.println();
        System.out.println("nonsquare:");
        print2DArr(nonsquare);
        System.out.println();
        System.out.println("latin:");
        print2DArr(latin);
        System.out.println();
        System.out.println("notlatin:");
        print2DArr(notlatin);
        System.out.println();

        //Testing the colSum() and rowSum() methods.
        System.out.println("To demonstrate the method rowSum and colSum The sums of the first row and column will\n" +
                "be calculated for all of the randomArrays and given arrays in the Lab 9 page. ");
        System.out.println("Random array 0 row sum: " + rowSum(randomArray0, 0) + "\nRandom Array 0 column sum: " + colSum(randomArray0, 0) + "\n");
        System.out.println("Random array 1 row sum: " + rowSum(randomArray1, 0) + "\nRandom Array 1 column sum: " + colSum(randomArray1, 0) + "\n");
        System.out.println("Random array 2 row sum: " + rowSum(randomArray2, 0) + "\nRandom Array 2 column sum: " + colSum(randomArray2, 0) + "\n");
        System.out.println("Random array 3 row sum: " + rowSum(randomArray3, 0) + "\nRandom Array 3 column sum: " + colSum(randomArray3, 0) + "\n");
        System.out.println("Random array 4 row sum: " + rowSum(randomArray4, 0) + "\nRandom Array 4 column sum: " + colSum(randomArray4, 0) + "\n");
        System.out.println("allneg row sum: " + rowSum(allneg, 0) + "\nallneg column sum: " + colSum(allneg, 0) + "\n");
        System.out.println("nonsquare row sum: " + rowSum(nonsquare, 0) + "\nnonsquare column sum: " + colSum(nonsquare, 0) + "\n");
        System.out.println("latin row sum: " + rowSum(latin, 0) + "\nlatin column sum: " + colSum(latin, 0) + "\n");
        System.out.println("notlatin row sum: " + rowSum(notlatin, 0) + "\nnotlatin column sum: " + colSum(notlatin, 0) + "\n");

        //Testing the isSquare() method.
        System.out.println("To demonstate the isSquare() method it wil be called with all the random arrays aswell as the 4 given arrays.\nIf the array is square the value will be true. \n");
        System.out.println("Random array 0 isSquare() ? " + isSquare(randomArray0) + "\n");
        System.out.println("Random array 1 isSquare() ? " + isSquare(randomArray1) + "\n");
        System.out.println("Random array 2 isSquare() ? " + isSquare(randomArray2) + "\n");
        System.out.println("Random array 3 isSquare() ? " + isSquare(randomArray3) + "\n");
        System.out.println("Random array 4 isSquare() ? " + isSquare(randomArray4) + "\n");
        System.out.println("allneg isSquare() ? " + isSquare(allneg) + "\n");
        System.out.println("nonsquare isSquare() ? " + isSquare(nonsquare) + "\n");
        System.out.println("latin isSquare() ? " + isSquare(latin) + "\n");
        System.out.println("notlatin isSquare() ? " + isSquare(notlatin) + "\n");

        // testing is latin method.
        System.out.println();
        System.out.println("Is Latin?");
        System.out.println("To demonstate the isLatin() method it wil be called with all the random arrays aswell as the 4 given arrays.\nIf the array is a latin square the value will be true. \n");
        System.out.println("Random array 0 isLatin() ? " + isLatin(randomArray0) + "\n");
        System.out.println("Random array 1 isLatin() ? " + isLatin(randomArray1) + "\n");
        System.out.println("Random array 2 isLatin() ? " + isLatin(randomArray2) + "\n");
        System.out.println("Random array 3 isLatin() ? " + isLatin(randomArray3) + "\n");
        System.out.println("Random array 4 isLatin() ? " + isLatin(randomArray4) + "\n");
        System.out.println("allneg isLatin() ? " + isLatin(allneg) + "\n");
        System.out.println("nonsquare isLatin() ? " + isLatin(nonsquare) + "\n");
        System.out.println("latin isLatin() ? " + isLatin(latin) + "\n");
        System.out.println("notlatin isLatin() ? " + isLatin(notlatin) + "\n");




    }

    /**
     * @param n
     * @param start
     * @param end
     * @return randomReturn
     * @description returns an n-by-n matrix of random integers ranging from start to end;
     */
    public static int[][] random(int n, int start, int end) {
        int[][] randomReturn = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                randomReturn[i][j] = randomIntWithRange(start, end);
            }
        }
        return randomReturn;
    }

    /**
     * @param min
     * @param max
     * @return randint
     * @description returns a psuedorandom integer within the range of values provided in parameters.
     */
    public static int randomIntWithRange(int min, int max) {
        int range = (max - min) + 1;
        int randInt = (int) (Math.random() * range) + min;
        return randInt;
    }

    /**
     * @param arr
     * @description prints the inputed two dimensional array
     */
    public static void print2DArr(int[][] arr) {
        for (int[] outerArray : arr) {
            for (int innerElement : outerArray) {
                System.out.print("[" + innerElement + "]" + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * @param a
     * @param i
     * @return sum
     * @description returns the sum of the elements in row i of the 2-D array a
     */
    public static int rowSum(int[][] a, int i) {
        int sum = 0;
        for (int j = 0; j < a[i].length; j++) {
            sum += a[i][j];
        }
        return sum;
    }

    public static int colSum(int[][] a, int j) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][j];
        }
        return sum;
    }

    /**
     * @param a
     * @return true/false
     * @description returns true if the 2-D array a is square (i.e. the number of rows and columns are the same);
     */
    public static boolean isSquare(int[][] a) {
        int numOfRows = a.length;
        int counter = 0;
        for (int i = 0; i < numOfRows; i++) {
            if (a[i].length == numOfRows) {
                counter++;
            }
        }
        if (counter == numOfRows) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param a
     * @return true/false
     * @descrition returns true if the 2-D array parameter represents a latin square, and false if it does not.
     */
    public static boolean isLatin(int[][] a) {
        if (isSquare(a)) {
            int[] row = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                row[i] = a[0][i];
            }
            Arrays.sort(row);
            for (int j = 0; j < a.length; j++) {
                int[] column = new int[a.length];
                for (int k = 0; k < a.length; k++) {
                    column[k] = a[k][j];
                }
                Arrays.sort(column);
                if (Arrays.equals(column, row)) {

                } else {
                    return false;
                }

            }
            return true;

        } else {
            return false;
        }
    }
}



