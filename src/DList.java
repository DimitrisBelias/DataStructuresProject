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

    @Override
    public MultiCounter getCounter(){
        return this.counter;
    }

    @Override
    public boolean insert(int key, String data) {
        
        ElementData element = new ElementData(key, data);
        Node node = new Node(element);

        counter.increaseCounter(1, 2);

        if (head == null) {
            counter.increaseCounter(1);
            
            head = node;
            tail = node;
            elementCount++;
            
            counter.increaseCounter(1, 3);
        }
        else {

            
            tail.setNext(node);
            tail = node;
            elementCount++;

            counter.increaseCounter(1, 3);

        }
        return true;
    }

    
    
    @Override
    public boolean delete(int key) {


        if (head == null) {
            counter.increaseCounter(2);
            return false;
        }
        
        if (head.getElement().getkey() == key) {
            counter.increaseCounter(2);

            
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            elementCount--;

            counter.increaseCounter(2,2);

            return true;
        } else {

           
            Node currentNode = head;
            
            counter.increaseCounter(2);

            
            while (currentNode.getNext() != null) {
                counter.increaseCounter(2);


                if (currentNode.getNext().getElement().getkey() == key) {
                    counter.increaseCounter(2);

                    
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    elementCount--;
                    // Count assignment operation
                    counter.increaseCounter(2,2);

                    
                    return true;
                }
                
                currentNode = currentNode.getNext();
                counter.increaseCounter(2);


            }
        }

        return false;
    }
    



    
    @Override
    public Element search(int key) {
        if (head == null) {
            
            counter.increaseCounter(0);
            return null;
            
        }
        

        
        Node currentNode = head;
        counter.increaseCounter(0);


        
        while (currentNode != null) {  // Changed condition to be more straightforward
            counter.increaseCounter(0);

            
            if (currentNode.getElement().getkey() == key) {
                
                counter.increaseCounter(0);
                return currentNode.getElement();
            }
            

            counter.increaseCounter(0);
            currentNode = currentNode.getNext();
            

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
