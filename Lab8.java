package com.company;

import java.util.*;

/**
 * @author Parker Amundsen
 * @version 11/21/2018
 */
public class Lab8 {

    public static void main(String[] args) {
        double[] arr = {1, 2, 2, 3, 5};
        double[] arr1 = {1, 2, 3, 2};
        System.out.println("isSorted() method:");
        System.out.println("array arr's sorted status is " + isSorted(arr));
        System.out.println("array arr1's sorted status is " + isSorted(arr1));
        System.out.println("");
        System.out.println("median() method:");
        System.out.println("The median of the array arr is " + median(arr));
        System.out.println("The median of the array arr1 is " + median(arr1));



        int[] arr2 = {1,2,3,4,5,6};
        int[] arr3 = {4,5,6,7,8,9};
        int[] common = new int[arr2.length + arr3.length];

        findCommon(arr2, arr3, common);
        System.out.println("The common values for arr2 and arr3 are: ");
        for (int x : common)
            System.out.print(x + " ");
        System.out.println("\n");
        rotateRight(common);
        System.out.println("The common values all rotated right by one index are: ");
        for (int x : common)
            System.out.print(x + " ");
        System.out.println("\n");
        System.out.println("The common values rotated then stretched will be: ");
        int[] commonStretched = stretch(common);
        for (int x : commonStretched){
            System.out.print(x + " ");
        }
        System.out.println("\n");
        System.out.println("Now we will be checking how many times the target value occurs in the streched rotated common value array.");
        System.out.println("Please provide the target value (must be an integer).");
        Scanner reader = new Scanner(System.in);
        int target = reader.nextInt();
        System.out.println(target + " occurs " + count(commonStretched,target) + " times in the array");



    }

    public static double median(double[] arr) {
        if (isSorted(arr)) {
            if (arr.length % 2 == 0) {
                int upperIndex = arr.length / 2;
                int lowerIndex = upperIndex - 1;
                double retVal = (arr[upperIndex] + arr[lowerIndex]) / 2;
                return retVal;
            } else {
                int index = arr.length / 2;
                double retVal = arr[index];
                return retVal;
            }
        } else {
            Arrays.sort(arr);
            if (arr.length % 2 == 0) {
                int upperIndex = arr.length / 2;
                int lowerIndex = upperIndex - 1;
                double retVal = (arr[upperIndex] + arr[lowerIndex]) / 2;
                return retVal;
            } else {
                int index = arr.length / 2;
                double retVal = arr[index];
                return retVal;
            }

        }
    }

    public static boolean isSorted(double[] arr) {
        double previous = arr[0];
        for (double x : arr) {
            if (x >= previous) {
                previous = x;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void findCommon(int[] arr1, int[] arr2, int[] common) {
        int commonIndex = 0;
        for (int x : arr1) {
            for (int y : arr2) {
                if (x == y) {
                    common[commonIndex++] = y;
                }
            }
        }
    }

    public static void rotateRight(int[] arr) {
        int newFirstIndex = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newFirstIndex;

    }

    public static int count(int[] arr, int target) {
        int count = 0;
        for (int x : arr) {
            if (x == target) {
                count++;
            }
        }
        return count;
    }

    public static int[] stretch(int[] arr) {
        int newArrIndex = 0;
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                newArr[newArrIndex++] = arr[i] / 2;
                newArr[newArrIndex++] = arr[i] / 2;
            } else {
                newArr[newArrIndex++] = (arr[i] / 2) + 1;
                newArr[newArrIndex++] = (arr[i] / 2);
            }
        }
        return newArr;
    }

}
