package lab1.practice;

import java.util.HashMap;
import java.util.Map;

public class RandomIntServiceLocator {

    private final static Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("maxPrinterCount", 10);
        }
    };

    public static Integer get(String key) {
        return map.get(key);
    }
}
