package yongbeom.utils.airquickutils.collections;

import java.util.ArrayList;
import java.util.Collections;

public class Lists {

    /**
     * Creates a <i>mutable</i>, empty {@code ArrayList} instance.
     *
     * @return a new, empty {@code ArrayList}
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    /**
     * Creates a <i>mutable</i> {@code ArrayList} instance containing the given elements.
     *
     * @param elements the elements that the list should contain, in order
     * @return a new {@code ArrayList} containing those elements
     */
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... elements) {
        ArrayList<E> list = new ArrayList<E>();
        Collections.addAll(list, elements);
        return list;
    }
}