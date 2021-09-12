package lesson_1.task_3;

public class DrawShapesExample {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        for (int i = 0; i < shapes.length; i++)
            shapes[i] = randShape();
        for (Shape shape : shapes) shape.draw();
    }

    public static Shape randShape() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> new Circle();
            case 1 -> new Square();
            case 2 -> new Triangle();
            default -> throw new IllegalStateException("Unexpected value: " + (int) (Math.random() * 3));
        };
    }
}

