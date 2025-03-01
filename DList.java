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
        return true;
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
