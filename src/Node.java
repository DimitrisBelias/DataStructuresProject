package src;

public class Node {
    
    private ElementData element;
    private Node next;


    
    protected Node(ElementData element){
        this.element = element;
        this.next = null;

    }

    protected ElementData getElement(){
        return element;
    }


    protected Node getNext(){
        return next;
    }

    protected void setNext(Node next){
        this.next = next;
    }

}
