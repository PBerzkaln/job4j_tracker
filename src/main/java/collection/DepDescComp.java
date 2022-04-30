package collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] tmpO1 = o1.split("/");
        String[] tmp02 = o2.split("/");
        int rsl = tmp02[0].compareTo(tmpO1[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}