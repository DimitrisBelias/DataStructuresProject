package src;

import java.util.ArrayList;

public class DListPool implements List {


    private Node head, tail;
    private LinkedListPool pool;
    private MultiCounter counter;
    private int ElementCount;

    protected DListPool(LinkedListPool pool){
        this.head = null;
        this.tail = null;
        this.pool = pool;
        this.counter = null;
        this.ElementCount = 0;
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
    public MultiCounter getCounter(){
        return this.counter;
    }

    @Override
    public boolean insert(int key, String data){
        if(pool.hasFreeObject()){
    
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            Node node = new Node(pool.getObject());
            
           
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            if(head == null){
               
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                head = node;
                tail = node;
                ElementCount++;
                
                
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
            else{
              
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                tail.setNext(node);
                tail = node;
                ElementCount++;
                
                
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
        }
        else{
         
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            Element element = new ElementData(key, data);
            Node node = new Node(element);
            
       
            if (counter != null) {
                counter.increaseCounter(1, 2);
            }

            if(head == null){
         
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                head = node;
                tail = node;
                ElementCount++;
                
      
                if (counter != null) {
                    counter.increaseCounter(1, 2);
                }
            }
            else{

                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                tail.setNext(node);
                tail = node;
                ElementCount++;
                
    
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

            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            return false;
        }
        
        if(head.getElement().getkey()==key){
 
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            pool.addObject(head.getElement());
            
      
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            ElementCount--;

            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            return true;
        }else{

            if (counter != null) {
                counter.increaseCounter(2);
            }
           
            Node currentNode = head;
            
     
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            while(currentNode.getNext()!=null){

                if (counter != null) {
                    counter.increaseCounter(2);
                }

                if(currentNode.getNext().getElement().getkey() == key){
   
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    pool.addObject(currentNode.getNext().getElement());
                    ElementCount--;
                    
         
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    
           
                    if (counter != null) {
                        counter.increaseCounter(2);
                    }
                    
                    return true;
                }
                
         
                if (counter != null) {
                    counter.increaseCounter(2);
                }
                
                currentNode = currentNode.getNext();
                
   
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
      
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            System.out.println("Search Failed. Head == null");
            return null;
        }
        
        Node currentNode = head;
        

        if (counter != null) {
            counter.increaseCounter(0);
        }
        
        while (currentNode != null) { 
       
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            if (currentNode.getElement().getkey() == key) {
        
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                System.out.println("Search Succeeded");
                return currentNode.getElement();
            }
            
        
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            currentNode = currentNode.getNext();
            
     
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
