import java.util.Random;
import java.util.Scanner;

public class Heap
{
    static void HeapApp()
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

        heapSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }
    //----------------------------------------------------------------------------
    private static void heapSort(int[] arr, int n)
    {
        //building the heap
        for(int i = n/2 - 1; i >= 0; i--)
            heapifyed(arr, n, i);

        for(int i = n-1; i > 0; i--)//extract item from heap one by one
        {
            swap(arr, 0, i);
            heapifyed(arr, i, 0);
        }
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
    //----------------------------------------------------------------------------
    private static void swap(int[] arr, int one, int two)
    {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    //----------------------------------------------------------------------------
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
