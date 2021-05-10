import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem3 {

    public static Long largestPrimeFactor(Long n) {
        Stack<Long> stack = new Stack<>();

        while (n % 2 == 0) {
            stack.push(2L);
            n /= 2;
        }

        for (Long i = 3L; i < Math.sqrt(n); i += 2L) {
            while (n % i == 0) {
                stack.push(i);
                n /= i;
            }
        }

        // for n prime > 2
        if (n > 2) {
            stack.push(n);
        }

        return stack.pop();
    }

    public static void solve() {
        System.out.println(
            largestPrimeFactor(600_851_475_143L)
        );
    }

    public static void main(String[] args) {
        solve();
    }
}
