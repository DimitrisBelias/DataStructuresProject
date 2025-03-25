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
    public boolean insert(int key, String data) {
        
        if(capacity == tail){
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            System.out.println("Array is full, can not add element");
            return false;
        }
        else{
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(1);
            }
            
            Element element = new ElementData(key, data);
            
            // Count element creation
            if (counter != null) {
                counter.increaseCounter(1);
            }

            for (int i = 0; i < tail; i++) {
                // Count loop comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
                
                if(dataArray[i].getkey() > key){
                    // Count key comparison
                    if (counter != null) {
                        counter.increaseCounter(1);
                    }
                    
                    for (int j = tail; j > i; j--) {
                        // Count loop comparison
                        if (counter != null) {
                            counter.increaseCounter(1);
                        }
                        
                        dataArray[j] = dataArray[j-1];
                        
                        // Count assignment
                        if (counter != null) {
                            counter.increaseCounter(1);
                        }
                    }
                    
                    dataArray[i] = element;
                    tail++;
                    
                    // Count assignments
                    if (counter != null) {
                        counter.increaseCounter(1, 2);
                    }
                    
                    return true;
                }
                // Count failed comparison
                if (counter != null) {
                    counter.increaseCounter(1);
                }
            }

            dataArray[tail] = element;
            tail++;
            
            // Count assignments
            if (counter != null) {
                counter.increaseCounter(1, 2);
            }
            
            return true;
        }
    }

    @Override
    public boolean delete(int key) {
        int result = BinarySearch(key);
        
        // Count binary search - Note: BinarySearch already counts operations

        if(result == -1){
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            System.out.println("Target key is not in the AList");
            return false;
        }
        else{
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(2);
            }
            
            for (int i = result; i < tail - 1; i++) {
                // Count loop comparison
                if (counter != null) {
                    counter.increaseCounter(2);
                }
                
                dataArray[i] = dataArray[i+1];
                
                // Count assignment
                if (counter != null) {
                    counter.increaseCounter(2);
                }
            }

            dataArray[tail - 1] = null;
            tail--;
            
            // Count assignments
            if (counter != null) {
                counter.increaseCounter(2, 2);
            }
            
            return true;
        }
    }

    @Override
    public Element search(int key) {
        int result = BinarySearch(key);
        
        // Count binary search - Note: BinarySearch already counts operations

        if(result == -1){
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            System.out.println("Target key is not in the AList");
            return null;
        }
        else{
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }
            
            return dataArray[result];
        }
    }

    public int BinarySearch(int key){
        int high = tail - 1;
        int low = 0;
        
        // Count assignments
        if (counter != null) {
            counter.increaseCounter(0, 2);
        }

        while(low <= high){
            // Count comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }

            int mid = low + (high - low)/2;
            
            // Count calculation and assignment
            if (counter != null) {
                counter.increaseCounter(0);
            }

            if(dataArray[mid].getkey()==key){
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                return mid;
            }
            
            // Count failed comparison
            if (counter != null) {
                counter.increaseCounter(0);
            }

            if(dataArray[mid].getkey() > key){
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                high = mid - 1;
                
                // Count assignment
                if (counter != null) {
                    counter.increaseCounter(0);
                }
            }
            else{
                // Count comparison
                if (counter != null) {
                    counter.increaseCounter(0);
                }
                
                low = mid + 1;
                
                // Count assignment
                if (counter != null) {
                    counter.increaseCounter(0);
                }
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
