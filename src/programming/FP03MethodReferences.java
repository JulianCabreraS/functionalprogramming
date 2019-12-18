package programming;

import java.util.List;

public class FP03MethodReferences {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices", "AWS");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
