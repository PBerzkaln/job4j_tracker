package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("vasyaivanod@gmail.com", "Vasya Ivanov");
        map.put("kolyapetrov@gmail.com", "Kolya Petrov");
        map.put("olyasmirnova@gmail.com", "Olya Smirnova");
        map.put("joedow@gmail.com", "Joe Dow");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
