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
        pool.setCounter(counter);
        
    }

    @Override
    public MultiCounter getCounter(){
        return this.counter;
    }

    @Override
    public boolean insert(int key, String data){
        if(pool.hasFreeObject()){
            counter.increaseCounter(1);
    
            Node node = new Node(pool.getObject());
            counter.increaseCounter(1);
            
            if(head == null){
                counter.increaseCounter(1);

                head = node;
                tail = node;
                ElementCount++;
                counter.increaseCounter(1,2);

            }
            else{
              
                tail.setNext(node);
                tail = node;
                ElementCount++;
                counter.increaseCounter(1,2);

            }
        }
        else{
         
            Element element = new ElementData(key, data);
            Node node = new Node(element);
            
            if(head == null){
                counter.increaseCounter(1);

                head = node;
                tail = node;
                ElementCount++;
                counter.increaseCounter(1,2);

        
            }
            else{

                tail.setNext(node);
                tail = node;
                ElementCount++;
                counter.increaseCounter(1,2);

            
            }    
        }
        return true;    
    }

    @Override
    public boolean delete(int key){
        if(head == null) {
            counter.increaseCounter(2);
            return false;
        }
        
        if(head.getElement().getkey()==key){
            counter.increaseCounter(2);
  
            pool.addObject(head.getElement());
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            ElementCount--;

            counter.increaseCounter(2,2);
            
            return true;

        }else{

            Node currentNode = head;
            counter.increaseCounter(2);


            while(currentNode.getNext()!=null){
                counter.increaseCounter(2);



                if(currentNode.getNext().getElement().getkey() == key){
                    counter.increaseCounter(2);

                    pool.addObject(currentNode.getNext().getElement());
                    ElementCount--;
                    
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    
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
            System.out.println("Search Failed. Head == null");
            return null;
        }
        
        Node currentNode = head;
        counter.increaseCounter(0);

        while (currentNode != null) { 
            counter.increaseCounter(0);
 
            if (currentNode.getElement().getkey() == key) {
                
                counter.increaseCounter(0);

                System.out.println("Search Succeeded");
                return currentNode.getElement();
            }
            
        

            
            currentNode = currentNode.getNext();
            counter.increaseCounter(0);


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
