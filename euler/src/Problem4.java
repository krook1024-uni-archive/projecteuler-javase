import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem4 {

    private static Boolean isPalindrome(Integer n) {
        String original = String.valueOf(n);
        StringBuilder reversed = new StringBuilder();

        for (int i = 1; i <= original.length(); i++) {
            reversed.append(original.charAt(original.length() - i));
        }

        return original.contentEquals(reversed);
    }

    private static Set<Integer> getProducts() {
        Set<Integer> set = new HashSet<>();

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                set.add(i * j);
            }
        }

        return set;
    }

    public static void solve() {
        List<Integer> palindromes = getPalindromes();

        System.out.println(
            palindromes
        );

        System.out.println(
            palindromes
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("No maximum found"))
        );
    }

    private static List<Integer> getPalindromes() {
        List<Integer> palindromes = getProducts()
            .stream()
            .filter(Problem4::isPalindrome)
            .collect(Collectors.toList());
        return palindromes;
    }

    public static void main(String[] args) {
        solve();
    }
}
