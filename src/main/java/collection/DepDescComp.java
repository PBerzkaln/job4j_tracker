package collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] tmpO1 = o1.split("/");
        String[] tmp02 = o2.split("/");
        if (tmp02[0].equals(tmpO1[0])) {
            return o1.compareTo(o2);
        }
        return tmp02[0].compareTo(tmpO1[0]);
    }
}