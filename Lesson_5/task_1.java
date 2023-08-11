import java.util.*;

public class task_1 {
    public static void main(String[] args) {
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.";

        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase().replaceAll("[.—:;,!?]", "");
        String[] words = str.split("\\s+");

        for (String item : words) {
            map.putIfAbsent(item, 0);
            map.put(item, map.get(item) + 1);
        }

        for (String key : map.keySet()) {
            System.out.printf("%s: %d\n", key, map.get(key));
        }
    }
}
