package org.example;

import java.util.ArrayList;
import java.util.List;

// Базовый абстрактный класс учащегося
abstract class Student {
    // Здесь могут быть общие поля и методы для всех учащихся
}

// Производный класс Школьник
class Schoolchild extends Student {
    // Специфичные для школьника поля и методы
}

// Производный класс Студент
class CollegeStudent extends Student {
    // Специфичные для студента поля и методы
}

// Класс Конференция, содержащая участников
class Conference {
    private List<Student> participants = new ArrayList<>();

    // Метод добавления участника
    public void addParticipant(Student student) {
        participants.add(student);
    }

    // Подсчет школьников
    public int countSchoolchildren() {
        int count = 0;
        for (Student participant : participants) {
            if (participant instanceof Schoolchild) {
                count++;
            }
        }
        return count;
    }

    // Подсчет студентов
    public int countCollegeStudents() {
        int count = 0;
        for (Student participant : participants) {
            if (participant instanceof CollegeStudent) {
                count++;
            }
        }
        return count;
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();

        conference.addParticipant(new Schoolchild());
        conference.addParticipant(new CollegeStudent());
        conference.addParticipant(new Schoolchild());
        conference.addParticipant(new CollegeStudent());
        conference.addParticipant(new CollegeStudent());

        System.out.println("Школьников: " + conference.countSchoolchildren());
        System.out.println("Студентов: " + conference.countCollegeStudents());
    }
}