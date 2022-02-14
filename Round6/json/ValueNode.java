/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class ValueNode extends Node {
    private Double value_1 = null;
    private Boolean value_2 = null;
    private String value_3 = "";
    
    public ValueNode(double value) {
        value_1 = value;
    }
    
    public ValueNode(boolean value) {
        value_2 = value;
    }
    
    public ValueNode(String value) {
        value_3 = value;
    }

    public boolean isNumber() {
        if (value_1 == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isBoolean() {
        if (value_2 == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isString() {
        if ((value_3 == null) || (value_3 == "")) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isNull() {
        if (value_3 == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public double getNumber() {
        return value_1;
    }
    
    public boolean getBoolean() {
        return value_2;
    }
    
    public String getString() {
        return value_3;
    }
}
