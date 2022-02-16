/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *

 */
public abstract class Node {
  public boolean isValue() {
    return this instanceof ValueNode;
  }

  public boolean isArray() {
    return this instanceof ArrayNode;
  }

  public boolean isObject() {
    return this instanceof ObjectNode;
  }
  
  public void printSimple() {
    StringBuilder sb = new StringBuilder();
    printSimple(this, sb);
    System.out.print(sb.toString());
  }

  private static final String NL = System.lineSeparator();

  private static String numberToString(Double d) {
    String str = Double.toString(d);
    if(str.endsWith(".0")) {
      str = str.substring(0, str.length() - 2);
    }
    return str;
  }
  
  private void printValueNode(ValueNode value) {
            
            if (value.isNumber()) {
                System.out.println(numberToString(value.getNumber()));
            } else if (value.isBoolean()) {
                System.out.println(Boolean.toString(value.getBoolean()));
            } else if (value.isString()) {
                System.out.println("\""+value.getString()+"\"");
            }
  }
  
  public void printJson() {
    System.out.println("{");
    ObjectNode x = (ObjectNode) this;
    
    for (String key_1 : x) {
        Node node_x = x.get(key_1);
        
        if (node_x.isObject()) {
            System.out.println("  \""+key_1+"\": {");
            
            ObjectNode objNode = (ObjectNode) node_x;
            
            for (String key_3 : objNode) {
                System.out.print("    \""+key_3+"\": ");
                ValueNode value_2 = (ValueNode) objNode.get(key_3);
                printValueNode(value_2);
            }
            System.out.println("  },");
        } 
        
        else if (node_x.isArray()) {
            System.out.println("  \""+key_1+"\": [");
            ArrayNode array = (ArrayNode) node_x;
            
            for (Node aNode : array) {
                
                ObjectNode value = (ObjectNode) aNode;
                
                for (String key_2 : value) {
                    System.out.println("    {");
                    System.out.print("      \""+key_2+"\": ");
                    
                    ValueNode value_1 = (ValueNode) value.get(key_2);
                    printValueNode(value_1);
                    System.out.println("    },");
                } 
            }
            System.out.println("  ],");
        } 
        
        else if (node_x.isValue()) {
            System.out.print("  \""+key_1+"\": ");
            ValueNode value = (ValueNode) node_x;
            
            printValueNode(value);
            
        }
    }
    
    
    
    
    System.out.println("}");
  }

  private void printSimple(Node node, StringBuilder sb) {
    if(node.isObject()) {
      sb.append("ObjectNode").append(NL);
      ObjectNode objNode = (ObjectNode) node;
      for(String name : objNode) {
        sb.append(name).append(": ");
        printSimple(objNode.get(name), sb);
      }
    }
    else if(node.isArray()) {
      sb.append("ArrayNode").append(NL);
      ArrayNode arrNode = (ArrayNode) node;
      for(Node aNode : arrNode) {
        printSimple(aNode, sb);
      }
    }
    else if(node.isValue()) {
      ValueNode valNode = (ValueNode) node;
      String typeStr = "NullValue";
      String valStr = "null";
      if(valNode.isNumber()) {
        typeStr = "NumberValue";
        valStr = numberToString(valNode.getNumber());
      }
      else if(valNode.isBoolean()) {
        typeStr = "BooleanValue";
        valStr = Boolean.toString(valNode.getBoolean());
      }
      else if(valNode.isString()) {
        typeStr = "StringValue";
        valStr = "\"" + valNode.getString() + "\"";
      }
      sb.append(String.format("%s(%s)%n", typeStr, valStr));
    }
  }
}
