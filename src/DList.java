package src;
/*\
 * 
 */

public class DList implements List {

    private Node head;
    private Node tail;

    public DList(){
        this.head = null;
        this.tail = null;
    }

    public boolean insert(int key, String data){
        
        Element element = new ElementData(key, data);
        Node node = new Node(element);


        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        return true;
    }


    
    public boolean delete(int key){

        if(head.getElement().getkey()==key){
            
            head = head.getNext();   // Garbage Collector will delete the head since there is no reference
            return true;

        }else{
           
            Node currentNode = head;
            while(currentNode.getNext()!=null){

                if(currentNode.getNext().getElement().getkey() == key){
                    currentNode.setNext(currentNode.getNext().getNext());  // Since there is no previous node variable we use getNext().getNext()
                    return true;
                }

            }
        }

        return false;
        
    }

    
    
    public Element search(int key){
        
        Node currentNode = head;
        
        while(currentNode.getNext() != null){  // if getNext == null that means that currentNode is the tail
            
            if(currentNode.getElement().getkey() == key){
                return currentNode.getElement();
            }
            else{
                currentNode = currentNode.getNext();
                if(currentNode.getNext() == null){
                    if(currentNode.getElement().getkey() == key){
                        return currentNode.getElement(); 
                    }
                }
            }
            
        }
        return null;
              
    }
}
