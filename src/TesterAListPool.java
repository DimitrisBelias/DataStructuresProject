package src;

public class TesterAListPool {
    
    LinkedListPool pool = new LinkedListPool();
    AListPool list = new AListPool(10, pool);

    public static void main(String[] args) {
        TesterAListPool tester = new TesterAListPool();
        tester.list.insert(5, "a");
        tester.list.insert(4, "b");
        tester.list.insert(3, "c");
        tester.list.insert(2, "d");
        tester.list.insert(1, "e");
        // insertion works

        tester.list.delete(3);
        tester.list.delete(5);


        tester.list.insert(19, "ixx");
        tester.list.insert(20, "20000");
        tester.list.insert(21, "20001");
        tester.list.insert(20, "123123123");





        System.out.println("End");

    }

}
