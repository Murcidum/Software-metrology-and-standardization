package org.example;

import java.util.ArrayList;
import java.util.List;

// Базовый абстрактный класс учащегося
abstract class Student {
    protected String name;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getDetails();
}

// Производный класс Школьник
class Schoolchild extends Student {
    private int grade;

    public Schoolchild(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public String getDetails() {
        return String.format("Школьник: %s, Возраст: %d, Класс: %d", name, age, grade);
    }
}

// Производный класс Студент колледжа
class CollegeStudent extends Student {
    private String university;
    private int year;

    public CollegeStudent(String name, int age, String university, int year) {
        super(name, age);
        this.university = university;
        this.year = year;
    }

    @Override
    public String getDetails() {
        return String.format("Студент: %s, Возраст: %d, Университет: %s, Курс: %d",
                name, age, university, year);
    }
}

// Новый класс: Аспирант
class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String researchTopic) {
        super(name, age);
        this.researchTopic = researchTopic;
    }

    @Override
    public String getDetails() {
        return String.format("Аспирант: %s, Возраст: %d, Тема исследования: %s",
                name, age, researchTopic);
    }
}

// Новый класс: Студент по обмену (наследуется от CollegeStudent)
class ExchangeStudent extends CollegeStudent {
    private String homeCountry;

    public ExchangeStudent(String name, int age, String university,
                           int year, String homeCountry) {
        super(name, age, university, year);
        this.homeCountry = homeCountry;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Страна происхождения: " + homeCountry;
    }
}

// Класс Конференция
class Conference {
    private List<Student> participants = new ArrayList<>();

    public void addParticipant(Student student) {
        participants.add(student);
    }

    public int countSchoolchildren() {
        return countParticipants(Schoolchild.class);
    }

    public int countCollegeStudents() {
        return countParticipants(CollegeStudent.class) - countExchangeStudents();
    }

    public int countGraduateStudents() {
        return countParticipants(GraduateStudent.class);
    }

    public int countExchangeStudents() {
        return countParticipants(ExchangeStudent.class);
    }

    private int countParticipants(Class<?> cls) {
        int count = 0;
        for (Student p : participants) {
            if (cls.isInstance(p)) count++;
        }
        return count;
    }

    public void printParticipantsDetails() {
        System.out.println("\nУчастники конференции:");
        for (Student p : participants) {
            System.out.println(p.getDetails());
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();

        // Добавляем участников разных типов
        conference.addParticipant(new Schoolchild("Анна", 14, 9));
        conference.addParticipant(new CollegeStudent("Иван", 20, "Технический Университет", 3));
        conference.addParticipant(new GraduateStudent("Мария", 25, "Искусственный Интеллект"));
        conference.addParticipant(new ExchangeStudent("Джон", 22, "Международный Университет",
                4, "США"));
        conference.addParticipant(new Schoolchild("Петр", 12, 7));

        // Выводим статистику
        System.out.println("Статистика участников:");
        System.out.println("Школьников: " + conference.countSchoolchildren());
        System.out.println("Студентов: " + conference.countCollegeStudents());
        System.out.println("Аспирантов: " + conference.countGraduateStudents());
        System.out.println("Студентов по обмену: " + conference.countExchangeStudents());

        // Выводим детальную информацию
        conference.printParticipantsDetails();
    }
}