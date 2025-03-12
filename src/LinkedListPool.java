package src;

public class LinkedListPool implements ObjectPool<Element> {
    
    Node head;
    Node tail;
    int objectCount;

    protected LinkedListPool(){
        this.head = null;
        this.tail = null;
        this.objectCount = 0;
    }

    @Override
    public void addObject(Element element){ 
        
        
        Node node = new Node(element);
        
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
    }

    @Override
    public boolean hasFreeObject(){
        return head!=null;
    }

    @Override
    public Element getObject(){
        Node returnNode = head;
        if(hasFreeObject()){
            head = head.getNext();            
            return returnNode.getElement();
        }
        else{
            return null;
        }
    }

    @Override
    public int length(){
        
        Node currentNode=head;
        int count=0;

            while(currentNode != null) {
                count++;
                currentNode = currentNode.getNext();

            }
            return count;

    }    
    
}



