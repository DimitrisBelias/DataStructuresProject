package src;

import java.util.ArrayList;

public class AList implements List{
    int tail, capacity;
    Element[] dataArray;
    private MultiCounter counter;

    protected AList(int capacity){
        this.tail=0;
        this.capacity = capacity;
        this.dataArray = new ElementData[capacity];
        this.counter = null;
    }

    @Override
    public void setCounter(MultiCounter counter) {
        this.counter = counter;
    }

    @Override
    public MultiCounter getCounter(){
        return this.counter;
    }



    @Override
    public boolean insert(int key, String data) {
        
        if(capacity == tail){
            
            counter.increaseCounter(1);
            System.out.println("Error: Array is full, can not add element in AList");

            return false;
        }
        else{
            counter.increaseCounter(1);  
            
            Element element = new ElementData(key, data);
            counter.increaseCounter(1);

            for (int i = 0; i < tail; i++) {

                counter.increaseCounter(1);
                
                if(dataArray[i].getkey() > key){
                        
                    counter.increaseCounter(1);

                    for (int j = tail; j > i; j--) {

                        counter.increaseCounter(1);
                        
                        dataArray[j] = dataArray[j-1];
                        counter.increaseCounter(1);

                    }
                    
                    dataArray[i] = element;
                    tail++;
                    counter.increaseCounter(1, 2);

                    return true;
                }

            }

            dataArray[tail] = element;
            tail++;
            counter.increaseCounter(1, 2);
            
            return true;
        }
    }

    @Override
    public boolean delete(int key) {
        int result = BinarySearch(key);
        counter.increaseCounter(2);
        
        if(result == -1){
            counter.increaseCounter(2);
            System.out.println("Target key is not in the AList. Can not delete it");
            return false;
        }
        else{

            for (int i = result; i < tail - 1; i++) {
                counter.increaseCounter(2);
                dataArray[i] = dataArray[i+1];
                counter.increaseCounter(2);
            }

            dataArray[tail - 1] = null;
            tail--;

            counter.increaseCounter(2,2);

            return true;
        }
    }


    @Override
    public Element search(int key) {
        
        int result = BinarySearch(key);
        
    
        if(result == -1){

            
            System.out.println("Binary Search Failed");
            return null;
        }
        else{

            System.out.println("Binary search succeeded");
            return dataArray[result];
        }
    }

    public int BinarySearch(int key){
        int high = tail - 1;
        int low = 0;
        
        counter.increaseCounter(1, 2);

        while(low <= high){
            counter.increaseCounter(0);

            int mid = low + (high - low)/2;
            counter.increaseCounter(0);         
    

            if(dataArray[mid].getkey()==key){
 
                counter.increaseCounter(0);        
                return mid;

            }
            


            if(dataArray[mid].getkey() > key){
                counter.increaseCounter(0);
                
                high = mid - 1;
                counter.increaseCounter(0);
                

            }
            else{

                low = mid + 1;
                counter.increaseCounter(0);
                

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
