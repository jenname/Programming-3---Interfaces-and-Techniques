/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Attainment {

    private String code_;
    private String num_;
    private int grade_;
        
    public Attainment(String courseCode, String studentNumber, int grade) {
        code_ = courseCode;
        num_ = studentNumber;
        grade_ = grade;
    }
        
    public String getCourseCode() {
        return code_;
    }
        
    public String getStudentNumber() {
        return num_;
    }
        
    public int getGrade() {
        return grade_;
    }
}
