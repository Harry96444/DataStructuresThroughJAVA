import java.util.Arrays;

public class TC {
    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        int n = 99999;
        System.out.println("Element Found At Index : "+search(n));
        System.out.println("Time taken by the algorithms is  : "+ (System.currentTimeMillis() - now)+" miliSeconds");
    }
    // public static int search(int n) {
    //     return  n * (n + 1)/2;
    // }
     public static int search(int n) {
          int sum = 0; 
          for(int i = 0; i <= n; i++) {
             sum += i;
        }
        return sum;
     }
}
