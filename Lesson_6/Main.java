import java.util.*;

public class Main {
    public static void main(String[] args) {
        NoteBook noteBook1 = new NoteBook("noteBook1", 4, "windows", "black", 512);
        NoteBook noteBook2 = new NoteBook("noteBook2", 3, "windows", "yellow", 1024);
        NoteBook noteBook3 = new NoteBook("noteBook3", 5, "linux", "white", 1024);
        NoteBook noteBook4 = new NoteBook("noteBook4", 4, "linux", "black", 1024);
        NoteBook noteBook5 = new NoteBook("noteBook5", 5, "windows", "yellow", 2048);
        NoteBook noteBook6 = new NoteBook("noteBook6", 6, "windows", "black", 512);
        NoteBook noteBook7 = new NoteBook("noteBook7", 8, "linux", "red", 1024);
        NoteBook noteBook8 = new NoteBook("noteBook8", 7, "linux", "black", 512);
        NoteBook noteBook9 = new NoteBook("noteBook9", 3, "windows", "white", 2048);
        NoteBook noteBook10 = new NoteBook("noteBook10", 6, "windows", "red", 2048);
        NoteBook noteBook11 = new NoteBook("noteBook11", 5, "windows", "white", 2048);

        List<NoteBook> noteBooks = new ArrayList<>();
        noteBooks.add(noteBook1);
        noteBooks.add(noteBook2);
        noteBooks.add(noteBook3);
        noteBooks.add(noteBook4);
        noteBooks.add(noteBook5);
        noteBooks.add(noteBook6);
        noteBooks.add(noteBook7);
        noteBooks.add(noteBook8);
        noteBooks.add(noteBook9);
        noteBooks.add(noteBook10);
        noteBooks.add(noteBook11);

        run(noteBooks);
    }

    private static void run(List<NoteBook> noteBooks) {
        String nd = "____________________________________________________\n";
        String text1 = "  1. Распечатать все ноутбуки\n  2. Выбрать по параметрам\n  3. Выход";
        String text2 = "  1. Указать минимальную RAM\n  2. Выбрать OS\n  3. Выбрать цвет" +
                "\n  4. Указать минимальный размер HD\n  5. Распечатать согласно требованиям\n  6. Сбросить\n  7. Выход";
        String choose = "\nВыберете вариант: ";
        String input = "Введите значение: ";

        while (true) {
            switch (inputNumber(nd + text1 + choose)) {
                case (1):
                    printList(noteBooks);
                    break;
                case (2):
                    Map<String, String> map = new HashMap<>();
                    while (true) {
                        switch (inputNumber(nd + text2 + choose)) {
                            case (1):
                                map.put("RAM", String.valueOf(inputNumber(input)));
                                break;
                            case (2):
                                map.put("OS", inputText(input));
                                break;
                            case (3):
                                map.put("color", inputText(input));
                                break;
                            case (4):
                                map.put("HD", String.valueOf(inputNumber(input)));
                                break;
                            case (5):
                                List<NoteBook> noteBooksTemp = new ArrayList<>();
                                for (NoteBook noteBook : noteBooks) {
                                    boolean b = true;
                                    if (map.containsKey("RAM")) {
                                        b = noteBook.getRandomAccessMemory() >= Integer.parseInt(map.get("RAM"));
                                    }
                                    if (map.containsKey("OS")) {
                                        b = b && noteBook.getOperationSystem().equalsIgnoreCase(map.get("OS"));
                                    }
                                    if (map.containsKey("color")) {
                                        b = b && noteBook.getColor().equalsIgnoreCase(map.get("color"));
                                    }
                                    if (map.containsKey("HD")) {
                                        b = b && noteBook.getHardDiskVolume() >= Integer.parseInt(map.get("HD"));
                                    }
                                    if (b) {
                                        noteBooksTemp.add(noteBook);
                                    }
                                }

                                // System.out.println(map);
                                printList(noteBooksTemp);
                                break;
                            case (6):
                                map.clear();
                                break;
                            case (7):
                                return;
                            default:
                                System.out.println("Ошибка ввода!");
                                break;
                        }
                    }
                case (3):
                    return;
                default:
                    System.out.println("Ошибка ввода!");
                    break;
            }
        }
    }

    private static String inputText(String firstText) {
        String text = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstText);
        text = scanner.nextLine();
        return text;
    }

    private static Integer inputNumber(String firstText) {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstText);
        number = scanner.nextInt();
        return number;
    }

    private static void printList(List<NoteBook> note) {
        for (NoteBook noteBook : note) {
            System.out.println(noteBook);
        }
    }
}

class NoteBook {
    private String name;
    private int randomAccessMemory;
    private String operationSystem;
    private String color;
    private int hardDiskVolume;

    public NoteBook(String name, int randomAccessMemory, String operationSystem, String color, int hardDiskVolume) {
        this.name = name;
        this.randomAccessMemory = randomAccessMemory;
        this.operationSystem = operationSystem;
        this.color = color;
        this.hardDiskVolume = hardDiskVolume;
    }

    public NoteBook() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(int randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHardDiskVolume() {
        return hardDiskVolume;
    }

    public void setHardDiskVolume(int hardDiskVolume) {
        this.hardDiskVolume = hardDiskVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        NoteBook noteBook = (NoteBook) o;

        if (randomAccessMemory != noteBook.randomAccessMemory)
            return false;
        if (hardDiskVolume != noteBook.hardDiskVolume)
            return false;
        if (name != null ? !name.equals(noteBook.name) : noteBook.name != null)
            return false;
        if (operationSystem != null ? !operationSystem.equals(noteBook.operationSystem)
                : noteBook.operationSystem != null)
            return false;
        return color != null ? color.equals(noteBook.color) : noteBook.color == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + randomAccessMemory;
        result = 31 * result + (operationSystem != null ? operationSystem.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + hardDiskVolume;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, RAM: %d GB, OS: %s, color: %s, HDD: %d GB;", name,
                randomAccessMemory, operationSystem, color, hardDiskVolume);
    }
}