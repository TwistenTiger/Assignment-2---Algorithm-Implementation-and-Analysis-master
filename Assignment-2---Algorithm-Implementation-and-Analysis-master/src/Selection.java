import java.util.Random;
import java.util.Scanner;

public class Selection
{
    static void selectionApp()
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

        selectionSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void selectionSort(int[] arr, int n)
    {
        display(arr, n);    //initial display of unsorted array.
        int min, j, i, comparison = 0;     //declarations
        for(j=0; j < n -1; j++)     //outer loop
        {
            min = j;    //minimum
            for(i=j+1; i < n; i++)      //inner loop
                if(arr[i] < arr[min])   //if min is greater
                    min = i;    //we have a new min value
            //will need to come and add a swap function
            swap(arr, j, min);
            comparison++;
            display(arr, n);
        }

        System.out.println();
        System.out.println("No. of comparisons: "+ comparison);
        System.out.println();
    }//end of selection sort
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//end of display
    //--------------------------------------------------------------
    private static void swap(int[] arr, int one, int two)
    {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }//end of swap
}
