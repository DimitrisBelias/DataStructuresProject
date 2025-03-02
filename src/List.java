package src;
/*
 * All Data Structures made in this project are implementing this interface.
 */

public interface List {
    
    /*
     * Responsible for inserting an Element into the list
     */
    public boolean insert(int key, String data);


    /*
     * Responsible for deleting an Element based on the key.
     */
    public boolean delete(int key);


    /*
     * Returns the first element found in the list matching the key.
     */
    public Element search(int key);

}
