import java.util.ArrayList;
import java.util.HashMap;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Object> g = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            g.add((int) (Math.random() * 1_000));
        }
        System.out.println(g);
        for (int i = g.size()-1; i >= 0; i--) {
            if (1 == (int) g.get(i) % 2) {
                g.remove(i);
            }
        }
        System.out.println(g);
    }
    public static int indexOf(ArrayList<Object> ar, Object o) {
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }
    public static int mode(ArrayList<Integer> arr) {
        if (arr.size() == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        final int[] mode = {0};
        final int[] modeNum = {0};
        map.forEach((k, v) -> {
            if (v > modeNum[0]) {
                mode[0] = k;
                modeNum[0] = v;
            }
        });
        return mode[0];
    }
}