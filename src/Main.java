package src;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Arrays;

public class Main {

    // Define counter indices for different operations
    private static final int SEARCH_OPERATIONS = 0;
    private static final int INSERT_OPERATIONS = 1;
    private static final int DELETE_OPERATIONS = 2;

    // Define 
    private static final int SIZES = 11;
    private static final int CALCULATIONS = 8;


    // Store result for each dataStructure
    double[][] DList_Results = new double[SIZES][CALCULATIONS];
    double[][] DListPool_Results = new double[SIZES][CALCULATIONS];
    double[][] AList_Results = new double[SIZES][CALCULATIONS];
    double[][] AListPool_Results = new double[SIZES][CALCULATIONS];
    

    
    public static void main(String[] args) {

        PrepareLists prepareLists = new PrepareLists();

        prepareLists.AddData();
        
        int[] sizesTest = {30, 50, 100, 200, 500, 1000, 5000, 10000, 50000, 100000};

        for (int size : sizesTest) {
            
            String sizeName = String.valueOf(size);
            DList dlist = prepareLists.getDList("dlist_" + sizeName);
            AList alist = prepareLists.getAList("alist_" + sizeName);
            AListPool alistPool = prepareLists.getAListPool("alistPool_" + sizeName);
            DListPool dlistPool = prepareLists.getDListPool("dlistPool_" + sizeName);

            int k;

            if (size < 201) {
                k = 10;
            } else if (size < 1001) {
                k = 50;
            } else {
                k = 100;
            }

            MultiCounter dlistCounter = new MultiCounter();









        }




    }

    public static void runExperiment(int size, List dataStructure, int k, MultiCounter counter){

        counter.resetAllCounters();
        long totalSearchTime = 0;

        // Taking data for: Search
        int[] randomNumberSearch = produceRandomNumbers(size, k);
        counter.resetCounter(SEARCH_OPERATIONS);
        
        
        for (int number : randomNumberSearch) {
            long startTimeSearch = System.nanoTime();
            dataStructure.search(number);
            long endTimeSearch = System.nanoTime();

            totalSearchTime = totalSearchTime + (endTimeSearch - startTimeSearch);
        }

        double averageSearchTime = (double) totalSearchTime / k;
        double averageSearchCount = (double) counter.getCount(SEARCH_OPERATIONS) / k;

        
        
        // Taking data for: Insertion 1
        long totalInsertion1Time = 0;
        int[] randomNumbersInsertion1 = produceRandomNumbers(size, k);
        counter.resetCounter(INSERT_OPERATIONS);

        for (int number : randomNumbersInsertion1) {
            long startTimeInsertion1 = System.nanoTime();
            dataStructure.insert(k, String.valueOf(number));
            long endTimeInsertion1 = System.nanoTime();
            
            totalInsertion1Time = totalInsertion1Time + (endTimeInsertion1 - startTimeInsertion1);
        }

        double averageInsertion1Time = (double) totalInsertion1Time / k;
        double averageInsertion1Count = (double) counter.getCount(INSERT_OPERATIONS) / k;



        // Taking data for: Deletion
        long totalDeletionTime = 0;
        counter.resetCounter(DELETE_OPERATIONS);
        int[] existingKeys = getExistingKeys(dataStructure, k);

        for (int key : existingKeys) {
            
            long startDeletionTime = System.nanoTime();
            dataStructure.delete(key);
            long endDeletionTime = System.nanoTime();

            totalDeletionTime = totalDeletionTime + (endDeletionTime - startDeletionTime);
        
        }

        double averageDeletionTime = totalDeletionTime / k;
        double averageDeletionCount = counter.getCount(DELETE_OPERATIONS) / k;

        // Taking data for: Insert2
        long totalInsertion2Time = 0;
        int[] randomNumbersInsertion2 = produceRandomNumbers(size, k);
        counter.resetCounter(INSERT_OPERATIONS);

        for (int number : randomNumbersInsertion1) {
            long startTimeInsertion2 = System.nanoTime();
            dataStructure.insert(k, String.valueOf(number));
            long endTimeInsertion2 = System.nanoTime();
            
            totalInsertion2Time = totalInsertion2Time + (endTimeInsertion2 - startTimeInsertion2);
        }

        double averageInsertion2Time = (double) totalInsertion2Time / k;
        double averageInsertion2Count = (double) counter.getCount(INSERT_OPERATIONS) / k; 
        




    }


    // Method to produce random numbers between 1 and 2**N
    /**
     * @param size : number of data in the given file. Used to determine which numbers to generate.
     * @param k : number that indicates how many numbers to generate.
     * @return  : return a list of random numbers from 0-2^n. K numbers generated 
     */
    public static int[] produceRandomNumbers(int size, int k){
        
        Random randomGenerator = new Random();
        int[] randomInts = randomGenerator.ints(0, (int) Math.pow(2, size)).limit(k).toArray();    ///To fix the space, need to add 1, error when adding +1
        
        return randomInts;

    }

    /**
     * Generates k-random keyes that exist in the give DataStructure
     * @param dataStructure : dataStructure from which we retrieve the keys as an ArrayList<Integer>
     * @param k : Number of random keys we want to produce
     * @return : returns a list of k-ints randomly picked
     */
    public static int[] getExistingKeys(List dataStructure, int k) {
        // Get all existing keys from the dataStructure
        int[] allKeys = dataStructure.getAllKeys().stream().mapToInt(Integer::intValue).toArray(); // Convert ArrayList<Integer> to int[]
    
        // Shuffle the keys and select the first k keys
        Random random = new Random();
        for (int i = allKeys.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = allKeys[i];
            allKeys[i] = allKeys[j];
            allKeys[j] = temp;
        }
    
        // Return the first k keys
        return Arrays.copyOfRange(allKeys, 0, k);
    }

}
