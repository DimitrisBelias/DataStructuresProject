package src;

public class Tester {
    public static void main(String[] args) {
        DList list = new DList();

        System.out.println(list.insert(5, "a!")); // checking insertion
        
        System.out.println(list.insert(10, "b!"));

        System.out.println(list.insert(15, "c!"));
        
        boolean isDeleted = list.delete(5);  /// Checking deletion
        System.out.println(isDeleted);
        
        ElementData element1 = new ElementData(20, "d");
        ElementData element2 = new ElementData(25, "e");
        ElementData element3 = new ElementData(30, "f");
        ElementData element4 = new ElementData(35, "g");


        LinkedListPool pool = new LinkedListPool();
        pool.addObject(element1);
        pool.addObject(element2);
        pool.addObject(element3);
        pool.addObject(element4);

        //Element retrievedElement = pool.getObject();
        int length = pool.length();
        System.out.println(length);



        System.out.println(pool.hasFreeObject());
        


    }
}
