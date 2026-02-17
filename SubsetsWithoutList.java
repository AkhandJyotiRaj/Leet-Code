public class SubsetsWithoutList {

    public static void findSubsets(int[] arr) {
        int[] subset = new int[arr.length];
        generate(arr, subset, 0, 0);
    }

    private static void generate(int[] arr, int[] subset, int index, int size) {
        
        // Base case: all elements processed
        if (index == arr.length) {
            // Print current subset
            System.out.print("{ ");
            for (int i = 0; i < size; i++) {
                System.out.print(subset[i] + " ");
            }
            System.out.println("}");
            return;
        }

        // 1️⃣ Include current element
        subset[size] = arr[index];
        generate(arr, subset, index + 1, size + 1);

        // 2️⃣ Exclude current element
        generate(arr, subset, index + 1, size);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findSubsets(arr);
    }
}
