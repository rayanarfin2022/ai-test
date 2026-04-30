package com.test.util;

import java.util.HashMap;
import java.util.Map;

public class BadUtil {

    private static Map<String, Integer> map = new HashMap<>();

    public void increment(String key) {

        // ❌ Race condition
        map.put(key, map.get(key) + 1);
    }

    public void checkUser(String name) {

        // ❌ NullPointer risk
        if (name.equals("admin")) {
            System.out.println("Admin");
        }
    }

    public void concat() {

        // ❌ Performance issue
        String result = "a" + "b" + "c" + "d" + "e";
    }
}