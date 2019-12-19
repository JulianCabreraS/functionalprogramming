package programming;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {


        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring boot", "Framework", 95, 20000),
                new Course("API", "Microservices", 97, 20000),
                new Course("Microservices", "Microservices", 91, 20000),
                new Course("AWS", "Cloud", 98, 20000)
        );

        /*allMatch, noneMatch, anyMatch*/
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println("\nAll match: "+ courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println("\nNone match"+courses.stream().noneMatch(reviewScoreGreaterThan90Predicate));
        System.out.println("\nAny Match: "+courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        /*Create comparators by using comparing and setting the getter of the class*/
        Comparator comparingByNoOfStudentIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator comparingByNoOfStudentDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        Comparator comparingByNoOfStudentAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        /* Use sorted and apply the comparator. Then collect in a list */
        System.out.println("\nStudent increasing: \n"+courses.stream()
                .sorted(comparingByNoOfStudentIncreasing)
                .collect(Collectors.toList()));
        System.out.println("\nStudent decreasing: \n" +courses.stream().sorted(comparingByNoOfStudentDecreasing).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).collect(Collectors.toList()));

        /* Limiting results */
        System.out.println("\nLimit 5:\n "+courses.stream()
                .sorted(comparingByNoOfStudentIncreasing)
                .limit(5)
                .collect(Collectors.toList()));

        /* Max result */
        System.out.println("\nMax of Students:\n "+courses.stream()
                .max(comparingByNoOfStudentAndNoOfReviews));

        /* Min results */
        System.out.println("\nFilter and Min: \n"+ courses.stream()
        .filter(reviewScoreLessThan90Predicate)
        .min(comparingByNoOfStudentAndNoOfReviews)
        .orElse(new Course("kubernetes", "Cloud", 91,2000)));


        /* Sum number of student */
        System.out.println("\nSum of Students: \n"+ courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        /* Average of student */
        System.out.println("\nAverage of Students: \n"+ courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average());
    }
}
