package lab1.example;


import java.util.HashMap;
import java.util.Map;

public class IntServiceLocator {
    private final static Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("printerCount", 5);
        }
    };

    public static Integer get(String key) {
        return map.get(key);
    }
}
