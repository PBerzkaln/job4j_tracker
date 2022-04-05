package ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                return rsl;
            }
        }
        throw new ElementNotFoundException("The index wasn't found.");
    }

    public static void main(String[] args) {
       try {
           System.out.println(indexOf(new String[] {"one", "two", "three", "four"}, "one"));
       } catch (ElementNotFoundException e) {
           e.printStackTrace();
       }
    }
}
