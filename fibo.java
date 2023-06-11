public class fibo {
    // return nth fibonacci number
    public static int fib(int n, int k, int f0, int f1){
        if (n == k){
            return f0;
        }
        else {
            return fib(n, k+1,f1,f0+f1);
        }
    }

    public static void main(String[] args){
        System.out.println(fib(6,0,0,1));
    }
}
