package com.mycompany.myapp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;

public class Datautils {

    public static boolean notNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static Long safeToLong(Object obj) {
        return safeToLong(obj, 0L);
    }

    public static Long safeToLong(Object obj1, Long defaultValue) {
        Long result = defaultValue;
        if (null != obj1) {
            if (obj1 instanceof BigDecimal) {
                return ((BigDecimal) obj1).longValue();
            }
            if (obj1 instanceof BigInteger) {
                return ((BigInteger) obj1).longValue();
            }

            try {
                result = Long.parseLong(obj1.toString());
            } catch (Exception e) {}
        }
        return result;
    }

    public static String safeToString(Object obj, String defaultValue) {
        if (obj == null || obj.toString().isEmpty()) {
            return defaultValue;
        }

        return obj.toString();
    }

    public static String safeToString(Object obj) {
        return safeToString(obj, "");
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean notNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }
}
