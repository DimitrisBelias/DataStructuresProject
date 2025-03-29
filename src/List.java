package src;
/*
 * All Data Structures made in this project are implementing this interface.
 */

import java.util.ArrayList;

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


    /*
     * Return existing keys
     */
    public ArrayList<Integer> getAllKeys();
    
    /*

     * Sets the counter for operation tracking
     */
    public void setCounter(MultiCounter counter);

    public MultiCounter getCounter();

}
