package src;

public class DListPool extends DList {
    private Node head, tail;
    private LinkedListPool pool;

    protected DListPool(LinkedListPool pool){
        this.head = null;
        this.tail = null;
        this.pool = pool;
    }

    @Override
    public boolean insert(int key, String data){

        if(pool.hasFreeObject()){
            Node node = new Node(pool.getObject());
            
            if(head == null){
                head = node;
                tail = node;
            }
            else{
                tail.setNext(node);
                tail = node;
            }
        }
        else{
            ElementData element = new ElementData(key, data);
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
        return true;    
    }

    @Override
    public boolean delete(int key){

        if(head.getElement().getkey()==key){
            pool.addObject(head.getElement());
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            return true;

        }else{
           
            Node currentNode = head;
            while(currentNode.getNext()!=null){

                if(currentNode.getNext().getElement().getkey() == key){
                    pool.addObject(currentNode.getNext().getElement());
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    return true;
                }
                currentNode = currentNode.getNext();

            }
        }

        return false;
        
    }


}
