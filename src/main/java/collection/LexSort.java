package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftWord = left.split("\\.");
        String[] rightWord = right.split("\\.");
        int leftNum = Integer.parseInt(leftWord[0]);
        int rightNum = Integer.parseInt(rightWord[0]);
        return Integer.compare(leftNum, rightNum);
    }
}
