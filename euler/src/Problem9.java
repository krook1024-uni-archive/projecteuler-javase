public class Problem9 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int upTo = 500;

        for (int a = 1; a < upTo; a++) {
            for (int b = a; b < upTo; b++) {
                for (int c = b; c < upTo; c++) {
                    if (a * a + b * b == c * c) {
                        if (a + b + c == 1000) {
                            System.out.println(a + ", " + b + ", " + c + " = " + (a + b + c));
                            System.out.println(a * b * c);
                        }
                    }
                }
            }
        }
    }

}
