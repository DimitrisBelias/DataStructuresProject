package src;

public class LinkedListPool implements ObjectPool<Element> {
    
    Node head;
    Node tail;
    int objectCount;
    private MultiCounter counter;

    protected LinkedListPool(){
        this.head = null;
        this.tail = null;
        this.objectCount = 0;
        this.counter = null;
    }
    
    public void setCounter(MultiCounter counter) {
        this.counter = counter;
    }

    @Override
    public void addObject(Element element){         /// Updating index 2 (delete) 
        
        Node node = new Node(element);
        counter.increaseCounter(2);

  
        if(head == null){
            counter.increaseCounter(2);

            head = node;
            tail = node;
            counter.increaseCounter(2,2);

        }
        else{
 
            tail.setNext(node);
            tail = node;
            counter.increaseCounter(2);
    
        }
    }

    @Override
    public boolean hasFreeObject(){

        return head!=null;
    }

    @Override
    public Element getObject(){    /// Updating index 1 (insertion)
        Node returnNode = head;
        counter.increaseCounter(1);

        
        if(hasFreeObject()){
            counter.increaseCounter(1);


          
            head = head.getNext();
            counter.increaseCounter(1);


            return returnNode.getElement();
        }
        else{
            
            return null;
        }
    }

    @Override
    public int length(){
        
        Node currentNode = head;
        int count = 0;
        

        while(currentNode != null) {

            count++;
            currentNode = currentNode.getNext();

        }
        
        return count;
    }    
}



