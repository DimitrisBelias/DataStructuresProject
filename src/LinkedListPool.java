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
    public void addObject(Element element){ 
        
        Node node = new Node(element);
        
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

    @Override
    public boolean hasFreeObject(){
        // Count comparison
        if (counter != null) {
            counter.increaseCounter(1);
        }
        
        return head!=null;
    }

    @Override
    public Element getObject(){
        Node returnNode = head;
        
        // Count assignment
        if (counter != null) {
            counter.increaseCounter(1);
        }
        
        if(hasFreeObject()){
            // Count comparison via hasFreeObject method
            
            head = head.getNext();
            
            // Count assignment
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            return returnNode.getElement();
        }
        else{
            // Count failed comparison via hasFreeObject method
            
            return null;
        }
    }

    @Override
    public int length(){
        
        Node currentNode = head;
        int count = 0;
        
        // Count assignments
        if (counter != null) {
            counter.increaseCounter(1, 2);
        }

        while(currentNode != null) {
            // Count loop comparison
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            count++;
            currentNode = currentNode.getNext();
            
            // Count assignments
            if (counter != null) {
                counter.increaseCounter(1, 2);
            }
        }
        
        return count;
    }    
}



