
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        //Get input for length of list and establish scanner
        System.out.print("Enter length of list: ");
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int myList[] = new int[length];

        //Misc
        boolean sorted;
        int max = 0;
        int min = 0;

        //Get the variables for the array
        System.out.print("Enter the list: ");
        for (int i = 0; i < myList.length; i++) {
            myList[i] = s.nextInt();
        }
        //Set boolean for whether or not the list is in order and give output
        sorted = isSorted(myList);

        if (sorted == true) {
            System.out.println("The list is already sorted.");

            //Max and min
            min = findMin(myList);
            max = findMax(myList);
            System.out.println("The minimum value is: " + min);
            System.out.println("The maximum value is: " + max);
        } else {
            System.out.println("The list is not sorted.");
            System.out.print("The unsorted list is: ");
            for (int i = 0; i < myList.length; i++) {
                System.out.print(myList[i] + " ");
            }
            System.out.println();

            //Send list to another method to sort list
            int sList[] = selectionSort(myList);

            //Display sorted list
            System.out.print("The sorted list is: ");
            for (int i = 0; i < sList.length; i++) {
                System.out.print(sList[i] + " ");
            }
            System.out.println();

            //Max and min
            min = findMin(sList);
            max = findMax(sList);
            System.out.println("The minimum value is: " + min);
            System.out.println("The maximum value is: " + max);
        }
    }

    public static boolean isSorted(int[] list) {
        int previous = list[0];
        boolean check = true;

        for (int i = 0; i < list.length; i++) {
            if (previous > list[i]) {
                check = false;
                break;
            }
            previous = list[i];
        }
        return check;
    }

    public static int[] selectionSort(int[] list) {
        int minIndex, minValue, temp = 0;

        for (int i = 0; i < list.length; i++) {
            minIndex = i;
            minValue = list[i];
            for (int j = i; j < list.length; j++) {
                if (minValue > list[j]) {
                    minIndex = j;
                    minValue = list[j];
                }
            }
            if (minValue < list[i]) {
                temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
        return list;
    }

    public static int findMin(int[] list) {
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (min > list[i]) {
                min = list[i];
            }
        }
        return min;
    }

    public static int findMax(int[] list) {
        int max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (max < list[i]) {
                max = list[i];
            }
        }
        return max;
    }
}
