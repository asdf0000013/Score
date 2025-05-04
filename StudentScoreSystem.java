import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private String course;
    private double score;

    public Student(String name, String id, String course, double score) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public double getScore() {
        return score;
    }
}

public class StudentScoreSystem {
    private static Map<String, Student> studentMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // 记录学生成绩
    public static void recordScore() {
        System.out.println("请输入学生姓名:");
        String name = scanner.nextLine();
        System.out.println("请输入学生学号:");
        String id = scanner.nextLine();
        System.out.println("请输入课程名称:");
        String course = scanner.nextLine();
        System.out.println("请输入成绩 (0-100) :");
        double score = scanner.nextDouble();
        scanner.nextLine(); // 清除换行符
        Student student = new Student(name, id, course, score);
        studentMap.put(name + "_" + id + "_" + course, student);
        System.out.println("成绩已成功记录!");
    }

    // 查询学生成绩
    public static void queryScore() {
        System.out.println("请选择查询方式:");
        System.out.println("1. 按学生姓名查询");
        System.out.println("2. 按学生学号查询");
        System.out.println("3. 按课程名称查询");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除换行符
        switch (choice) {
            case 1:
                System.out.println("请输入学生姓名:");
                String name = scanner.nextLine();
                for (Student student : studentMap.values()) {
                    if (student.getName().equals(name)) {
                        printStudentInfo(student);
                    }
                }
                break;
            case 2:
                System.out.println("请输入学生学号:");
                String id = scanner.nextLine();
                for (Student student : studentMap.values()) {
                    if (student.getId().equals(id)) {
                        printStudentInfo(student);
                    }
                }
                break;
            case 3:
                System.out.println("请输入课程名称:");
                String course = scanner.nextLine();
                for (Student student : studentMap.values()) {
                    if (student.getCourse().equals(course)) {
                        printStudentInfo(student);
                    }
                }
                break;
            default:
                System.out.println("无效的查询选项");
        }
    }

    private static void printStudentInfo(Student student) {
        System.out.println("姓名: " + student.getName() + ", 学号: " + student.getId() +
                ", 课程: " + student.getCourse() + ", 成绩: " + student.getScore());
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎使用学生成绩管理系统");
            System.out.println("请选择操作:");
            System.out.println("1. 记录学生成绩");
            System.out.println("2. 查询学生成绩");
            System.out.println("3. 统计课程成绩");
            System.out.println("4. 退出系统");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符
            switch (choice) {
                case 1:
                    recordScore();
                    break;
                case 2:
                    queryScore();
                    break;
                case 4:
                    System.out.println("感谢使用学生成绩管理系统, 再见!");
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新输入");
            }
        }
    }
}