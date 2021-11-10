import java.util.Random;
import java.util.Scanner;

public class Quick
{
    static void quickApp()
    {
        int sizeArray,nElems;
        Scanner sc = new Scanner(System.in);        //scanner input object declaration
        Random randNum = new Random();        //random object declaration

        System.out.print("Enter array size: ");  //prompt message
        sizeArray = sc.nextInt();       //array size input

        int[] arr = new int[sizeArray];       // array declaration

        // For loop for inserting the elements into the arr
        for(nElems= 0; nElems < sizeArray; nElems++)
        {
            int randomElements = randNum.nextInt(100);
            System.out.println("adding element... " + randomElements);
            arr[nElems] = randomElements;
            System.out.println("Element stored: "+arr[nElems]);
        }

        System.out.println("All elements are stored :)\n");
        System.out.println("Array in unsorted order");
        int arrayLength = arr.length;
        display(arr, arrayLength);
        System.out.println();

        quickSort(arr, 0,arrayLength-1);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }
    //--------------------------------------------------------------
    private static void quickSort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }//end of quickSort
    //--------------------------------------------------------------
    private static int partition(int[] arr, int low, int high)
    {
        int n = arr.length;
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
            display(arr, n);
        }
        swap(arr, i+1, high);
        return (i+1);
    }//end of Partitioning it
    //--------------------------------------------------------------
    private static void swap(int[] arr, int one, int two)
    {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    //--------------------------------------------------------------
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    //--------------------------------------------------------------
}
