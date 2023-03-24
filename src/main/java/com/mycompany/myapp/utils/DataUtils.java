package com.mycompany.myapp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;

public class DataUtils {

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
}
