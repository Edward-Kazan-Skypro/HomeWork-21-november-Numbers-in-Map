import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static ArrayList<String> strings = new ArrayList<>(Arrays.asList(
            "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "JJJ", "LLL"));

    static Map<String, Integer> map = new HashMap<>();

    public static void viewMap(){
        System.out.println("Список пар <ключ - значение>:");
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("key - " + m.getKey() + " " + ", value - " + m.getValue());
        }
    }

    public static void main(String[] args) {

        int counter = 10;
        //Первоначальное заполнение списка значениями
        for (int i = 0; i < counter; i++) {
            int index = (int) (Math.random() * strings.size());
            String key = strings.get(index);
            int value = (int) (Math.random() * 1000);
            map.put(key, value);
        }
        //Смотрим какой список получился
       viewMap();

        //Добавляем новые значения
        for (int i = 0; i < counter; i++) {
            int index = (int) (Math.random() * strings.size());
            String key = strings.get(index);
            int value = (int) (Math.random() * 1000);
            if (map.containsKey(key) && map.containsValue(value)) {
                throw new RuntimeException("Такой ключ уже есть и значения совпадают.");
            }
            if (map.containsKey(key) && !map.containsValue(value)) {
                System.out.println("Найдено совпадение по ключу " + key);
                System.out.println("Обновляем значение.");
                System.out.println("Для ключа " + key + " будет обновлено значение на " + value);
                map.put(key, value);
            }
            if (!map.containsKey(key)){
                map.put(key, value);
            }
        }
        //Смотрим какой список получился
        viewMap();
    }
}