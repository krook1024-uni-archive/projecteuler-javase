import java.util.stream.IntStream;

public class Problem6 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        System.out.println(getDiff(100));
    }

    private static Long getDiff(Integer first_n) {
        Long sumOfSquares = (long) IntStream.range(1, first_n + 1).sum();
        return (sumOfSquares * sumOfSquares)
                - IntStream.range(1, first_n + 1).map(n -> n * n).sum();
    }

}
