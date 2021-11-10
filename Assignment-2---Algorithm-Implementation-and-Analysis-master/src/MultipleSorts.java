import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class MultipleSorts
{
    static void multipleSortsApp()
    {
        int sizeArray, nElems;
        Scanner sc = new Scanner(System.in);        //scanner input object declaration
        Random randNum = new Random();        //random object declaration

        System.out.print("Enter array size: ");  //prompt message
        sizeArray = sc.nextInt();       //array size input

        /*
            Making separate sorting algorithms arrays.
            this is the best way possible. The arrays are all give the same values
            by the random function and equal sorted by each algorithm
         */
        int[] selectionArray = new int[sizeArray];
        int[] insertionArray = new int[sizeArray];
        int[] mergeArray = new int[sizeArray];
        int[] quickArray = new int[sizeArray];
        int[] heapArray = new int[sizeArray];
        int[] bubbleArray = new int[sizeArray];       // array declaration
        int[] optimalBubbleArray = new int[sizeArray];
        int[] countingArray = new int[sizeArray];
        int[] generalCountingArray = new int[sizeArray];

        /*
            the comparison feature when called in each algorithm module is
            a hit and miss, sometimes works. but when bubble sort algorithm
            is not the first to be called it doesn't seem to compare.

            this won't apply for methods that call themselves
         */
        int selectionCompare = 0;
        int insertionCompare = 0;
        int heapCompare = 0;
        int bubbleCompare = 0;
        int optimalBubbleCompare = 0;
        int countingCompare = 0;
        int generalCountCompare = 0;

        // For loop for inserting the elements into the arr
        /*
            For loop for inserting the elements into all arrays
            this is the best way to do it as we are giving each array
            the same values as the next or previous
         */
        for(nElems= 0; nElems < sizeArray; nElems++)
        {
            int randomElements = randNum.nextInt(100);
            selectionArray[nElems] = randomElements;
            insertionArray[nElems] = randomElements;
            mergeArray[nElems] = randomElements;
            quickArray[nElems] = randomElements;
            heapArray[nElems] = randomElements;
            bubbleArray[nElems] = randomElements;
            optimalBubbleArray[nElems] = randomElements;
            countingArray[nElems] = randomElements;
            generalCountingArray[nElems] = randomElements;
        }
        int arrayLength = selectionArray.length; //array length
        /*
            here we are display the contents that are put in the array
            we are testing to see if the arrays are having equal values
            as we are testing their abilities
         */
        //unsorted selection
        System.out.println("Unsorted selection array");
        display(selectionArray, arrayLength);
        System.out.println();

        //unsorted insertion
        System.out.println("Unsorted insertion array");
        display(insertionArray, arrayLength);
        System.out.println();

        //unsorted merge
        System.out.println("Unsorted merge array");
        display(mergeArray, arrayLength);
        System.out.println();

        //unsorted quick
        System.out.println("Unsorted quick array");
        display(quickArray, arrayLength);
        System.out.println();

        //unsorted heap
        System.out.println("Unsorted heap array");
        display(heapArray, arrayLength);
        System.out.println();

        //unsorted bubble
        System.out.println("Unsorted bubble array");
        display(bubbleArray, arrayLength);
        System.out.println();

        //unsorted optimal bubble
        System.out.println("Unsorted optimal bubble array");
        display(optimalBubbleArray, arrayLength);
        System.out.println();

        //unsorted counting
        System.out.println("Unsorted counting array");
        display(countingArray, arrayLength);
        System.out.println();

        //unsorted general counting
        System.out.println("Unsorted general counting array");
        display(generalCountingArray, arrayLength);
        System.out.println();

        //sorting algorithms calls
        selectionSort(selectionArray, arrayLength, selectionCompare);
        insertionSort(insertionArray, arrayLength, insertionCompare);
        mergeSort(mergeArray, arrayLength);
        quickSort(quickArray,0,arrayLength-1, arrayLength);
        heapSort(heapArray,arrayLength, heapCompare);
        bubbleSort(bubbleArray, arrayLength, bubbleCompare);
        optimisedBubbleSort(optimalBubbleArray, arrayLength, optimalBubbleCompare);
        countingSort(countingArray, arrayLength, countingCompare);

        //sorted selection
        System.out.println("Sorted selection array");
        display(selectionArray, arrayLength);
        System.out.println();

        //sorted insertion
        System.out.println("Sorted insertion array");
        display(insertionArray, arrayLength);
        System.out.println();

        //sorted merge
        System.out.println("Sorted merge array");
        display(mergeArray, arrayLength);
        System.out.println();

        //sorted quick
        System.out.println("Sorted quick array");
        display(quickArray, arrayLength);
        System.out.println();

        //sorted heap
        System.out.println("Sorted heap array");
        display(heapArray, arrayLength);
        System.out.println();

        //sorted bubble
        System.out.println("Sorted bubble array");
        display(bubbleArray, arrayLength);
        System.out.println();

        //sorted optimal bubble
        System.out.println("Sorted optimal bubble array");
        display(optimalBubbleArray, arrayLength);
        System.out.println();

        //sorted counting
        System.out.println("Sorted counting array");
        display(countingArray, arrayLength);
        System.out.println();

        //sorted general counting
        System.out.println("Sorted general counting array");
        display(generalCountingArray, arrayLength);
        System.out.println();

    }

    static void selectionSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Selection Sort";
        int min, j, i;     //declarations
        for(j=0; j < n -1; j++)     //outer loop
        {
            min = j;    //minimum
            for(i=j+1; i < n; i++)      //inner loop
            {
                c++;
                if(arr[i] < arr[min])   //if min is greater
                    min = i;    //we have a new min value
            }

            swap(arr, j, min);
        }
        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of selection sort
    /*-------------------------------------------------END OF SELECTION-----------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Insertion sort algorithm
    */
    static void insertionSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Insertion Sort";
        int temp, j, i;
        for(j = 1; j < n; j++)
        {
            temp = arr[j];
            i = j;
            while(i > 0 && arr[i-1] >= temp)
            {
                arr[i] = arr[i-1];
                i--;
                c++;
            }
            arr[i] = temp;
        }

        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of insertion sort
    /*--------------------------------------------END OF INSERTION SORT-----------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Merge sort algorithm and merge related functions
    */
    private static void mergeSort(int[] arr, int n)
    {
        int comparison = 15; //just putting a random number to allow execution
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Merge Sort";
        if(n < 2)
            return;

        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for(int i = 0; i < middle; i++)
        {
            leftArray[i] = arr[i];
            comparison++;
        }

        for(int i = middle; i < n; i++)
        {
            rightArray[i - middle] = arr[i];
            comparison++;
        }


        mergeSort(leftArray, middle);
        mergeSort(rightArray, n - middle);

        mergeFunction(arr, leftArray, rightArray, middle,n - middle);

        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ comparison + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of merge sort
    /*----------------------------------------------------------------------------------------------------------------*/
    private static void mergeFunction(int[] arr, int[] leftArray,
                                      int[] rightArray, int left, int right)
    {
        int i = 0, j = 0, k = 0;
        while(i < left && j < right)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k++] = leftArray[i++];
            }
            else
            {
                arr[k++] = rightArray[j++];
            }
        }// end of while loop

        while(i < left)
        {
            arr[k++] = leftArray[i++];
        }

        while(j < right)
        {
            arr[k++] = rightArray[j++];
        }
    }//end of merge function for the merge sort class
    /*-------------------------------------------END of Merge and related functions-----------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Quick sort algorithm and related functions
    */
    private static void quickSort(int[] arr, int low, int high, int n)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Quick Sort";
        int comparison = 15; // 15 for test purposes.
        if(low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1, n);
            quickSort(arr, pi+1, high, n);
        }
        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ comparison + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of quickSort
    //--------------------------------------------------------------
    private static int partition(int[] arr, int low, int high)
    {
        //int n = arr.length;
        //pivot
        int pivot =  arr[high];
        int i = (low-1);
        for(int j = low; j <= high - 1; j++)
        {
            if(arr[j] < pivot)
            {
                //increasing index
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }//end of Partitioning it
    /*------------------------------------END OF QUICK AND FUNCTIONS--------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Heap sort algorithm
    */
    private static void heapSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Heap Sort";
        //building the heap
        for(int i = n/2 - 1; i >= 0; i--)
        {
            c++;
            heapifyed(arr, n, i);
        }

        for(int i = n-1; i > 0; i--)//extract item from heap one by one
        {
            c++;
            swap(arr, 0, i);
            heapifyed(arr, i, 0);
        }

        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }
    //----------------------------------------------------------------------------
    private static void heapifyed(int[] arr, int n, int i)  //hahaha get it as in Hippies hahaha so not funny
    {
        int biggest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //if left child is bigger than root
        if(left < n && arr[left] > arr[biggest])
            biggest = left;

        //if right child is bigger than current bigger make it the biggest
        if(right < n && arr[right] >  arr[biggest])
            biggest = right;

        if(biggest != i)
        {
            swap(arr, i, biggest); //might try the swap method here to
            heapifyed(arr, n, biggest);
        }
    }
    /*----------------------------------------END OF HEAP SORT--------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Bubble sort algorithm
    */
    static void bubbleSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Bubble Sort";
        int i, j;

        for(j = 0; j < n; j++)
            for(i = 1; i < (n-j); i++)
            {
                c++;
                if(arr[i-1] > arr[i])       //out of order
                {
                    swap(arr, i-1, i);
                }
            }


        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c+ " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of bubble sort
    //------------------------------------------------------------------------------------------------------------------
    static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//end of display
    //------------------------------------------------------------------------------------------------------------------
    private static void swap(int[] arr, int one, int two)
    {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }//end of swap
    /*------------------------------------------END OF BUBBLE SORT----------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Optimal Bubble sort algorithm
    */
    private static void optimisedBubbleSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Optimised-Bubble Sort";
        int i, j;
        boolean swapped;
        for(j = 0; j < n; j++)
        {
            swapped = false; //nothing is swapped
            for(i = 1; i < (n-j); i++)
            {
                c++;
                if(arr[i-1] > arr[i])       //out of order
                {
                    //swapping elements, doing comparisons
                    swap(arr, i-1, i);
                    swapped = true; //there has been a swap
                }
            }

            if(!swapped)    //if not swapped break.
                break;
        }

        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis
        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c+ " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }
    /*------------------------------------------OPTIMISED BUBBLE SORT-------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*
        Counting sort algorithm
    */
    private static void countingSort(int[] arr, int n, int c)
    {
        Instant startTime = Instant.now(); //algorithm starting point
        String sortName = "Counting Sort";
        int[] output = new int[n];
        int[] count = new int[256];

        for(int i = 0; i < 256; i++)
        {
            count[i] = 0;
            c++;
        }


        for (int j = 0; j < n; j++)
        {
            count[arr[j]]++;
        }


        for(int k = 1; k <= 255; k++)
            count[k] += count[k-1];

        for(int l = n - 1; l >= 0; l--)
        {
            output[count[arr[l]] - 1] = arr[l];
            count[arr[l]]--;
        }

        for(int m = 0; m < n; m++)
        {
            arr[m] = output[m];
        }

        Instant endTime = Instant.now(); //algorithm end point
        long timeElapsed = Duration.between(startTime, endTime).toMillis(); //in millis

        System.out.println("-------------------------------------------------------------------------\n" +
                sortName + " | "+ n + " | "+ c + " | " + timeElapsed +" (ms.)" +"\n" +
                "-------------------------------------------------------------------------");
    }//end of counting sort

}
