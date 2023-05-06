package non_csa;

public class root2powerroot2 {
    public static void main(String[] args) {
        String out = """
                public double theThing(long iter) {
                        if (iter < 1000) {
                            return Math.pow(Math.sqrt(2),theThing(++iter));
                        } else {
                            return Math.sqrt(2);
                        }
                    }
                    
                """;
        System.out.println(out);
        System.out.println(theThing(0));
    }
    public static double theThing(long iter) {
        if (iter < 1000) {
            return Math.pow(Math.sqrt(2),theThing(++iter));
        } else {
            return Math.sqrt(2);
        }
    }
}
