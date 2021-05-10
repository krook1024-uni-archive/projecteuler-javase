import java.util.stream.IntStream;

public class Problem1 {

    public static void solve() {
        long sum = IntStream.range(0, 1000).filter(i -> (i % 3 == 0) || (i % 5 == 0)).asLongStream().sum();

        System.out.println(sum);
    }

    public static void main(String[] args) {
        solve();
    }

}
