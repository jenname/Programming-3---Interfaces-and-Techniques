import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class ObjectNode extends Node implements Iterable<String> {
    private TreeMap<String, Node> objects_;
    
    @Override
    public Iterator<String> iterator () {
        Set<String> keys = objects_.keySet();
        
        return keys.iterator();
    }
    
    public ObjectNode() {
        objects_ = new TreeMap<>();
    }
    
    public Node get(String key) {
        return objects_.get(key);
    }
    
    void set(String key, Node node) {
        if (objects_.containsKey(key)) {
            objects_.remove(key);
        }
        objects_.put(key, node);
    }
    
    public int size() {
        int size = objects_.size();
        return size;
    }

    
}
