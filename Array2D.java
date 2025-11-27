import java.util.Scanner;

public class Array2D {

    // Print 2D array
    public static void print(int[][] arr) {
        System.out.println("\n2D Array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sum of all elements
    public static int sum(int[][] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
        }
        return total;
    }

    // Transpose of 2D array
    public static int[][] transpose(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    // Rotate 90 degrees clockwise
    public static int[][] rotateClockwise(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }
        return result;
    }

    // Find max element
    public static int findMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("\nEnter " + rows * cols + " elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = sc.nextInt();
            }
        }

        print(arr);
        System.out.println("Sum of all elements: " + sum(arr));
        System.out.println("Max element: " + findMax(arr));

        // Transpose
        int[][] transposed = transpose(arr);
        System.out.println("\nTransposed Array:");
        print(transposed);

        // Rotate (only for square matrices)
        if (rows == cols) {
            int[][] rotated = rotateClockwise(arr);
            System.out.println("Rotated 90° Clockwise:");
            print(rotated);
        }

        sc.close();
    }
}
