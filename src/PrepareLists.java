package src;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrepareLists {

    ArrayList<String> dataNames = new ArrayList<>(Arrays.asList(
        "data_30.bin", "data_50.bin", "data_100.bin", "data_200.bin", "data_500.bin", "data_800.bin",
        "data_1000.bin", "data_5000.bin", "data_10000.bin", "data_50000.bin", "data_100000.bin"
    ));

    private HashMap<String, DList> dlists = new HashMap<>();
    private HashMap<String, AList> alists = new HashMap<>();
    private HashMap<String, AListPool> alistPools = new HashMap<>();
    private HashMap<String, DListPool> dlistPools = new HashMap<>();
    private HashMap<String, LinkedListPool> linkedListPoolsForAList = new HashMap<>();
    private HashMap<String, LinkedListPool> linkedListPoolsForDList = new HashMap<>();

    public void AddData() {
        for (String filename : dataNames) {
            // Extract the size from the filename (e.g., "30" from "data_30.bin")
            int size = Integer.parseInt(filename.split("_")[1].split("\\.")[0]);

            // Create instances for each structure
            DList currentDList = new DList();
            AList currentAList = new AList(size*2); 
            LinkedListPool currentLinkedListPoolForAList = new LinkedListPool();
            LinkedListPool currentLinkedListPoolForDList = new LinkedListPool();
            AListPool currentAListPool = new AListPool(size*2, currentLinkedListPoolForAList);
            DListPool currentDListPool = new DListPool(currentLinkedListPoolForDList);


            // Generate names for each structure
            String baseName = String.valueOf(size);
            String dlistName = "dlist_" + baseName;
            String alistName = "alist_" + baseName;
            String alistPoolName = "alistPool_" + baseName;
            String dlistPoolName = "dlistPool_" + baseName;
            String linkedListPoolForAListName = "linkedListPoolForAList_" + baseName;
            String linkedListPoolForDListName = "linkedListPoolForDList_" + baseName;
            

            // Store structures in their respective HashMaps
            dlists.put(dlistName, currentDList);
            alists.put(alistName, currentAList);
            alistPools.put(alistPoolName, currentAListPool);
            dlistPools.put(dlistPoolName, currentDListPool);
            linkedListPoolsForAList.put(linkedListPoolForAListName, currentLinkedListPoolForAList);
            linkedListPoolsForDList.put(linkedListPoolForDListName, currentLinkedListPoolForDList);

            // Read data from the file and populate all structures
            String inputFile = "dataFiles/number_files/" + filename;
            int TUPLE_SIZE = 54;

           try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {
                while (dis.available() >= TUPLE_SIZE) {
                    int number = dis.readInt(); // Read the integer (4 bytes)
                    byte[] stringBytes = new byte[50];
                    dis.readFully(stringBytes); // Read the 50-byte string
                    String text = new String(stringBytes, StandardCharsets.UTF_8).trim();

                    // Insert data into each structure
                    currentDList.insert(number, text);
                    currentAList.insert(number, text);
                    currentAListPool.insert(number, text);
                    currentDListPool.insert(number, text);

                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + filename);
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, DList> getDlists() {
        return dlists;
    }



    public HashMap<String, AList> getAlists() {
        return alists;
    }



    public HashMap<String, AListPool> getAlistPools() {
        return alistPools;
    }



    public HashMap<String, DListPool> getDlistPools() {
        return dlistPools;
    }



    public DList getDList(String name) {
        return dlists.get(name);
    }



    public AList getAList(String name) {
        return alists.get(name);
    }



    public AListPool getAListPool(String name) {
        return alistPools.get(name);
    }



    public DListPool getDListPool(String name) {
        return dlistPools.get(name);
    }



    public LinkedListPool getLinkedListPoolForAList(String name) {
        return linkedListPoolsForAList.get(name);
    }



    public LinkedListPool getLinkedListPoolForDList(String name) {
        return linkedListPoolsForDList.get(name);
    }
}
