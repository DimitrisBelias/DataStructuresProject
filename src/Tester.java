package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tester {
    
    public static final int DELETE_OPERATION = 2;
    public static final int INSERT1_OPERATION = 1;
    public static final int SEARCH_OPERATION = 0;



    public static void main(String[] args) {
        
        int[] sizes = {30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 50000, 100000};

        //Expiraments for ALists----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Running Expirement for AList.....\n");
        TestDataCollector AListCollector = new TestDataCollector(
                Arrays.asList(
                        "Size",
                            "Α μ.ο πράξεων ανά αναζήτηση",
                            "Β μ.ο πράξεων ανά εισαγωγή 1",
                            "C μ.ο πράξεων ανά διαγραφή",
                            "D μ.ο πράξεων ανά εισαγωγή 2",
                            "A μ.ο χρόνου ανά αναζήτηση",
                            "B μ.ο χρόνου ανά εισαγωγή 1",
                            "C μ.ο χρόνου ανά διαγραφή",
                            "D μ.ο χρόνου ανά εισαγωγή 2"

                    
                )
        );

        for (int size : sizes) {
            
            AList currentList = new AList(size+200);
            MultiCounter currentCounter = new MultiCounter(4);
            currentList.setCounter(currentCounter);

            populate_Structure(currentList, size);

            int k;
            if(size < 201){
                k = 10;
            }
            else if(size > 200 && size < 1001){
                k = 50;
            }
            else{
                k = 100;
            }

            runExpirament(size, currentList, k, AListCollector);

        }

        System.out.println("\n\n\n");
        AListCollector.toScreen();
        AListCollector.toFile("AList.csv");



        //Expiraments for DLists----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Running Expirement for DList.....\n");
        TestDataCollector DListCollector = new TestDataCollector(
                Arrays.asList(
                        "Size",
                            "Α μ.ο πράξεων ανά αναζήτηση",
                            "Β μ.ο πράξεων ανά εισαγωγή 1",
                            "C μ.ο πράξεων ανά διαγραφή",
                            "D μ.ο πράξεων ανά εισαγωγή 2",
                            "A μ.ο χρόνου ανά αναζήτηση",
                            "B μ.ο χρόνου ανά εισαγωγή 1",
                            "C μ.ο χρόνου ανά διαγραφή",
                            "D μ.ο χρόνου ανά εισαγωγή 2"

                    
                )
        );

        for (int size : sizes) {
            
            DList currentList = new DList();
            MultiCounter currentCounter = new MultiCounter(4);
            currentList.setCounter(currentCounter);

            populate_Structure(currentList, size);

            int k;
            if(size < 201){
                k = 10;
            }
            else if(size > 200 && size < 1001){
                k = 50;
            }
            else{
                k = 100;
            }

            runExpirament(size, currentList, k, DListCollector);

        }

        System.out.println("\n\n\n");
        DListCollector.toScreen();
        DListCollector.toFile("DList.csv");




        //Expiraments for DListsPool----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Running Expirement for DListPool.....\n");
        TestDataCollector DListPoolCollector = new TestDataCollector(
                Arrays.asList(
                        "Size",
                            "Α μ.ο πράξεων ανά αναζήτηση",
                            "Β μ.ο πράξεων ανά εισαγωγή 1",
                            "C μ.ο πράξεων ανά διαγραφή",
                            "D μ.ο πράξεων ανά εισαγωγή 2",
                            "A μ.ο χρόνου ανά αναζήτηση",
                            "B μ.ο χρόνου ανά εισαγωγή 1",
                            "C μ.ο χρόνου ανά διαγραφή",
                            "D μ.ο χρόνου ανά εισαγωγή 2"

                    
                )
        );

        for (int size : sizes) {

            LinkedListPool currentPool = new LinkedListPool();
            DListPool currentList = new DListPool(currentPool);
            MultiCounter currentCounter = new MultiCounter(4);
            currentList.setCounter(currentCounter);

            populate_Structure(currentList, size);

            int k;
            if(size < 201){
                k = 10;
            }
            else if(size > 200 && size < 1001){
                k = 50;
            }
            else{
                k = 100;
            }

            runExpirament(size, currentList, k, DListPoolCollector);

        }

        System.out.println("\n\n\n");
        DListCollector.toScreen();
        DListCollector.toFile("DListPool.csv");




        //Expiraments for ALists----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Running Expirement for AListPool.....\n");
        TestDataCollector AListPoolCollector = new TestDataCollector(
                Arrays.asList(
                        "Size",
                            "Α μ.ο πράξεων ανά αναζήτηση",
                            "Β μ.ο πράξεων ανά εισαγωγή 1",
                            "C μ.ο πράξεων ανά διαγραφή",
                            "D μ.ο πράξεων ανά εισαγωγή 2",
                            "A μ.ο χρόνου ανά αναζήτηση",
                            "B μ.ο χρόνου ανά εισαγωγή 1",
                            "C μ.ο χρόνου ανά διαγραφή",
                            "D μ.ο χρόνου ανά εισαγωγή 2"

                    
                )
        );

        for (int size : sizes) {
            
            LinkedListPool AListPool = new LinkedListPool();
            AListPool currentList = new AListPool(size+200, AListPool);
            MultiCounter currentCounter = new MultiCounter(4);
            currentList.setCounter(currentCounter);

            populate_Structure(currentList, size);

            int k;
            if(size < 201){
                k = 10;
            }
            else if(size > 200 && size < 1001){
                k = 50;
            }
            else{
                k = 100;
            }

            runExpirament(size, currentList, k, AListPoolCollector);

        }

        System.out.println("\n\n\n");
        AListCollector.toScreen();
        AListCollector.toFile("AListPool.csv");







    }



    
    
    public static void populate_Structure(List structure, int size){
               
        String path = "src\\data_";
            
        String inputFile = path + String.valueOf(size) + ".bin";

        globalMethods.readFile(inputFile, structure);

    
    }


    public static void runExpirament(int size, List structure, int k, TestDataCollector collector){
        System.out.println("Running Expirement for size: " + size);
////----------------------------------------------------------------------------------------------------------------------------------------------------////
        /// Search - Operation 


        long startTimeSearch = 0;
        long endTimeSearch = 0;
        long totalTimeSearch = 0;

        int[] randomNumbersSearch = globalMethods.generateNumbers(size, k);
        for (int number : randomNumbersSearch) {
            
            startTimeSearch = System.nanoTime();
            structure.search(number);
            endTimeSearch = System.nanoTime();

            totalTimeSearch = totalTimeSearch + (endTimeSearch - startTimeSearch);

        }

        double averageSearchTime = (double) totalTimeSearch / k;
        double averageSearchCount = (double) structure.getCounter().getCount(SEARCH_OPERATION) / k;

////-----------------------------------------------------------------------------------------------------------------------------------------------////
        /// Insert1 - Operation


        long startTimeInsertion1 = 0;
        long endTimeInsertion1 = 0;
        long totalTimeInsertion1 = 0;

        int[] randomNumbersInsertion1 = globalMethods.generateNumbers(size, k);
        for(int number : randomNumbersInsertion1){

            startTimeInsertion1 = System.nanoTime();
            structure.insert(number, String.valueOf(number));
            endTimeInsertion1 = System.nanoTime();

            totalTimeInsertion1 = totalTimeInsertion1 + (endTimeInsertion1 - startTimeInsertion1);

        }

        double averageInsertion1Time = (double) totalTimeInsertion1 / k;
        double averageInsertion1Count = (double) structure.getCounter().getCount(INSERT1_OPERATION) / k;



////--------------------------------------------------------------------------------------------------------------------------------------------------///
        /// Delete - Operation


        long startTimeDelete = 0;
        long endTimeDelete = 0;
        long totalTimeDelete = 0;

        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Integer> k_random_keys = new ArrayList<>();

        keys = structure.getAllKeys();
        Collections.shuffle(keys);



        for (int i = 0; i < k; i++) {
            k_random_keys.add(keys.get(i));   /// k-random keys have been produced
        }

        for (Integer randomKey : k_random_keys) {
            startTimeDelete = System.nanoTime();
            structure.delete(randomKey);
            endTimeDelete = System.nanoTime();

            totalTimeDelete = totalTimeDelete + (endTimeDelete - startTimeDelete);
        }

        double averageDeleteTime = (double) totalTimeDelete / k;
        double averageDeleteCount = (double) structure.getCounter().getCount(DELETE_OPERATION) / k;

        System.out.println("sdfg");

////----------------------------------------------------------------------------------------------------------------------------------------------------///
        /// Insertion2 - Operation   

        
        long startTimeInsertion2 = 0;
        long endTimeInsertion2 = 0;
        long totalInsertion2Time = 0;

        structure.getCounter().resetCounter(INSERT1_OPERATION);

        int[] randomNumbers_insertion2 = globalMethods.generateNumbers(size, k);
        for (int number_insertion : randomNumbers_insertion2) {
            startTimeInsertion2 = System.nanoTime();
            structure.insert(number_insertion, String.valueOf(number_insertion));
            endTimeInsertion2 = System.nanoTime();

            totalInsertion2Time = totalInsertion2Time + (endTimeInsertion2 - startTimeInsertion2);
        }

        double averageInsertion2Time = (double) totalInsertion2Time / k;
        double averageInsertion2Count = (double) structure.getCounter().getCount(INSERT1_OPERATION) / k;


        ArrayList<Object> resultDataRow = new ArrayList<>();

        resultDataRow.addAll(
            Arrays.asList(
                    size,

                    averageSearchCount,
                    averageInsertion1Count,
                    averageDeleteCount,
                    averageInsertion2Count,
                    
                    averageSearchTime,
                    averageInsertion1Time,
                    averageDeleteTime,
                    averageInsertion2Time

            )
        );
        collector.addRow(resultDataRow);
        
        

    }
}
