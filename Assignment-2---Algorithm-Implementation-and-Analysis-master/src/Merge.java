import java.util.Random;
import java.util.Scanner;

public class Merge
{
    static void mergeApp()
    {
        int sizeArray, nElems;
        Scanner sc = new Scanner(System.in);        //scanner input object declaration
        Random randNum = new Random();        //random object declaration

        System.out.print("Enter array size: ");  //prompt message
        sizeArray = sc.nextInt();       //array size input

        int[] arr = new int[sizeArray];       // array declaration

        // For loop for inserting the elements into the arr
        for(nElems= 0; nElems < sizeArray; nElems++)
        {
            int randomElements = randNum.nextInt(100);  //change the 50 to 100
            System.out.println("adding element... " + randomElements);
            arr[nElems] = randomElements;
            System.out.println("Element stored: "+arr[nElems]);
        }

        System.out.println("All elements are stored :)\n");
        System.out.println("Array in unsorted order");
        int arrayLength = arr.length;
        display(arr, arrayLength);
        System.out.println();

        mergeSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }//end of mergeApp
    //--------------------------------------------------------------
    //private static method for
    private static void mergeSort(int[] arr, int n)
    {
        if(n < 2)
            return;

        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for(int i = 0; i < middle; i++)
            leftArray[i] = arr[i];
        for(int i = middle; i < n; i++)
            rightArray[i - middle] = arr[i];

        mergeSort(leftArray, middle);
        mergeSort(rightArray, n - middle);

        mergeFunction(arr, leftArray, rightArray, middle,n - middle, n);
    }//end of merge sort
    //--------------------------------------------------------------
    //private static method for array displays
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//end of display
    //--------------------------------------------------------------
    private static void mergeFunction(int[] arr, int[] leftArray,
                                      int[] rightArray, int left, int right, int n)
    {
        int i = 0, j = 0, k = 0, comparison = 0;
        while(i < left && j < right)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k++] = leftArray[i++];
                comparison++;
            }
            else
            {
                arr[k++] = rightArray[j++];
                comparison++;
            }
        }// end of while loop

        while(i < left)
        {
            arr[k++] = leftArray[i++];
            comparison++;
        }

        while(j < right)
        {
            arr[k++] = rightArray[j++];
            comparison++;
        }

        System.out.println();
        System.out.println("No. of comparisons: "+ comparison);
        System.out.println();
        display(arr, n);
    }//end of mergeFunction
    //--------------------------------------------------------------
}
