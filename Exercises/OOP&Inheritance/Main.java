import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle(5),
            new Rectangle(3, 6),
            new Circle(2)
        );

        for (Shape shape: shapes) {
            System.out.println(shape);
        }
    }
}
