package src;

public class Node {
    
    private Element element;
    private Node next;


    
    protected Node(Element element){
        this.element = element;
        this.next = null;

    }

    protected Element getElement(){
        return element;
    }


    protected Node getNext(){
        return next;
    }

    protected void setNext(Node next){
        this.next = next;
    }

}
