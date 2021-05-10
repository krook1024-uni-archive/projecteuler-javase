import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem10 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int primesBelow = 2_000_000;

        var primeSum = LongStream
            .rangeClosed(2, primesBelow)
            .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
            .sum();

        System.out.println(primeSum);
    }

}
