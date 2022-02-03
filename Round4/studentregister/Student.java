/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Student {

    private String name_ = "";
    private String number_ = "";
        
    public Student(String name, String studentNumber) {
        name_ = name;
        number_ = studentNumber;
    }
        
    public String getName() {
        return name_;
    }
        
    public String getStudentNumber() {
        return number_;
    }
}
