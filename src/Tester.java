package src;

public class Tester {
    public static void main(String[] args) {
        DList list = new DList();

        System.out.println(list.insert(5, "a!")); // checking insertion
        
        System.out.println(list.insert(10, "b!"));

        System.out.println(list.insert(15, "c!"));
        
        boolean isDeleted = list.delete(5);  /// Checking deletion
        System.out.println(isDeleted);




    }
}
