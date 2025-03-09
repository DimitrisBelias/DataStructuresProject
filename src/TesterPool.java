package src;

public class TesterPool {
    public static void main(String[] args) {

        LinkedListPool pool = new LinkedListPool();
        DListPool dlistpool = new DListPool(pool);



        dlistpool.insert(1, "a");
        dlistpool.insert(2, "b");
        dlistpool.insert(3, "c");
        dlistpool.insert(4, "d");
        dlistpool.insert(5, "e");
        dlistpool.insert(6, "f");
        dlistpool.insert(7, "g");

        System.out.println(dlistpool.delete(3));
        System.out.println(dlistpool.delete(7));
        System.out.println(dlistpool.delete(1));
        System.out.println(dlistpool.delete(5));

  


        System.out.println("End");
    }
}
