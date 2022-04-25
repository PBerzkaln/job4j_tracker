package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        int k = 0;
        while (k < lim) {
            char leftCh = left.charAt(k);
            char rightCH = right.charAt(k);
            if (leftCh != rightCH) {
                return Character.compare(leftCh, rightCH);
            }
            k++;
        }
        return Integer.compare(left.length(), right.length());
    }
}