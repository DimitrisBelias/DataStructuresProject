package src;
/** 
 
Elements are the data (consisting of a key and value(string)) stored in the Data Structures.
@param key 
@param stringData

**/



public interface Element {
    
    /*
     * Returns the key of a Element Instance
     */
    public int getkey();


    /*
     * Returns the data of a Element Instance
     */
     public String getData();
}