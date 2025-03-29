package src;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

public class globalMethods {

    public static final int STRING_LENGTH = 50;


    
    
    /**
     * 
     * @param inputFile : file to read
     * @param dataStructure : Data Structure in which the insert method is going to be called to store key and value
     * 
     */
    
    public static void readFile(String file, List dataStructure) {
        

        int TUPLE_SIZE = 54;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
           while (dis.available() >= TUPLE_SIZE) { 
               int number = dis.readInt(); 
               
                                          
               byte[] stringBytes = new byte[STRING_LENGTH];
               dis.readFully(stringBytes);
               String text = new String(stringBytes, StandardCharsets.UTF_8).trim();
        
               dataStructure.insert(number, text);
              
           }
        } catch (IOException e) {
            System.out.println("\nError: readFile has failed\n");
           e.printStackTrace();
        }
        
    }




    public static int[] generateNumbers(int size, int k){
        java.util.Random randomGenerator = new java.util.Random();

        int maxIntNumber = 2*size;
        
        int[] randomInts = randomGenerator.ints(0, maxIntNumber + 1).limit(k).distinct().toArray();
    

        return randomInts;

    }

}


