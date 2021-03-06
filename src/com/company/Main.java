package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Output the current date-time
        LocalDateTime today = LocalDateTime.now();
        System.out.println("The date and time right now is " + today + ".");

        //Output tomorrow's date using a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println(formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeks = today.plusWeeks(5);
        System.out.println(fiveWeeks);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime kaitansBirthday = LocalDateTime.of(1998, 10, 14, 12, 35);

        //Output the day of the week (Sunday-Saturday that you were born
        DayOfWeek dayofWeek = kaitansBirthday.getDayOfWeek();
        System.out.println("Kaitan was born on a " + dayofWeek + ".");

        //Output the number of days you've been alive.
        long daysFromBirthday = kaitansBirthday.toEpochSecond(ZoneOffset.MAX);
        long daysFromToday;
        daysFromToday = today.toEpochSecond(ZoneOffset.MAX);
        long resultFromDates = daysFromToday - daysFromBirthday;
        long secondsToDays = resultFromDates / 86400;
        System.out.println("Kaitan has been alive for " + secondsToDays + " days.");

        //Output the number of days between two dates.
        Random rand = new Random();
        LocalDate randomDate1 = LocalDate.of(rand.nextInt(9999), rand.nextInt(12) + 1, rand.nextInt(28) + 1);
        LocalDate randomDate2 = LocalDate.of(rand.nextInt(9999), rand.nextInt(12) + 1, rand.nextInt(28) + 1);
        System.out.println("Date 1: " + randomDate1);
        System.out.println("Date 2: " + randomDate2);
        System.out.println("The number of days between these two dates are: " + Math.abs(randomDate1.compareTo(randomDate2)));

        //Given two dates, output the earlier..
        if (randomDate1.isBefore(randomDate2)) {
            System.out.println("The earlier date is " + randomDate1);
        } else
            System.out.println("The earlier date is " + randomDate2);

        //Create a file with 100 random "month/day/year hour:minutes" (in that format) on each line.
        File outfile = new File("RandomDateFile.txt");
        try (PrintWriter pw = new PrintWriter(outfile)) {
            for (int i = 0; i < 50; i++) {
                LocalDateTime randomDatesLoop = today.minusSeconds(rand.nextInt(345678909));
                LocalDateTime randomDatesLoop2 = today.plusSeconds(rand.nextInt(345678909));
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
                pw.println(randomDatesLoop.format(formatter2));
                pw.println(randomDatesLoop2.format(formatter2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //TODO Store data from the file into an ArrayList of LocalDateTime objects.
        ArrayList<LocalDateTime> dataFromFile = readDataFromFile("RandomDateFile.txt");
        System.out.println(dataFromFile);


        //TODO Output the number of stored dates in the year [Y]
        Scanner scIn = new Scanner(System.in);
        System.out.println("Which year would you like to investigate?");
        int investigatedYear = scIn.nextInt();
        if (investigatedYear > 9999) {
            System.out.println("Sorry, our software does not support years that far into the future.");
        }
        if (investigatedYear < 0) {
            System.out.println("Sorry, our software does not support years that far in the past.");
        }


        //TODO Count the number of stored dates within the current year
        int currentYear = today.getYear();


        //TODO Count the number of duplicates
        for (int i = 0; i < dataFromFile.size(); i++) {
            if (dataFromFile.get(i).equals(dataFromFile.get())) {

            }
        }

        //TODO Sort the dates in chronological order
        for (int i = 0; i < dataFromFile.size(); i++) {
            if (dataFromFile.get(i+1).isAfter(dataFromFile.get(i))) {

            }

        }

        //TODO Count the number of duplicates in a sorted list without using a Java Set.

        //TODO Count the number of evening (after 6pm) dates.

        //TODO Count the number of dates in each of the individual 12 months using a Java Map

        //TODO Determine the index of the latest LocalDateTime.

        //TODO Determine the indexes of the elements that have the earliest starting time, regardless of date.

        //TODO Output a date in the format "January 1st, 2018
    }

    private static ArrayList<LocalDateTime> readDataFromFile(String s) throws FileNotFoundException {
        Scanner scKeyboard = new Scanner(System.in); // System.in means read from the keyboard
        Scanner sc = new Scanner(new File("RandomDateFile.txt"));  // means read from the given filename
        while (sc.hasNext()) {
            String aLineOfInput = sc.nextLine();  // read a line from sc
            String[] partDateFromTime = aLineOfInput.split(" "); // split the line on the space
            System.out.println("time part is " + partDateFromTime[1] + " and date part is " + partDateFromTime[0]);

            // now split the 3 parts of the date based on "/"

            // now split the  2 parts of the time based on ":"
            String[] partTime = partDateFromTime[1].split(":");
            System.out.println("mm is " + partTime[1] + " and hh is " + partTime[0]);
            ArrayList<LocalDateTime> ar = new ArrayList<>();
        }
        return ar;
    }
}

