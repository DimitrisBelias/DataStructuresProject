package src;

import java.util.ArrayList;

public class DListPool implements List {


    private Node head, tail;
    private LinkedListPool pool;
    private MultiCounter counter;

    protected DListPool(LinkedListPool pool){
        this.head = null;
        this.tail = null;
        this.pool = pool;
        this.counter = null;
    }
    
    @Override
    public void setCounter(MultiCounter counter) {
        this.counter = counter;
        // Also set counter for the pool if available
        if (pool != null) {
            pool.setCounter(counter);
        }
    }

    @Override
    public boolean insert(int key, String data){
        if(pool.hasFreeObject()){
            // Count comparison via hasFreeObject method
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            Node node = new Node(pool.getObject());
            
            // Count node creation
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            if(head == null){
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                head = node;
                tail = node;
                
                // Count assignments
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
            else{
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                tail.setNext(node);
                tail = node;
                
                // Count assignments
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
        }
        else{
            // Count comparison via hasFreeObject method
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            Element element = new ElementData(key, data);
            Node node = new Node(element);
            
            // Count element and node creation
            if (counter != null) {
                counter.increaseCounter(1, 2);
            }

            if(head == null){
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                head = node;
                tail = node;
                
                // Count assignments
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
            else{
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                tail.setNext(node);
                tail = node;
                
                // Count assignments
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }    
        }
        return true;    
    }

    @Override
    public boolean delete(int key){
        if(head == null) {
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            return false;
        }
        
        if(head.getElement().getkey()==key){
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            pool.addObject(head.getElement());
            
            // Count pool operation
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            
            // Count assignment
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            return true;
        }else{
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(2);
            }
           
            Node currentNode = head;
            
            // Count assignment
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            while(currentNode.getNext()!=null){
                // Count loop comparison
                if (counter != null) {
                    counter.increaseCounter(2);
                }

                if(currentNode.getNext().getElement().getkey() == key){
                    // Count key comparison
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    pool.addObject(currentNode.getNext().getElement());
                    
                    // Count pool operation
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    
                    // Count assignment
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    return true;
                }
                
                // Count failed comparison
                if (counter != null) {
                    counter.increaseCounter(2);
                }
                
                currentNode = currentNode.getNext();
                
                // Count assignment
                if (counter != null) {
                    counter.increaseCounter(2);
                }
            }
        }

        return false;
    }
    
    @Override
    public Element search(int key) {
        if (head == null) {
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            return null;
        }
        
        Node currentNode = head;
        
        // Count assignment
        if (counter != null) {
            counter.increaseCounter(0);
        }
        
        while (currentNode != null) {  // Changed condition to be more straightforward
            // Count loop comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            if (currentNode.getElement().getkey() == key) {
                // Count key comparison
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                return currentNode.getElement();
            }
            
            // Count failed comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            currentNode = currentNode.getNext();
            
            // Count assignment
            if (counter != null) {
                counter.increaseCounter(0);
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<Integer> getAllKeys(){

        ArrayList<Integer> keys = new ArrayList<>();
        
        Node currentNode = head;

        while(currentNode != null){
            keys.add(currentNode.getElement().getkey());
            currentNode = currentNode.getNext();
        }

        return keys;
    }
}
