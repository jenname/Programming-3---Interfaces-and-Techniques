import java.lang.Math.*;
import java.lang.Math;
import static java.lang.Math.PI;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public interface IShapeMetrics {

    double PI = Double.parseDouble(String.format("%.5f", Math.PI));
    
    String name();
    double area();
    double circumference();

}
