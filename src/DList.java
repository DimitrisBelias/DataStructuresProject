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
        

        Node node = new Node(key, data);


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

        if( head.getkey()==key ){
            
            head = head.getNext();
            return true;

        }else{
           
            Node currentNode = head;
            while(currentNode.getNext()!=null){

                if(currentNode.getNext().getkey() == key){
                    currentNode.setNext(currentNode.getNext().getNext());
                    return true;
                }

            }
        }

        return false;
        
    }

    
    
    public Element search(int key){
        
        Node currentNode = head;
        
        while(currentNode.getNext() != null){  // if getNext == null that means that currentNode is the tail
            
            if(currentNode.getkey() == key){
                return currentNode;
            }
            else{
                currentNode = currentNode.getNext();
                if(currentNode.getNext() == null){
                    if(currentNode.getkey() == key){
                        return currentNode; 
                    }
                }
            }
            
        }
        return null;
              
    }
}
