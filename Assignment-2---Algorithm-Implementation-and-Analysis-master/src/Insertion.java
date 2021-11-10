import java.util.Random;
import java.util.Scanner;

public class Insertion
{
    static void insertionApp()
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

        insertionSort(arr, arrayLength);

        System.out.println();
        System.out.println("Array in sorted order");
        display(arr, arrayLength);
    }// end of insertion app
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void insertionSort(int[] arr, int n)
    {
        int temp, j, i;
        int comparison = 0;
        for(j = 1; j < n; j++)
        {
            temp = arr[j];
            i = j;
            while(i > 0 && arr[i-1] >= temp)
            {
                arr[i] = arr[i-1];
                i--;
                comparison++;
            }
            arr[i] = temp;
            display(arr, n);
        }

        System.out.println();
        System.out.println("No. of comparisons: "+ comparison);
        System.out.println();
    }//end of insertion sort
    //--------------------------------------------------------------
    //private method for encapsulation
    private static void display(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//end of display
    //--------------------------------------------------------------
}
