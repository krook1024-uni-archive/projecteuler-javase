import java.util.stream.IntStream;

public class Problem5 {

    public static void main(String[] args) {
        //solve();
        solve2();
    }

    private static void solve() {
        Integer val = IntStream
            .range(2_000_000_00, 1_000_000_000)
            .filter(n -> IntStream.range(1, 20).noneMatch(x -> n % x != 0))
            .findFirst()
            .getAsInt();

        System.out.println(val);
    }

    private static void solve2() {
        System.out.println(
            IntStream
                .range(1, 20)
                .reduce(1, Problem5::lcm)
        );
    }

    private static Integer lcm(int x, int y) {
        return Math.abs(x * y) / euclideanGcd(x, y);
    }

    private static Integer euclideanGcd(Integer x, Integer y) {
        while (!x.equals(y)) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }

        return x;
    }

}
