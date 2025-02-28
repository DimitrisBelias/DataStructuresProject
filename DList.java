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
            return null;
        
    }
}
