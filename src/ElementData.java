package src;

public class ElementData implements Element {

    private int key;
    private String data;

    protected ElementData(int key, String data){
        this.key = key;
        this.data = data;
    }
    
    
    @Override
    public int getkey() {
        return key;
    }

    @Override
    public String getData() {
        return data;
    }
    
    
}
