/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Course {

    private String code_ = "";
    private String name_ = "";
    private int creds_ = 0;
        
    public Course(String code, String name, int credits) {
        code_ = code;
        name_ = name;
        creds_ = credits;
    }
        
    public String getCode() {
        return code_;
    }
        
    public String getName() {
        return name_;
    }
        
    public int getCredits() {
        return creds_;
    }
}
