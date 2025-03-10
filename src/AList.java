package src;

public class AList implements List{
    int tail, capacity;
    ElementData[] data;

    protected AList(int capacity){
        this.tail=0;
        this.capacity = capacity;
        this.data = null;
    }

    @Override
    public boolean insert(int key, String data) {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean delete(int key) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Element search(int key) {
        
        int result = BinarySearch(key);

        if(result == -1){
            System.out.println("Target key is not in the AList");
            return null;
        }
        else{
            return data[result];
        }
    }

    public int BinarySearch(int key){
        
        int high = tail - 1;
        int low = 0;

        int mid = low + (high - low)/2;

        while(low <= high){
            if(data[mid].getkey()==key){
                return mid;
            }

            if(data[mid].getkey() > key){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;   // Reachable code only in case the target key is not in the list
        
    }


}
