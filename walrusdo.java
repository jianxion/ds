public class walrusdo {
    public static void main(String[] args) {
        Walrus walrus = new Walrus(3500, 10.5);
        int x = 9;
        int answer = doStuff(walrus, x);
        System.out.println(answer);
    }

    public static int doStuff(Walrus W, int x){
        W.weight = W.weight - 100;
        x = x - 5;
        return x;

        }
}
