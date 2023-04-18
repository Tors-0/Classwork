import tools.Functions;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 999999; i++) {
            int x = Functions.squareArrayCount(4);
            if (map.containsKey(x)) {
                int l = map.get(x);
                l++;
                map.put(x,l);
            } else {
                map.put(x,1);
            }
        }
        System.out.println(map.toString());
    }
}
