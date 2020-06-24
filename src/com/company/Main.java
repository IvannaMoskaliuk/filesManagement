/*
 * Classname: Main
 *
 * @version 24.06.2020
 * @author Ivanna Moskaliuk KNUTE
 *
 *          Module 4 task 1
 *  Home task. Files management.
 *
 *  1. Parse the file logs.txt (see the attachment).
 *  Extract to a separate file all the logs from October 2019.
 *
 *  2. Calculate the total number of logs (lines).
 *
 *  3. Calculate the total  number of  ERROR logs.
 *  Use previous skills - String.split
 *
 *  4. Calculate the total number of ERROR logs. Use Files.lines.
 *
 *  5. Compare two results.
 *
 */

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. Parse the file logs.txt (see the attachment).
        // Extract to a separate file all the logs.
        /*
         * @param startTime return time start
         * counting ERROR lines in the String.split way
         */
        LocalDateTime startTime = LocalDateTime.now();

        /*
         * @param text return text from file logs.txt
         */
        String text = new String(Files.readAllBytes(Paths.get
                ("C:\\Users\\ivank\\Desktop\\logs.txt")));

        // 2. Calculate the total number of logs (lines).
        /*
         * @param lines return text return
         * String array of lines from file logs.txt
         */
        String[] lines = text.split("\n");

        System.out.println("------------------------------------" +
                "\nFile logs.txt contains of " +
                lines.length + " lines");


        // 3. Calculate the total  number of  ERROR logs.
        // Use previous skills - String.split
        /*
         * @param counterErrors return count of lines
         * with ERROR from file logs.txt
         */
        int errors = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR")){
                errors++;
            }
        }

        System.out.println("------------------------------------"
                + "\nFile logs.txt contains of "
                + errors + " ERROR logs");

        /*
         * @param finishTime return time finish
         * counting ERROR lines in the String.split way
         */
        LocalDateTime finishTime = LocalDateTime.now();

        System.out.println("Using String.split for finding ERRORS needs "
                + ChronoUnit.MILLIS.between(startTime, finishTime)
                + " milliseconds");


        System.out.println("------------------------------------");


        // 4. Calculate the total number of ERROR logs. Use Files.lines.
        /*
         * @param startFiles return time start
         * counting ERROR lines in the String.split way
         **/

        LocalDateTime startTime1 = LocalDateTime.now();

        /*
         * @param counterErrors2 return count of lines
         * with ERROR from file logs.txt
         */

        final long errors2 =
                Files.lines(Paths.get("C:\\Users\\ivank\\Desktop\\logs.txt"))
                        .filter(line -> line.contains("ERROR"))
                        .count();

        System.out.println("File logs.txt contains of "
                + errors2 + " ERROR logs");

        /*
         * @param finishFiles return time finish
         * counting ERROR lines in the String.split way
         */

        LocalDateTime finishTime1 = LocalDateTime.now();

        System.out.println("Using Files.lines for finding ERRORS needs "
                + ChronoUnit.MILLIS.between(startTime1, finishTime1)
                + " milliseconds");

        System.out.println("------------------------------------");

        /*
        * @param theOctober2019Logs return String List
        * with date October 2019 from file logs.txt
        * (from stream to list)
        */

        List<String> theOctober2019Logs =
                Files.lines(Paths.get("C:\\Users\\ivank\\Desktop\\logs.txt"))
                        .filter(line -> line.contains("2019-10-"))
                        .collect(Collectors.toList());

        // @param octoberLogs return empty line and filling
        String octoberLogs = "";
        for (String line:theOctober2019Logs){
            octoberLogs += line + System.lineSeparator();
        }

        // Creation file October2019logs.txt and recording data from octoberLogs
        Path path = Paths.get("C:\\Users\\ivank\\Desktop\\October2019logs.txt");
        Files.write(path, octoberLogs.getBytes());

        System.out.println
                ("File 'October2019logs.txt' with all logs from " +
                        "October 2019 on Desktop");



    }
}
