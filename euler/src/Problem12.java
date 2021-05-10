import java.util.stream.LongStream;

public class Problem12 {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Boolean found = false;
        Long n = 1L;
        while (!found) {
            n++;
            if (getNumberOfDivisors(getNthTriangleNum(n)) > 500) {
                found = true;
                Long triangle = getNthTriangleNum(n);
                System.out.println(n + "th num " + triangle + ": " + getNumberOfDivisors(triangle) + " divisors");
            }
        }
    }

    public static Long getNthTriangleNum(Long n) {
        return n * (n + 1) / 2;
    }

    public static long getNumberOfDivisors(Long n) {
        return LongStream
            .rangeClosed(1, (int) Math.sqrt(n))
            .filter(x -> n % x == 0)
            .count() * 2;
    }
}
