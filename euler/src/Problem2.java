import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static List<Integer> fib(Integer max_iter, Integer max_n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for (int i = 2; i < max_iter; i++) {
            Integer sum = list.get(i - 1) + list.get(i - 2);

            if (sum > max_n) {
                break;
            }

            list.add(sum);
        }

        return list;
    }

    public static void solve() {
        System.out.println(
            fib(1_000, 4_000_000)
                .stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n).sum()
        );
    }

    public static void main(String[] args) {
        solve();
    }

}
