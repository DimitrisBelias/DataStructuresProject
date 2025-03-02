package src;
public class Tester {
    public static void main(String[] args) {
        DList list = new DList();

        System.out.println(list.insert(5, "a!"));
        
        System.out.println(list.insert(10, "b!"));

        System.out.println(list.insert(15, "c!"));
        System.out.println(list);


        Node result;
        result = (Node) list.search(5);
        System.out.println(result);
        boolean value = list.delete(5);
        System.out.println( value );

    }
}
