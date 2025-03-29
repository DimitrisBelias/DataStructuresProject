package src;

import java.util.ArrayList;

public class AListPool implements List {
    int tail, capacity;
    Element[] dataArray;
    private LinkedListPool pool;
    private MultiCounter counter;
    
    protected AListPool(int capacity, LinkedListPool pool){
        this.tail=0;
        this.capacity = capacity;
        this.pool = pool;
        this.dataArray = new ElementData[capacity];
        this.counter = null;
    }
    
    @Override
    public void setCounter(MultiCounter counter) {
        this.counter = counter;
        // Also set counter for the pool if available
        
            pool.setCounter(counter);
        
    }

    @Override
    public MultiCounter getCounter(){
        return this.counter;
    }
    
    @Override
    public boolean insert(int key, String data) {
        
        if(capacity == tail){

            
            System.out.println("Error: Array is full, can not add element in AListPool");
            return false;
        }
        else{

            
            Element element;
            if(!pool.hasFreeObject()){
  
                
                element = new ElementData(key, data);
                
   
            }
            else{

                
                element = pool.getObject();
                key = element.getkey();
                

            }    

            for (int i = 0; i < tail; i++) {
 
                
                if(dataArray[i].getkey() > key){

                    
                    for (int j = tail; j > i; j--) {

                        
                        dataArray[j] = dataArray[j-1];
                        

                    }
                    

                    dataArray[i] = element;
                    tail++;
                    

                    
                    return true;
                }
                

            }

            dataArray[tail] = element;
            tail++;
            

            
            return true;
        }
    }
    

    @Override
    public boolean delete(int key) {
        int result = BinarySearch(key);
        
        // Count binary search - Note: BinarySearch already counts operations

        if(result == -1){

            
            ///System.out.println("Target key is not in the AList");
            return false;
        }
        else{


            pool.addObject(dataArray[result]);
            

            
            for (int i = result; i < tail - 1; i++) {

                
                dataArray[i] = dataArray[i+1];
                

            }

            dataArray[tail - 1] = null;
            tail--;
            

            
            return true;
        }
    }
 

    @Override
    public Element search(int key) {
        int result = BinarySearch(key);
        
        // Count binary search - Note: BinarySearch already counts operations

        if(result == -1){

            
            //System.out.println("Target key is not in the AListPool");
            return null;
        }
        else{

            
            return dataArray[result];
        }
    }
    
    public int BinarySearch(int key){
        int high = tail - 1;
        int low = 0;
        


        while(low <= high){


            int mid = low + (high - low)/2;
            


            if(dataArray[mid].getkey()==key){

                
                return mid;
            }
            


            if(dataArray[mid].getkey() > key){

                
                high = mid - 1;
                

            }
            else{

                
                low = mid + 1;
                

            }
        }

        return -1;   // Reachable code only in case the target key is not in the list
    }

    @Override
    public ArrayList<Integer> getAllKeys() {
        
        ArrayList<Integer> keys = new ArrayList<>();
        
        if(dataArray != null){
            
            for (Element element : dataArray) {
                if (element != null) {
                    keys.add(element.getkey());
                }
            }
        }
        
        return keys;
    }

}
