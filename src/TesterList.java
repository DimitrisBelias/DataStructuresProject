package src;

public class TesterList {
    public static void main(String[] args){
        
        AList list = new AList(10);


        list.insert(6, "f");
        list.insert(7, "g");
        list.insert(10, "h");
        list.insert(9, "i");
        list.insert(1, "a");
        list.insert(2, "b");
        list.insert(3, "c");
        list.insert(10, "d");
        list.insert(5, "e");
        list.insert(10, "sdf");

       
        // insertion works //

        Element searching = list.search(0);
   

        // searching works //

        list.delete(2);
        list.delete(10);


        System.out.println("End");



    }
}
