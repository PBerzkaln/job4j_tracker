package lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var bird = new BirdData();
        bird.setAge(1);
        System.out.println(bird);
    }
}