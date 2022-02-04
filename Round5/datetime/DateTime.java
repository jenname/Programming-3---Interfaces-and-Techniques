/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class DateTime extends Date {
    private int hour_;
    private int min_;
    private int sec_;
    
    private boolean isRealDatetime(int hour, int min, int sec) {
        boolean timeOk = false;
        
        if (0 <= hour && hour <= 23 && 0 <= min && min <= 59 && 0 <= sec &&
                sec <= 59) {
            timeOk = true;
        }
        return timeOk;
    }
    
    public DateTime (int year, int month, int day, int hour, int minute, 
            int second) throws DateException {
        super(year, month, day);
        boolean timeOk = isRealDatetime(hour, minute, second);
        
        if (timeOk == false) {
            throw new DateException(String.format("Illegal time %02d:%02d:%02d",
                    hour, minute, second));
        } else {
            hour_ = hour;
            min_ = minute;
            sec_ = second;
        }
    }
    
    public int getHour() {
        return hour_;
    }
    
    public int getMinute() {
        return min_;
    }
    
    public int getSecond() {
        return sec_;
    }
    
    public String toString() {
        String line = super.toString();
        line += " ";
        String time = String.format("%02d:%02d:%02d", hour_, min_, sec_);
        line += time;
        
        return line;
    }
            
            

    
}
