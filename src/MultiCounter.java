package src;

/**
 * A utility class for tracking and managing multiple counters
 */
public class MultiCounter {
    /**
     * Default constructor
     */
    public MultiCounter() {
        counters = new long[20];
    }
    
    /**
     * Constructor with custom number of counters
     * @param numCounters Number of counters to initialize
     */
    public MultiCounter(int numCounters) {
        counters = new long[numCounters];
    }
    
    /**
     * variable holding our counters
     */
    private long[] counters;

    /**
     * Resets the internal counter of counterIndex to zero
     * @param counterIndex The counter to reset
     */
    public void resetCounter(int counterIndex) {
        if (counterIndex < counters.length && counterIndex >= 0)
            counters[counterIndex] = 0;
    }
    
    /**
     * Resets all counters to zero
     */
    public void resetAllCounters() {
        for (int i = 0; i < counters.length; i++) {
            counters[i] = 0;
        }
    }

    /**
     * Returns the current count for given counterIndex
     * 
     * @param counterIndex The counter to return
     * @return the current count for given counterIndex
     */
    public long getCount(int counterIndex) {
        if (counterIndex < counters.length && counterIndex >= 0)
            return counters[counterIndex];
        return -1;
    }

    /**
     * Increases the current count of counterIndex by 1. Returns always true so that it can be used
     * in boolean statements
     * 
     * @param counterIndex The counter to modify
     * @return always true
     */
    public boolean increaseCounter(int counterIndex) {
        if (counterIndex < counters.length && counterIndex >= 0)
            counters[counterIndex]++;
        return true;
    }

    /**
     * Increases the current count of counter given by counterIndex by step. Returns always true 
     * so that it can be used in boolean statements. Step could be negative. 
     * It is up to the specific usage scenario whether this is desirable or not.
     * 
     * @param counterIndex The counter to modify
     * @param step The amount to increase the counter
     * @return always true
     */
    public boolean increaseCounter(int counterIndex, int step) {
        if (counterIndex < counters.length && counterIndex >= 0)
            counters[counterIndex] = counters[counterIndex] + step;
        return true;
    }
} 