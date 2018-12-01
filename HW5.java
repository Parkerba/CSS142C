package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Parker Amundsen
 * @description this program takes a formatted Input.txt file containing students grades and names of the student.
 * The program then processes the grades and gives statistics on individual students and questions of the test in a formatted Output.txt file.
 * @version 11/15/2018
 */
public class HW5 {
    //global data members for use in multiple methods
    private static double[][] grades = null;
    private static String[] names = null;
    private static double[] totalScores = null;

    public static void main(String[] args) throws FileNotFoundException {

        //establishes input stream from Input.txt aswell as Scanner object to read file.
        FileInputStream input = new FileInputStream("Input.txt");
        Scanner reader = new Scanner(input);
        //establishes output stream to Output.txt aswell as a PrintWriter object to write to file.
        FileOutputStream fos = new FileOutputStream("Output.txt");
        PrintWriter writer = new PrintWriter(fos);

        //Below methods called in this order to achieve desired output format to Output.txt
        initializeArrays(reader);
        allScoresPrint(writer);
        sectionData(writer);
        overallPerStudent(writer);
        writer.close();
    }

    /**
     * @param reader
     * @throws FileNotFoundException
     * @description this initializes (assigns size) the grades[][] and names[] arrays.
     */
    public static void initializeArrays(Scanner reader) {
        int numOfStudents = reader.nextInt();
        int numOfQuestions = (reader.nextInt() - 1);
        grades = new double[numOfStudents][numOfQuestions];
        names = new String[numOfStudents];
        assignArrays(reader, numOfStudents, numOfQuestions);
    }

    /**
     * @param reader
     * @throws FileNotFoundException
     * @description assignArrays() gives the values the arrays names[] and grades[][].
     */
    public static void assignArrays(Scanner reader, int numOfStudents, int numOfQuestions) {
        for (int studentNumber = 0; studentNumber < numOfStudents; studentNumber++) {
            names[studentNumber] = reader.next();
            for (int questionNumber = 0; questionNumber < numOfQuestions; questionNumber++) {
                grades[studentNumber][questionNumber] = reader.nextDouble();
            }
        }

    }

    /**
     * @param writer
     * @description allScoresPrint() prints to the output file (Output.txt) all the scores of each section by student.
     */
    public static void allScoresPrint(PrintWriter writer) {
        int studentNumber = 0;
        writer.println("Score per section per student: \n=============================================");
        for (double[] student : grades) {
            writer.print(names[studentNumber] + ": ");
            studentNumber++;
            for (double grade : student) {
                writer.print(grade + " ");
            }
            writer.println("");
        }

    }

    /**
     * @param writer
     * @param sectionNumber
     * @description Prints the maximum value along with student names of the given section number in grades[][] to the output file.
     */
    public static void findMax(PrintWriter writer, int sectionNumber) {
        double max = 0;
        for (int i = 0; i < names.length; i++) {
            if (grades[i][sectionNumber] > max) {
                max = grades[i][sectionNumber];
            }
        }
        writer.println("Highest score: " + max);
        for (int i = 0; i < names.length; i++) {
            if (grades[i][sectionNumber] == max) {
                writer.print(names[i] + " ");
            }
        }
        writer.println("");
    }

    /**
     * @param writer
     * @param studentTotals
     * @description Prints the maximum value of the overall score among all the students to the output file along with student names.
     */
    public static void findMax(PrintWriter writer, boolean studentTotals) {
        if (studentTotals == true) {
            double max = totalScores[0];
            for (int i = 0; i < names.length; i++) {
                if (totalScores[i] > max) {
                    max = totalScores[i];
                }
            }
            writer.println("Highest score: " + max);

            for (int i = 0; i < names.length; i++) {
                if (max == totalScores[i]) {
                    writer.print(names[i] + " ");
                }
            }
            writer.println("");
        }
    }

    /**
     * @param writer
     * @param sectionNumber
     * @description Prints the minimum value along with student names of the given section number in grades[][] to the output file.
     */
    public static void findMin(PrintWriter writer, int sectionNumber) {
        double min = grades[0][sectionNumber];
        for (int i = 0; i < names.length; i++) {
            if (grades[i][sectionNumber] < min) {
                min = grades[i][sectionNumber];
            }
        }
        writer.println("Lowest score: " + min);

        for (int i = 0; i < names.length; i++) {
            if (min == grades[i][sectionNumber]) {
                writer.print(names[i] + " ");
            }
        }
        writer.println("");
    }

    /**
     * @param writer
     * @param studentTotals
     * @description Prints the minimum value of the overall score among all the students to the output file along with student names.
     */
    public static void findMin(PrintWriter writer, boolean studentTotals) {
        if (studentTotals == true) {
            double min = totalScores[0];
            for (int i = 0; i < names.length; i++) {
                if (totalScores[i] < min) {
                    min = totalScores[i];
                }
            }
            writer.println("Lowest score: " + min);

            for (int i = 0; i < names.length; i++) {
                if (min == totalScores[i]) {
                    writer.print(names[i] + " ");
                }
            }
            writer.println("");
        }
    }

    /**
     * @param writer
     * @param sectionNumber
     * @description findAverage() prints the average values of the given section number among all of the students to the output file.
     */
    public static void findAverage(PrintWriter writer, int sectionNumber) {
        double sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += grades[i][sectionNumber];
        }
        double average = sum / grades.length;
        writer.println("Average: " + average);
    }

    /**
     * @param writer
     * @param overallAverage
     * @description findAverage() prints the average value of the overall student scores to the output file.
     */
    public static void findAverage(PrintWriter writer, boolean overallAverage) {
        if (overallAverage == true) {
            double sum = 0;
            for (int i = 0; i < names.length; i++) {
                sum += totalScores[i];
            }
            double average = sum / grades.length;
            writer.println("Average: " + average);
        }
    }

    /**
     * @param writer
     * @description sectionData() formats the output of findMax(), findMin(), and findAverage() and loops through all sections.
     */
    public static void sectionData(PrintWriter writer) {
        int numOfQuestions = grades[0].length;
        for (int questionNum = 0; questionNum < numOfQuestions; questionNum++) {
            writer.println("=============================================");
            writer.println("Question: " + (questionNum + 1));
            findMax(writer, questionNum);
            findMin(writer, questionNum);
            findAverage(writer, questionNum);
        }
        writer.println("=============================================");
    }

    /**
     * @param writer
     * @descrition overallPerStudent() initializes the size of global data member totalScores().
     * Aswell as prints the formatted overall statistics to the output file.
     */
    public static void overallPerStudent(PrintWriter writer) {
        totalScores = new double[names.length];
        writer.println("Overall scores by student: ");
        for (int student = 0; student < names.length; student++) {
            writer.print(names[student] + ": ");
            double total = 0;
            for (int questionNum = 0; questionNum < grades[0].length; questionNum++) {
                total += grades[student][questionNum];
            }
            writer.println(total);
            totalScores[student] = total;
        }
        writer.println("");
        writer.println("Overall highest, lowest, and average score:");
        findMax(writer, true);
        findMin(writer, true);
        findAverage(writer, true);
        writer.println("=============================================");

    }
}

