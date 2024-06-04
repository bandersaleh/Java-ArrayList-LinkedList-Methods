//Bander Saleh RTC CSI 260 Intro to Data Struct & Algorithms Prof Lhoucine Zerrouki
import java.util.ArrayList; // Import built-in ArrayList class Java package

public class Main {
    public static void main(String[] args) {
        // Output "Question 1: "
        System.out.println("Question 1: ");
        // Define Array1
        int[] array1 = {27, 5, 19, 2, 20};

        // Initialize new ArrayList to store subarrays
        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<>();

        // Outer loop to iterate over starting index of subarrays
        for (int i = 0; i < array1.length; i++) {
            // Inner loop to iterate over ending index of subarrays
            for (int j = i; j < array1.length; j++) {
                // Create a new subarray list
                ArrayList<Integer> subarray = new ArrayList<>();

                // Loop to populate subarray with elements from the original array
                for (int k = i; k <= j; k++) {
                    // Add elements to the subarray
                    subarray.add(array1[k]);
                }
                // Add subarray to the list of subarrays
                subarrays.add(subarray);
            }
        }

        // Output the subarrays and their sums
        for (ArrayList<Integer> subarray : subarrays) {
            // Output subarray and its sum (via sum method)
            System.out.println(subarray + " Sum: " + sum(subarray));
        }






        // Output "Question 2: "
        System.out.println("\nQuestion 2: ");

        // Define Array2
        int[] array2 = {1, 2, 3, 4, 5};

        // Define int representing number of rotations
        int count = 2;

        System.out.println("Original Array:");
        // Output ArrayList
        printArray(array2);

        // Run the Rotate Method
        rotate(array2, count);

        // Output rotated array
        System.out.println("\nArray after " + count + " rotations:");
        // Output ArrayList
        printArray(array2);






        // Output "Question 3: "
        System.out.println("\n\nQuestion 3: ");
        // Define Array3
        int[] array3 = {9, 15, 5, 29, 2, 11};
        // Output ArrayList
        printArray(array3);
        // Define int representing secondMin value and run method
        int secondMin = findSecondMinimum(array3);
        // Output requested value
        System.out.println("\nSecond minimum: " + secondMin);



    } // END OF MAIN
















    // METHOD for Question 1: (see below)
    // METHOD to calculate sum of elements in a list
    public static int sum(ArrayList<Integer> list) {
        // Internal temp int
        int sum = 0;
        // For loop to go through each index
        for (int num : list) {
            // Add values to current inputted ArrayList's sum
            sum += num;
        }
        // Return the final calculated value
        return sum;
    }



    // METHOD for Question 2: (see below)
    // METHOD to rotate the elements of an array count times
    public static void rotate(int[] array, int count) {
        // Define value n as inputted array's length
        int n = array.length;
        // Ensure count is within the range of array length
        count %= n;

        // Reverse the entire array
        reverse(array, 0, n - 1);
        // Reverse the first count elements
        reverse(array, 0, count - 1);
        // Reverse the remaining elements
        reverse(array, count, n - 1);
    }

    // Method to reverse the elements of an array within a specified range
    public static void reverse(int[] array, int start, int end) {
        // Loop until the start index is less than the end index
        while (start < end) {
            // Swap the elements at start and end positions using a temporary variable
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            // Move start index towards the end of the range
            start++;
            // Move end index towards the start of the range
            end--;
        }
    }


    // Method to print the elements of an ArrayList
    public static void printArray(int[] array) {
        // ForEach index value of inputted array, print value of current index location
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }




    // METHOD for Question 3: (see below)
    // Method to find the second minimum in an unsorted array
    public static int findSecondMinimum(int[] array) {
        // Initialize the minimum value to the maximum possible integer value
        int min = Integer.MAX_VALUE;
        // Initialize the second minimum value to the maximum possible integer value
        int secondMin = Integer.MAX_VALUE;

        // Loop through each element in the array
        for (int num : array) {
            // If the current element is less than the current minimum
            if (num < min) {
                // Update the second minimum to the previous minimum
                secondMin = min;
                // Update the minimum to the current element
                min = num;
            }
            // If the current element is greater than the minimum but less than the second minimum
            else if (num < secondMin && num != min) {
                // Update the second minimum to the current element
                secondMin = num;
            }
        }
        // Return the second minimum found
        return secondMin;
    }


}