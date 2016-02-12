package lesson7_10.reflection;


import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionView {

    private static Bird bird = new Duck();

    public ReflectionView() {
    }

    public static void main(String[] args) {

        printClassInfo(bird.getClass());
        printClassMethods(bird.getClass());
        printClassFields(bird.getClass());
    }

    public static void printClassInfo(Class className) {

        if (className != null) {
            System.out.println("Class name: " + className);
            System.out.println("Class simple name: " + className.getSimpleName());
            className = className.getSuperclass();
            printClassInfo(className);
        }
    }

    public static void printClassMethods(Class className) {

        if (className != null) {
            System.out.println("Class methods: " + Arrays.toString(className.getMethods()));
            className = className.getSuperclass();
            printClassMethods(className);
        }
    }

    public static void printClassFields(Class className) {

        if (className != null) {

            Field[] fields = className.getDeclaredFields();
            System.out.println("Class fields: " + className.getSimpleName());

            for (Field field : fields) {
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }
            System.out.println();

            className = className.getSuperclass();
            printClassFields(className);
        }
    }
}
