package com.nationwide.pilotadmin.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rushidesai
 */
public class CollectionUtils {

    public static <T> Set<T> listToSet(List<T> list) {
        if (list == null) return null;

        return new HashSet<>(list);
    }
}
