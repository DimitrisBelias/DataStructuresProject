package src;
/*\
 * 
 */

import java.util.ArrayList;

public class DList implements List {

    private Node head;
    private Node tail;
    private MultiCounter counter;
    private int elementCount;

    public DList() {
        this.head = null;
        this.tail = null;
        this.counter = null;
        this.elementCount=0;
    }
    
    public void setCounter(MultiCounter counter) {
        this.counter = counter;
    }

    public boolean insert(int key, String data) {
        
        ElementData element = new ElementData(key, data);
        Node node = new Node(element);

        // Count operations if counter is set
        if (counter != null) {
            counter.increaseCounter(1); // Count element creation as an operation
        }

        if (head == null) {
            head = node;
            tail = node;
            elementCount++;
            
            if (counter != null) {
                counter.increaseCounter(1); // Count assignment operation
            }
        }
        else {
            // Count comparison operation
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            tail.setNext(node);
            tail = node;
            elementCount++;

            
            // Count assignment operations
            if (counter != null) {
                counter.increaseCounter(1, 2); // 2 assignments
            }
        }
        return true;
    }

    public boolean delete(int key) {
        if (counter != null) {
            counter.increaseCounter(2); // Initial comparison operation
        }

        if (head == null) {
            return false;
        }
        
        if (head.getElement().getkey() == key) {
            // Count comparison operation
            if (counter != null) {
                counter.increaseCounter(2); // Key comparison + null check
            }
            
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            elementCount--;
            // Count assignment operation
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            return true;
        } else {
            // Count comparison operation
            if (counter != null) {
                counter.increaseCounter(2);
            }
           
            Node currentNode = head;
            
            // Count assignment operation
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            while (currentNode.getNext() != null) {
                // Count comparison operation
                if (counter != null) {
                    counter.increaseCounter(2); // null check + loop iteration
                }

                if (currentNode.getNext().getElement().getkey() == key) {
                    // Count comparison operation
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    elementCount--;
                    // Count assignment operation
                    if (counter != null) {
                        counter.increaseCounter(1);
                    }
                    
                    return true;
                }
                
                currentNode = currentNode.getNext();
                
                // Count assignment operation
                if (counter != null) {
                    counter.increaseCounter(1);
                }
            }
        }

        return false;
    }
    
    public Element search(int key) {
        if (head == null) {
            return null;
        }
        
        // Count comparison operation
        if (counter != null) {
            counter.increaseCounter(0);
        }
        
        Node currentNode = head;
        
        // Count assignment operation
        if (counter != null) {
            counter.increaseCounter(0);
        }
        
        while (currentNode != null) {  // Changed condition to be more straightforward
            // Count comparison operation for loop condition
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            if (currentNode.getElement().getkey() == key) {
                // Count comparison operation
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                return currentNode.getElement();
            }
            
            // Count comparison operation
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            currentNode = currentNode.getNext();
            
            // Count assignment operation
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
