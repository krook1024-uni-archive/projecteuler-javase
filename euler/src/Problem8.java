import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem8 {

    private static final int N_OF_ADJACENT_DIGITS = 13;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        String numbers = """
            73167176531330624919225119674426574742355349194934
            96983520312774506326239578318016984801869478851843
            85861560789112949495459501737958331952853208805511
            12540698747158523863050715693290963295227443043557
            66896648950445244523161731856403098711121722383113
            62229893423380308135336276614282806444486645238749
            30358907296290491560440772390713810515859307960866
            70172427121883998797908792274921901699720888093776
            65727333001053367881220235421809751254540594752243
            52584907711670556013604839586446706324415722155397
            53697817977846174064955149290862569321978468622482
            83972241375657056057490261407972968652414535100474
            82166370484403199890008895243450658541227588666881
            16427171479924442928230863465674813919123162824586
            17866458359124566529476545682848912883142607690042
            24219022671055626321111109370544217506941658960408
            07198403850962455444362981230987879927244284909188
            84580156166097919133875499200524063689912560717606
            05886116467109405077541002256983155200055935729725
            71636269561882670428252483600823257530420752963450
            """
            .replace("\n", "")
            .replace("\r", "")
            .replace(" ", "");

        StringReader sr = new StringReader(numbers);
        LinkedList<Integer> current = new LinkedList<>();
        Map<ArrayList<Integer>, Long> products = new HashMap<>();

        for (int i = 0; i < (N_OF_ADJACENT_DIGITS - 1); i++) {
            current.add(Integer.parseInt(String.valueOf((char) sr.read())));
        }

        int read = sr.read();
        while (read != -1) {
            // read one number
            current.add(Integer.parseInt(String.valueOf((char) read)));

            // calculate + store currentProduct if larger than 0
            Long currentProduct = getCurrentProduct(current);

            if (currentProduct > 0) {
                products.put(new ArrayList<Integer>(current), currentProduct);
            }

            // shift by one
            current.removeFirst();
            read = sr.read();
        }

        System.out.println(products);

        System.out.println(
            products
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("No max found"))
        );
    }

    private static Long getCurrentProduct(LinkedList<Integer> current) {
        Long currentProduct = current
            .stream()
            .mapToLong(Long::valueOf)
            .filter(n -> n != 1L)
            .reduce(1L, (old, curr) -> old * curr);

        return currentProduct;
    }
}
