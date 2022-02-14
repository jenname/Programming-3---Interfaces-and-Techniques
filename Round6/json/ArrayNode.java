import java.lang.Iterable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**KYSY TÄSTÄ SOS!!
 *
 * @author Jenna
 */
public class ArrayNode extends Node implements Iterable<Node> {
    private ArrayList<Node> list_;
    
    @Override
    public Iterator<Node> iterator() {
        return list_.iterator();
    }
    
    public ArrayNode() {
        list_ = new ArrayList<>();
    }
    
    public void add(Node node) {
        list_.add(node);
    }
    
    public int size() {
        int size = list_.size();
        return size;
    }
}
