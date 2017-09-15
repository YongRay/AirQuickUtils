package yongbeom.utils.airquickutils.collections;

import java.util.HashSet;

public class Sets {

    /**
     * Creates a <i>mutable</i>, empty {@code HashSet} instance.
     *
     * @return a new, empty {@code HashSet}
     */
    public static <E> HashSet<E> newHashSet() {
        return new HashSet<E>();
    }
}