import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem7 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        System.out.println(
            nthPrime(10_001)
        );
    }

    private static Long nthPrime(int n) {
        --n;
        List<Integer> primes = IntStream.rangeClosed(2, 200_000)
            .filter(i -> {
                    return IntStream.rangeClosed(2, (int) Math.sqrt(i))
                        .allMatch(j -> i % j != 0);
                }
            ).boxed().collect(Collectors.toList());

        return Long.valueOf(primes.get(n));
    }

}
