package com.company;

import java.io.*;
import java.util.*;

/**
 * @author Parker Amundsen
 * @version 11/9/2018
 */
public class HW4V3 {


    private static String[] namesA = null;
    private static double[] gradesA = null;
    private static String[] namesB = null;
    private static double[] gradesB = null;
    private static String[] namesC = null;
    private static double[] gradesC = null;
    private static String[] namesAll = null;
    private static double[] gradesAll = null;
    private static String[] sectionNames = new String[3];
    private static double[] sectionAverages = new double[3];
    private static int sectionNamesIndex = 0;
    private static double averageOfAll;


    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("output.txt");
        processSectionA(writer, "grade1.txt");
        processSectionB(writer, "grade2.txt");
        processSectionC(writer, "grade3.txt");

        merge(namesA, namesB, namesC, gradesA, gradesB, gradesC);
        averageOfAll = findAverage(gradesAll);
        process(writer, "Overall", namesAll, gradesAll, true);
        writer.close();
    }

    /**
     * @param writer
     * @param inputFileName
     * @throws FileNotFoundException
     * @description: processSectionA reads inputFileName and initializes
     * global member arrays (String) namesA and  (double) gradesA. Passes member arrays
     * and section name to initializeAndProcess() method.
     */
    public static void processSectionA(PrintWriter writer, String inputFileName) throws FileNotFoundException {
        File f = new File(inputFileName);
        Scanner reader = new Scanner(new FileInputStream(f));
        String section = reader.nextLine();
        int size = reader.nextInt();
        namesA = new String[size];
        gradesA = new double[size];
        initializeAndProcess(writer, reader, section, namesA, gradesA);
    }

    /**
     * @param writer
     * @param inputFileName
     * @throws FileNotFoundException
     * @description: processSectionA reads inputFileName and initializes (String) namesB and (double) gradesB global member arrays.
     * Passes member arrays and section name to initializeAndProcess() method.
     */
    public static void processSectionB(PrintWriter writer, String inputFileName) throws FileNotFoundException {
        File f = new File(inputFileName);
        Scanner reader = new Scanner(new FileInputStream(f));
        String section = reader.nextLine();
        int size = reader.nextInt();
        namesB = new String[size];
        gradesB = new double[size];
        initializeAndProcess(writer, reader, section, namesB, gradesB);
    }

    /**
     * @param writer
     * @param inputFileName
     * @throws FileNotFoundException
     * @description: processSectionA reads inputFileName and initializes (String) namesC and (double) gradesC global member arrays. Passes member arrays
     * and section name to initializeAndProcess() method.
     */
    public static void processSectionC(PrintWriter writer, String inputFileName) throws FileNotFoundException {
        File f = new File(inputFileName);
        Scanner reader = new Scanner(new FileInputStream(f));
        String section = reader.nextLine();
        int size = reader.nextInt();
        namesC = new String[size];
        gradesC = new double[size];
        initializeAndProcess(writer, reader, section, namesC, gradesC);

    }

    /**
     * @param writer
     * @param reader
     * @param section
     * @param names
     * @param grades
     * @throws FileNotFoundException
     * @description: initializeAndProcess() reads through FileInputStream with Scanner object parameter, assigns values
     * to (String) names and (double) grades arrays passed as parameters. Finally initializeAndProcess() calls process(), passes
     * PrinterWriter object, assigned arrays, and section name.
     */
    public static void initializeAndProcess(PrintWriter writer, Scanner reader, String section, String[] names, double[] grades)
            throws FileNotFoundException {
        int index = 0;
        while (reader.hasNext()) {
            names[index] = reader.next();
            grades[index] = reader.nextDouble();
            index++;
        }
        process(writer, section, names, grades);
    }

    /**
     * @param writer
     * @param section
     * @param names
     * @param grades
     * @throws FileNotFoundException
     * @description: Process() assigns the values to minIndex, maxIndex, and average by calling. This is achieved by calling
     * findMinIndex(), findMaxIndex(), and findAverage() on the input (double) grades array. Process() also calls the flush() method,
     * and passes PrinterWriter object, section,  minIndex, maxIndex, section, and grades.
     */
    public static void process(PrintWriter writer, String section, String[] names, double[] grades) throws FileNotFoundException {
        int minIndex = findMinIndex(grades);
        int maxIndex = findMaxIndex(grades);
        double average = findAverage(grades);

        flush(writer, section, minIndex, maxIndex, average, names, grades);
    }

    /**
     * @param writer
     * @param section
     * @param names
     * @param grades
     * @param forAllSections
     * @throws FileNotFoundException
     * @description: Process() assigns the values to minIndex, maxIndex, and average by calling. This is achieved by calling
     * findMinIndex(), findMaxIndex(), and findAverage() on the input (double) grades array. Process() also calls the flush() method,
     * and passes PrinterWriter object, section,  minIndex, maxIndex, section, and grades. This Process() method also takes an extra
     * boolean parameter forAllSections to pass an extra parameter into flush.
     */
    public static void process(PrintWriter writer, String section, String[] names, double[] grades, boolean forAllSections) throws FileNotFoundException {
        if (forAllSections = true) {
            int minIndex = findMinIndex(grades);
            int maxIndex = findMaxIndex(grades);
            double average = findAverage(grades);
            flush(writer, section, minIndex, maxIndex, average, names, grades, forAllSections);
        } else {
            process(writer, section, names, grades);
        }
    }

    /**
     * @param grades
     * @return minIndex
     * @description: simply returns the minIndex or the index with the lowest value of the grades parameter.
     */
    public static int findMinIndex(double[] grades) {
        double minValue = 100;
        int minIndex = 0;
        for (int i = 0; i < grades.length; i++) {
            if (minValue > grades[i]) {
                minValue = grades[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * @param grades
     * @return maxIndex
     * @description: returns the maxIndex or the greatest value of the grades parameter.
     */
    public static int findMaxIndex(double[] grades) {
        double maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < grades.length; i++) {
            if (maxValue < grades[i]) {
                maxValue = grades[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * @param grades
     * @return average
     * @description: returns the average value of the parameter array.
     */
    public static double findAverage(double[] grades) {
        double average;
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        average = sum / grades.length;
        return average;

    }

    /**
     * @param writer
     * @param section
     * @param minIndex
     * @param maxIndex
     * @param average
     * @param names
     * @param grades
     * @throws FileNotFoundException
     * @description: flush() writes the formatted section data to the output file using the PrintWriter object.
     */
    public static void flush(PrintWriter writer, String section, int minIndex, int maxIndex, double average, String[] names, double[] grades)
            throws FileNotFoundException {
        writer.println("--------------------------");
        writer.println(section + ":");
        writer.println("Highest Score: " + names[maxIndex] + ": " + grades[maxIndex]);
        writer.println("Lowest Score: " + names[minIndex] + ": " + grades[minIndex]);
        writer.println("Average Score: " + average);
        writer.println("--------------------------");
        sectionNames[sectionNamesIndex] = section;
        sectionAverages[sectionNamesIndex++] = average;
    }

    /**
     * @param writer
     * @param section
     * @param minIndex
     * @param maxIndex
     * @param average
     * @param names
     * @param grades
     * @param forAllSections
     * @throws FileNotFoundException
     * @description: flush() writes the formatted data of all the sections, and provides the section analytics. This flush()
     * takes an extra boolean parameter forAllSections to indicate the inclusion of section analytics.
     */
    public static void flush(PrintWriter writer, String section, int minIndex, int maxIndex, double average, String[] names, double[] grades, boolean forAllSections)
            throws FileNotFoundException {
        String maxIndexSection;
        String minIndexSection;

        if (maxIndex < namesA.length) {
            maxIndexSection = "Section 142A";
        } else if (maxIndex < (namesA.length + namesB.length)) {
            maxIndexSection = "Section 142B";
        } else {
            maxIndexSection = "Section 142C";
        }

        if (minIndex < namesA.length) {
            minIndexSection = "Section 142A";
        } else if (minIndex < (namesA.length + namesB.length)) {
            minIndexSection = "Section 142B";
        } else {
            minIndexSection = "Section 142C";
        }

        writer.println("--------------------------");
        writer.println(section + ":");
        writer.println("Highest Score: " + names[maxIndex] + ": " + grades[maxIndex] + " " + maxIndexSection);
        writer.println("Lowest Score: " + names[minIndex] + ": " + grades[minIndex] + " " + minIndexSection);
        writer.println("Average Score: " + average);
        for (int i = 0; i < sectionAverages.length; i++) {
            sectionAnalytics(writer, sectionNames[i], sectionAverages[i], averageOfAll);
        }
        writer.println("--------------------------");

    }

    /**
     * @param namesA
     * @param namesB
     * @param namesC
     * @param gradesA
     * @param gradesB
     * @param gradesC
     * @description: merge() creates two new arrays by combining three (double) arrays for the first created array and
     * three (String) arrays for the second created array.
     */
    public static void merge(String[] namesA, String[] namesB, String[] namesC, double[] gradesA,
                             double[] gradesB, double[] gradesC) {
        namesAll = new String[namesA.length + namesB.length + namesC.length];

        int indexAllNames = 0;

        for (int x = 0; x < namesA.length; x++) {
            namesAll[indexAllNames] = namesA[x];
            indexAllNames++;
        }
        for (int y = 0; y < namesB.length; y++) {
            namesAll[indexAllNames] = namesB[y];
            indexAllNames++;
        }
        for (int z = 0; z < namesC.length; z++) {
            namesAll[indexAllNames] = namesC[z];
            indexAllNames++;
        }

        gradesAll = new double[gradesA.length + gradesB.length + gradesC.length];

        int indexAllGrades = 0;

        for (int h = 0; h < gradesA.length; h++) {
            gradesAll[indexAllGrades] = gradesA[h];
            indexAllGrades++;
        }
        for (int i = 0; i < gradesB.length; i++) {
            gradesAll[indexAllGrades] = gradesB[i];
            indexAllGrades++;
        }
        for (int j = 0; j < gradesC.length; j++) {
            gradesAll[indexAllGrades] = gradesC[j];
            indexAllGrades++;
        }
    }

    /**
     * @param writer
     * @param section
     * @param sectionAverage
     * @param overallAverage
     * @description: This provides prints a formatted section analytic summary.
     */
    public static void sectionAnalytics(PrintWriter writer, String section, double sectionAverage, double overallAverage) {
        if (sectionAverage > overallAverage) {
            writer.println(section + " had a greater average than the average for all the sections");
        } else if (sectionAverage < overallAverage) {
            writer.println(section + " had a lesser average than the average for all the sections");
        } else {
            writer.println(section + " had same average as the average for all the sections");
        }


    }


}