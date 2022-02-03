import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class StudentRegister {

    private TreeMap<String, Student> studentMap; 
    private TreeMap<String, Course> courseMap; 
    public ArrayList<Student> students;
    public ArrayList<Course> courses;
    public ArrayList<Attainment> attainments;
    private HashMap<String, String> courseInfo = new HashMap<>();
    private HashMap<String, Integer> attainmentInfo = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    
    
    
    public StudentRegister() {
        studentMap = new TreeMap<>(); 
        courseMap = new TreeMap<>();
                
        // Nämä ehkä pois.         
        students = new ArrayList<>();
        courses = new ArrayList<>();
        attainments = new ArrayList<>();
    }
    
    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        
        for (String key : studentMap.keySet()) {
            Student x = studentMap.get(key);
            studentList.add(x);
        }
        
        return studentList;
    }
    
    public ArrayList<Course> getCourses() {
        ArrayList<Course> courseList = new ArrayList<>();
        
        for (String key : courseMap.keySet()) {
            Course x = courseMap.get(key);
            courseList.add(x);
        }
        
        return courseList;
    }
    
    public void addStudent(Student student) {
        String name = student.getName();
        studentMap.put(name, student);
        students.add(student);
    }
    
    public void addCourse(Course course) {
        String code = course.getCode();
        String name = course.getName();
        
        courseMap.put(name, course);
        
        courses.add(course);
        courseInfo.put(code, name);
    }
    
    public void addAttainment(Attainment att) {
        attainments.add(att);
        String num = att.getStudentNumber();
        int grade = att.getGrade();
        attainmentInfo.put(num, grade);
    }
    
    private void printByCode(ArrayList<String> codes, Integer studentNum) {
        
        Collections.sort(codes, (a,b) -> a.compareToIgnoreCase(b));
        
        for (String code : codes) {
            String name = "";
            int grade = 0;
            
            if (courseInfo.containsKey(code)) {
                name = courseInfo.get(code);
            }
            
            for (Attainment att : attainments) {
                int num = Integer.parseInt(att.getStudentNumber());
                String courseCode = att.getCourseCode();
                
                if ((num == studentNum)&&(courseCode == code)) {
                    grade = att.getGrade();
                }
            }
            
            System.out.format("  %s %s: %d", code, name, grade);
            System.out.println();
        }
    }
    
    private void printByName(ArrayList<String> codes, Integer studentNum) {
        
        ArrayList<String> names = new ArrayList<>();
        
        for (String code : codes) {
            
            if (courseInfo.containsKey(code)) {
                String name = courseInfo.get(code);
                names.add(name);
            }
        }
        
        Collections.sort(names, (a,b) -> a.compareToIgnoreCase(b));
        
        for (String name : names) {
            String code = "";
            int grade = 0; 
            
            for (Course x : courses) {
                if (name == x.getName()) {
                    code = x.getCode();
                    //System.out.println(code);
                }
            }
            
            grade = letsGetGrade(code, studentNum);

            System.out.format("  %s %s: %d", code, name, grade);
            System.out.println();
        }
    }
    
    private int letsGetGrade(String code, Integer num) {
        int grade = 0;
        for (Attainment att : attainments) {
            int number = Integer.parseInt(att.getStudentNumber());
            String courseCode = att.getCourseCode();
                
             
            if ((courseCode.equals(code))&&(number == num)){
                grade = att.getGrade();
            }
        }
        return grade;
    }
    
    private void printWithoutOrder(ArrayList<String> codes, Integer studentNum) {
        
        for (String code : codes) {
            String name = "";
            int grade = 0;
            
            if (courseInfo.containsKey(code)) {
                name = courseInfo.get(code);
            }
            
            for (Attainment att : attainments) {
                int num = Integer.parseInt(att.getStudentNumber());
                String courseCode = att.getCourseCode();
                
                if ((num == studentNum)&&(courseCode == code)) {
                    grade = att.getGrade();
                }
            }
            
            System.out.format("  %s %s: %d", code, name, grade);
            System.out.println();
        }
    }
    
    public void printStudentAttainments(String studentNumber, String order) {
        boolean inRecord = false;
        
        
        
        for (Student a : students) {
            
            if (studentNumber == a.getStudentNumber()) {
                System.out.format("%s (%s):", a.getName(), a.getStudentNumber());
                System.out.println();
                inRecord = true;
                break;
            }
        }
        ArrayList<String> codes = new ArrayList<>();
        
        if (inRecord == false) {
            System.out.println("Unknown student number: " + studentNumber);
        } else {
            int studentNum = Integer.parseInt(studentNumber);
            
            for (Attainment z : attainments) {
                int num = Integer.parseInt(z.getStudentNumber());

                if (studentNum == num) {
                    codes.add(z.getCourseCode());
                    
                }
            }
            
            if (order == "by code") {
                printByCode(codes, studentNum);
            } else if (order == "by name") {
                printByName(codes, studentNum);
            } else {
                printWithoutOrder(codes, studentNum);
            }
            
        }
    }
    
    public void printStudentAttainments(String studentNumber) {
        boolean inRecord = false;
        for (Student a : students) {
            if (studentNumber == a.getStudentNumber()) {
                System.out.format("%s (%s):", a.getName(), a.getStudentNumber());
                System.out.println();
                inRecord = true;
                break;
            }
        }
        
        ArrayList<String> codes = new ArrayList<>();
        
        if (inRecord == false) {
            System.out.println("Unknown student number: " + studentNumber);
        } else {
            int studentNum = Integer.parseInt(studentNumber);
            
            for (Attainment att : attainments) {
                int num = Integer.parseInt(att.getStudentNumber());
                
                if (studentNum == num) {
                    codes.add(att.getCourseCode());
                }
            }
            
            printWithoutOrder(codes, studentNum);
        }
    }
    
}
