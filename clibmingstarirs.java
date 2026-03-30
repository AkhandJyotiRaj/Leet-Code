public class clibmingstarirs {
    
    public static int climbb(int n) {
        
        // write is here your code
        if(n<=3) return n;
        return climbb(n - 1) + climbb(n - 2)+ climbb(n - 3);
    }

    public static void main(String[] args) {
        
        // clibmingstarirs c = new clibmingstarirs();
        System.out.println(climbb(3));


    }
}
