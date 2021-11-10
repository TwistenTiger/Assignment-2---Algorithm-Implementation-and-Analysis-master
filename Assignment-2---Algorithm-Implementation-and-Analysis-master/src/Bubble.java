import java.util.Random;
import java.util.Scanner;

public class Bubble
{
    static void bubbleApp()
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
            int randomElements = randNum.nextInt(100); //making this 100
            System.out.println("adding element... " + randomElements);
            arr[nElems] = randomElements;
            System.out.println("Element stored: "+arr[nElems]);
        }

        System.out.println("All elements are stored :)\n");
        System.out.println("Array in unsorted order");
        int arrayLength = arr.length;
        display(arr, arrayLength);
        System.out.println();

        bubbleSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }//End of bubble start
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void bubbleSort(int[] arr, int n)
    {
        int j, i;
        int comparison = 0;
        for(j = 0; j < n; j++)
            for(i = 1; i < (n-j); i++)
                if(arr[i-1] > arr[i])       //out of order
                {
                    //swapping elements, doing comparisons
                    comparison++;
                    swap(arr, i-1, i); //calling the swap method

                    display(arr,n);
                }
        System.out.println();
        System.out.println("No. of comparisons: "+ comparison);
        System.out.println();
    }//End of bubble sort
    //--------------------------------------------------------------
    private static void swap(int[] arr, int one, int two)
    {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }//end of swap
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    //--------------------------------------------------------------
}
