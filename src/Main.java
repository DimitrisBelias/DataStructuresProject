package src;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // Define counter indices for different operations
    private static final int SEARCH_OPERATIONS = 0;
    private static final int INSERT_OPERATIONS = 1;
    private static final int DELETE_OPERATIONS = 2;


    
    public static void main(String[] args) {

        PrepareLists prepareLists = new PrepareLists();

        prepareLists.AddData();

            
        int[] sizesTest = {30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 50000, 100000};

        TestDataCollector CollectorDList = new TestDataCollector(
            Arrays.asList(
                    "N",
                        "Α μ.ο πράξεων ανά αναζήτηση",
                        "Β μ.ο πράξεων ανά εισαγωγή",
                        "C μ.ο πράξεων ανά διαγραφή",
                        "D μ.ο πράξεων ανά εισαγωγή 2",
                        "A μ.ο χρόνου ανά αναζήτηση",
                        "B μ.ο χρόνου ανά εισαγωγή 1",
                        "C μ.ο χρόνου ανά διαγραφή",
                        "D μ.ο χρόνου ανά εισαγωγή"

            )   
        );

        TestDataCollector CollectorAList = new TestDataCollector(
            Arrays.asList(
                    "N",
                        "Α μ.ο πράξεων ανά αναζήτηση",
                        "Β μ.ο πράξεων ανά εισαγωγή",
                        "C μ.ο πράξεων ανά διαγραφή",
                        "D μ.ο πράξεων ανά εισαγωγή 2",
                        "A μ.ο χρόνου ανά αναζήτηση",
                        "B μ.ο χρόνου ανά εισαγωγή 1",
                        "C μ.ο χρόνου ανά διαγραφή",
                        "D μ.ο χρόνου ανά εισαγωγή"

            )   
        );


        TestDataCollector CollectorDListPool = new TestDataCollector(
            Arrays.asList(
                    "N",
                        "Α μ.ο πράξεων ανά αναζήτηση",
                        "Β μ.ο πράξεων ανά εισαγωγή",
                        "C μ.ο πράξεων ανά διαγραφή",
                        "D μ.ο πράξεων ανά εισαγωγή 2",
                        "A μ.ο χρόνου ανά αναζήτηση",
                        "B μ.ο χρόνου ανά εισαγωγή 1",
                        "C μ.ο χρόνου ανά διαγραφή",
                        "D μ.ο χρόνου ανά εισαγωγή"

            )   
        );


        TestDataCollector CollectorAListPool = new TestDataCollector(
            Arrays.asList(
                    "N",
                        "Α μ.ο πράξεων ανά αναζήτηση",
                        "Β μ.ο πράξεων ανά εισαγωγή",
                        "C μ.ο πράξεων ανά διαγραφή",
                        "D μ.ο πράξεων ανά εισαγωγή 2",
                        "A μ.ο χρόνου ανά αναζήτηση",
                        "B μ.ο χρόνου ανά εισαγωγή 1",
                        "C μ.ο χρόνου ανά διαγραφή",
                        "D μ.ο χρόνου ανά εισαγωγή"

            )   
        );


 



   

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

            MultiCounter dlistCounter = new MultiCounter(3);
            MultiCounter alistCounter = new MultiCounter(3);
            MultiCounter alistPoolCounter = new MultiCounter(3);
            MultiCounter dlistPoolCounter = new MultiCounter(3);

            dlist.setCounter(dlistCounter);
            alist.setCounter(alistCounter);
            alistPool.setCounter(alistPoolCounter);
            dlistPool.setCounter(dlistPoolCounter);

            runExperiment(size, dlist, k, dlistCounter, CollectorDList);
            runExperiment(size, dlistPool, k, dlistPoolCounter, CollectorDListPool);
            runExperiment(size, alist, k, alistCounter, CollectorAList);
            runExperiment(size, alistPool, k, alistPoolCounter, CollectorAListPool);
            


        }

        CollectorDList.toScreen();
        CollectorDList.toFile("DList_Metrics.csv");

        CollectorDListPool.toScreen();
        CollectorDListPool.toFile("DListPool_Metrics.csv");

        CollectorAList.toScreen();
        CollectorAList.toFile("AList_Metrics.csv");

        CollectorAListPool.toScreen();
        CollectorAListPool.toFile("AListPool_Metrics.csv");

        

        


    }

    public static void runExperiment(int size, List dataStructure, int k, MultiCounter counter, TestDataCollector collector){


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

        for (int number : randomNumbersInsertion2) {
            long startTimeInsertion2 = System.nanoTime();
            dataStructure.insert(k, String.valueOf(number));
            long endTimeInsertion2 = System.nanoTime();
            
            totalInsertion2Time = totalInsertion2Time + (endTimeInsertion2 - startTimeInsertion2);
        }

        double averageInsertion2Time = (double) totalInsertion2Time / k;
        double averageInsertion2Count = (double) counter.getCount(INSERT_OPERATIONS) / k; 

        ArrayList<Object> resultDataRow = new ArrayList<>();

        resultDataRow.addAll(
            Arrays.asList(
                    size,
                    
                    averageSearchCount,
                    averageInsertion1Count,
                    averageDeletionCount,
                    averageInsertion2Count,
                    
                    averageSearchTime,
                    averageInsertion1Time,
                    averageDeletionTime,
                    averageInsertion2Time
                
            )
        );
        collector.addRow(resultDataRow);
        

        




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
