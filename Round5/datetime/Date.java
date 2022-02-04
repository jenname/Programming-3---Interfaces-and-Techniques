/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Date {
    
    private int year_;
    private int month_;
    private int day_;
    
    static int[][] allowedDays = {{31,31},{28,29},{31,31},{30,30},{31,31},
        {30,30},{31,31},{31,31},{30,30},{31,31},{30,30},{31,31}};
    
    private boolean leapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
    
    private int daysInMonth(int month, int year) {
        int days = -1;
        
        if (1 <= month && month <= 12) {
            days = leapYear(year) ? allowedDays[month-1][1] : 
                    allowedDays[month-1][0];
        }
        return days;
    }
    
    private boolean isDate(int day, int month, int year) {
        return (1 <= day) && (day <= daysInMonth(month, year));
    }
    
    public Date(int year, int month, int day) throws DateException {
        boolean dateOk = isDate(day, month, year);
        
        if (dateOk == false) {
            throw new DateException(String.format("Illegal date %d.%d.%d", day, 
                    month, year));
        } else {
            day_ = day;
            month_ = month;
            year_ = year;
        }
    }
    
    public int getYear() {
        return year_;
    }
    
    public int getMonth() {
        return month_;
    }
    
    public int getDay() {
        return day_;
    }
    
    public String toString() {
        String line = String.format("%02d.%02d.%d", day_, month_, year_);
        return line;
    }
}
