public class recurssiontree {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int rows = 5;
        printPattern(rows, 1);
    }

    public static void printPattern(int rows, int currentRow) {
        if (currentRow > rows) {
            return;
        }
        
        for (int j = 1; j <= currentRow; j++) {
            System.out.print("* ");
        }
        System.out.println();
        
        printPattern(rows, currentRow + 1);
    }
}
