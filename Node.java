public class Node implements Element {
    
    private int key;
    private String stringData;
    private Node next;


    
    public Node(int key, String stringData){
        this.key = key;
        this.stringData = stringData;
        this.next = null;

    }


    public int getkey(){
        return key;
    }

    public String getData(){
        return stringData;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}
