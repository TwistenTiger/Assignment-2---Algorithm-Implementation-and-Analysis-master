import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome follow the menu prompt");
        int option, subMenuOption;
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println();
            System.out.println("Please, select an option");
            System.out.println("1. Test an individual sorting algorithm");
            System.out.println("2. Test multiple sorting algorithms");
            System.out.print("Select algorithm by corresponding number: ");

            option = sc.nextInt();
            switch (option)
            {
                //-------------------------------------------------------------------------------------
                //Case statement 1: sorting individuals algorithm
                //-------------------------------------------------------------------------------------
                case 1:
                    System.out.println();
                    System.out.println("Test an individual algorithm");
                    System.out.println("1. selection sort");
                    System.out.println("2. insertion sort");
                    System.out.println("3. merge sort");
                    System.out.println("4. quick sort");
                    System.out.println("5. heap sort");
                    System.out.println("6. bubble sort");
                    System.out.println("7. optimal-bubble sort");
                    System.out.println("8. counting sort");
                    System.out.println("9. general-counting sort");
                    System.out.print("Select algorithm by corresponding number: ");

                    subMenuOption = sc.nextInt();  //submenu option selector scanner input
                    switch(subMenuOption)
                    {
                        //selection sort
                        case 1:
                            System.out.println();
                            System.out.println("selection sort");
                            Selection.selectionApp();
                            break;

                        //insertion sort
                        case 2:
                            System.out.println();
                            System.out.println("insertion sort");
                            Insertion.insertionApp();
                            break;

                        //merge sort
                        case 3:
                            System.out.println();
                            System.out.println("merge sort");
                            Merge.mergeApp();
                            break;

                        //quick sort
                        case 4:
                            System.out.println();
                            System.out.println("quick sort");
                            Quick.quickApp();
                            break;

                        //heap sort
                        case 5:
                            System.out.println();
                            System.out.println("heap sort");
                            Heap.HeapApp();
                            break;

                        //bubble sort
                        case 6:
                            System.out.println();
                            System.out.println("bubble sort");
                            Bubble.bubbleApp(); //calling the bubble class to run the bubble algorithm
                            break;

                        //optimal-bubble sort
                        case 7:
                            System.out.println();
                            System.out.println("optimal-bubble sort");
                            OptimisedBubble.optimisedBubbleApp();
                            break;

                        //counting sort
                        case 8:
                            System.out.println();
                            System.out.println("counting sort");
                            Counting.countingApp();
                            break;

                        //will come back later when we find the algorithm for this sort
                        case 9:
                            System.out.println();
                            System.out.println("general-counting sort");
                            break;
                        default:
                    }
                    break;
                //end of case 1
                //-----------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------
                //Case statement 2: sort multiple sorting algorithm
                //-------------------------------------------------------------------------------------
                case 2:
                    System.out.println();
                    System.out.println("sort multiple sorting algorithm");
                    MultipleSorts.multipleSortsApp();
                    break;
                default:
                //end of case 2
                //-----------------------------------------------------------------------------------
            }// end of main switch statement
        }
        while(option != 0); //end of do-while loop
    } //end of public static void main method
}
