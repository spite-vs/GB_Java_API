import java.util.*;

public class task_2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова",
                        "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                        "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                        "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"));

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            List<String> temp = List.of(names.get(i).split(" "));
            if (!words.containsKey(temp.get(0))) {
                words.put(temp.get(0), 1);
            } else {
                words.put(temp.get(0), words.get(temp.get(0)) + 1);
            }
        }
        words.values().removeAll(Collections.singleton(1));

        int size = words.size();
        List<ArrayList<Object>> lst = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            lst.add(new ArrayList<>());
        }
        int l = 0;
        for (Map.Entry<String, Integer> elem : words.entrySet()) {
            if (elem.getValue() > 1) {
                lst.get(l).add(elem.getKey());
                lst.get(l).add(elem.getValue());
                l++;
            }
        }
        for (int i = 0; i < lst.size() - 1; i++) {
            for (int j = 0; j < lst.size() - 1 - i; j++) {
                if ((int) lst.get(j).get(1) < (int) lst.get(j + 1).get(1)) {
                    List<Object> temp = lst.get(j);
                    lst.set(j, lst.get(j + 1));
                    lst.set(j + 1, (ArrayList) temp);
                }
            }
        }

        for (

                int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).get(0) + ": " + lst.get(i).get(1));
        }
    }
}