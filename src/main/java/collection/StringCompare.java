package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        for (int i = 0; i < lim; i++) {
            char leftCh = left.charAt(i);
            char rightCH = right.charAt(i);
            if (leftCh != rightCH) {
                return Character.compare(leftCh, rightCH);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}