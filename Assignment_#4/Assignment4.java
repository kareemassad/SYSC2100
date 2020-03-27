import java.util.*;

/**
 * This class is made for the sysc2100 Assignment number 4
 * @author Kareem El Assad
 * @version 3/26/2020
 * 
 */
class Assignment4 {
    /**
     * 
     * @param <T>   Array type
     * @param theArray  The array being sorted  
     * @param n the size of the array
     */
    public static <T extends Comparable<? super T>> void recursiveSelectionSort (T[] theArray, int n){
        //keeps track of spot before the end of the array
        int greatestIndex = n - 1;

        for (int index = n-2; index >= 0; index--){
            if (theArray[index].compareTo(theArray[greatestIndex]) > 0) {
                greatestIndex = index;
            }
        }
        if (greatestIndex != n-1) {
            T temp = theArray[greatestIndex];
            theArray[greatestIndex] = theArray[n-1];
            theArray[n-1] = temp;
        }
        if(n > 2) {
            recursiveSelectionSort(theArray, n-1);
        }
    }
    /**
     * 
     * @param <T>   Array type
     * @param theArray  The array being sorted
     * @param n size of the array
     */
    public static <T extends Comparable<? super T>> void recursiveBubbleSort (T[] theArray, int n){
        //sorted identifier set as true for the recursion to work
        boolean checker = true;
        for(int i = n - 1; i > 0; i--){
            /*  returns >0 if curr > curr-1
                returns 0 if curr = curr-1
                return <0 if curr < curr-1
            */
            // if the current value is smaller than the one before then do the switch
            if(theArray[i].compareTo(theArray[i-1]) < 0){
                //simple switcheroo
                T temp = theArray[i];
                theArray[i] = theArray[i-1]
                theArray[i-1] = temp;
                //not sorted identifier
                checker = false;
            }
            //if it isnt true then it is not sorted and so run it again
            if (checker != true) {
                recursiveBubbleSort(theArray, n-1);
            }
        }
    }

}