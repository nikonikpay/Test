package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesFromNikoDemo {

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

            //1 -get the student johnny fro data base
            //2 - creat more courses
            //3- add student to courses
            //4- save th courses



            //1
            int studentId =2;
            Student tempStudent = session.get(Student.class,studentId);
            System.out.println("Loaded student "+ tempStudent);
            System.out.println("Course :"+tempStudent.getCourses());






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
