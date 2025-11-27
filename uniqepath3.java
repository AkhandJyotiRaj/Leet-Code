import java.util.*;
public class uniqepath3 {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int i = sc.nextInt();
        System.out.println("Enter columns:");
        int j= sc.nextInt();
        int[][] arr = new int[i][j];
        System.out.println("Enter elements:");
        for (i = 0; i < arr.length; i++) {  
            for (j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("2D Array:");
        for (i = 0; i < arr.length; i++) {  
            for (j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
