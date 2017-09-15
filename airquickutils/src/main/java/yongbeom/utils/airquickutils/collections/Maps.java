package yongbeom.utils.airquickutils.collections;


import java.util.HashMap;

public class Maps {

    /**
     * Creates a <i>mutable</i>, empty {@code HashMap} instance.
     *
     * @return a new, empty {@code HashMap}
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }
}