import java.util.TreeSet;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Dates {

    public static class DateDiff {
        private String start_;
        private String end_;
        private int diff_;
        private String weekDayStart_;
        private String weekDayEnd_;
        
        
        public String getStart() {
            return start_;
            // Palauttaa "1999-01-01"
        }
        
        public String getEnd() {
            return end_;
        }
        
        public int getDiff() {
            return diff_;
        }
        
        private DateDiff(String start, int day_1, String end, 
                int day_2, int difference) {
            start_ = start;
            end_ = end;
            diff_ = difference;
            
            if (day_1 == 1) {
                weekDayStart_ = "Monday";
            } else if (day_1 == 2) {
                weekDayStart_ = "Tuesday";
            } else if (day_1 == 3) {
                weekDayStart_ = "Wednesday";
            } else if (day_1 == 4) {
                weekDayStart_ = "Thursday";
            } else if (day_1 == 5) {
                weekDayStart_ = "Friday";
            } else if (day_1 == 6) {
                weekDayStart_ = "Saturday";
            } else {
                weekDayStart_ = "Sunday";
            }
            
            if (day_2 == 1) {
                weekDayEnd_ = "Monday";
            } else if (day_2 == 2) {
                weekDayEnd_ = "Tuesday";
            } else if (day_2 == 3) {
                weekDayEnd_ = "Wednesday";
            } else if (day_2 == 4) {
                weekDayEnd_ = "Thursday";
            } else if (day_2 == 5) {
                weekDayEnd_ = "Friday";
            } else if (day_2 == 6) {
                weekDayEnd_ = "Saturday";
            } else {
                weekDayEnd_ = "Sunday";
            }
        }
        
        public String toString() {
            String[] start = start_.split("-");
            String[] end = end_.split("-");
            
            String line = String.format("%s %s.%s.%s --> %s %s.%s.%s: %d days", 
                    weekDayStart_,start[2], start[1], start[0], 
                    weekDayEnd_, end[2], end[1], end[0], diff_);
            return line;
        }
    }
    
    public static DateDiff[] dateDiffs(String ...dateStrs) throws DateTimeException {
        ArrayList<DateDiff> results = new ArrayList<>();
        TreeSet<LocalDate> dates = new TreeSet<>();
        int year = 0;
        int month = 0;
        int day = 0;
        
        for (String str : dateStrs) {
            
            String[] value_1 = str.split("\\.");
            
            if (value_1.length == 1) {
                String[] value_2 = str.split("\\-");
                
                if ((value_2[0].length() == 4) && (value_2[1].length() == 2) &&
                        (value_2[2].length() == 2)) {
                    year = Integer.parseInt(value_2[0]);
                    month = Integer.parseInt(value_2[1]);
                    day = Integer.parseInt(value_2[2]);
                } else {
                    System.out.format("The date \"%s\" is illegal!", str);
                    System.out.println();
                }
                
                
            } else if (value_1.length == 3) {
                year = Integer.parseInt(value_1[2]);
                month = Integer.parseInt(value_1[1]);
                day = Integer.parseInt(value_1[0]);
            } else {
                System.out.format("The date \"%s\" is illegal!", str);
                System.out.println();
            }
            
            if ((1000 <= year) && (year <= 9999)) {
                try {
                    LocalDate x = LocalDate.of(year, month, day);
                    dates.add(x);
                    
                }
                catch (DateTimeException e) {
                    System.out.format("The date \"%s\" is illegal!", str);
                    System.out.println();
                }
        
            } else {
                System.out.format("The date \"%s\" is illegal!", str);
                System.out.println();
            }
        }
        
        int n = 1;
        LocalDate currentDate = LocalDate.of(1000,1,1);
        for (LocalDate x : dates) {
            if (n == 1) {
                currentDate = x;
                ++n;
            } else {
                long diff = currentDate.until(x, ChronoUnit.DAYS);
                ++n;
                
                int day_1 = x.getDayOfMonth();
                int month_1 = x.getMonthValue();
                int year_1 = x.getYear();
                
                String line_1 = String.format("%d-%02d-%02d", year_1, month_1, day_1);
                
                int day_2 = currentDate.getDayOfMonth();
                int month_2 = currentDate.getMonthValue();
                int year_2 = currentDate.getYear();
                        
                String line_2 = String.format("%d-%02d-%02d", year_2, month_2, day_2);
                
                int difference = (int) diff;
                
                DayOfWeek weekDay_1 = currentDate.getDayOfWeek();
                DayOfWeek weekDay_2 = x.getDayOfWeek();
                
                int first_day = weekDay_1.getValue();
                int second_day = weekDay_2.getValue();
                
                DateDiff d = new Dates.DateDiff(line_2, first_day, line_1, 
                        second_day, difference);
                results.add(d);
                
                currentDate = x;
                
            }
        }
        
        DateDiff[] finalResults = new DateDiff[results.size()];
        finalResults = results.toArray(finalResults);
        
        return finalResults;
        
    }
}
