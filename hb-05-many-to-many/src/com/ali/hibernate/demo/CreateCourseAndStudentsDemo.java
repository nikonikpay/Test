package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            //1-create a course
            //2- add student to the course
            //3- save the student


            Course tempCourse = new Course("Pacman how to score one million point");


            System.out.println("Saving the course");
            System.out.println(tempCourse);
            session.save(tempCourse);
            System.out.println(tempCourse+ " Has been saved");


            Student tempStudent1 = new Student("John","Doe","John@gmail.com");
            Student tempStudent2 = new Student("Niko "  ,"Nikpay","Niko@gmail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("We are saving students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("the Students has been saved "+ tempCourse.getStudents());


            session.getTransaction().commit();
            System.out.println("The job is successfully  done");

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
