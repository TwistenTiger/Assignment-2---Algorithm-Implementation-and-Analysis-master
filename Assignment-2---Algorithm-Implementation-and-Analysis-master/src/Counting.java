import java.util.Random;
import java.util.Scanner;

public class Counting
{
    static void countingApp()
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

        countingSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }
    //----------------------------------------------------------------------------
    private static void countingSort(int[] arr, int n)
    {
        int[] output = new int[n];
        int[] count = new int[256];

        for(int i = 0; i < 256; i++)
            count[i] = 0;

        for (int j = 0; j < n; j++)
            count[arr[j]]++;

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
            display(arr, n);
        }
    }//end of counting sort
    //----------------------------------------------------------------------------
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//end of display
    //----------------------------------------------------------------------------
}
